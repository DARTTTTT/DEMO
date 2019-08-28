package com.ltqh.qh.operation.fragment.user;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.operation.entity.ORechargeEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;

import butterknife.BindView;

public class OLoginFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.edit_number)
    EditText edit_number;

    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.img_hide)
    ImageView img_hide;

    @BindView(R.id.text_forget)
    TextView text_forget;

    private int isHide = 0;

    @Override
    protected void initView(View view) {
        btn_login.setOnClickListener(this);
        img_hide.setOnClickListener(this);
        text_forget.setOnClickListener(this);


        String string = SPUtils.getString(OUserConfig.USER_ACCOUNT);

        if (string!=null){
            edit_number.setText(string);
        }


        edit_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 11) {
                    edit_password.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_login;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                postLogin(edit_number.getText().toString(), edit_password.getText().toString());
                break;
            case R.id.img_hide:
                if (isHide == 0) {
                    edit_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isHide = 1;
                    img_hide.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeopen));
                } else if (isHide == 1) {
                    edit_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isHide = 0;
                    img_hide.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeclose));


                }
                break;

            case R.id.text_forget:
                OUserActivity.enter(getActivity(), OConstant.FORGET);
                getActivity().finish();
                break;


        }
    }

    private void postLogin(String username, String password) {


        OkGo.<String>post(OConstant.URL_LOGIN)
                .tag(this)
                .params(OConstant.PARAM_MOBILE, username)
                .params(OConstant.PARAM_PASSWORD, password)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.getErrorCode() == 200 || oCodeMsgEntity.getErrorCode() == 0) {

                                getMine();
                                getBaseMine();

                            } else {

                            }

                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), "当前网络不好，请检查网络", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getBaseMine() {
        OkGo.<String>get(OConstant.URL_USER_BASE_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OBaseMineEntity oBaseMineEntity = new Gson().fromJson(response.body(), OBaseMineEntity.class);
                            SPUtils.putData(OUserConfig.BASEMINE, oBaseMineEntity);
                        }
                    }
                });
    }

    private void getMine() {
        OkGo.<String>get(OConstant.URL_USER_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OMineEntity oMineEntity = new Gson().fromJson(response.body(), OMineEntity.class);
                            SPUtils.putData(OUserConfig.USER, oMineEntity);
                            //登录成功需要更新下
                            postRecharge();

                            QuoteProxy.getInstance().setLogin(true);
                            getActivity().finish();
                        }
                    }
                });

    }

    private void postRecharge() {

        OkGo.<String>post(OConstant.URL_RECHARGE)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_GET_PAY_LIST)
                .params(OConstant.PARAM_SWITCH_TYPE, "1")
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {
                            if (!TextUtils.isEmpty(response.body())) {

                                ORechargeEntity oRechargeEntity = new Gson().fromJson(response.body(), ORechargeEntity.class);

                                QuoteProxy.getInstance().setoRechargeEntity(oRechargeEntity);

                            }
                        } else {

                        }
                    }
                });
    }

}

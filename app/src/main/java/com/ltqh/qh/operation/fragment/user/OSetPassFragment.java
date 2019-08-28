package com.ltqh.qh.operation.fragment.user;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.activity.SecondActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

public class OSetPassFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.edit_password_old)
    EditText edit_password_old;

    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.edit_password_confirm)
    EditText edit_password_confirm;

    @BindView(R.id.btn_sure)
    Button btn_sure;


    @BindView(R.id.img_eye_one)
    ImageView img_eye_one;

    @BindView(R.id.img_eye_two)
    ImageView img_eye_two;



    private int flag_one = 0;
    private int flag_two = 0;


    @Override
    protected void initView(View view) {

        btn_sure.setOnClickListener(this);
        img_eye_one.setOnClickListener(this);
        img_eye_two.setOnClickListener(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        OMineEntity oMineEntity = SPUtils.getData(OUserConfig.USER, OMineEntity.class);
        if (oMineEntity != null) {

        } else {


        }

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_set_pass;
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


            case R.id.btn_sure:
                String loginpass = edit_password_old.getText().toString();
                String password = edit_password.getText().toString();
                String passwordConfirm = edit_password_confirm.getText().toString();


                if (loginpass.equals("")) {
                    Toast.makeText(getActivity(), "请输入登录密码", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.equals("")) {
                    Toast.makeText(getActivity(), "请输入提款密码", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (passwordConfirm.equals("")) {
                    Toast.makeText(getActivity(), "请再次输入提款密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                postSet(loginpass, password, passwordConfirm);

                break;

            case R.id.img_eye_one:
                if (flag_one == 0) {
                    edit_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    flag_one = 1;
                    img_eye_one.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeopen));

                } else if (flag_one == 1) {
                    edit_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    flag_one = 0;
                    img_eye_one.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeclose));

                }
                break;
            case R.id.img_eye_two:
                if (flag_two == 0) {
                    edit_password_confirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    flag_two = 1;
                    img_eye_two.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeopen));

                } else if (flag_two == 1) {
                    edit_password_confirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    flag_two = 0;
                    img_eye_two.setImageDrawable(getResources().getDrawable(R.mipmap.o_login_eyeclose));

                }
                break;
        }
    }


    //确认重置
    private void postSet(final String passOld, String pass, String passConfirm) {
        OkGo.<String>post(OConstant.URL_SET_ATM_PASS)
                .tag(this)
                .params(OConstant.PARAM_PASSWORD, passOld)
                .params(OConstant.PARAM_WITHDRAWPW, pass)
                .params(OConstant.PARAM_WITHDRAWPWCFM, passConfirm)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }


                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {

                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                getActivity().finish();

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


}

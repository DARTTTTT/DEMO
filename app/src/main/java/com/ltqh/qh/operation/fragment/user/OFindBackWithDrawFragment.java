package com.ltqh.qh.operation.fragment.user;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class OFindBackWithDrawFragment extends BaseFragment implements View.OnClickListener {




    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.edit_password_confirm)
    EditText edit_password_confirm;

    @BindView(R.id.btn_sure)
    Button btn_sure;





    private int isHide = 0;


    @Override
    protected void initView(View view) {

        btn_sure.setOnClickListener(this);


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_findback_withdraw;
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
                String password = edit_password.getText().toString();
                String passwordConfirm = edit_password_confirm.getText().toString();


                if (password.equals("")){
                    Toast.makeText(getActivity(),"请输入新密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passwordConfirm.equals("")){
                    Toast.makeText(getActivity(),"请再次输入新密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                postReset(password,passwordConfirm);

                break;


        }
    }


    //确认重置
    private void postReset( String pass, String passConfirm) {
        OkGo.<String>post(OConstant.URL_FINDBACK)
                .tag(this)
                .params(OConstant.PARAM_ACTION,OConstant.STAY_PASSWD)
                .params(OConstant.PARAM_NEWPASS, pass)
                .params(OConstant.PARAM_NEWPASS_CFM, passConfirm)
                .params(OConstant.PARAM_TYPE,"2")
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

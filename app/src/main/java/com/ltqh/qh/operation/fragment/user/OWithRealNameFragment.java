package com.ltqh.qh.operation.fragment.user;

import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class OWithRealNameFragment extends BaseFragment implements View.OnClickListener {




    @BindView(R.id.edit_realname)
    EditText edit_realname;

    @BindView(R.id.edit_id)
    EditText edit_id;

    @BindView(R.id.btn_sure)
    Button btn_sure;

    private int isHide = 0;


    @Override
    protected void initView(View view) {


        view.findViewById(R.id.btn_sure).setOnClickListener(this);







    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_withdraw_realname;
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
                String realname = edit_realname.getText().toString();
                String id = edit_id.getText().toString();
                if (realname.equals("")){
                    Toast.makeText(getActivity(), "请输入您登记的姓名", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (id.equals("")){
                    Toast.makeText(getActivity(), "请输入您登记的身份证号码", Toast.LENGTH_SHORT).show();

                    return;
                }
                postProfileAuth(realname, id);
                break;
            case R.id.layout_lianxi:


                break;

        }
    }


    private void postProfileAuth(String realname, String id) {


        String url = OConstant.URL_FINDBACK + "?" + OConstant.PARAM_ACTION + "=" + OConstant.STAY_AUTH
                + "&" + OConstant.PARAM_NAME + "=" + realname + "&" + OConstant.PARAM_IDENTITYNUMBER
                + "=" + id+"&"+OConstant.PARAM_TYPE+"=2";


        OkGo.<String>post(url)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {

                            if (!TextUtils.isEmpty(response.body())) {
                                Log.d("print", "onSuccess:150:  " + response.body());
                                OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                                if (oCodeMsgEntity.isSuccess() == true) {
                                    getActivity().finish();
                                    OUserActivity.enter(getActivity(),OConstant.FINDBACKWITHDRAW);
                                }else {
                                    Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        }
                    }
                });


    }


}

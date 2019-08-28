package com.ltqh.qh.operation.fragment.user;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.activity.SecondActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.utils.SmsTimeUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;

public class OResetPhoneFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.btn_sure)
    Button btn_sure;

    @BindView(R.id.edit_number)
    EditText edit_number;


    @BindView(R.id.edit_code)
    EditText edit_code;
    @BindView(R.id.text_getcode)
    TextView text_getcode;
    @BindView(R.id.edit_imgcode)
    EditText edit_imgcode;
    @BindView(R.id.img_code)
    ImageView img_code;

    @Override
    protected void initView(View view) {

        btn_sure.setOnClickListener(this);

        text_getcode.setOnClickListener(this);
        img_code.setOnClickListener(this);

        edit_number.setEnabled(false);

        OMineEntity oMineEntity = SPUtils.getData(OUserConfig.USER, OMineEntity.class);
        if (oMineEntity != null) {
            edit_number.setText(oMineEntity.getUser().getLoginMobile());
        } else {


        }
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_reset_phone;
    }

    @Override
    protected void intPresenter() {
        getImgcode();
    }

    @Override
    protected void initData() {
    }

    private void getImgcode() {

        String displayName = TimeZone.getDefault().getDisplayName();
        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
        String format = dateFormat.format(date);
        String url = OConstant.URL_REGISTER_IMG_CODE + "?_=" + format + "(" + displayName + ")";

        OkGo.<Bitmap>get(url)
                .tag(url)
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Response<Bitmap> response) {
                        Bitmap bitmap = response.body();
                        if (img_code==null){
                            return;
                        }
                        img_code.post(new Runnable() {
                            @Override
                            public void run() {
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                                byte[] bytes = baos.toByteArray();
                                Glide.with(getActivity()).load(bytes)
                                        .asBitmap()
                                        .error(R.mipmap.o_try)
                                        .centerCrop().into(img_code);
                            }
                        });

                    }
                });

    }

    @Override
    public void onClick(View v) {
        String number = edit_number.getText().toString();
        switch (v.getId()) {
            case R.id.img_code:
                getImgcode();
                break;


            case R.id.text_getcode:

                if (!TextUtils.isEmpty(number) && !TextUtils.isEmpty(edit_imgcode.getText().toString())) {

                    getCode(number, edit_imgcode.getText().toString());


                } else {
                    Toast.makeText(getActivity(), "请输入手机号码和图片验证码", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_sure:
                String edit_code = this.edit_code.getText().toString();
                if (edit_code.equals("")){
                    Toast.makeText(getActivity(), "请输入短信验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                postNext(edit_code);

                break;

        }
    }

    private void postNext(String imcode) {
        OkGo.<String>post(OConstant.URL_MOBILE)
                .params(OConstant.PARAM_ACTION,OConstant.STAY_VERIFY)
                .params(OConstant.PARAM_TYPE,"1")
                .params(OConstant.PARAM_VERIFYCODE,imcode)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())){
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(),oCodeMsgEntity.getErrorMsg(),Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess()==true){
                                getActivity().finish();
                                OUserActivity.enter(getActivity(),OConstant.RESETPHONENEXT);

                            }

                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                    }
                });

    }


    //获取验证码
    private void getCode(String username, String imgcode) {
        OkGo.<String>post(OConstant.URL_MOBILE)
                .tag(this)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_SEND_VERIFY)
                .params(OConstant.PARAM_MOBILE, username)
                .params(OConstant.PARAM_IMGCODE, imgcode)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        Log.d("print", "onSuccess:229: " + response.body());
                        if (!TextUtils.isEmpty(response.body())) {
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            if (oCodeMsgEntity.getErrorCode() == 200) {
                                mHandler.sendEmptyMessage(0);
                                Message msg = new Message();
                                mHandler.sendMessage(msg);
                                Toast.makeText(getContext(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                                getImgcode();
                                edit_imgcode.setText("");
                                if (oCodeMsgEntity.getErrorCode() == 500) {
                                    edit_number.setText("");

                                }

                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                    }
                });
    }


    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    SmsTimeUtils.check(SmsTimeUtils.SETTING_FINANCE_ACCOUNT_TIME, false);
                    SmsTimeUtils.startCountdown(text_getcode);


                    break;
                default:
                    break;
            }
        }

    };

}

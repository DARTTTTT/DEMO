package com.ltqh.qh.operation.fragment.user;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.operation.entity.ORegisterEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import okhttp3.Cookie;


public class ORegisterFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.layout_view)
    RelativeLayout layout_view;


    @BindView(R.id.edit_number)
    EditText edit_number;

    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.edit_code)
    EditText edit_code;

    @BindView(R.id.edit_imgcode)
    EditText edit_imgcode;

    @BindView(R.id.img_code)
    ImageView img_code;

    @BindView(R.id.btn_register)
    Button btn_register;

    @BindView(R.id.text_getcode)
    TextView text_getcode;

    @BindView(R.id.img_hide)
    ImageView img_hide;

    private int isHide = 0;

    @BindView(R.id.img_check)
    ImageView img_check;

    private int flag = 1;


    @Override
    protected void initView(View view) {

        btn_register.setOnClickListener(this);
        text_getcode.setOnClickListener(this);
        img_hide.setOnClickListener(this);
        img_code.setOnClickListener(this);

        img_check.setOnClickListener(this);
        view.findViewById(R.id.text_rule).setOnClickListener(this);
        view.findViewById(R.id.text_agree).setOnClickListener(this);


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
        return R.layout.o_fragment_register;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        getImgcode();

    }


    private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

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
                        if (img_code == null) {
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


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_agree:
            case R.id.img_check:
                if (flag == 0) {
                    img_check.setBackground(getResources().getDrawable(R.mipmap.o_check_true));
                    flag = 1;
                } else if (flag == 1) {
                    img_check.setBackground(getResources().getDrawable(R.mipmap.o_check_false));
                    flag = 0;
                }


                break;


            case R.id.text_getcode:


                if (!TextUtils.isEmpty(edit_number.getText().toString()) && !TextUtils.isEmpty(edit_imgcode.getText().toString())) {

                    getCode(edit_number.getText().toString(), edit_imgcode.getText().toString());


                } else {
                    Toast.makeText(getActivity(), "请输入手机号码和图片验证码", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_register:
                String username = edit_number.getText().toString();
                String password = edit_password.getText().toString();
                String code = edit_code.getText().toString();

                if (!TextUtils.isEmpty(edit_number.getText().toString())
                        && !TextUtils.isEmpty(edit_imgcode.getText().toString())
                        && !TextUtils.isEmpty(edit_code.getText().toString())
                        && !TextUtils.isEmpty(edit_password.getText().toString())) {

                    if (flag == 1) {
                        postCode(username, password, code);
                    } else if (flag == 0) {
                        Toast.makeText(getActivity(), "请阅读用户注册协议，并且同意", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getActivity(), "手机号码、密码和验证码不能为空", Toast.LENGTH_SHORT).show();

                }


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

            case R.id.img_code:

                getImgcode();

                break;

            case R.id.text_rule:
                showPopWindow("用户注册协议", getResources().getString(R.string.o_text_terms));

                break;


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow(String text, String content) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_about, null);
        TextView text_title = view.findViewById(R.id.text_title);
        TextView text_content = view.findViewById(R.id.text_content);

        text_content.setLineSpacing(0, 1.4f);
        text_content.setText(content);
        text_title.setText(text);

        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    //获取验证码
    private void getCode(String username, String imgcode) {
        OkGo.<String>post(OConstant.URL_REGISTER)
                .tag(this)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_ACTION)
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

    //验证短信验证码
    private void postCode(String username, String password, String code) {
        OkGo.<String>post(OConstant.URL_REGISTER)
                .tag(this)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_VERIFYCODE_ACTION)
                .params(OConstant.PARAM_VERIFYCODE, code)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d("print", "onSuccess:265: " + response.body());
                        if (!TextUtils.isDigitsOnly(response.body())) {
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            if (oCodeMsgEntity.getErrorCode() == 200) {
                                postRegister(username, password);
                            } else {
                                dismissProgressDialog();
                                Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();

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

    //提交注册
    private void postRegister(String username, final String pass) {


        OkGo.<String>post(OConstant.URL_REGISTER)
                .tag(this)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_REGISTER)
                .params(OConstant.PARAM_PASSWORD, pass)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {
                            ORegisterEntity oRegisterEntity = new Gson().fromJson(response.body(), ORegisterEntity.class);

                            //      OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oRegisterEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oRegisterEntity.isSuccess() == true) {
                                //这里作登录操作
                                postLogin(username, pass);

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
                        Log.d("print", "onSuccess:143: " + response.body());
                        if (!TextUtils.isEmpty(response.body())) {
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Log.d("print", "onSuccess:145: " + oCodeMsgEntity);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.getErrorCode() == 0 || oCodeMsgEntity.getErrorCode() == 200) {
                                getMine();
                                getBaseMine();
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
                            QuoteProxy.getInstance().setLogin(true);

                            getActivity().finish();
                        }
                    }
                });

    }
}

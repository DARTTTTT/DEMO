package com.ltqh.qh.fragment.user;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.BuildConfig;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.JsonEntity;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.entity.TipEntity;
import com.ltqh.qh.entity.UserInfoEntity;
import com.ltqh.qh.utils.AppUtil;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class PersonalCenterFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.btn_logout)
    Button btn_logout;
    @BindView(R.id.layout_delete)
    RelativeLayout layout_delete;

    @BindView(R.id.tv_version)
    TextView text_version;
    @BindView(R.id.text_username)
    TextView text_username;
    @BindView(R.id.text_nickname)
    TextView text_nickname;
    @BindView(R.id.layout_change)
    LinearLayout layout_change;
    @BindView(R.id.text_sign)
    TextView text_signature;
    @BindView(R.id.text_hc)
    TextView text_hc;

    @BindView(R.id.layout_sign)
    RelativeLayout layout_sign;

    @BindView(R.id.layout_nickname)
    RelativeLayout layout_nickname;

    private LoginEntity loginEntity;

    @BindView(R.id.layout_view)
    LinearLayout layout_view;


    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        loginEntity = SPUtils.getData(UserConfig.LOGIN_USER, LoginEntity.class);
        Log.d("print", "initView:用户Token: " + loginEntity.getData().getToken());
        btn_logout.setOnClickListener(this);
        view.findViewById(R.id.img_back).setOnClickListener(this);
        text_version.setText("version" + BuildConfig.VERSION_NAME);


        layout_change.setOnClickListener(this);
        layout_nickname.setOnClickListener(this);
        layout_sign.setOnClickListener(this);
        layout_delete.setOnClickListener(this);
        text_hc.setText(AppUtil.getAppClearSize(getContext()));

        view.findViewById(R.id.rl_head).setOnClickListener(this);


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void intPresenter() {

    }

    //只有修改成功了 才更新数据
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(Integer data) {
        if (data == Constant.ONRESUME_PERSON) {
            getUserInfo();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //getUserInfo();
    }

    @Override
    protected void initData() {
        getUserInfo();

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout:
                postLogout();
                break;

            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.layout_change:
                UserActivity.enter(getActivity(), Constant.RESET);
                break;

            case R.id.layout_nickname:
                UserActivity.enter(getActivity(), Constant.NICKNAME);
                break;

            case R.id.layout_sign:
                UserActivity.enter(getActivity(), Constant.SIGNATURE);

                break;
            case R.id.layout_delete:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        //进入到这里代表没有权限.请求权限
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2000);
                    } else {
                        clearCache();
                    }
                } else {
                    clearCache();
                }
                break;

            case R.id.rl_head:
                showPopWindow();


                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_headselect_layout, null);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        PopupWindow popupWindow = new PopupWindow(view, width, height);

        //PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.findViewById(R.id.text_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();

            }
        });


        view.findViewById(R.id.text_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();


            }
        });

        view.findViewById(R.id.text_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();


            }
        });
        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private void clearCache() {
        AppUtil.cleanExternalCache(getContext());
        AppUtil.cleanDatabases(getContext());
        AppUtil.cleanInternalCache(getContext());

        showToast("缓存已清理");
        text_hc.setText("0.0MB");

        text_hc.invalidate();
    }

    private void getUserInfo() {
        String token = loginEntity.getData().getToken();
        OkGo.<String>get(Constant.USER_INFO_URL)
                .tag(this)
                .headers(Constant.PARAM_XX_TOKEN, token)
                .headers(Constant.PARAM_XX_DEVICE_TYPE, Constant.PARAM_DEVICE_NAME)
                .execute(new StringCallback() {

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            Log.d("print", "onSuccess:152 " + codeMsgEntity);
                            if (codeMsgEntity.getCode() == 1) {
                                UserInfoEntity userInfoEntity = new Gson().fromJson(response.body(), UserInfoEntity.class);
                                Log.d("print", "onSuccess:用户信息 " + userInfoEntity);

                                String user_nickname = userInfoEntity.getData().getUser_nickname();
                                String mobile = userInfoEntity.getData().getMobile();
                                text_username.setText(mobile);

                                if (user_nickname.equals("")) {
                                    text_nickname.setText("用户");
                                } else {
                                    text_nickname.setText(user_nickname);
                                }
                                String signature = userInfoEntity.getData().getSignature();
                                if (signature.equals("")) {
                                    text_signature.setText("开开心心每一天~");
                                } else {
                                    text_signature.setText(signature);
                                }

                                SPUtils.putData(UserConfig.USER, userInfoEntity);
                            } else {
                                SPUtils.remove(UserConfig.LOGIN_USER);
                                SPUtils.remove(UserConfig.USER);
                                Toast.makeText(getActivity(), "用户登录已失效", Toast.LENGTH_SHORT).show();
                                UserActivity.enter(getActivity(), Constant.LOGIN);
                                getActivity().finish();
                            }


                        }
                    }
                });
    }

    private void postLogout() {

        String token = loginEntity.getData().getToken();

        Log.d("print", "postLogout:Token:" + token);
        if (loginEntity == null) {
            return;
        }

        OkGo.<String>post(Constant.LOGIN_OUT_URL)
                .tag(this)
                .headers(Constant.PARAM_CONTENT_TYPE, Constant.PARAM_APPLICATION)
                .headers(Constant.PARAM_XX_TOKEN, token)
                .headers(Constant.PARAM_XX_DEVICE_TYPE, Constant.PARAM_DEVICE_NAME)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();


                        if (!TextUtils.isEmpty(response.body()) && !response.body().equals("{")) {
                            Log.d("print", "onSuccess:88 " + response.body().toString());

                            TipEntity tipEntity = new Gson().fromJson(response.body(), TipEntity.class);
                            Toast.makeText(getActivity(), tipEntity.getMsg(), Toast.LENGTH_SHORT).show();

                            if (tipEntity.getCode() == 1) {
                                SPUtils.remove(UserConfig.LOGIN_USER);
                                SPUtils.remove(UserConfig.USER);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

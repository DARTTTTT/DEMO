package com.ltqh.qh.operation.activity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.ltqh.qh.BuildConfig;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.base.BaseActivity;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.ImgEntity;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.entity.TipEntity;
import com.ltqh.qh.entity.UserInfoEntity;
import com.ltqh.qh.operation.base.OBaseActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.utils.AppUtil;
import com.ltqh.qh.utils.FileUtil;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.view.CircleImageView;
import com.ltqh.qh.view.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import butterknife.BindView;
import skin.support.SkinCompatManager;

public class OPersonActivity extends OBaseActivity implements View.OnClickListener {


    @BindView(R.id.btn_logout)
    Button btn_logout;
    @BindView(R.id.layout_delete)
    RelativeLayout layout_delete;

    @BindView(R.id.tv_version)
    TextView text_version;

    @BindView(R.id.text_hc)
    TextView text_hc;

    @BindView(R.id.img_switch)
    ImageView img_switch;

    @BindView(R.id.text_switch)
    TextView text_switch;

    private int flag = 0;


    public static void enter(Context context) {
        Intent intent = new Intent(context, OPersonActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setContentLayout() {
        return R.layout.o_activity_person;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(View view) {
        String string = SPUtils.getString(OUserConfig.P_NIGHT);

        if (string.equals("")) {

        } else {
            if (string.equals("night")) {
                StatusBarUtil.setStatusBarDarkTheme(OPersonActivity.this, false);

            } else if (string.equals("day")) {
                StatusBarUtil.setStatusBarDarkTheme(OPersonActivity.this, true);
            }
        }

        btn_logout.setOnClickListener(this);

        this.findViewById(R.id.layout_change).setOnClickListener(this);
        this.findViewById(R.id.img_back).setOnClickListener(this);
        text_version.setText("version" + BuildConfig.VERSION_NAME);


        layout_delete.setOnClickListener(this);
        text_hc.setText(AppUtil.getAppClearSize(this));


        if (string.equals("")) {

        } else {
            if (string.equals("night")) {
                img_switch.setImageDrawable(getResources().getDrawable(R.mipmap.o_open_btn));
                text_switch.setText("开");
                flag = 1;

            } else if (string.equals("day")) {
                img_switch.setImageDrawable(getResources().getDrawable(R.mipmap.o_close_btn));
                flag = 0;
                text_switch.setText("关");

            }
        }


    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {

    }

    private void clearCache() {
        AppUtil.cleanExternalCache(OPersonActivity.this);
        AppUtil.cleanDatabases(OPersonActivity.this);
        AppUtil.cleanInternalCache(OPersonActivity.this);

        showToast("缓存已清理");
        text_hc.setText("0.0MB");

        text_hc.invalidate();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout:
                getLogout();
                break;

            case R.id.img_back:
                finish();
                break;


            case R.id.layout_delete:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(OPersonActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(OPersonActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        //进入到这里代表没有权限.请求权限
                        ActivityCompat.requestPermissions(OPersonActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2000);
                    } else {
                        clearCache();
                    }
                } else {
                    clearCache();
                }
                break;

            case R.id.layout_change:
                if (flag == 0) {

                    img_switch.setImageDrawable(getResources().getDrawable(R.mipmap.o_open_btn));
                    text_switch.setText("开");

                    SPUtils.putString(OUserConfig.P_NIGHT,"night");

                    EventBus.getDefault().post(new OEventData(OUserConfig.P_NIGHT,"night"));

                    StatusBarUtil.setStatusBarDarkTheme(OPersonActivity.this, false);

                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                    flag = 1;


                } else if (flag == 1) {
                    img_switch.setImageDrawable(getResources().getDrawable(R.mipmap.o_close_btn));
                    text_switch.setText("关");
                    EventBus.getDefault().post(new OEventData(OUserConfig.P_NIGHT,"day"));
                    StatusBarUtil.setStatusBarDarkTheme(OPersonActivity.this, true);
                    SPUtils.putString(OUserConfig.P_NIGHT,"day");
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                    flag = 0;


                }


                break;


        }
    }

    private void getLogout() {
        OkGo.<String>get(OConstant.URL_LOGOUT)
                .tag(this)
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
                            if (oCodeMsgEntity.getCode() == 200) {
                                OMineEntity data = SPUtils.getData(OUserConfig.USER, OMineEntity.class);
                                SPUtils.putString(OUserConfig.USER_ACCOUNT, data.getUser().getLoginMobile());
                                SPUtils.remove(OUserConfig.USER);
                                SPUtils.remove(OUserConfig.BASEMINE);
                                finish();


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


}

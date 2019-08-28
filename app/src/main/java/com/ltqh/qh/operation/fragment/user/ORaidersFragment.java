package com.ltqh.qh.operation.fragment.user;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.operation.activity.OMarketActivity;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.entity.OUnionEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.operation.utils.ImageUtil;
import com.ltqh.qh.operation.utils.OUtil;
import com.ltqh.qh.operation.utils.QRCodeUtil;
import com.ltqh.qh.utils.Util;
import com.ltqh.qh.view.AlphaChangeListener;
import com.ltqh.qh.view.MyScrollView;
import com.ltqh.qh.view.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

public class ORaidersFragment extends OBaseFragment implements View.OnClickListener {




    private Bitmap qrcode_bitmap;//生成的二维码





    @BindView(R.id.layout_bar)
    RelativeLayout layout_bar;

    @BindView(R.id.layout_bar2)
    RelativeLayout layout_bar2;

    @BindView(R.id.scrollView)
    MyScrollView myScrollView;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_raiders;
    }
    @Override
    protected void onLazyLoad() {
    }





    @Override
    protected void initView(View view) {
        StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = getResources().getDimensionPixelSize(resourceId);

        int i = Util.dip2px(getContext(), 48);

        Log.d("print", "initView:144:    "+statusBarHeight+"---"+i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, statusBarHeight + i);
        layout_bar.setLayoutParams(params);
        layout_bar2.setLayoutParams(params);

        myScrollView.setAlphaChangeListener(new AlphaChangeListener() {
            @Override
            public void alphaChanging(float alpha) {
                layout_bar2.setVisibility(View.VISIBLE);
                layout_bar2.setAlpha(alpha);
                layout_bar.setAlpha(1 - alpha);
              /*  if (alpha==0.0){
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);

                }else {
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), true);

                }*/


            }
        });

        view.findViewById(R.id.img_back).setOnClickListener(this);
        view.findViewById(R.id.btn_sure).setOnClickListener(this);



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
            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.btn_sure:
                List<String> dataList = QuoteProxy.getInstance().getDataList();

                if (dataList == null) {
                    return;
                }

                String s = dataList.get(0);

                OMarketActivity.enter(getActivity(), OConstant.OQUETO, "2", s);
                getActivity().finish();
                break;

        }
    }


}

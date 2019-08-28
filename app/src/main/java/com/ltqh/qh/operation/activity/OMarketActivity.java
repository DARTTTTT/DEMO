package com.ltqh.qh.operation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.fragment.quote.OQuoteFragment;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.view.StatusBarUtil;

public class OMarketActivity extends BaseActivity implements View.OnClickListener {
    private static final String TYPE = "USER_TYPE";
    private int type;


    private FragmentTransaction ft;


    @Override
    protected int setContentLayout() {
        return R.layout.o_activity_market;
    }

    public static void enter(Context context, int type) {
        Intent intent = new Intent(context, OMarketActivity.class);
        intent.putExtra(TYPE, type);
        context.startActivity(intent);
    }

    public static void enter(Context context, int type, String isTrade, String code) {
        Intent intent = new Intent(context, OMarketActivity.class);
        intent.putExtra(TYPE, type);
        intent.putExtra("ISTRADE", isTrade);
        intent.putExtra("DATA", code);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        type = getIntent().getIntExtra(TYPE, 0);

        if (type == OConstant.OQUETO) {
            addMarketFragment();
        }

    }


    private void addMarketFragment() {
        String data = getIntent().getStringExtra("DATA");
        String istrade = getIntent().getStringExtra("ISTRADE");

        OQuoteFragment oQuetoFragment = OQuoteFragment.newInstance(data, istrade);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_fragment_containter, oQuetoFragment).commit();
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
                StatusBarUtil.setStatusBarDarkTheme(OMarketActivity.this, false);

            } else if (string.equals("day")) {
                StatusBarUtil.setStatusBarDarkTheme(OMarketActivity.this, true);

            }
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}

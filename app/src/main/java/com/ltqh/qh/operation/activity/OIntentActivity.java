package com.ltqh.qh.operation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.fragment.home.OSearchFragment;
import com.ltqh.qh.operation.fragment.info.OAboutFragment;
import com.ltqh.qh.operation.fragment.info.OActivityFragment;
import com.ltqh.qh.operation.fragment.info.OConversionFragment;
import com.ltqh.qh.operation.fragment.info.OFinancialCalendarFragment;
import com.ltqh.qh.operation.fragment.info.OGuideBookFragment;
import com.ltqh.qh.operation.fragment.info.OHotFragment;
import com.ltqh.qh.operation.fragment.info.OReportFragment;
import com.ltqh.qh.operation.fragment.market.OAllAddMarketFragment;
import com.ltqh.qh.operation.fragment.market.OEditMarketFragment;
import com.ltqh.qh.operation.fragment.user.OLoginRegisterFragment;
import com.ltqh.qh.operation.fragment.user.ONoviceFragment;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.view.StatusBarUtil;

import butterknife.BindView;

public class OIntentActivity extends BaseActivity implements View.OnClickListener {
    private static final String TYPE = "USER_TYPE";
    private int type;
    @BindView(R.id.layout_bar)
    RelativeLayout layout_bar;

    @BindView(R.id.text_title)
    TextView text_title;

    private FragmentTransaction ft;
    private OLoginRegisterFragment oLoginFragment;

    private OAllAddMarketFragment oAllAddMarketFragment;

    private OEditMarketFragment oEditMarketFragment;

    private OFinancialCalendarFragment oFinancialCalendarFragment;

    private OGuideBookFragment oGuideBookFragment;

    private OAboutFragment oAboutFragment;

    private OReportFragment oReportFragment;

    private OHotFragment oHotFragment;

    private OSearchFragment oSearchFragment;

    private ONoviceFragment oNoviceFragment;

    private OConversionFragment oConversionFragment;

    @Override
    protected int setContentLayout() {
        return R.layout.o_activity_intent;
    }

    public static void enter(Context context, int type) {
        Intent intent = new Intent(context, OIntentActivity.class);
        intent.putExtra(TYPE, type);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = SPUtils.getString(OUserConfig.P_NIGHT);

        if (string.equals("")) {

        } else {
            if (string.equals("night")) {
                StatusBarUtil.setStatusBarDarkTheme(OIntentActivity.this, false);

            } else if (string.equals("day")) {
                StatusBarUtil.setStatusBarDarkTheme(OIntentActivity.this, true);
            }
        }

        type = getIntent().getIntExtra(TYPE, 0);

        if (type == OConstant.LOGIN) {
            layout_bar.setVisibility(View.GONE);
            addLoginFragment();
        } else if (type == OConstant.OADDMARKET) {
            text_title.setText("添加自选");
            addOaddMarketFragment();
        }else if (type == OConstant.OEDITMARKET) {
            layout_bar.setVisibility(View.GONE);
            addOEditMarketFragment();
        }else if (type == OConstant.O_FINANCE) {
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("财经播报");
            addOFinanceFragment();
        }else if (type == OConstant.O_GUIDEBOOK) {
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("新手指引");
            addOGuideBookFragment();
        }else if (type == OConstant.O_ABOUT) {
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("关于我们");
            addOAboutFragment();
        }else if (type == OConstant.O_REPORT) {
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("公告");
            addOReportFragment();
        }else if (type == OConstant.O_HOT) {
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("每日热点");
            addOHotFragment();
        }else if (type==OConstant.O_SEARCH){
            layout_bar.setVisibility(View.GONE);
            addSearchFragment();
        }else if (type==OConstant.O_NOVICE){
            layout_bar.setVisibility(View.VISIBLE);
            text_title.setText("任务详情");
            addNoviceFragment();
        }else if (type==OConstant.O_CONVERSION){
            layout_bar.setVisibility(View.GONE);
            addConversionFragment();
        }

    }

    private void addConversionFragment() {
        String name = OConversionFragment.class.getSimpleName();
        oConversionFragment = new OConversionFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oConversionFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addNoviceFragment() {
        String name = ONoviceFragment.class.getSimpleName();
        oNoviceFragment = new ONoviceFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oNoviceFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();

    }

    private void addSearchFragment() {
        String name = OSearchFragment.class.getSimpleName();
        oSearchFragment = new OSearchFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oSearchFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOHotFragment() {
        String name = OHotFragment.class.getSimpleName();
        oHotFragment = new OHotFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oHotFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOReportFragment() {
        String name = OReportFragment.class.getSimpleName();
        oReportFragment = new OReportFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oReportFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }


    private void addOAboutFragment() {
        String name = OAboutFragment.class.getSimpleName();
        oAboutFragment = new OAboutFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oAboutFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOGuideBookFragment() {

        String name = OGuideBookFragment.class.getSimpleName();
        oGuideBookFragment = new OGuideBookFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oGuideBookFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOFinanceFragment() {
        String name = OFinancialCalendarFragment.class.getSimpleName();
        oFinancialCalendarFragment = new OFinancialCalendarFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oFinancialCalendarFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();

    }


    private void addLoginFragment() {
        String name = OLoginRegisterFragment.class.getSimpleName();
        oLoginFragment = new OLoginRegisterFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oLoginFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOaddMarketFragment() {
        String name = OAllAddMarketFragment.class.getSimpleName();
        oAllAddMarketFragment = new OAllAddMarketFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oAllAddMarketFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    private void addOEditMarketFragment() {
        String name = OEditMarketFragment.class.getSimpleName();
        oEditMarketFragment = new OEditMarketFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment_containter, oEditMarketFragment, name);
        ft.addToBackStack(name);
        ft.commitAllowingStateLoss();
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(View view) {

        findViewById(R.id.img_back).setOnClickListener(this);

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
            case R.id.img_back:
                finish();
                break;
        }
    }
}

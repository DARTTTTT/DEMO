package com.ltqh.qh.fragment.market;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ltqh.qh.R;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.fragment.news.AlertsFragment;
import com.ltqh.qh.fragment.news.DubiFragment;
import com.ltqh.qh.fragment.news.FinancialCalendarFragment;
import com.ltqh.qh.fragment.news.LiveBannerFragment;
import com.ltqh.qh.view.EnhanceTabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class AllMarketTabFragment extends BaseFragment implements View.OnClickListener{


    private final static int PERIOD = 5 * 1000; // 5s






    @BindView(R.id.home_tab)
    EnhanceTabLayout home_tab;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private String Titles[] = new String[]{"国内", "国外"};



    @Override
    public void onResume() {
        super.onResume();



    }




    protected void initView(View view) {


        home_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < Titles.length; i++) {
            home_tab.addTab(Titles[i]);
        }

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(home_tab.getTabLayout()));
        home_tab.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        initViewPager(viewPager);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_allmarket_tab;
    }
    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.addFragment(new StockSlideFragment());
        myPagerAdapter.addFragment(new StockForeignFragment());

        viewPager.setAdapter(myPagerAdapter);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        startScheduleJob(mHandler, PERIOD, PERIOD);


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


        }
    };





    @Override
    public void onClick(View view) {
        switch (view.getId()) {



        }
    }




    public String dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }



    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

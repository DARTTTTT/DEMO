package com.ltqh.qh.fragment.forum;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.ltqh.qh.R;
import com.ltqh.qh.activity.PublishActivity;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.fragment.news.AlertsFragment;
import com.ltqh.qh.fragment.news.FinancialCalendarFragment;
import com.ltqh.qh.fragment.news.LiveFragment;
import com.ltqh.qh.view.EnhanceTabLayout;

import butterknife.BindView;

public class ForumTabFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.home_tab)
    EnhanceTabLayout home_tab;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private String Titles[] = new String[]{"讨论", "小组"};


    @BindView(R.id.layout_send)
    LinearLayout layout_send;

    @Override
    protected void initView(View view) {



        layout_send.setOnClickListener(this);

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

    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.addFragment(new ChatFragment());
        myPagerAdapter.addFragment(new GubaListFragment());

        viewPager.setAdapter(myPagerAdapter);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_tabforum;
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
            case R.id.layout_send:
                if (isLogin()) {
                  PublishActivity.enter(getActivity());

                } else {
                    UserActivity.enter(getActivity(), Constant.LOGIN);
                }

                break;
        }
    }
}

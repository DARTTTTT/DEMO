package com.ltqh.qh.operation.fragment.user;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ltqh.qh.R;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.fragment.user.LoginFragment;
import com.ltqh.qh.fragment.user.RegisterFragment;
import com.ltqh.qh.view.EnhanceTabLayout;

import butterknife.BindView;

public class OLoginRegisterFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.home_tab)
    EnhanceTabLayout home_tab;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private String Titles[] = new String[]{"登录", "注册"};

    @Override
    protected void initView(View view) {

        view.findViewById(R.id.img_back).setOnClickListener(this);

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
        myPagerAdapter.addFragment(new OLoginFragment());
        myPagerAdapter.addFragment(new ORegisterFragment());
        viewPager.setAdapter(myPagerAdapter);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_loginregister;
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

        }
    }

}

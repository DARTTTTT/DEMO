package com.ltqh.qh.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.IntentActivity;
import com.ltqh.qh.activity.PersonActivity;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.entity.UserInfoEntity;
import com.ltqh.qh.fragment.find.RecommendFragment;
import com.ltqh.qh.fragment.news.AlertsFragment;
import com.ltqh.qh.fragment.news.DubiFragment;
import com.ltqh.qh.fragment.news.FinancialCalendarFragment;
import com.ltqh.qh.fragment.news.LiveFragment;
import com.ltqh.qh.fragment.news.StockNewsFragment;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.view.CircleImageView;
import com.ltqh.qh.view.EnhanceTabLayout;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class HomeInfoFragment extends BaseFragment implements View.OnClickListener {

    private final static int PERIOD = 5 * 1000; // 5s

    @BindView(R.id.text_login)
    TextView text_login;



    @BindView(R.id.home_tab)
    EnhanceTabLayout home_tab;

    @BindView(R.id.viewpager)
    ViewPager viewPager;





    @BindView(R.id.img_head)
    CircleImageView img_head;



    private String Titles[] = new String[]{"市场", "7×24实时", "快讯", "日历财经", "币讯"};




    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_homeinfo;
    }

    @Override
    public void onResume() {
        super.onResume();
        LoginEntity loginEntity = SPUtils.getData(UserConfig.LOGIN_USER, LoginEntity.class);
        UserInfoEntity userInfoEntity = SPUtils.getData(UserConfig.USER, UserInfoEntity.class);

        if (userInfoEntity != null) {

            // getUserInfo();
            Glide.with(getActivity())
                    .load(Constant.USER_AVATER_URL + userInfoEntity.getData().getAvatar())
                    .asBitmap()
                    .error(R.mipmap.user_icon)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(img_head);
            String user_nickname = userInfoEntity.getData().getUser_nickname();
            if (user_nickname.equals("")) {
                text_login.setText("用户");
            } else {
                text_login.setText(userInfoEntity.getData().getUser_nickname());
            }

        } else {
            text_login.setText("登录");
            img_head.setImageDrawable(getResources().getDrawable(R.mipmap.user_icon));

            if (loginEntity != null) {
                Glide.with(getActivity())
                        .load(Constant.USER_AVATER_URL + loginEntity.getData().getUser().getAvatar())
                        .asBitmap()
                        .error(R.mipmap.user_icon)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .into(img_head);
                //  getUserInfo();

                String user_nickname = loginEntity.getData().getUser().getUser_nickname();
                if (user_nickname.equals("")) {
                    text_login.setText("用户");
                } else {
                    text_login.setText(loginEntity.getData().getUser().getUser_nickname());

                }
            }
        }


    }


    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {

            EventBus.getDefault().register(this);
        }
        text_login.setOnClickListener(this);


        img_head.setOnClickListener(this);



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


        startScheduleJob(mHandler, PERIOD, PERIOD);

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            //  getHomeGold();
            // updateNews();


        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(Integer integer) {
        if (integer == Constant.ONRESUME_LOGIN) {
            onResume();
        } else if (integer == Constant.ONRESUME_PERSON) {
            getUserInfo();
        }
    }

    private void getUserInfo() {
        LoginEntity loginEntity = SPUtils.getData(UserConfig.LOGIN_USER, LoginEntity.class);

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
                            //Log.d("print", "onSuccess:152 " + codeMsgEntity);
                            if (codeMsgEntity.getCode() == 1) {
                                UserInfoEntity userInfoEntity = new Gson().fromJson(response.body(), UserInfoEntity.class);
                                //   Log.d("print", "onSuccess:用户信息 " + userInfoEntity);

                                String user_nickname = userInfoEntity.getData().getUser_nickname();
                                String mobile = userInfoEntity.getData().getMobile();

                                Glide.with(getActivity())
                                        .load(Constant.USER_AVATER_URL + userInfoEntity.getData().getAvatar())
                                        .asBitmap()
                                        .error(R.mipmap.user_icon)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .centerCrop()
                                        .into(img_head);

                              /*  String signature = userInfoEntity.getData().getSignature();
                                if (signature.equals("")) {
                                    text_sign.setText("开开心心每一天~");
                                } else {
                                    text_sign.setText(signature);
                                }*/

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

    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());

        myPagerAdapter.addFragment(new StockNewsFragment());
        myPagerAdapter.addFragment(new LiveFragment());
        myPagerAdapter.addFragment(new AlertsFragment());
        myPagerAdapter.addFragment(new FinancialCalendarFragment());
        myPagerAdapter.addFragment(new DubiFragment());
        viewPager.setAdapter(myPagerAdapter);
    }


    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        //getBanner();

        // getHomeGold();

        //  getGold();
    }







    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_login:
            case R.id.img_head:

                if (isLogin()) {
                    PersonActivity.enter(getActivity());
                } else {
                    UserActivity.enter(getActivity(), Constant.LOGIN);
                }
                break;

            case R.id.text_more:

                IntentActivity.enter(getActivity(), Constant.STOCKMARKET);


                break;

            case R.id.text_ketang:
                IntentActivity.enter(getActivity(), Constant.LEARNCLASS);

                break;
            case R.id.text_quanzi:
                IntentActivity.enter(getActivity(), Constant.FORUM);

                break;
            case R.id.text_gongju:
                IntentActivity.enter(getActivity(), Constant.SKILLALL);

                break;
            case R.id.text_shipin:
                IntentActivity.enter(getActivity(), Constant.VIDEO);

                break;

            case R.id.img_add:
                IntentActivity.enter(getActivity(), Constant.TYPE);

                break;
        }
    }











    @Override
    public void onPause() {
        super.onPause();
        cancelTimer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();
        EventBus.getDefault().unregister(this);

    }
}

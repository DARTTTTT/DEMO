package com.ltqh.qh.operation.fragment.market;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.operation.activity.OIntentActivity;
import com.ltqh.qh.operation.activity.SecondActivity;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OReportEntity;
import com.ltqh.qh.utils.ListUtil;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.view.SkinInfoEnhanceTabLayout;
import com.ltqh.qh.view.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import skin.support.SkinCompatManager;

import static com.ltqh.qh.operation.base.OConstant.PERIOD;

public class OMarketFragment extends OBaseFragment implements View.OnClickListener {
    @BindView(R.id.home_tab)
    SkinInfoEnhanceTabLayout home_tab;

    @BindView(R.id.text_edit)
    TextView text_edit;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.layout_report)
    LinearLayout layout_report;

    @BindView(R.id.img_delete)
    ImageView img_delete;

    @BindView(R.id.img_night)
    ImageView img_night;

    @BindView(R.id.ts_news)
    TextSwitcher mTextSwitcherNews;
    private List<OReportEntity.NoticesBean> newSdata;
    private int mNewsIndex;
    private int flag = 0;

    private String Titles[] = new String[]{ "自选","全部", "国际", "股指", "国内"};
    private TextView textView;

    /*    @Override
        public void onHiddenChanged(boolean hidden) {
            super.onHiddenChanged(hidden);
            Log.d("print", "onHiddenChanged: "+hidden);
            initTabView();

        }*/
@Override
protected int setLayoutResourceID() {
    return R.layout.o_fragment_market;
}

    private void initTabView() {
        //  Log.d("print", "onStart:40:    "+"initTabView");

        home_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    text_edit.setVisibility(View.VISIBLE);

                } else {
                    text_edit.setVisibility(View.GONE);

                }
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
        viewPager.setOffscreenPageLimit(4);
        text_edit.setOnClickListener(this);
        initViewPager(viewPager);

        dismissProgressDialog();

    }


    @Override
    public void onStart() {
        super.onStart();
        //   Log.d("print", "onStart:79:    "+"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        //  Log.d("print", "onStart:85:    "+"onResume");

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            updateNews();


        }
    };

    private void updateNews() {
        if (newSdata != null) {
            mNewsIndex++;
            if (newSdata.size() > 0) {
                if (mNewsIndex >= newSdata.size()) mNewsIndex = 0;
                if (ListUtil.isNotEmpty(newSdata)) {
                    String title = newSdata.get(mNewsIndex).getTitle();
                    mTextSwitcherNews.setText(title);

                }
            }
        }
    }

    @Override
    protected void onLazyLoad() {
        // initTabView();
        // Log.d("print", "onStart:92:    "+"onLazyLoad");

        getReport();

        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_report.setVisibility(View.GONE);
                cancelTimer();
            }
        });


    }

    @Override
    protected void initView(View view) {
        //   Log.d("print", "onStart:92:    "+"initView");
        showProgressDialog();
        startScheduleJob(mHandler, PERIOD, PERIOD);



        mTextSwitcherNews.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(getContext());
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setLineSpacing(1.1f, 1.1f);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.o_text_5c5e76));
                textView.setTextSize(15);
                //   textView.setSingleLine();
                return textView;
            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initTabView();

            }
        }, 100);

        img_night.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }


    private void getReport() {


        OkGo.<String>get(OConstant.URL_NEWS_REPORT)
                .tag(this)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {


                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            OReportEntity oReportEntity = new Gson().fromJson(response.body(), OReportEntity.class);
                            SPUtils.putData(OUserConfig.CACHE_REPORT, oReportEntity);
                            newSdata = oReportEntity.getNotices();


                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");


                    }
                });
    }


    public String dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }

    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.addFragment(new OMineMarketFragment());
        myPagerAdapter.addFragment(new OAllMarketFragment());
        myPagerAdapter.addFragment(new OForeignMarketFragment());
        myPagerAdapter.addFragment(new OStockMarketFragment());
        myPagerAdapter.addFragment(new ODomesMarketFragment());
        viewPager.setAdapter(myPagerAdapter);
    }


    @Override
    protected void intPresenter() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_edit:
                OIntentActivity.enter(getActivity(), OConstant.OEDITMARKET);
                break;

            case R.id.img_night:
                String string = SPUtils.getString(OUserConfig.P_NIGHT);

                if (string.equals("")) {

                } else {
                    if (string.equals("night")) {
                        flag = 1;

                    } else if (string.equals("day")) {
                        flag = 0;

                    }
                }
                if (flag == 0) {

                    SPUtils.putString(OUserConfig.P_NIGHT, "night");
                    textView.setTextColor(ContextCompat.getColor(getContext(), R.color.o_text_8289));

                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                    flag = 1;
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);
                    EventBus.getDefault().post(new OEventData(OUserConfig.P_NIGHT,"night"));


                } else if (flag == 1) {

                    textView.setTextColor(ContextCompat.getColor(getContext(), R.color.o_text_2d2ef));

                    SPUtils.putString(OUserConfig.P_NIGHT, "day");
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                    flag = 0;
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), true);
                    EventBus.getDefault().post(new OEventData(OUserConfig.P_NIGHT,"day"));


                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }
}

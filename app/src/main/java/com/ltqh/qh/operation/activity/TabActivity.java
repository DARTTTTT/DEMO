package com.ltqh.qh.operation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.config.IntentConfig;
import com.ltqh.qh.fragment.find.QuestionFragment;
import com.ltqh.qh.operation.base.OBaseActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OMarketEntity;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.entity.ORuleEntity;
import com.ltqh.qh.operation.entity.OTradeListEntity;
import com.ltqh.qh.operation.fragment.home.OHomeFragment;
import com.ltqh.qh.operation.fragment.info.OInfoFragment;
import com.ltqh.qh.operation.fragment.market.OMarketFragment;
import com.ltqh.qh.operation.fragment.quote.OQuoteFragment;
import com.ltqh.qh.operation.fragment.user.OMyFragment;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.operation.quotebase.QuoteSubject;
import com.ltqh.qh.operation.utils.ODateUtil;
import com.ltqh.qh.utils.SPUtils;
import com.ltqh.qh.utils.Util;
import com.ltqh.qh.view.InfoEnhanceTabLayout;
import com.ltqh.qh.view.MyViewPager;
import com.ltqh.qh.view.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

import static com.ltqh.qh.operation.base.OConstant.MARKET_PERIOD;
import static com.ltqh.qh.operation.base.OConstant.PARAM_CALLBACK;
import static com.ltqh.qh.operation.base.OConstant.PARAM_CODE;
import static com.ltqh.qh.operation.base.OConstant.PARAM_SIMPLE;

public class TabActivity extends OBaseActivity  {


    private String Titles[] = new String[]{"首页", "行业", "交易", "资讯", "我的"};


    private List<String> dataList;
    private List<String> foreigndataList;
    private List<String> stockindexdataList;
    private List<String> domesdataList;
    private QuoteSubject quoteSubject;
    private FragmentTransaction ft;

    private OHomeFragment oHomeFragment;

    private OMarketFragment oMarketFragment;

    private OInfoFragment oInfoFragment;

    private OMyFragment oMyFragment;

    private OQuoteFragment oQuoteFragment;

    @BindView(R.id.home_tab)
    TabLayout home_tab;

    @BindView(R.id.viewpager)
    MyViewPager viewPager;


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    /**
     * 首页Tab索引
     */
    public static final class TAB_TYPE {
        public static final int COUNT = 4;
        public static final int TAB_HOME = 0;
        public static final int TAB_HALL = TAB_HOME + 1;
        public static final int TAB_POSITION = TAB_HALL + 1;
        public static final int TAB_INFORMATION = TAB_POSITION + 1;
        //   public static final int TAB_DISCOVERY = TAB_INFORMATION + 1;


        public static final int TAB_HALL_QUOTATION = 100;
        public static final int TAB_MY = 3;

    }

    public static void enter(Context context, int tabIndex) {

        Intent intent = new Intent(context, TabActivity.class);
        intent.putExtra(IntentConfig.Keys.POSITION, tabIndex);
        context.startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.hasExtra(IntentConfig.Keys.REGISTER_SUCCESS)) {
            //showCompleteInfoDialog(intent.getStringExtra(IntentConfig.Keys.REGISTER_SUCCESS));
        } else if (intent.hasExtra(IntentConfig.Keys.POSITION)) {
            int position = intent.getIntExtra(IntentConfig.Keys.POSITION, 0);
            home_tab.getTabAt(position);
        }
    }

    @Override
    protected void initView(View view) {



        List<String> dataList2 = QuoteProxy.getInstance().getDataList();

        if (dataList2 == null) {
            return;
        }

        String s2 = dataList2.get(0);

        oQuoteFragment = OQuoteFragment.newInstance(s2, "1");
        home_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        initViewPager(viewPager);
        //  viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(home_tab.getTabLayout()));
        viewPager.setOffscreenPageLimit(1);
        home_tab.setupWithViewPager(viewPager);





        if (!ODateUtil.isWeekend()) {
            startScheduleJob(mHandler, MARKET_PERIOD, MARKET_PERIOD);
        }

        StatusBarUtil.setRootViewFitsSystemWindows(this, false);




    }


    private void initViewPager(MyViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragment(new OHomeFragment(), "首页");
        myPagerAdapter.addFragment(new OMarketFragment(), "行情");
        myPagerAdapter.addFragment(oQuoteFragment, "交易");
        myPagerAdapter.addFragment(new OInfoFragment(), "资讯");
        myPagerAdapter.addFragment(new OMyFragment(), "我的");

        viewPager.setAdapter(myPagerAdapter);
    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            postQuote();


            if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {
                getShipanPosition();
                getMoniPosition();
                getMOniTradelist();
                getShipanTradelist();
            } else {
                SPUtils.remove(OUserConfig.LOGIN_USER);
            }


        }
    };
    private Fragment currentFragment = new Fragment();







    @Override
    protected int setContentLayout() {
        return R.layout.activity_tab;
    }

    @Override
    protected void initPresenter() {

    }


    private List<ORuleEntity> oRuleEntities;

    @Override
    protected void initData() {


        postQuote();
        if (QuoteProxy.getInstance().isLogin() == true) {
            getShipanPosition();
            getMoniPosition();
            getMOniTradelist();
            getShipanTradelist();
        } else {
            SPUtils.remove(OUserConfig.LOGIN_USER);

        }


        ORuleEntity rule = SPUtils.getData("rule", ORuleEntity.class);
        if (rule != null) {

        } else {
            String s = readTextFromSDcard();
            ORuleEntity oRuleEntity = new Gson().fromJson(s, ORuleEntity.class);
            SPUtils.putData("rule", oRuleEntity);
        }


    }

    //行情的请求
    public void postQuote() {
        String string = SPUtils.getString(OUserConfig.ALLDEX);
        if (string != null) {
            String code = string.replaceAll("\\[", "").replaceAll("]", "").replace(" ", "");
            OkGo.<String>post(OConstant.URL_MARKET)
                    .tag(this)
                    .params(PARAM_CALLBACK, "?")
                    .params(PARAM_CODE, code)
                    .params("_", Calendar.getInstance().getTimeInMillis())
                    .params(PARAM_SIMPLE, true)
                    .execute(new StringCallback() {
                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            super.onStart(request);

                        }

                        @Override
                        public void onSuccess(Response<String> response) {
                            if (!TextUtils.isEmpty(response.body())) {
                                String responese = Util.jsonReplace(response.body());
                                OMarketEntity oMarketEntity = new Gson().fromJson(responese, OMarketEntity.class);
                                String data = oMarketEntity.getData();
                                if (data != null) {
                                    String[] split = data.split(";");
                                    dataList = new ArrayList<>();
                                    for (String a : split) {
                                        dataList.add(a);
                                    }
                                }
                                //所有的行情
                                QuoteProxy.getInstance().setDataList(dataList);

                                foreigndataList = new ArrayList<>();
                                List<String> foreignList = QuoteProxy.getInstance().getForeignList();
                                if (foreignList != null) {
                                    for (String quote : dataList) {
                                        String[] split = quote.split(",");
                                        if (foreignList.toString().contains(split[0].replaceAll("[^a-z^A-Z]", ""))) {
                                            foreigndataList.add(quote);
                                        }
                                    }
                                    QuoteProxy.getInstance().setForeigndataList(foreigndataList);
                                }


                                stockindexdataList = new ArrayList<>();
                                List<String> stockindexList = QuoteProxy.getInstance().getStockindexList();
                                if (stockindexList != null) {
                                    for (String quote : dataList) {
                                        String[] split = quote.split(",");
                                        if (stockindexList.toString().contains(split[0].replaceAll("[^a-z^A-Z]", "")) & !split[0].replaceAll("[^a-z^A-Z]", "").equals("SI")) {
                                            stockindexdataList.add(quote);
                                        }
                                    }
                                    QuoteProxy.getInstance().setStockindexdataList(stockindexdataList);
                                }

                                domesdataList = new ArrayList<>();
                                List<String> domesList = QuoteProxy.getInstance().getDomesList();
                                if (domesList != null) {
                                    for (String quote : dataList) {
                                        String[] split = quote.split(",");
                                        if (domesList.toString().contains(split[0].replaceAll("[^a-z^A-Z]", ""))) {
                                            domesdataList.add(quote);
                                        }
                                    }
                                    QuoteProxy.getInstance().setDomesdataList(domesdataList);
                                }

                            }
                        }
                    });

        }

    }

    //实盘持仓
    private void getShipanPosition() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "1")
                .params(OConstant.PARAM_TRADETYPE, "1")
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OPositionEntity oPositionEntity = new Gson().fromJson(response.body(), OPositionEntity.class);
                            QuoteProxy.getInstance().setoPositionEntity(oPositionEntity);


                        }

                    }
                });

    }

    //模拟持仓
    private void getMoniPosition() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "1")
                .params(OConstant.PARAM_TRADETYPE, "2")
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OPositionEntity oPositionEntity = new Gson().fromJson(response.body(), OPositionEntity.class);
                            QuoteProxy.getInstance().setoPositionMoniEntity(oPositionEntity);

                        }

                    }
                });

    }

    //实盘tradelist
    private void getShipanTradelist() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "0")
                .params(OConstant.PARAM_TRADETYPE, "1")
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OTradeListEntity oPositionEntity = new Gson().fromJson(response.body(), OTradeListEntity.class);
                            QuoteProxy.getInstance().setoTradeListEntity(oPositionEntity);


                        }

                    }
                });

    }

    //模拟tradelist
    private void getMOniTradelist() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "0")
                .params(OConstant.PARAM_TRADETYPE, "2")
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OTradeListEntity oTradeListEntity = new Gson().fromJson(response.body(), OTradeListEntity.class);
                            QuoteProxy.getInstance().setoTradeListMoniEntity(oTradeListEntity);

                        }

                    }
                });

    }


    private String readTextFromSDcard() {
        InputStreamReader inputStreamReader;
        String resultString = null;
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("rule.json"), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
            resultString = stringBuilder.toString();
            Log.i("TAG", stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;
    }


    @Override
    protected void initEvent() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SPUtils.remove("KDATA");
        cancelTimer();

    }
}

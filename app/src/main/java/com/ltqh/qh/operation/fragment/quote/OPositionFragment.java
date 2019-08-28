package com.ltqh.qh.operation.fragment.quote;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.MyPagerAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.entity.OProfitEntity;
import com.ltqh.qh.operation.entity.ORechargeEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.operation.utils.ODateUtil;
import com.ltqh.qh.view.EnhanceTabLayout;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.ltqh.qh.operation.base.OConstant.ONE_PERIOD;

public class OPositionFragment extends OBaseFragment implements View.OnClickListener {
    @BindView(R.id.layout_view)
    LinearLayout layout_view;
    @BindView(R.id.home_tab)
    EnhanceTabLayout home_tab;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.text_profit)
    TextView text_profit;

    @BindView(R.id.text_balance)
    TextView text_balance;

    @BindView(R.id.text_bond)
    TextView text_bond;

    @BindView(R.id.text_service)
    TextView text_service;


    private String Titles[] = new String[]{"持仓", "结算"};
    private String isTrade;
    private OPositionListFragment oPositionListFragment;
    private OSettlementFragment oSettlementFragment;

    private List<OProfitEntity> oProfitEntities;
    private List<OPositionEntity.DataBean> data;

    private List<String> closeidlist;
    private String deposit;
    private String service;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String code = getArguments().getString("code");
            String[] split = code.split(",");
            isTrade = split[4];
            // Log.d("print", "onCreate:83:   "+isTrade);
        }


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData) {
        String key = oEventData.getKey();
        if (key.equals(OUserConfig.O_TRADE)) {
            isTrade = (String) oEventData.getObject();

        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_position;
    }

    @Override
    protected void onLazyLoad() {
        getPosition();

    }

    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        view.findViewById(R.id.text_all_close).setOnClickListener(this);
        view.findViewById(R.id.layout_recharge).setOnClickListener(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

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

                oPositionListFragment = OPositionListFragment.newInstance(isTrade);
                oSettlementFragment = OSettlementFragment.newInstance(isTrade);
                initViewPager(viewPager);
            }
        }, 100);


        OPositionEntity oPositionEntity = QuoteProxy.getInstance().getoPositionEntity();
        if (oPositionEntity != null) {
            if (oPositionEntity.isIsLogin() == true) {
                if (!ODateUtil.isWeekend()) {
                    startScheduleJob(mHandler, ONE_PERIOD, ONE_PERIOD);
                }
            } else {

            }
        }


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            getPosition();
        }
    };

    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.addFragment(oPositionListFragment);
        myPagerAdapter.addFragment(oSettlementFragment);
        viewPager.setAdapter(myPagerAdapter);
    }


    @Override
    protected void intPresenter() {

    }


    @Override
    protected void initData() {

        //  getPosition();


    }

    private String balance = null;
    private List<Double> incomelist;


    private void getPosition() {


        if (isTrade.equals("1")) {
            //获取实盘的保证金
            deposit = QuoteProxy.getInstance().getShipanDeposit();
            //获取实盘的综合费
            service = QuoteProxy.getInstance().getShipanService();

            double income = QuoteProxy.getInstance().getShipanincome();
            if (text_profit != null) {
                text_profit.setText(income + "");
            }

            OPositionEntity oPositionEntity = QuoteProxy.getInstance().getoPositionEntity();
            if (oPositionEntity == null) {
                return;
            }

            if (oPositionEntity.isIsLogin() == true) {

                data = oPositionEntity.getData();
                closeidlist = new ArrayList<>();
                for (OPositionEntity.DataBean itemdata : data) {
                    closeidlist.add(itemdata.getId());
                }
                balance = String.valueOf(oPositionEntity.getAsset().getMoney());

                if (text_balance != null) {
                    text_balance.setText(balance);
                }

            }

            QuoteProxy.getInstance().setShipanCloseList(closeidlist);


        } else if (isTrade.equals("2")) {
            deposit = QuoteProxy.getInstance().getMoniDeposit();
            service = QuoteProxy.getInstance().getMoniService();


            double income = QuoteProxy.getInstance().getMoniincome();
            if (text_profit != null) {
                text_profit.setText(income + "");
            }

            OPositionEntity oPositionEntity = QuoteProxy.getInstance().getoPositionMoniEntity();
            if (oPositionEntity == null) {
                return;
            }
            if (oPositionEntity.isIsLogin() == true) {
                data = oPositionEntity.getData();
                closeidlist = new ArrayList<>();


                for (OPositionEntity.DataBean itemdata : data) {
                    closeidlist.add(itemdata.getId());

                }
                balance = String.valueOf(oPositionEntity.getAsset().getGame());
                if (text_balance != null) {
                    text_balance.setText(balance);
                }

            }
            //设置可平仓的列表
            QuoteProxy.getInstance().setMoniCloseList(closeidlist);

        }


        if (deposit != null) {
            if (text_bond != null) {
                text_bond.setText(deposit);
            }
        }

        if (service != null) {
            if (text_service != null) {
                text_service.setText(service);
            }
        }
    }


    private void postClose(String idList, String source) {

        OkGo.<String>post(OConstant.URL_CLOSE)
                .params(OConstant.PARAM_BETTINGLIST, idList)
                .params(OConstant.PARAM_TRADETYPE, isTrade)
                .params(OConstant.PARAM_SOURCE, source)
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
                            Log.d("print", "onSuccess:250:  " + oCodeMsgEntity);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();

                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();
        EventBus.getDefault().unregister(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_all_close:
                String replace = closeidlist.toString().replaceAll("\\[", "").replaceAll("]", "").replace(" ", "");
                postClose(replace, "下单");
                if (isTrade.equals("2")) {
                    QuoteProxy.getInstance().setMoniDeposit("0.0");
                    QuoteProxy.getInstance().setMoniService("0.0");

                } else if (isTrade.equals("1")) {
                    QuoteProxy.getInstance().setShipanDeposit("0.0");
                    QuoteProxy.getInstance().setShipanService("0.0");

                }

                break;

            case R.id.layout_recharge:
                if (isTrade.equals("2")) {

                    getAddScore();
                } else if (isTrade.equals("1")) {
                    ORechargeEntity oRechargeEntity = QuoteProxy.getInstance().getoRechargeEntity();
                    if (oRechargeEntity == null) {
                        Toast.makeText(getActivity(), "请求中...", Toast.LENGTH_SHORT).show();
                        postRecharge();
                    } else {
                        int payFirst = oRechargeEntity.getPayFirst();
                        if (payFirst == 1) {
                            showItemPopWindow();
                        } else {
                            OUserActivity.enter(getActivity(), OConstant.O_RECHARGE);
                        }
                    }
                }
                break;
        }
    }
    private void getAddScore() {
        OkGo.<String>get(OConstant.URL_ADDSCORE)
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
                            Toast.makeText(getActivity(), oCodeMsgEntity.getResultMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                    }
                });


    }
    private void postRecharge() {

        OkGo.<String>post(OConstant.URL_RECHARGE)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_GET_PAY_LIST)
                .params(OConstant.PARAM_SWITCH_TYPE, "1")
                .params(OConstant.PARAM_PLATFORM, OConstant.STAY_ANDROID)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {
                            if (!TextUtils.isEmpty(response.body())) {

                                ORechargeEntity oRechargeEntity = new Gson().fromJson(response.body(), ORechargeEntity.class);

                                QuoteProxy.getInstance().setoRechargeEntity(oRechargeEntity);

                            }
                        } else {

                        }
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showItemPopWindow() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_check_pop, null);
        EditText edit_name = view.findViewById(R.id.edit_name);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);


        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);

        TextView text_back = view.findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        //关键
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                postCheckName(name);
            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }

    public void backgroundAlpha(float bgalpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgalpha;
        getActivity().getWindow().setAttributes(lp);


    }

    //核实用户验证
    private void postCheckName(String name) {

        String url = OConstant.URL_RECHARGE + "?" + OConstant.PARAM_ACTION + "=" + OConstant.STAY_CHECKNAME + "&" + OConstant.PARAM_NAME + "=" + name;
        Log.d("print", "postCheckName:309:   " + url);
        OkGo.<String>post(url)
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
                            Log.d("print", "onSuccess:315:   " + response.body());
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                postRecharge();
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), getString(R.string.o_text_err), Toast.LENGTH_SHORT).show();

                    }
                });

    }
}

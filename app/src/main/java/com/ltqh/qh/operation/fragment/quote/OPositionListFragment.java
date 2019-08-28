package com.ltqh.qh.operation.fragment.quote;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.adapter.OPositionAdapter;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OApiEntity;
import com.ltqh.qh.operation.entity.OBondEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.entity.OTradeListEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.operation.utils.ODateUtil;
import com.ltqh.qh.operation.utils.OUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;

import static com.ltqh.qh.operation.base.OConstant.ONE_PERIOD;

public class OPositionListFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.layout_view)
    RelativeLayout layout_view;


    private OPositionAdapter oPositionAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.layout_main)
    LinearLayout layout_main;

    @BindView(R.id.layout_add)
    LinearLayout layout_add;

  /*  @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;*/

    private String isTrade;
    private double minprofitloss;
    private List<Double> depositList;
    private List<Double> serviceList;
    private double div;
    private List<Integer> stopLossList;
    private List<Integer> tradeBeanDepositList;
    private int chargeUnit;
    private int volume;
    private Set<OBondEntity> oBondEntityList;
    private int moneyType;


    public static OPositionListFragment newInstance(String istrade) {
        OPositionListFragment fragment = new OPositionListFragment();
        Bundle args = new Bundle();
        args.putString("istrade", istrade);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isTrade = getArguments().getString("istrade");
            //  Log.d("print", "onCreate:39: "+isTrade);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData){
        String key = oEventData.getKey();
        if (key.equals(OUserConfig.O_TRADE)){
            isTrade= (String) oEventData.getObject();

        }
    }


    @Override
    protected void initView(View view) {

        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        if (!ODateUtil.isWeekend()) {

            startScheduleJob(mHandler, ONE_PERIOD, ONE_PERIOD);
        }
       /* swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPosition();
            }
        });*/

       layout_add.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        oPositionAdapter = new OPositionAdapter(getActivity());

        recyclerView.setAdapter(oPositionAdapter);

        oPositionAdapter.setOnItemClick(new OPositionAdapter.OnItemClick() {
            @Override
            public void onPingcangListener(int position, OPositionEntity.DataBean dataBean) {
                postClose(dataBean.getId(), "下单", position);

            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onTiaozhengListener(OPositionEntity.DataBean dataBean) {

                showPopWindow(dataBean);

            }

            @Override
            public void onDetailListener(OPositionEntity.DataBean dataBean) {

                EventBus.getDefault().post(new OEventData(OUserConfig.O_POSITION_DETAIL,dataBean));

            }
        });


    }


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow(OPositionEntity.DataBean dataBean) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_spsl, null);

        TextView text_name = view.findViewById(R.id.text_name);

        TextView text_volum = view.findViewById(R.id.text_volum);

        TextView text_income = view.findViewById(R.id.text_income);

        TextView text_minprofit = view.findViewById(R.id.min_profit);
        TextView text_maxprofit = view.findViewById(R.id.max_profit);
        TextView text_minloss = view.findViewById(R.id.min_loss);
        TextView text_maxloss = view.findViewById(R.id.max_loss);

        TextView text_stopprofit = view.findViewById(R.id.text_stopprofit);

        TextView text_stoploss = view.findViewById(R.id.text_stoploss);


        SeekBar seekBar_profit = view.findViewById(R.id.seekbar_profit);


        OApiEntity oApiEntity = QuoteProxy.getInstance().getoApiEntity();


        text_name.setText(dataBean.getCommodity() + dataBean.getContCode());


        boolean isBuy = dataBean.isIsBuy();
        if (isBuy == true) {
            text_volum.setText("买多" + dataBean.getVolume() + "手");
        } else if (isBuy == false) {
            text_volum.setText("买空" + dataBean.getVolume() + "手");
        }

        List<String> dataList = QuoteProxy.getInstance().getDataList();

        double opPrice = dataBean.getOpPrice();
        int moneyType = dataBean.getMoneyType();
        double multiple = 1;
        if (moneyType == 0) {
            multiple = 1;
        } else if (moneyType == 1) {
            multiple = 10;
        }
        String lastPrice = null;

        if (dataList == null) {
            return;
        }

        for (String quote : dataList) {
            String[] split = quote.split(",");
            if (dataBean.getContCode().replaceAll("[^a-z^A-Z]", "").equals(split[0].replaceAll("[^a-z^A-Z]", ""))) {
                lastPrice = split[2];
            }
        }


        List<OApiEntity.ForeignCommdsBean> foreignCommds = oApiEntity.getForeignCommds();
        List<OApiEntity.StockIndexCommdsBean> stockIndexCommds = oApiEntity.getStockIndexCommds();
        List<OApiEntity.DomesticCommdsBean> domesticCommds = oApiEntity.getDomesticCommds();

        String priceChange = null;
        String price = null;
        double sub = 0;
        if (isBuy == true) {
            sub = OUtil.sub(Double.valueOf(lastPrice), opPrice);

        } else {
            sub = OUtil.sub(opPrice, Double.valueOf(lastPrice));

        }
        double income = 0;
        double allcome = 0;

        if (foreignCommds == null) {
            return;
        }

        if (stockIndexCommds == null) {
            return;
        }

        if (domesticCommds == null) {
            return;
        }


        for (OApiEntity.ForeignCommdsBean foreign : foreignCommds) {
            if (foreign.getCode().equals(dataBean.getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                price = foreign.getPrice();
                priceChange = foreign.getPriceChange();

                double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                income = OUtil.mul(mul2, div2);
                double div_income = OUtil.div(income, multiple, 1);

                allcome = OUtil.mul(div_income, dataBean.getVolume());

                minprofitloss = OUtil.mul(mul2, dataBean.getVolume());


            }
        }
        for (OApiEntity.StockIndexCommdsBean foreign : stockIndexCommds) {
            if (foreign.getCode().equals(dataBean.getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                price = foreign.getPrice();
                priceChange = foreign.getPriceChange();

                double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                income = OUtil.mul(mul2, div2);
                double div_income = OUtil.div(income, multiple, 1);

                allcome = OUtil.mul(div_income, dataBean.getVolume());
                //allcome = OUtil.mul(income, dataBean.getVolume());

                minprofitloss = OUtil.mul(mul2, dataBean.getVolume());

            }
        }
        for (OApiEntity.DomesticCommdsBean foreign : domesticCommds) {
            if (foreign.getCode().equals(dataBean.getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                price = foreign.getPrice();
                priceChange = foreign.getPriceChange();


                double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                income = OUtil.mul(mul2, div2);
                double div_income = OUtil.div(income, multiple, 1);

                allcome = OUtil.mul(div_income, dataBean.getVolume());
               // allcome = OUtil.mul(income, dataBean.getVolume());

                minprofitloss = OUtil.mul(mul2, dataBean.getVolume());


            }
        }

        if (allcome >= 0) {
            text_income.setTextColor(getResources().getColor(R.color.redcolor));
        } else {
            text_income.setTextColor(getResources().getColor(R.color.greencolor));
        }


        text_income.setText(allcome + "元");


        if (opPrice == 0.0) {
            text_income.setText("正在加载");
            text_income.setTextSize(15f);

        } else {
            text_income.setTextSize(29f);
            text_income.setText(allcome + "元");
        }


        text_minprofit.setText(String.valueOf(minprofitloss) + "元");
        text_minloss.setText("-" + String.valueOf(minprofitloss) + "元");


        double stopProfit = dataBean.getStopProfit();
        double stopProfitBegin = dataBean.getStopProfitBegin();

        double add = OUtil.add(stopProfitBegin, minprofitloss);
        //止盈条设置最大值
        seekBar_profit.setMax((int) add);
        //止盈条设置最小值
        seekBar_profit.setMin((int) minprofitloss);
        //默认数据
        text_stopprofit.setText(String.valueOf(stopProfit));
        //显示
        text_maxprofit.setText(String.valueOf(stopProfitBegin) + "元");
        //bar的默认位置
        seekBar_profit.setProgress((int) stopProfit);

        seekBar_profit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                int a = (int) (progress / minprofitloss);
                int b = (int) (a * minprofitloss);
                text_stopprofit.setText(b + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar_loss = view.findViewById(R.id.seekbar_loss);


        double stopLoss = dataBean.getStopLoss();
        double stopLossBegin = dataBean.getStopLossBegin();

        double sub1 = OUtil.sub(stopLossBegin, minprofitloss);
        seekBar_loss.setMax((int) (sub1 - (sub1 + sub1)));
        seekBar_loss.setMin((int) (minprofitloss));

        text_stoploss.setText(String.valueOf(stopLoss));

        text_maxloss.setText(String.valueOf(stopLossBegin) + "元");

        seekBar_loss.setProgress((int) (stopLoss - (stopLoss + stopLoss)));

        seekBar_loss.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = (int) ((progress - (progress + progress)) / minprofitloss);
                int b = (int) (a * minprofitloss);
                text_stoploss.setText(b + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        view.findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postChange(dataBean.getId(), text_stopprofit.getText().toString(), text_stoploss.getText().toString(), popupWindow);

            }
        });

        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }


    private void postChange(String id, String toString, String toString1, PopupWindow popupWindow) {
        OkGo.<String>post(OConstant.URL_SPSL)
                .params(OConstant.PARAM_BETTINGID, id)
                .params(OConstant.PARAM_TRADETYPE, isTrade)
                .params(OConstant.PARAM_STOPPROFIT, toString)
                .params(OConstant.PARAM_STOPLOSS, toString1)
                .params(OConstant.PARAM_SOURCE, "设置止盈止损")
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
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            Log.d("print", "onSuccess:442:   "+oCodeMsgEntity);
                            if (oCodeMsgEntity.isSuccess() == true) {

                                popupWindow.dismiss();
                            }
                        }
                    }
                });

    }


    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_positionlist;
    }

    @Override
    protected void intPresenter() {

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getPosition();
        }
    };


    @Override
    protected void initData() {

        getPosition();
    }

    private void getPosition() {


        switch (isTrade) {

            case "1":


                OPositionEntity oPositionEntity = QuoteProxy.getInstance().getoPositionEntity();
                OTradeListEntity oTradeListEntity = QuoteProxy.getInstance().getoTradeListEntity();

                if (oPositionEntity != null) {

                    if (oPositionEntity.isIsLogin() == true) {

                        List<OPositionEntity.DataBean> data = oPositionEntity.getData();
                        if (data.size() != 0) {

                            oPositionAdapter.setDatas(data);
                            oPositionAdapter.setTradeList(oTradeListEntity);
                            if (layout_main != null && layout_add != null) {
                                layout_main.setVisibility(View.VISIBLE);
                                layout_add.setVisibility(View.GONE);
                            }

                            if (oTradeListEntity==null){
                                return;
                            }
                            List<OTradeListEntity.TradeListBean> tradeList = oTradeListEntity.getTradeList();
                            int deposit = 0;


                            depositList = new ArrayList<>();
                            serviceList = new ArrayList<>();


                            for (OPositionEntity.DataBean optionBean : data) {
                                for (OTradeListEntity.TradeListBean tradeBean : tradeList) {
                                    moneyType = optionBean.getMoneyType();
                                    if (tradeBean.getContCode().equals(optionBean.getContCode())) {

                                        double multiple = 1;
                                        if (moneyType == 0) {
                                            multiple = 1;
                                        } else if (moneyType == 1) {
                                            multiple = 10;
                                        }

                                        double stopLossBegin = optionBean.getStopLossBegin();
                                        volume = optionBean.getVolume();
                                        div = OUtil.div(stopLossBegin, volume, 0);
                                        stopLossList =tradeBean.getStopLossList();
                                        tradeBeanDepositList = tradeBean.getDepositList();
                                        chargeUnit = tradeBean.getChargeUnit();
                                        double server_div = OUtil.div(chargeUnit, multiple, 1);
                                        double mul2 = OUtil.mul(server_div, volume);
                                        serviceList.add(mul2);
                                        if (stopLossList.size()==0){
                                            return;
                                        }


                                        for (int i2 = 0; i2 < stopLossList.size(); i2++) {
                                            //这里为何要乘是因为角模式
                                            double mul1 = OUtil.mul(this.div, multiple);
                                            if (mul1 == stopLossList.get(i2)) {

                                                if (tradeBeanDepositList.size()!=0){
                                                    double deposit_div = OUtil.div(tradeBeanDepositList.get(i2), multiple, 1);
                                                    double mul = OUtil.mul(deposit_div, volume);
                                                    deposit = tradeBeanDepositList.get(i2) * volume;
                                                    depositList.add(mul);
                                                }else {
                                                    double deposit_div = OUtil.div(stopLossList.get(i2), multiple, 1);
                                                    double mul = OUtil.mul(deposit_div, volume);
                                                    double mul3 = OUtil.mul(mul, -1);
                                                    deposit = stopLossList.get(i2) * volume;
                                                    depositList.add(mul3);
                                                }

                                            }
                                        }


                                    }
                                }
                            }


                            double monideposit = 0;
                            for (int i = 0; i < depositList.size(); i++) {
                                monideposit += depositList.get(i);
                            }

                            double moniservice = 0;
                            for (int i = 0; i < serviceList.size(); i++) {
                                moniservice += serviceList.get(i);
                            }

                            double monideposit_double = OUtil.double1Point(monideposit);
                            double moniservice_double = OUtil.double1Point(moniservice);

                            QuoteProxy.getInstance().setShipanDeposit(String.valueOf(monideposit_double));
                            QuoteProxy.getInstance().setShipanService(String.valueOf(moniservice_double));


                        } else {
                            if (layout_main != null && layout_add != null) {
                                layout_main.setVisibility(View.GONE);
                                layout_add.setVisibility(View.VISIBLE);
                            }
                            QuoteProxy.getInstance().setShipanDeposit("0.0");
                            QuoteProxy.getInstance().setShipanService("0.0");

                        }
                    } else {

                    }
                }
                break;

            case "2":


                OPositionEntity oPositionEntity1 = QuoteProxy.getInstance().getoPositionMoniEntity();
                OTradeListEntity oTradeListEntity1 = QuoteProxy.getInstance().getoTradeListEntity();


                if (oPositionEntity1 != null) {

                    if (oPositionEntity1.isIsLogin() == true) {

                        List<OPositionEntity.DataBean> data = oPositionEntity1.getData();
                        if (data.size() != 0) {

                            oPositionAdapter.setDatas(data);
                            oPositionAdapter.setTradeList(oTradeListEntity1);
                            if (layout_main != null && layout_add != null) {
                                layout_main.setVisibility(View.VISIBLE);
                                layout_add.setVisibility(View.GONE);
                            }

                            if (oTradeListEntity1==null){
                                return;
                            }
                            List<OTradeListEntity.TradeListBean> tradeList = oTradeListEntity1.getTradeList();

                            int deposit = 0;
                            depositList = new ArrayList<>();
                            serviceList = new ArrayList<>();

                            for (OPositionEntity.DataBean optionBean : data) {
                                moneyType = optionBean.getMoneyType();
                                for (OTradeListEntity.TradeListBean tradeBean : tradeList) {
                                    if (tradeBean.getContCode().equals(optionBean.getContCode())) {
                                        double multiple = 1;
                                        if (moneyType == 0) {
                                            multiple = 1;
                                        } else if (moneyType == 1) {
                                            multiple = 10;
                                        }

                                        double stopLossBegin = optionBean.getStopLossBegin();
                                        volume = optionBean.getVolume();
                                        div = OUtil.div(stopLossBegin, volume, 0);
                                        stopLossList = tradeBean.getStopLossList();
                                        tradeBeanDepositList = tradeBean.getDepositList();
                                        chargeUnit = tradeBean.getChargeUnit();

                                        double server_div = OUtil.div(chargeUnit, multiple, 1);
                                        double mul2 = OUtil.mul(server_div, volume);
                                        serviceList.add(mul2);


                                        if (stopLossList.size()==0){
                                            return;
                                        }
                                    /*if (tradeBeanDepositList.size()==0){
                                        return;
                                    }*/
                                        for (int i2 = 0; i2 < stopLossList.size(); i2++) {
                                            double mul1 = OUtil.mul(div, multiple);
                                            // Log.d("print", "getPosition:659:  "+mul1+"-----"+multiple+"-----  "+div+"-------"+stopLossList);
                                            // Log.d("print", "getPosition:691:  "+tradeBeanDepositList);

                                            if (mul1 == stopLossList.get(i2)) {
                                                if (tradeBeanDepositList.size()!=0){
                                                    double deposit_div = OUtil.div(tradeBeanDepositList.get(i2), multiple, 1);
                                                    double mul = OUtil.mul(deposit_div, volume);
                                                    deposit = tradeBeanDepositList.get(i2) * volume;
                                                    depositList.add(mul);
                                                }else {
                                                    double deposit_div = OUtil.div(stopLossList.get(i2), multiple, 1);
                                                    double mul = OUtil.mul(deposit_div, volume);
                                                    double mul3 = OUtil.mul(mul, -1);

                                                    deposit = stopLossList.get(i2) * volume;
                                                    depositList.add(mul3);
                                                }


                                            }
                                        }
                                    }
                                }
                            }


                            double monideposit = 0;
                            if (depositList.size()!=0){
                                for (int i = 0; i < depositList.size(); i++) {
                                    monideposit += depositList.get(i);
                                }
                            }else {
                                for (int i = 0; i < stopLossList.size(); i++) {
                                    monideposit += stopLossList.get(i);
                                }
                            }


                            double moniservice = 0;
                            for (int i = 0; i < serviceList.size(); i++) {
                                moniservice += serviceList.get(i);
                            }
                            double monideposit_double = OUtil.double1Point(monideposit);
                            double moniservice_double = OUtil.double1Point(moniservice);

                            QuoteProxy.getInstance().setMoniDeposit(String.valueOf(monideposit_double));
                            QuoteProxy.getInstance().setMoniService(String.valueOf(moniservice_double));


                        } else {
                            if (layout_main != null && layout_add != null) {
                                layout_main.setVisibility(View.GONE);
                                layout_add.setVisibility(View.VISIBLE);

                            }
                            QuoteProxy.getInstance().setMoniDeposit("0.0");
                            QuoteProxy.getInstance().setMoniService("0.0");

                        }
                    } else {

                    }
                }


                break;


        }

    }

    //private List<OTradeListEntity.TradeListBean> selecttradeList;
    //private List<OPositionEntity.DataBean> selectoptionList;


    private void postClose(String id, String source, int position) {

        OkGo.<String>post(OConstant.URL_CLOSE)
                .params(OConstant.PARAM_BETTINGID, id)
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
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                // oPositionAdapter.removeItemData(position);
                                if (isTrade.equals("2")) {

                                } else if (isTrade.equals("1")) {

                                }

                            }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_add:
                EventBus.getDefault().post(new OEventData(OUserConfig.O_POSITION,true));
                break;
        }
    }
}

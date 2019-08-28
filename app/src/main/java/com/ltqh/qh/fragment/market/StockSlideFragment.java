package com.ltqh.qh.fragment.market;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.IntentActivity;
import com.ltqh.qh.adapter.StockTabAdapter;
import com.ltqh.qh.adapter.StockslideAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.StockEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

public class StockSlideFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.recyclerview_zhangdiefu)
    RecyclerView recyclerView_zhagndiefu;

    @BindView(R.id.recyclerview_zhangdiee)
    RecyclerView recyclerView_zahgndiee;

    @BindView(R.id.recyclerview_chengjiaoliang)
    RecyclerView recyclerView_chengjiaoliang;

    @BindView(R.id.recyclerview_chengjiaoe)
    RecyclerView recyclerView_chengjiaoe;

    @BindView(R.id.recyclerview_huanshoulv)
    RecyclerView recyclerView_huanshoulv;

    private StockslideAdapter stockslideAdapter, stockslideAdapter2, stockslideAdapter3, stockslideAdapter4, stockslideAdapter5;

    int page = 1;
    private int lastVisibleItem;
    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";
    // private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;

    private String SORT = Constant.STAY_CHANGEPERCENT;

    private StockTabAdapter stockTabAdapter;

    @Override
    protected void initView(View view) {
        stockslideAdapter = new StockslideAdapter(getActivity());
        recyclerView_zhagndiefu.setLayoutManager(new GridLayoutManager(getActivity(), 2,LinearLayoutManager.VERTICAL,false));
        recyclerView_zhagndiefu.setAdapter(stockslideAdapter);

        stockslideAdapter2 = new StockslideAdapter(getActivity());
        recyclerView_zahgndiee.setLayoutManager(new GridLayoutManager(getActivity(), 2,LinearLayoutManager.VERTICAL,false));
        recyclerView_zahgndiee.setAdapter(stockslideAdapter2);

        stockslideAdapter3 = new StockslideAdapter(getActivity());
        recyclerView_chengjiaoliang.setLayoutManager(new GridLayoutManager(getActivity(), 2,LinearLayoutManager.VERTICAL,false));
        recyclerView_chengjiaoliang.setAdapter(stockslideAdapter3);

        stockslideAdapter4 = new StockslideAdapter(getActivity());
        recyclerView_chengjiaoe.setLayoutManager(new GridLayoutManager(getActivity(), 2,LinearLayoutManager.VERTICAL,false));
        recyclerView_chengjiaoe.setAdapter(stockslideAdapter4);

        stockslideAdapter5 = new StockslideAdapter(getActivity());
        recyclerView_huanshoulv.setLayoutManager(new GridLayoutManager(getActivity(), 2,LinearLayoutManager.VERTICAL,false));
        recyclerView_huanshoulv.setAdapter(stockslideAdapter5);


        stockTabAdapter = new StockTabAdapter(getActivity());
        linearLayoutManager = new LinearLayoutManager(getActivity());


        view.findViewById(R.id.text_more).setOnClickListener(this);
        view.findViewById(R.id.text_more1).setOnClickListener(this);
        view.findViewById(R.id.text_more2).setOnClickListener(this);
        view.findViewById(R.id.text_more3).setOnClickListener(this);
        view.findViewById(R.id.text_more4).setOnClickListener(this);


    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stockslide;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {


        getStock1(Constant.STAY_CHANGEPERCENT);
        getStock2(Constant.STAY_PRICECHANGE);
        getStock3(Constant.STAY_VOLUME);
        getStock4(Constant.STAY_AMOUNT);
        getStock5(Constant.STAY_TURNOVERRATIO);

    }


    private void getStock1(String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 6)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode() ==1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                stockslideAdapter.setDatas(data);

                            } else {
                                stockslideAdapter.stopLoad();
                            }

                        } else {
                            stockslideAdapter.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    private void getStock2(String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 6)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode() ==1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                stockslideAdapter2.setDatas(data);

                            } else {
                                stockslideAdapter2.stopLoad();
                            }

                        } else {
                            stockslideAdapter2.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    private void getStock3(String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 6)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode() ==1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                stockslideAdapter3.setDatas(data);

                            } else {
                                stockslideAdapter3.stopLoad();
                            }

                        } else {
                            stockslideAdapter3.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    private void getStock4(String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 6)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode()== 1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                stockslideAdapter4.setDatas(data);

                            } else {
                                stockslideAdapter4.stopLoad();
                            }

                        } else {
                            stockslideAdapter4.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    private void getStock5(String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 6)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
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

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode() ==1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                stockslideAdapter5.setDatas(data);

                            } else {
                                stockslideAdapter5.stopLoad();
                            }

                        } else {
                            stockslideAdapter5.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.text_more:
                IntentActivity.enter(getActivity(),Constant.STOCKSLIDE,Constant.STAY_CHANGEPERCENT,"涨跌幅");
                break;

            case R.id.text_more1:
                IntentActivity.enter(getActivity(),Constant.STOCKSLIDE,Constant.STAY_PRICECHANGE,"涨跌额");

                break;

            case R.id.text_more2:
                IntentActivity.enter(getActivity(),Constant.STOCKSLIDE,Constant.STAY_VOLUME,"成交量");

                break;

            case R.id.text_more3:
                IntentActivity.enter(getActivity(),Constant.STOCKSLIDE,Constant.STAY_AMOUNT,"成交额");

                break;
            case R.id.text_more4:
                IntentActivity.enter(getActivity(),Constant.STOCKSLIDE,Constant.STAY_TURNOVERRATIO,"换手率");

                break;


        }
    }


}

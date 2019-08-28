package com.ltqh.qh.fragment.market;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.IntentActivity;
import com.ltqh.qh.adapter.StockForeignTabAdapter;
import com.ltqh.qh.adapter.StockforeignslideAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.StockForeignEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

public class StockForeignSlideFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.recyclerview_niujiaosuo)
    RecyclerView recyclerView_niujiaosuo;

    @BindView(R.id.recyclerview_nasidake)
    RecyclerView recyclerView_nasidake;

    @BindView(R.id.recyclerview_meiguojiaoyi)
    RecyclerView recyclerView_meiguio;

    private StockforeignslideAdapter stockforeignslideAdapter, stockforeignslideAdapter2, stockforeignslideAdapter3;

    int page = 1;
    private int lastVisibleItem;
    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";
    // private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;

    private String SORT = Constant.STAY_CHANGEPERCENT;


    @Override
    protected void initView(View view) {
        //gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        linearLayoutManager = new LinearLayoutManager(getActivity());


        stockforeignslideAdapter = new StockforeignslideAdapter(getActivity());
        recyclerView_niujiaosuo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_niujiaosuo.setAdapter(stockforeignslideAdapter);


        stockforeignslideAdapter2 = new StockforeignslideAdapter(getActivity());
        recyclerView_nasidake.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_nasidake.setAdapter(stockforeignslideAdapter2);

        stockforeignslideAdapter3 = new StockforeignslideAdapter(getActivity());
        recyclerView_meiguio.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_meiguio.setAdapter(stockforeignslideAdapter3);

        view.findViewById(R.id.text_more).setOnClickListener(this);
        view.findViewById(R.id.text_more1).setOnClickListener(this);
        view.findViewById(R.id.text_more2).setOnClickListener(this);
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
        return R.layout.fragment_stockforeignslide;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {


        getStock1("N");
        getStock2("O");
        getStock3("A");
    }


    private void getStock1(String sort) {
        OkGo.<String>get(Constant.URL_STOCK_USA)
                .params(Constant.PARAM_PAGE, 1)
                .params(Constant.PARAM_NUM, 1)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_MARKET, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            String json = response.body().replaceAll("/", "");

                            if (response.body() != null) {
                                CodeMsgEntity codeMsgEntity = new Gson().fromJson(json, CodeMsgEntity.class);
                                if (codeMsgEntity.getCode() == 1) {
                                    StockForeignEntity stockForeignEntity = new Gson().fromJson(json, StockForeignEntity.class);
                                    stockforeignslideAdapter.setDatas(stockForeignEntity.getData().getData());

                                }

                            } else {
                                stockforeignslideAdapter.stopLoad();
                            }

                        } else {
                            stockforeignslideAdapter.stopLoad();
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
        OkGo.<String>get(Constant.URL_STOCK_USA)
                .params(Constant.PARAM_PAGE, 1)
                .params(Constant.PARAM_NUM, 1)
                .params(Constant.PARAM_ASC, 1)
                .params(Constant.PARAM_MARKET, sort)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            Log.d("print", "onSuccess:154 " + response.body());
                            if (response.body() != null) {
                                String json = response.body().replaceAll("/", "");
                                CodeMsgEntity codeMsgEntity = new Gson().fromJson(json, CodeMsgEntity.class);
                                if (codeMsgEntity.getCode() == 1) {
                                    StockForeignEntity stockForeignEntity = new Gson().fromJson(json, StockForeignEntity.class);
                                    if (stockForeignEntity.getData() != null) {
                                        stockforeignslideAdapter2.setDatas(stockForeignEntity.getData().getData());
                                    }
                                }
                            } else {
                                stockforeignslideAdapter2.stopLoad();
                            }
                        } else {
                            stockforeignslideAdapter2.stopLoad();
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
        OkGo.<String>get(Constant.URL_STOCK_USA)
                .params(Constant.PARAM_PAGE, 1)
                .params(Constant.PARAM_NUM, 1)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_MARKET, sort)
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

                            if (response.body() != null) {
                                String json = response.body().replaceAll("/", "");

                                CodeMsgEntity codeMsgEntity = new Gson().fromJson(json, CodeMsgEntity.class);
                                if (codeMsgEntity.getCode() == 1) {
                                    StockForeignEntity stockForeignEntity = new Gson().fromJson(json, StockForeignEntity.class);
                                    stockforeignslideAdapter3.setDatas(stockForeignEntity.getData().getData());

                                }

                            } else {
                                stockforeignslideAdapter3.stopLoad();
                            }

                        } else {
                            stockforeignslideAdapter3.stopLoad();
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
                IntentActivity.enter(getActivity(), Constant.STOCKFOREIGNSLIDE, "N", "纽交所");
                break;

            case R.id.text_more1:
                IntentActivity.enter(getActivity(), Constant.STOCKFOREIGNSLIDE, "O", "纳斯达克交易所");

                break;

            case R.id.text_more2:
                IntentActivity.enter(getActivity(), Constant.STOCKFOREIGNSLIDE, "A", "美国交易所");

                break;

        }
    }


}

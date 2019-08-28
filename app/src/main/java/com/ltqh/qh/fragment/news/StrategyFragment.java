package com.ltqh.qh.fragment.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.NewsDetailActivity;
import com.ltqh.qh.adapter.StrategyAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.entity.StrategyEntity;
import com.ltqh.qh.utils.ParamUrlUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import java.util.List;

public class StrategyFragment extends BaseFragment {
    private int pageNumber = 1;

    private RecyclerView recyclerView;

    private StrategyAdapter strategyAdapter;
    private int lastVisibleItem;

    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";




    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        strategyAdapter = new StrategyAdapter(getActivity());
        recyclerView.setAdapter(strategyAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE, "1");
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == strategyAdapter.getItemCount() - 1) {
                    strategyAdapter.startLoad();
                    pageNumber = pageNumber + 1;
                    initData(LOADTYPE, String.valueOf(pageNumber));

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });


        strategyAdapter.setOnItemClick(new StrategyAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(StrategyEntity.DataBean dataBean) {
                NewsDetailActivity.enter(getActivity(), "STRATEGY", dataBean);
            }
        });

        initData(REFRESHTYPE, "1");

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    private void initData(final String type, String count) {
        String newsUrl = ParamUrlUtil.getStrategyParamUrl("pageNo", count);
        Log.d("print", "initData:98: " + newsUrl);


        OkGo.<String>get(newsUrl)
                .tag(this)
                .cacheKey("strtegy")
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (type.equals(REFRESHTYPE)) {

                            swipeRefreshLayout.setRefreshing(true);
                        } else {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }


                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        swipeRefreshLayout.setRefreshing(false);
                        if (!TextUtils.isEmpty(response.body())) {
                            StrategyEntity strategyEntity = new Gson().fromJson(response.body(), StrategyEntity.class);
                            List<StrategyEntity.DataBean> data = strategyEntity.getData();
                            if (data!=null){
                                if (type.equals(REFRESHTYPE)) {
                                    strategyAdapter.setDatas(data);
                                } else {
                                    strategyAdapter.addDatas(data);
                                }
                            }

                        }
                    }


                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);
                        strategyAdapter.stopLoad();
                    }


                });

    }


}

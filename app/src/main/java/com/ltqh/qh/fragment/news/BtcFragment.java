package com.ltqh.qh.fragment.news;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.NewsDetailActivity;
import com.ltqh.qh.adapter.AlertsAdapter;
import com.ltqh.qh.adapter.BtcAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.AlertsEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class BtcFragment extends BaseFragment implements View.OnClickListener {

    private String type;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private BtcAdapter btcAdapter;


    @BindView(R.id.text_content)
    TextView text_content;


    @Override
    protected void initView(View view) {

        btcAdapter = new BtcAdapter(getActivity());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(btcAdapter);


        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNewsData();
            }
        });


        view.findViewById(R.id.img_back).setOnClickListener(this);

        text_content.setLineSpacing(0, 1.4f);

        btcAdapter.setOnItemClick(new BtcAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(AlertsEntity.NewsListBean newsListBean) {
                NewsDetailActivity.enter(getActivity(), "ALERTS", newsListBean);

            }
        });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_btc;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        getNewsData();
    }


    private void getNewsData() {
        OkGo.<String>get(Constant.URL_ALERTS)
                .tag(this)
                .params(Constant.PARAM_TYPE, "0")
                .cacheKey(Constant.URL_ALERTS)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        swipeRefreshLayout.setRefreshing(true);
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        swipeRefreshLayout.setRefreshing(false);

                        Log.d("print", "onSuccess:201: " + response);
                        if (!TextUtils.isEmpty(response.body())) {
                            AlertsEntity alertsEntity = new Gson().fromJson(response.body(), AlertsEntity.class);
                            btcAdapter.setDatas(alertsEntity.getNewsList());
                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);

                        showToast("获取失败,请检查网络");
                        Log.d("print", "onError:212 " + response.message());
                    }
                });
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

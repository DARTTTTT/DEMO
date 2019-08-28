package com.ltqh.qh.fragment.news;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.EastMoneyAdapter;
import com.ltqh.qh.adapter.LianDeAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.EastMoneyEntity;
import com.ltqh.qh.entity.LianDeEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LiandeFragment extends BaseFragment {


    private RecyclerView recyclerView;

    private LianDeAdapter lianDeAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    private int count = 1;

    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";


    @Override
    protected void intPresenter() {

    }

    protected void initView(View view) {

        initData(REFRESHTYPE, 1);

        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        lianDeAdapter = new LianDeAdapter(getActivity());
        recyclerView.setAdapter(lianDeAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE, 1);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == lianDeAdapter.getItemCount() - 1) {
                    lianDeAdapter.startLoad();
                    count = count + 1;
                    initData(LOADTYPE, count);

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });




    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_liande;
    }


    @Override
    protected void initData() {

    }

    private void initData(final String type, int count) {

        OkGo.<String>get(Constant.URL_LIANDE)
                .tag(this)
                .params(Constant.PARAM_CATEGORIES, Constant.STAY_NICTATION)
                .params(Constant.PARAM_PAGE, count)
                .execute(new StringCallback() {


                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (type.equals(REFRESHTYPE)) {
                            swipeRefreshLayout.setRefreshing(true);
                        } else if (type.equals(LOADTYPE)) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        swipeRefreshLayout.setRefreshing(false);
                        if (!TextUtils.isEmpty(response.body())) {
                            Log.d("print", "onSuccess:133 "+response.body());

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            if (codeMsgEntity.getCode()==1){

                                LianDeEntity lianDeEntity = new Gson().fromJson(response.body(), LianDeEntity.class);
                                if (type.equals(REFRESHTYPE)) {

                                    lianDeAdapter.setDatas(lianDeEntity.getData());
                                } else if (type.equals(LOADTYPE)) {
                                    lianDeAdapter.addDatas(lianDeEntity.getData());

                                }
                            }



                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        lianDeAdapter.stopLoad();

                    }
                });
    }


    public String dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }


}

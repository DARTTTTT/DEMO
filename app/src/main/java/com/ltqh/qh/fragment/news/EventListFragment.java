package com.ltqh.qh.fragment.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.EventListAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.EventEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventListFragment extends BaseFragment {
    private RecyclerView recyclerView;

    private EventListAdapter eventListAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    private int count = 10;

    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";
    private String eventId;


    public static EventListFragment newInstance(EventEntity.DataBean alerts) {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.KEY_ARTICLE, alerts);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            EventEntity.DataBean dataBean = (EventEntity.DataBean) getArguments().getSerializable(Constant.KEY_ARTICLE);
            eventId = dataBean.getId();

        }
    }
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_eventlist;
    }

    @Override
    protected void intPresenter() {

    }

    protected void initView(View view) {
        initData(REFRESHTYPE, eventId, 10);

        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventListAdapter = new EventListAdapter(getActivity());
        recyclerView.setAdapter(eventListAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE, eventId, 10);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == eventListAdapter.getItemCount() - 1) {
                    eventListAdapter.startLoad();
                    count = count + 10;
                    initData(LOADTYPE, eventId, count);

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

        eventListAdapter.setOnItemClick(new EventListAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(EventEntity.DataBean content) {
               // WebActivity.openEvent(getContext(),content.getUrl());
            }
        });

    }




    @Override
    protected void initData() {

    }

    private void initData(final String type, String id, int count) {

        OkGo.<String>get(Constant.URL_JINTOUWANGLIST)
                .tag(this)
                .params(Constant.PARAM_EVENTID, id)
                .params(Constant.PARAM_LASTTIME, dateToStamp())
                .params(Constant.PARAM_PAGESIZE, count)
                .cacheKey(Constant.URL_JINTOUWANG)
                .cacheMode(CacheMode.DEFAULT)
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

                            EventEntity eventEntity = new Gson().fromJson(response.body(), EventEntity.class);

                            List<EventEntity.DataBean> data = eventEntity.getData();
                            eventListAdapter.setDatas(data);

                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        eventListAdapter.stopLoad();

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

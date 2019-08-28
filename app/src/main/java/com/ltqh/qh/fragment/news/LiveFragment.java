package com.ltqh.qh.fragment.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.EastMoneyAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.BannerEntity;
import com.ltqh.qh.entity.EastMoneyEntity;
import com.ltqh.qh.fragment.HomeFragment;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveFragment extends BaseFragment {
    @BindView(R.id.banner)
    MZBannerView banner;

    private RecyclerView recyclerView;

    private EastMoneyAdapter eastMoneyAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    private int count = 10;

    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";


    @Override
    protected void intPresenter() {

    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();

    }

    protected void initView(View view) {

        initData(REFRESHTYPE, 10);

        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        eastMoneyAdapter = new EastMoneyAdapter(getActivity());
        recyclerView.setAdapter(eastMoneyAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE, 10);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == eastMoneyAdapter.getItemCount() - 1) {
                    eastMoneyAdapter.startLoad();
                    count = count + 10;
                    initData(LOADTYPE, count);

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

        /*eastMoneyAdapter.setOnItemClick(new FinanceCalendarAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(FinanceEntity.DataBean.NewsBean.NewsDataBean dataBean) {
                String url = dataBean.getUrl();
                WebActivity.openCaijin(getContext(), url);
            }
        });*/


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_live;
    }


    @Override
    protected void initData() {
        getBanner();

    }

    private void getBanner() {
        OkGo.<String>get(Constant.URL_BANNER)
                .tag(this)
                .params(Constant.PARAM_SLIDE_ID, 1)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            BannerEntity bannerEntity = new Gson().fromJson(response.body(), BannerEntity.class);
                            List<BannerEntity.DataBean> data = bannerEntity.getData();
                            upBanner(data);
                        }
                    }
                });
    }


    private void upBanner(List<BannerEntity.DataBean> data) {
        banner.setPages(data, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new HomeFragment.BannerViewHolder();
            }
        });

    }

    private void initData(final String type, int count) {

        OkGo.<String>get(Constant.URL_HOUR)
                .tag(this)
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

                            EastMoneyEntity eastMoneyEntity = new Gson().fromJson(response.body(), EastMoneyEntity.class);
                            List<String> data = eastMoneyEntity.getData();
                            eastMoneyAdapter.setDatas(data);

                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        eastMoneyAdapter.stopLoad();

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

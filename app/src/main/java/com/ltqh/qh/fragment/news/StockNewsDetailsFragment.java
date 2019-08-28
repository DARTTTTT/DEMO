package com.ltqh.qh.fragment.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.AppContext;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.StocknewsDetailEntity;
import com.ltqh.qh.entity.StocknewsEntity;
import com.ltqh.qh.entity.StrategyDetailEntity;
import com.ltqh.qh.entity.StrategyEntity;
import com.ltqh.qh.utils.ParamUrlUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

public class StockNewsDetailsFragment extends BaseFragment {

    private TextView text_title, text_date, text_source, text_readcount;
    private ImageView img_banner;
    private String content_url;
    private SwipeRefreshLayout swipeRefreshLayout;
    private WebView webView;




    protected void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);


        webView = (WebView) view.findViewById(R.id.webView);

        text_title = (TextView) view.findViewById(R.id.text_title);
        text_date = (TextView) view.findViewById(R.id.text_date);
        text_source = (TextView) view.findViewById(R.id.text_source);
        text_readcount = (TextView) view.findViewById(R.id.text_readcount);
        img_banner = (ImageView) view.findViewById(R.id.img_banner);


        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        swipeRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                return webView.getScrollY()>0;
            }
        });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stocknews_detail;
    }

    @Override
    protected void intPresenter() {

    }

    protected void initData() {


        OkGo.<String>get(Constant.URL_STOCKNEWS_DETAIL)
                .params(Constant.PARAM_CONTENT_URL,content_url)
                .tag(this)
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
                        if (!TextUtils.isEmpty(response.body())) {
                            StocknewsDetailEntity stocknewsDetailEntity = new Gson().fromJson(response.body(), StocknewsDetailEntity.class);
                            StocknewsDetailEntity.DataBean data = stocknewsDetailEntity.getData();

                            text_title.setText(data.getTitle());
                      /*      text_source.setText("来源:" + data.getOutSourceName());
                            text_date.setText(data.getCreateDate().substring(0, 16));
                            text_readcount.setText(data.getReadCount() + "已阅");*/

                            webView.loadDataWithBaseURL(null, data.getContent(), "text/html", "utf-8", null);
                        /*    Glide.with(AppContext.getAppContext())
                                    .load(data.getBannerUrl())
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(img_banner);*/
                        }
                    }


                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);

                    }


                });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            StocknewsEntity.DataBean dataBean = (StocknewsEntity.DataBean) getArguments().getSerializable(Constant.KEY_ARTICLE);
            content_url = dataBean.getContent_url();
        }
    }

    public static StockNewsDetailsFragment newInstance(StocknewsEntity.DataBean alerts) {
        StockNewsDetailsFragment fragment = new StockNewsDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.KEY_ARTICLE, alerts);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();


    }
}

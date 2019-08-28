package com.ltqh.qh.fragment.shop;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.BookAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.BookContentEntity;
import com.ltqh.qh.entity.BooktypeEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class BookItemFragment extends BaseFragment {
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    private int count = 1;

    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private BooktypeEntity.ResultBean bean;

    private BookAdapter bookAdapter;

    @SuppressLint("ValidFragment")
    public BookItemFragment(BooktypeEntity.ResultBean bean){
        this.bean=bean;
    }

    @Override
    protected void initView(View view) {
        Log.d("print", "initView: 23"+bean);
        bookAdapter=new BookAdapter(getActivity());
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bookAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE,bean.getId(), 1);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == bookAdapter.getItemCount() - 1) {
                    bookAdapter.startLoad();
                    count = count + 1;
                    initData(LOADTYPE,bean.getId(), count);

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
        return R.layout.fragment_bookitem;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        initData(REFRESHTYPE,bean.getId(), 1);

    }
    private void initData(final String type,String id, int count) {

        OkGo.<String>get(Constant.URL_BOOKTYPE_CONTENT)
                .tag(this)
                .params(Constant.CATALOG_ID, id)
                .params(Constant.PN, count)
                .params(Constant.RN,10)
                .params(Constant.DTYPE,"")
                .params(Constant.KEY,Constant.KEY_VALUE)
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
                            BookContentEntity bookContentEntity = new Gson().fromJson(response.body(), BookContentEntity.class);
                            if (type.equals(REFRESHTYPE)) {
                                bookAdapter.setDatas(bookContentEntity.getResult().getData());

                            } else if (type.equals(LOADTYPE)) {
                                bookAdapter.addDatas(bookContentEntity.getResult().getData());

                            }



                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        bookAdapter.stopLoad();

                    }
                });
    }

}

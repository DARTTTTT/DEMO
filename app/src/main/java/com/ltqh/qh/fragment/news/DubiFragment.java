package com.ltqh.qh.fragment.news;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.DubiAdapter;
import com.ltqh.qh.adapter.LianDeAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.DubiEntity;
import com.ltqh.qh.entity.LianDeEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("ValidFragment")
public class DubiFragment extends BaseFragment {
    private String typeId="0";



/*    @SuppressLint("ValidFragment")
    public DubiFragment(String typeId){
        this.typeId=typeId;
    }*/


    private RecyclerView recyclerView;

    private DubiAdapter dubiAdapter;

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

        initData(REFRESHTYPE, typeId,1);

        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        dubiAdapter = new DubiAdapter(getActivity());
        recyclerView.setAdapter(dubiAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE,typeId, 1);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == dubiAdapter.getItemCount() - 1) {
                    dubiAdapter.startLoad();
                    count = count + 1;
                    initData(LOADTYPE,typeId, count);

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
        return R.layout.fragment_dubi;
    }


    @Override
    protected void initData() {

    }

    private void initData(final String type, String id,int count) {

        OkGo.<String>get(Constant.URL_DUBI)
                .tag(this)
                .params(Constant.PARAM_TYPE, id)
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
                            Log.d("print", "onSuccess:133 " + response.body());

                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            if (codeMsgEntity.getCode() == 1) {

                                DubiEntity dubiEntity = new Gson().fromJson(response.body(), DubiEntity.class);
                                if (type.equals(REFRESHTYPE)) {

                                    dubiAdapter.setDatas(dubiEntity.getData());
                                } else if (type.equals(LOADTYPE)) {
                                    dubiAdapter.addDatas(dubiEntity.getData());

                                }
                            }


                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        dubiAdapter.stopLoad();

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

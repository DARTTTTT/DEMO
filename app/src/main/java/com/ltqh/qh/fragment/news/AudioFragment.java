package com.ltqh.qh.fragment.news;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class AudioFragment extends BaseFragment {

    private String type;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;



    @Override
    protected void initView(View view) {


        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getVideo("2");
            }
        });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        getVideo("2");
    }

    private void getVideo(String type){
        OkGo.<String>get(Constant.URL_AUDIOVIDEO)
                .tag(this)
                .params(Constant.PARAM_NAME,"")
                .params(Constant.PARAM_TYPE,type)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        swipeRefreshLayout.setRefreshing(true);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.d("print", "onSuccess:70 "+type+":"+response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

    }
}

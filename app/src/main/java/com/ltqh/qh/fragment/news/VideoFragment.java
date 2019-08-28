package com.ltqh.qh.fragment.news;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.WebVideoActivity;
import com.ltqh.qh.adapter.VideoAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.AudioVideoEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class VideoFragment extends BaseFragment implements View.OnClickListener {

    private String type;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    @BindView(R.id.text_content)
    TextView text_content;
    private VideoAdapter videoAdapter;


    @Override
    protected void initView(View view) {

        videoAdapter = new VideoAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(videoAdapter);


        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getVideo("1");
            }
        });

        videoAdapter.setOnItemClick(new VideoAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(String content) {
                WebVideoActivity.enter(getActivity(),content);
            }
        });

        view.findViewById(R.id.img_back).setOnClickListener(this);

        text_content.setLineSpacing(0,1.4f);
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
        getVideo("1");
    }

    private void getVideo(String type) {
        OkGo.<String>get(Constant.URL_AUDIOVIDEO)
                .tag(this)
                .params(Constant.PARAM_NAME, "")
                .params(Constant.PARAM_TYPE, type)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        swipeRefreshLayout.setRefreshing(true);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        swipeRefreshLayout.setRefreshing(false);
                        if (!TextUtils.isEmpty(response.body())) {
                            AudioVideoEntity audioVideoEntity = new Gson().fromJson(response.body(), AudioVideoEntity.class);
                            Log.d("print", "onSuccess: " + audioVideoEntity);
                            videoAdapter.setDatas(audioVideoEntity.getData());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }
}

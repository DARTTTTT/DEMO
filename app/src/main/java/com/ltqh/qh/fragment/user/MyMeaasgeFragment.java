package com.ltqh.qh.fragment.user;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.adapter.MessageAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.entity.MyMessageEntity;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

public class MyMeaasgeFragment extends BaseFragment {

    private MessageAdapter messageAdapter;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;
    int page = 1;
    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";

    @Override
    protected void initView(View view) {

        messageAdapter = new MessageAdapter(getActivity());
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;
                getMyMessage(REFRESHTYPE, page);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == messageAdapter.getItemCount() - 1) {
                    messageAdapter.startLoad();
                    page = page + 1;
                    getMyMessage(LOADTYPE, page);
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
        return R.layout.fragment_mymessage;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        getMyMessage(REFRESHTYPE, 1);
    }

    private void getMyMessage(final String type, int page) {

        LoginEntity loginEntity = SPUtils.getData(UserConfig.LOGIN_USER, LoginEntity.class);
        if (loginEntity == null) {
            showToast("请登录");

        } else {


            OkGo.<String>get(Constant.URL_MESSAGE)
                    .tag(this)
                    .headers(Constant.PARAM_CONTENT_TYPE, Constant.PARAM_APPLICATION)
                    .headers(Constant.PARAM_XX_TOKEN, loginEntity.getData().getToken())
                    .headers(Constant.PARAM_XX_DEVICE_TYPE, Constant.PARAM_DEVICE_NAME)
                    .params(Constant.PARAM_PAGE, page)
                    .params(Constant.PARAM_PAGE_SIZE, 10)
                    .params(Constant.PARAM_TABLE_NAME, Constant.STAY_SHARE_POST)
                    .params(Constant.PARAM_TYPE, "my")
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
                                CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                                if (codeMsgEntity.getCode()==1) {

                                    MyMessageEntity myMessageEntity = new Gson().fromJson(response.body(), MyMessageEntity.class);
                                    List<MyMessageEntity.DataBeanX.DataBean> data = myMessageEntity.getData().getData();
                                    if (data.size() == 0) {
                                        //showToast("我的评论列表为空");
                                        messageAdapter.stopLoad();

                                    } else {
                                        if (type.equals(REFRESHTYPE)) {

                                            messageAdapter.setDatas(data);
                                        } else {
                                            messageAdapter.addDatas(data);
                                        }
                                    }

                                }else {
                                    SPUtils.remove(UserConfig.LOGIN_USER);
                                    SPUtils.remove(UserConfig.USER);
                                    Toast.makeText(getActivity(),"用户登录已失效",Toast.LENGTH_SHORT).show();
                                    UserActivity.enter(getActivity(),Constant.LOGIN);
                                    getActivity().finish();
                                }
                            }
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            swipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(getActivity(), "当前网络不好,请检查网络", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }
}

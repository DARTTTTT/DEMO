package com.ltqh.qh.operation.fragment.quote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.adapter.OPositionAdapter;
import com.ltqh.qh.operation.adapter.OSettleAdapter;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;

public class OSettlementFragment extends BaseFragment implements View.OnClickListener {
    private OSettleAdapter oSettleAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.layout_main)
    LinearLayout layout_main;

    @BindView(R.id.layout_add)
    LinearLayout layout_add;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    private String isTrade;

    public static OSettlementFragment newInstance(String  istrade) {
        OSettlementFragment fragment = new OSettlementFragment();
        Bundle args = new Bundle();
        args.putString("istrade", istrade);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isTrade = getArguments().getString("istrade");
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData){
        String key = oEventData.getKey();
        if (key.equals(OUserConfig.O_TRADE)){
            isTrade= (String) oEventData.getObject();
            //这里需要刷新一次
            getPosition();

        }
    }
    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPosition();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        oSettleAdapter=new OSettleAdapter(getActivity());

        recyclerView.setAdapter(oSettleAdapter);

        layout_add.setOnClickListener(this);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_settlement;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        getPosition();
    }

    private void getPosition() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "2")
                .params(OConstant.PARAM_TRADETYPE, isTrade)
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (isAdded()){

                            swipeRefreshLayout.setRefreshing(true);
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (isAdded()){
                            swipeRefreshLayout.setRefreshing(false);

                            if (!TextUtils.isEmpty(response.body())) {
                                OPositionEntity oPositionEntity = new Gson().fromJson(response.body(), OPositionEntity.class);
                                if (oPositionEntity.isIsLogin()==true){

                                    List<OPositionEntity.DataBean> data = oPositionEntity.getData();
                                    if (data.size()!=0){
                                        if (layout_main!=null&layout_add!=null) {


                                            layout_main.setVisibility(View.VISIBLE);
                                            layout_add.setVisibility(View.GONE);
                                            oSettleAdapter.setDatas(data);
                                            for (OPositionEntity.DataBean databean : data
                                            ) {
                                                double income = databean.getIncome();
                                                double icome = income++;
                                            }

                                        }
                                    }else {
                                        if (layout_main != null & layout_add != null) {

                                            layout_main.setVisibility(View.GONE);
                                            layout_add.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }else {

                                }

                            }




                            //text_profit.setText(icome + "");





                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (swipeRefreshLayout!=null){

                            swipeRefreshLayout.setRefreshing(false);
                        }

                    }
                });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_add:
                EventBus.getDefault().post(new OEventData(OUserConfig.O_POSITION,true));
                break;
        }
    }
}

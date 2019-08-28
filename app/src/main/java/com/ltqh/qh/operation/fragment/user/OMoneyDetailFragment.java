package com.ltqh.qh.operation.fragment.user;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.adapter.OFundsAdapter;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.entity.OFundsEntity;
import com.ltqh.qh.view.InfoEnhanceTabLayout;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

public class OMoneyDetailFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.layout_add)
    LinearLayout layout_add;

    private OFundsAdapter oFundsAdapter;


    private String Titles[] = new String[]{"充值提款", "交易明细", "推广佣金", "红包明细"};
    @BindView(R.id.home_tab)
    InfoEnhanceTabLayout home_tab;

    private String tyep="1";

    @Override
    protected void initView(View view) {
        home_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    tyep="1";
                }else if (tab.getPosition()==1){
                    tyep="2";
                }else if (tab.getPosition()==2){
                    tyep="3";
                }else if (tab.getPosition()==3){
                    tyep="4";
                }
                getMore();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < Titles.length; i++) {
            home_tab.addTab(Titles[i]);
        }

        oFundsAdapter=new OFundsAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oFundsAdapter);


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_money_detail;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        getMore();

    }

    private void getMore() {

        OkGo.<String>get(OConstant.URL_FUNDS)
                .params(OConstant.PARAM_ACTION,OConstant.STAY_MORE)
                .params(OConstant.PARAM_TYPE,tyep)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())){
                            OFundsEntity oFundsEntity = new Gson().fromJson(response.body(), OFundsEntity.class);
                            List<OFundsEntity.DataBean> data = oFundsEntity.getData();

                            if (data.size()!=0){
                                if (recyclerView!=null){
                                    recyclerView.setVisibility(View.VISIBLE);
                                    layout_add.setVisibility(View.GONE);
                                    oFundsAdapter.setDatas(data);
                                }
                            }else {
                                recyclerView.setVisibility(View.GONE);
                                layout_add.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(),getString(R.string.o_text_erro),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

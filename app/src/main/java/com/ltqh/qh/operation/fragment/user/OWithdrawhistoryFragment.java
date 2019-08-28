package com.ltqh.qh.operation.fragment.user;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.adapter.OAreaSelectAdapter;
import com.ltqh.qh.operation.adapter.OAreaSelectChildAdapter;
import com.ltqh.qh.operation.adapter.OBankListAdapter;
import com.ltqh.qh.operation.adapter.OWithdrawHistoryAdapter;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OAddressEntity;
import com.ltqh.qh.operation.entity.OBankListEntity;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OWithdrawHistoryEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;

import static com.ltqh.qh.operation.base.OConstant.FIRSTLOAD;
import static com.ltqh.qh.operation.base.OConstant.REFRESHTYPE;

public class OWithdrawhistoryFragment extends BaseFragment {

    @BindView(R.id.layout_view)
    RelativeLayout layout_view;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.layout_add)
    LinearLayout layout_add;

    @BindView(R.id.text_tip)
    TextView text_tip;

    private OWithdrawHistoryAdapter oWithdrawHistoryAdapter;


    @Override
    protected void initView(View view) {

        oWithdrawHistoryAdapter = new OWithdrawHistoryAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oWithdrawHistoryAdapter);

       /* swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getWithDrawHistory(REFRESHTYPE);

            }
        });*/


        layout_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWithDrawHistory(REFRESHTYPE);

            }
        });
    }


    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_withdrawhistory;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        getWithDrawHistory(FIRSTLOAD);


    }

    private void getWithDrawHistory(String type) {
        OkGo.<String>get(OConstant.URL_WITHDRAW_HISTORY)
                .execute(new StringCallback() {

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (type.equals(FIRSTLOAD)) {

                            showProgressDialog();
                        } else if (type.equals(REFRESHTYPE)) {
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {
                            OWithdrawHistoryEntity oWithdrawHistoryEntity = new Gson().fromJson(response.body(), OWithdrawHistoryEntity.class);
                            List<OWithdrawHistoryEntity.InoutsBean> inouts = oWithdrawHistoryEntity.getInouts();
                            if (recyclerView==null){
                                return;
                            }


                            if (inouts.size() == 0) {
                                recyclerView.setVisibility(View.GONE);
                                layout_add.setVisibility(View.VISIBLE);
                                text_tip.setText("暂无提款历史");

                            } else {
                                recyclerView.setVisibility(View.VISIBLE);
                                layout_add.setVisibility(View.GONE);
                                oWithdrawHistoryAdapter.setDatas(inouts);
                            }

                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        recyclerView.setVisibility(View.GONE);
                        layout_add.setVisibility(View.VISIBLE);
                        text_tip.setText("点击重试");
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

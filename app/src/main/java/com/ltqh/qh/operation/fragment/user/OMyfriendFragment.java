package com.ltqh.qh.operation.fragment.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.activity.PersonActivity;
import com.ltqh.qh.operation.adapter.OUnionUserAdapter;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.entity.ORuleEntity;
import com.ltqh.qh.operation.entity.OUnionUserEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

public class OMyfriendFragment extends OBaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.layout_add)
    LinearLayout layout_add;

    private OUnionUserAdapter oUnionUserAdapter;

    @Override
    protected void onLazyLoad() {
        oUnionUserAdapter = new OUnionUserAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oUnionUserAdapter);
        getUnionUser();

    }

    private void getUnionUser() {

        OkGo.<String>get(OConstant.URL_UNION_USER)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {
                            OUnionUserEntity oUnionUserEntity = new Gson().fromJson(response.body(), OUnionUserEntity.class);
                            if (recyclerView!=null){
                                if (oUnionUserEntity.getUsers().size() != 0) {
                                    recyclerView.setVisibility(View.VISIBLE);
                                    layout_add.setVisibility(View.GONE);
                                    oUnionUserAdapter.setDatas(oUnionUserEntity.getUsers());
                                } else {
                                    recyclerView.setVisibility(View.GONE);
                                    layout_add.setVisibility(View.VISIBLE);
                                }

                            }



                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), "当前网络不好，请检查网络", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_myfriend;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

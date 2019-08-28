package com.ltqh.qh.operation.fragment.info;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.operation.adapter.OReportAdapter;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OReportEntity;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OReportFragment extends OBaseFragment {


    private RecyclerView recyclerView;

    private OReportAdapter oReportAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    private int count = 0;

    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";


    @Override
    protected void intPresenter() {

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void onLazyLoad() {

       // initData(REFRESHTYPE, 0);

        OReportEntity data = SPUtils.getData(OUserConfig.CACHE_REPORT, OReportEntity.class);

        if (data!=null){
            oReportAdapter.setDatas(data.getNotices());

        }else {

            initData(REFRESHTYPE, 0);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData) {
        String key = oEventData.getKey();
        if (key.equals(OUserConfig.P_NIGHT)){
          initData(LOADTYPE,0);
        }

    }


    protected void initView(View view) {

        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        oReportAdapter = new OReportAdapter(getActivity());
        recyclerView.setAdapter(oReportAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(REFRESHTYPE, 0);
            }
        });


       /* recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (swipeRefreshLayout.isRefreshing()) return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == oReportAdapter.getItemCount() - 1) {
                    oReportAdapter.startLoad();
                    count = count + 1;
                    initData(LOADTYPE, count);

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
*/

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_report;
    }


    @Override
    protected void initData() {



    }





    private void initData(final String type, int count) {



        OkGo.<String>get(OConstant.URL_NEWS_REPORT)
                .tag(this)
                .cacheMode(CacheMode.DEFAULT)
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
                    public void onSuccess(Response<String> response) {

                        swipeRefreshLayout.setRefreshing(false);
                        if (!TextUtils.isEmpty(response.body())) {
                            OReportEntity oReportEntity = new Gson().fromJson(response.body(), OReportEntity.class);
                            SPUtils.putData(OUserConfig.CACHE_REPORT,oReportEntity);
                            List<OReportEntity.NoticesBean> notices = oReportEntity.getNotices();
                            oReportAdapter.setDatas(notices);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        showToast("获取失败,请检查网络");
                        swipeRefreshLayout.setRefreshing(false);
                        oReportAdapter.stopLoad();

                    }
                });
    }


    public String dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

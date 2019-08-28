package com.ltqh.qh.fragment.market;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.adapter.StockTabAdapter;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.StockEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class StockSelectFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_paihangbang)
    TextView text_paihangbang;

    @BindView(R.id.text_title)
    TextView text_title;

    int page = 1;
    private int lastVisibleItem;
    private String REFRESHTYPE = "refresh";
    private String LOADTYPE = "load";
    // private GridLayoutManager gridLayoutManager;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private String SORT = Constant.STAY_CHANGEPERCENT;

    private String TITLE;

    private StockTabAdapter stockTabAdapter;


    @SuppressLint("ValidFragment")
    public StockSelectFragment(String id, String title) {
        this.SORT = id;
        this.TITLE = title;
    }

    @Override
    protected void initView(View view) {
        stockTabAdapter = new StockTabAdapter(getActivity());
        //gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(stockTabAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getStockData(REFRESHTYPE, page, SORT);
            }
        });


        text_title.setText(TITLE);

        text_paihangbang.setText(TITLE);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //用来标记是否正在向最后一个滑动，既是否向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] lastVisiblePositions = staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]);
                    int lastVisiblePos = getMaxElem(lastVisiblePositions);
                    int totalItemCount = staggeredGridLayoutManager.getItemCount();

                    // 判断是否滚动到底部
                    if (lastVisiblePos == (totalItemCount - 1) && isSlidingToLast) {
                        //加载更多功能的代码
                        page = page + 1;
                        getStockData(LOADTYPE, page, SORT);


                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dy > 0) {
                    //大于0表示，正在向下滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0 表示停止或向上滚动
                    isSlidingToLast = false;
                }
            }
        });


        view.findViewById(R.id.img_back).setOnClickListener(this);
        text_paihangbang.setOnClickListener(this);
    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stockselect;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        Log.d("print", "initData:146: " + SORT);
        getStockData(REFRESHTYPE, 1, SORT);
    }

    private void getStockData(String type, int page, String sort) {
        OkGo.<String>get(Constant.URL_STOCK)
                .params(Constant.PARAM_PAGE, page)
                .params(Constant.PARAM_NUM, 20)
                .params(Constant.PARAM_ASC, 0)
                .params(Constant.PARAM_NODE, Constant.STAY_SH_A)
                .params(Constant.PARAM_SORT, sort)
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
                        if (swipeRefreshLayout != null) {

                            swipeRefreshLayout.setRefreshing(false);
                        }
                        if (!TextUtils.isEmpty(response.body())) {
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);

                            if (codeMsgEntity.getCode() ==1) {
                                StockEntity stockEntity = new Gson().fromJson(response.body(), StockEntity.class);
                                List<StockEntity.DataBean> data = stockEntity.getData();
                                if (type.equals(REFRESHTYPE)) {
                                    stockTabAdapter.setDatas(data);
                                } else if (type.equals(LOADTYPE)) {
                                    stockTabAdapter.addDatas(data);
                                }
                            } else {
                                stockTabAdapter.stopLoad();
                            }

                        } else {
                            stockTabAdapter.stopLoad();
                            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getActivity(), "当前暂无数据", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.text_paihangbang:
                showPopWindow();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_popmenu_layout, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.findViewById(R.id.layout_zhangdiefu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockData(REFRESHTYPE, page, Constant.STAY_CHANGEPERCENT);
                text_paihangbang.setText("涨跌幅");
                SORT = Constant.STAY_CHANGEPERCENT;
                popupWindow.dismiss();


            }
        });


        view.findViewById(R.id.layout_zhangdiee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockData(REFRESHTYPE, page, Constant.STAY_PRICECHANGE);
                text_paihangbang.setText("涨跌额");
                SORT = Constant.STAY_PRICECHANGE;
                popupWindow.dismiss();

            }
        });

        view.findViewById(R.id.layout_chengjiaoe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockData(REFRESHTYPE, page, Constant.STAY_VOLUME);
                text_paihangbang.setText("成交额");
                SORT = Constant.STAY_VOLUME;
                popupWindow.dismiss();

            }
        });
        view.findViewById(R.id.layout_chegnjiaoliang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockData(REFRESHTYPE, page, Constant.STAY_AMOUNT);
                text_paihangbang.setText("成交量");
                SORT = Constant.STAY_AMOUNT;
                popupWindow.dismiss();

            }
        });
        view.findViewById(R.id.layout_huanshoulv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockData(REFRESHTYPE, page, Constant.STAY_TURNOVERRATIO);
                text_paihangbang.setText("换手率");
                SORT = Constant.STAY_TURNOVERRATIO;
                popupWindow.dismiss();

            }
        });
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(text_paihangbang);

    }
}

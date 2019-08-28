package com.ltqh.qh.operation.fragment.user;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.operation.activity.OMarketActivity;
import com.ltqh.qh.operation.adapter.OLotteryHistoryAdapter;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.entity.OHistoryEntity;
import com.ltqh.qh.operation.entity.OLotteryEntity;
import com.ltqh.qh.operation.entity.OPrizesEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.utils.ListUtil;
import com.ltqh.qh.utils.Util;
import com.ltqh.qh.view.AlphaChangeListener;
import com.ltqh.qh.view.MyScrollView;
import com.ltqh.qh.view.NumberRunningTextView;
import com.ltqh.qh.view.RotateListener;
import com.ltqh.qh.view.StatusBarUtil;
import com.ltqh.qh.view.WheelSurfView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OLotteryFragment extends OBaseFragment implements View.OnClickListener {

    @BindView(R.id.layout_view)
    RelativeLayout layout_view;

    @BindView(R.id.layout_bar)
    RelativeLayout layout_bar;

    @BindView(R.id.layout_bar2)
    RelativeLayout layout_bar2;

    @BindView(R.id.scrollView)
    MyScrollView myScrollView;

    @BindView(R.id.ts_news)
    TextSwitcher mTextSwitcherNews;

    @BindView(R.id.text_red_money)
    TextView text_money;

    @BindView(R.id.text_count)
    TextView text_count;

    private List<String> newSdata;
    private int mNewsIndex;
    private OLotteryEntity oLotteryEntity;
    private String[] des;
    private OPrizesEntity oPrizesEntity;
    private OHistoryEntity oHistoryEntity;

    private OLotteryHistoryAdapter oLotteryHistoryAdapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_lottery;
    }

    @Override
    protected void onLazyLoad() {
        double eagle = QuoteProxy.getInstance().getEagle();
        if (eagle != 0) {
            text_money.setText("红包: " + eagle + "");
        }
        newSdata = new ArrayList<>();
        newSdata.add(" 恭喜 132*6   获得 888元礼金 ");
        newSdata.add(" 恭喜 186*3   获得 88元礼金 ");
        newSdata.add(" 恭喜 131*9   获得 100元话费 ");
        newSdata.add(" 恭喜 136*7   获得 100红包 ");
        newSdata.add(" 恭喜 152*3   获得 38元礼金 ");
        postLotteryPrizes();
        postLotteryHistry();
        startScheduleJob(mHandler, 5000, 5000);


        oLotteryHistoryAdapter=new OLotteryHistoryAdapter(getActivity());
    }

    private void postLotteryPrizes() {
        //历史记录
        OkGo.<String>post(OConstant.URL_LOTTERY + "/list.htm")
                .tag(this)
                .execute(new StringCallback() {


                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d("print", "onSuccess:91:   " + response.body());
                        if (!TextUtils.isEmpty(response.body())) {
                            oLotteryEntity = new Gson().fromJson(response.body(), OLotteryEntity.class);
                            text_count.setText(oLotteryEntity.getData().get(0).getLimit() + "");


                        }

                    }
                });
    }

    private void postLotteryHistry() {
        //历史记录
        OkGo.<String>post(OConstant.URL_LOTTERY + "/history.htm")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d("print", "onSuccess:137:   " + response.body());
                        if (!TextUtils.isEmpty(response.body())){
                            oHistoryEntity = new Gson().fromJson(response.body(), OHistoryEntity.class);

                        }
                    }
                });


    }


    @Override
    protected void initView(View view) {
        StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = getResources().getDimensionPixelSize(resourceId);

        int i = Util.dip2px(getContext(), 48);

        Log.d("print", "initView:144:    " + statusBarHeight + "---" + i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, statusBarHeight + i);
        layout_bar.setLayoutParams(params);
        layout_bar2.setLayoutParams(params);


        mTextSwitcherNews.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setLineSpacing(1.1f, 1.1f);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                textView.setTextSize(15);
                //   textView.setSingleLine();
                return textView;
            }
        });


        myScrollView.setAlphaChangeListener(new AlphaChangeListener() {
            @Override
            public void alphaChanging(float alpha) {
                layout_bar2.setVisibility(View.VISIBLE);
                layout_bar2.setAlpha(alpha);
                layout_bar.setAlpha(1 - alpha);
              /*  if (alpha==0.0){
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);

                }else {
                    StatusBarUtil.setStatusBarDarkTheme(getActivity(), true);

                }*/


            }
        });

        view.findViewById(R.id.img_back).setOnClickListener(this);
        view.findViewById(R.id.text_history).setOnClickListener(this);


        //颜色
        Integer[] colors = new Integer[]{Color.parseColor("#ff6c00"), Color.parseColor("#ffdd00")
                , Color.parseColor("#ff6c00"), Color.parseColor("#ffdd00")
                , Color.parseColor("#ff6c00"), Color.parseColor("#ffdd00")
                , Color.parseColor("#ff6c00"), Color.parseColor("#ffdd00")};
        //文字
        des = new String[]{"再接再厉!", "8元", "88元"
                , "电话充值卡100元", "38元", "100积分",
                "28元", "888元"};
        //图标
        List<Bitmap> mListBitmap = new ArrayList<>();
      /*  for ( int i2 = 0; i2 < colors.length; i2++ ) {
            mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.node));
        }*/

        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_one));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_two));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_three));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_five));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_two));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_six));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_two));
        mListBitmap.add(BitmapFactory.decodeResource(getResources(), R.mipmap.o_disc_three));

        //主动旋转一下图片
        mListBitmap = WheelSurfView.rotateBitmaps(mListBitmap);

        //获取第三个视图
        final WheelSurfView wheelSurfView = view.findViewById(R.id.wheelSurfView);
        WheelSurfView.Builder build = new WheelSurfView.Builder()
                .setmColors(colors)
                .setmTextSize(25)
                .setmTextColor(getResources().getColor(R.color.o_text_3433))
                .setmDeses(des)
                .setmIcons(mListBitmap)
                .setmType(1)
                .setmTypeNum(8)
                .build();
        wheelSurfView.setConfig(build);
        //添加滚动监听
        wheelSurfView.setRotateListener(new RotateListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void rotateEnd(int position, String des) {

                Log.d("print", "rotateEnd:位置:  " + position + "描述: " + des);

                showLotteryPopWindow(oPrizesEntity);
                double eagle = QuoteProxy.getInstance().getEagle();
                if (eagle != 0) {
                    text_money.setText("红包: " + eagle + "");
                }
            }

            @Override
            public void rotating(ValueAnimator valueAnimator) {

            }

            @Override
            public void rotateBefore(ImageView goImg) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("温馨提示");
                builder.setMessage("确定要花费50红包抽奖？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (oLotteryEntity != null) {
                            int id = oLotteryEntity.getData().get(0).getId();
                            postOpen(id, wheelSurfView);
                        } else {
                            postLotteryHistry();
                        }


                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();

            }
        });

    }

    private void postOpen(int id, WheelSurfView wheelSurfView) {

        OkGo.<String>post(OConstant.URL_LOTTERY + "/open.htm")
                .params(OConstant.PARAM_LOTTERY_ID, id)
                .execute(new StringCallback() {

                    private int position;

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (isAdded()) {
                            if (!TextUtils.isEmpty(response.body())) {
                                Log.d("print", "onSuccess:287:   " + response.body());
                                oPrizesEntity = new Gson().fromJson(response.body(), OPrizesEntity.class);
                                if (oPrizesEntity.isSuccess() == true) {
                                    String prizeName = oPrizesEntity.getPrize().getPrizeName();

                                    for (int i = 0; i < des.length; i++) {
                                        Log.d("print", "onSuccess: 297:  " + prizeName + "----" + des[i]);
                                        if (prizeName.equals(des[i])) {
                                            position =des.length-i;
                                        }
                                    }


                                    //模拟位置
                                    Log.d("print", "onSuccess: 304:  " + (position+1)+"     "+des[position]);

                                    wheelSurfView.startRotate((position+1));
                                    postLotteryHistry();

                                } else {
                                    Toast.makeText(getActivity(), oPrizesEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showLotteryPopWindow(OPrizesEntity data) {

        Log.d("print", "showLotteryPopWindow:302:  " + data);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_lottery, null);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);


        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);

        NumberRunningTextView numberRunningTextView = view.findViewById(R.id.text_eagle);
        TextView text_content = view.findViewById(R.id.text_content);

        TextView text_title=view.findViewById(R.id.text_title);

        if (data.isSuccess()==true){
            text_title.setText("恭喜获得");
        }else {
            text_title.setText("未中奖");
        }


        text_content.setText(data.getPrize().getPrizeName());


        //关键
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }

    public void backgroundAlpha(float bgalpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgalpha;
        getActivity().getWindow().setAttributes(lp);


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            updateNews();


        }
    };

    private void updateNews() {
        if (newSdata != null) {
            mNewsIndex++;
            if (newSdata.size() > 0) {
                if (mNewsIndex >= newSdata.size()) mNewsIndex = 0;
                if (ListUtil.isNotEmpty(newSdata)) {
                    String title = newSdata.get(mNewsIndex);
                    if (mTextSwitcherNews != null) {

                        mTextSwitcherNews.setText(title);
                    }

                }
            }
        }
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.btn_sure:
                List<String> dataList = QuoteProxy.getInstance().getDataList();

                if (dataList == null) {
                    return;
                }

                String s = dataList.get(0);

                OMarketActivity.enter(getActivity(), OConstant.OQUETO, "2", s);
                getActivity().finish();
                break;

            case R.id.text_history:

                showLotteryHistoryPopWindow();

                break;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showLotteryHistoryPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_lottery_history, null);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);


        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);

        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oLotteryHistoryAdapter);


        oLotteryHistoryAdapter.setDatas(oHistoryEntity.getData());



        //关键
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        view.findViewById(R.id.text_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }
}

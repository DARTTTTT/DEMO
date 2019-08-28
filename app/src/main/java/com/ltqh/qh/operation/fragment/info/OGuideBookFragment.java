package com.ltqh.qh.operation.fragment.info;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.activity.OImmersiveActivity;
import com.ltqh.qh.operation.activity.OMarketActivity;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.quotebase.QuoteProxy;

import java.util.List;

import butterknife.BindView;

public class OGuideBookFragment extends OBaseFragment {

    @BindView(R.id.layout_view)
    LinearLayout layout_view;

    @Override
    protected void onLazyLoad() {

    }

    private int xinshouFlag = 1;
    private int upFlag = 1;
    private int downFlag = 1;
    private int zhiyinFlag = 1;
    private int zhisunFlag = 1;
    private int chicangFlag = 1;
    private int dazhangFlag = 1;
    private int jiaoyiFlag = 1;
    private int lvyueFlag = 1;
    private int yinliFlag = 1;

    @Override
    protected void initView(View view) {
        RelativeLayout layout_xinsou = view.findViewById(R.id.layout_xinshou);
        LinearLayout laout_stay_xinshou = view.findViewById(R.id.stay_xinshou);
        layout_xinsou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xinshouFlag == 0) {
                    laout_stay_xinshou.setVisibility(View.GONE);
                    xinshouFlag = 1;
                } else if (xinshouFlag == 1) {
                    laout_stay_xinshou.setVisibility(View.VISIBLE);
                    xinshouFlag = 0;
                }
            }
        });

        RelativeLayout layout_up = view.findViewById(R.id.layout_up);
        LinearLayout stay_up = view.findViewById(R.id.stay_up);
        layout_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (upFlag == 0) {
                    stay_up.setVisibility(View.GONE);
                    upFlag = 1;
                } else if (upFlag == 1) {
                    stay_up.setVisibility(View.VISIBLE);
                    upFlag = 0;
                }
            }
        });

        RelativeLayout layout_down = view.findViewById(R.id.layout_down);
        LinearLayout stay_down = view.findViewById(R.id.stay_down);
        layout_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downFlag == 0) {
                    stay_down.setVisibility(View.GONE);
                    downFlag = 1;
                } else if (downFlag == 1) {
                    stay_down.setVisibility(View.VISIBLE);
                    downFlag = 0;
                }
            }
        });

        RelativeLayout layout_zhiyin = view.findViewById(R.id.layout_zhiyin);
        LinearLayout stay_zhiyin = view.findViewById(R.id.stay_zhiyin);
        layout_zhiyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zhiyinFlag == 0) {
                    stay_zhiyin.setVisibility(View.GONE);
                    zhiyinFlag = 1;
                } else if (zhiyinFlag == 1) {
                    stay_zhiyin.setVisibility(View.VISIBLE);
                    zhiyinFlag = 0;
                }
            }
        });

        RelativeLayout layout_zhisun = view.findViewById(R.id.layout_zhisun);
        LinearLayout stay_zhisun = view.findViewById(R.id.stay_zhisun);
        layout_zhisun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zhisunFlag == 0) {
                    stay_zhisun.setVisibility(View.GONE);
                    zhisunFlag = 1;
                } else if (zhisunFlag == 1) {
                    stay_zhisun.setVisibility(View.VISIBLE);
                    zhisunFlag = 0;
                }
            }
        });

        RelativeLayout layout_chicang = view.findViewById(R.id.layout_chicang);
        LinearLayout stay_chicang = view.findViewById(R.id.stay_chicang);
        layout_chicang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chicangFlag == 0) {
                    stay_chicang.setVisibility(View.GONE);
                    chicangFlag = 1;
                } else if (chicangFlag == 1) {
                    stay_chicang.setVisibility(View.VISIBLE);
                    chicangFlag = 0;
                }
            }
        });

        RelativeLayout layout_dazhang = view.findViewById(R.id.layout_dazahng);
        LinearLayout stay_dazhang = view.findViewById(R.id.stay_dazhang);
        layout_dazhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dazhangFlag == 0) {
                    stay_dazhang.setVisibility(View.GONE);
                    dazhangFlag = 1;
                } else if (dazhangFlag == 1) {
                    stay_dazhang.setVisibility(View.VISIBLE);
                    dazhangFlag = 0;
                }
            }
        });

        RelativeLayout layout_jiaoyi = view.findViewById(R.id.layout_jiaoyizonghefei);
        LinearLayout stay_jiaoyi = view.findViewById(R.id.stay_jiaoyizonghefei);
        layout_jiaoyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jiaoyiFlag == 0) {
                    stay_jiaoyi.setVisibility(View.GONE);
                    jiaoyiFlag = 1;
                } else if (jiaoyiFlag == 1) {
                    stay_jiaoyi.setVisibility(View.VISIBLE);
                    jiaoyiFlag = 0;
                }
            }
        });

        RelativeLayout layout_lvyue = view.findViewById(R.id.layout_lvyuebaozhangjin);
        LinearLayout stay_lvyue = view.findViewById(R.id.stay_lvyuebaozhenjin);
        layout_lvyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lvyueFlag == 0) {
                    stay_lvyue.setVisibility(View.GONE);
                    lvyueFlag = 1;
                } else if (lvyueFlag == 1) {
                    stay_lvyue.setVisibility(View.VISIBLE);
                    lvyueFlag = 0;
                }
            }
        });

        RelativeLayout layout_yinliruhe = view.findViewById(R.id.layout_yinliruhe);
        LinearLayout stay_yinliruhe = view.findViewById(R.id.stay_yinliruhe);
        layout_yinliruhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yinliFlag == 0) {
                    stay_yinliruhe.setVisibility(View.GONE);
                    yinliFlag = 1;
                } else if (yinliFlag == 1) {
                    stay_yinliruhe.setVisibility(View.VISIBLE);
                    yinliFlag = 0;
                }
            }
        });

        laout_stay_xinshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> dataList = QuoteProxy.getInstance().getDataList();

                if (dataList == null) {
                    return;
                }

                String s = dataList.get(1);

                OMarketActivity.enter(getActivity(), OConstant.OQUETO, "2", s);
            }
        });

        view.findViewById(R.id.layout_raiders).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                OImmersiveActivity.enter(getActivity(), OConstant.O_RAIDERS);
                getActivity().finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_raiders, null);


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_guidebook;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

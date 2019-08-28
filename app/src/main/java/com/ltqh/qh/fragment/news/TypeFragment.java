package com.ltqh.qh.fragment.news;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.TitleEntity;
import com.ltqh.qh.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TypeFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.text_tuijian)
    TextView text_tuijian;

    @BindView(R.id.text_seven)
    TextView text_seven;

    @BindView(R.id.text_kuaixun)
    TextView text_kuaixun;

    @BindView(R.id.text_rili)
    TextView text_rili;

    @BindView(R.id.text_dubi)
    TextView text_dubi;

    @BindView(R.id.text_liande)
    TextView text_liande;

    private List<String> types;

    private int flag1 = 1;
    private int flag2 = 1;
    private int flag3 = 1;
    private int flag4 = 1;
    private int flag5 = 1;
    private int flag6 = 1;
    private TitleEntity titleEntity;
    private List<TitleEntity.DataBean> titleData = new ArrayList<>();

    @Override
    protected void initView(View view) {

        text_tuijian.setOnClickListener(this);
        text_seven.setOnClickListener(this);
        text_kuaixun.setOnClickListener(this);
        text_rili.setOnClickListener(this);
        text_dubi.setOnClickListener(this);
        text_liande.setOnClickListener(this);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_type;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        //  TitleEntity data = SPUtils.getData(UserConfig.TYPE, TitleEntity.class);
        //  List<TitleEntity.DataBean> data1 = data.getData();
        //  Log.d("print", "initData:33 " + data1);

        String tuijian = SPUtils.getString(UserConfig.TYPE1);
        String seven = SPUtils.getString(UserConfig.TYPE2);
        String kuaixun = SPUtils.getString(UserConfig.TYPE3);
        String rili = SPUtils.getString(UserConfig.TYPE4);
        String dubi = SPUtils.getString(UserConfig.TYPE5);
        String liande = SPUtils.getString(UserConfig.TYPE6);

        //  titleData.addAll(data1);


        types = new ArrayList<>();
/*

        for (int i = 0; i < data1.size(); i++) {
            types.add(data1.get(i).getTitle());
        }
*/


        String text_1 = text_tuijian.getText().toString();
        String text_2 = text_seven.getText().toString();
        String text_3 = text_kuaixun.getText().toString();
        String text_4 = text_rili.getText().toString();
        String text_5 = text_dubi.getText().toString();
        String text_6 = text_liande.getText().toString();


        if (tuijian.contains(text_1)) {
            text_tuijian.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_tuijian.setTextColor(getResources().getColor(R.color.white));
            flag1 = 1;
        } else {
            text_tuijian.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_tuijian.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag1 = 0;
        }
        if (seven.contains(text_2)) {
            text_seven.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_seven.setTextColor(getResources().getColor(R.color.white));
            flag2 = 1;

        } else {
            text_seven.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_seven.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag2 = 0;

        }
        if (kuaixun.contains(text_3)) {
            text_kuaixun.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_kuaixun.setTextColor(getResources().getColor(R.color.white));
            flag3 = 1;

        } else {
            text_kuaixun.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_kuaixun.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag3 = 0;
        }
        if (rili.contains(text_4)) {
            text_rili.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_rili.setTextColor(getResources().getColor(R.color.white));
            flag4 = 1;
        } else {
            text_rili.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_rili.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag4 = 0;
        }
        if (dubi.contains(text_5)) {
            text_dubi.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_dubi.setTextColor(getResources().getColor(R.color.white));
            flag5 = 1;
        } else {
            text_dubi.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_dubi.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag5 = 0;
        }
        if (liande.contains(text_6)) {
            text_liande.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
            text_liande.setTextColor(getResources().getColor(R.color.white));
            flag6 = 1;
        } else {
            text_liande.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
            text_liande.setTextColor(getResources().getColor(R.color.text_maincolor));
            flag6 = 0;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_tuijian:
                if (flag1 == 0) {
                    text_tuijian.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_tuijian.setTextColor(getResources().getColor(R.color.white));
                    flag1 = 1;
                    SPUtils.putString(UserConfig.TYPE1, getString(R.string.text_recommend));
                    //EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);



                } else if (flag1 == 1) {
                    text_tuijian.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_tuijian.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag1 = 0;
                    SPUtils.remove(UserConfig.TYPE1);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                }
                break;

            case R.id.text_seven:
                if (flag2 == 0) {
                    text_seven.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_seven.setTextColor(getResources().getColor(R.color.white));
                    SPUtils.putString(UserConfig.TYPE2, getString(R.string.text_allhours));
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                    flag2 = 1;

                } else if (flag2 == 1) {
                    text_seven.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_seven.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag2 = 0;
                    SPUtils.remove(UserConfig.TYPE2);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                }
                break;
            case R.id.text_kuaixun:
                if (flag3 == 0) {
                    text_kuaixun.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_kuaixun.setTextColor(getResources().getColor(R.color.white));
                    SPUtils.putString(UserConfig.TYPE3, getString(R.string.text_kuaixun));
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                    flag3 = 1;

                } else if (flag3 == 1) {
                    text_kuaixun.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_kuaixun.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag3 = 0;
                    SPUtils.remove(UserConfig.TYPE3);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                }
                break;
            case R.id.text_rili:
                if (flag4 == 0) {
                    text_rili.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_rili.setTextColor(getResources().getColor(R.color.white));
                    SPUtils.putString(UserConfig.TYPE4, getString(R.string.text_finance));
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                    flag4 = 1;

                } else if (flag4 == 1) {
                    text_rili.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_rili.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag4 = 0;
                    SPUtils.remove(UserConfig.TYPE4);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                }
                break;
            case R.id.text_dubi:
                if (flag5 == 0) {
                    text_dubi.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_dubi.setTextColor(getResources().getColor(R.color.white));
                    SPUtils.putString(UserConfig.TYPE5, getString(R.string.text_dubizixun));
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);

                    flag5 = 1;



                } else if (flag5 == 1) {
                    text_dubi.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_dubi.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag5 = 0;
                    SPUtils.remove(UserConfig.TYPE5);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                }
                break;

            case R.id.text_liande:
                if (flag6 == 0) {
                    text_liande.setBackground(getResources().getDrawable(R.drawable.new_order_bg_mainclor));
                    text_liande.setTextColor(getResources().getColor(R.color.white));
                    SPUtils.putString(UserConfig.TYPE6, getString(R.string.text_liandezixun));
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);


                    flag6 = 1;

                } else if (flag6 == 1) {
                    text_liande.setBackground(getResources().getDrawable(R.drawable.bg_shape_background));
                    text_liande.setTextColor(getResources().getColor(R.color.text_maincolor));
                    flag6 = 0;
                    SPUtils.remove(UserConfig.TYPE6);
                    EventBus.getDefault().postSticky(Constant.ONRESUME_TYPE);

                }
                break;
        }
    }
}

package com.ltqh.qh.fragment.find;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ltqh.qh.R;
import com.ltqh.qh.activity.IntentActivity;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.fragment.forum.ForumFragment;
import com.ltqh.qh.fragment.forum.ForumGadioFragment;
import com.ltqh.qh.fragment.news.AlertsFragment;
import com.ltqh.qh.fragment.news.FinancialCalendarFragment;
import com.ltqh.qh.fragment.news.LiandeFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FindFragment extends BaseFragment implements View.OnClickListener {


    @Override
    public void onResume() {
        super.onResume();


    }


    protected void initView(View view) {


        view.findViewById(R.id.layout_chuji).setOnClickListener(this);
        view.findViewById(R.id.layout_zhongji).setOnClickListener(this);
        view.findViewById(R.id.layout_gaoji).setOnClickListener(this);
        view.findViewById(R.id.img_study).setOnClickListener(this);
        view.findViewById(R.id.img_video).setOnClickListener(this);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_findtab;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:

                getActivity().finish();
                break;

            case R.id.layout_chuji:
                IntentActivity.enter(getActivity(), Constant.LEARNCLASS);


                break;

            case R.id.layout_zhongji:
                IntentActivity.enter(getActivity(), Constant.SKILLALL);

                break;
            case R.id.layout_gaoji:
                IntentActivity.enter(getActivity(),Constant.FEEDBACK);

                break;

            case R.id.img_study:
                IntentActivity.enter(getActivity(), Constant.LEARNCLASS);

                break;

            case R.id.img_video:
                IntentActivity.enter(getActivity(),Constant.VIDEO);

                break;



        }
    }


    public String dateToStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }


    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

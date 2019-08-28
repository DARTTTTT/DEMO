package com.ltqh.qh.fragment.news;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;

public class InfoFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private final static int PERIOD = 5 * 1000; // 5s




    private RadioGroup radioGroup;
    private RadioButton rb0;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;







    @Override
    public void onResume() {
        super.onResume();



    }




    protected void initView(View view) {

        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        rb0 = (RadioButton) view.findViewById(R.id.radio_0);
        rb1 = (RadioButton) view.findViewById(R.id.radio_1);
        rb2 = (RadioButton) view.findViewById(R.id.radio_2);
        rb3 = (RadioButton) view.findViewById(R.id.radio_3);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(0);
        rb0.setChecked(true);
        rb1.setChecked(false);
        rb2.setChecked(false);
        view.findViewById(R.id.img_back).setOnClickListener(this);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_info;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        startScheduleJob(mHandler, PERIOD, PERIOD);


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


        }
    };





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:

                getActivity().finish();
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
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_0:
                showFragment(R.id.layout_fragment_containter, new LiveFragment(), null, null);
                rb0.setTextSize(20);
                rb1.setTextSize(17);
                rb2.setTextSize(17);
                rb3.setTextSize(17);

                break;

            case R.id.radio_1:
                showFragment(R.id.layout_fragment_containter, new FinancialCalendarFragment(), null, null);
                rb0.setTextSize(17);
                rb1.setTextSize(20);
                rb2.setTextSize(17);
                rb3.setTextSize(17);

                break;
            case R.id.radio_2:
                showFragment(R.id.layout_fragment_containter, new AlertsFragment(), null, null);
                rb0.setTextSize(17);
                rb1.setTextSize(17);
                rb2.setTextSize(20);
                rb3.setTextSize(17);

                break;
            case R.id.radio_3:
                showFragment(R.id.layout_fragment_containter, new DubiFragment(), null, null);
                rb0.setTextSize(17);
                rb1.setTextSize(17);
                rb2.setTextSize(17);
                rb3.setTextSize(20);
                break;


        }
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

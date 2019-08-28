package com.ltqh.qh.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CountTextView extends TextView implements View.OnClickListener {

    private long defaultTime = 10 * 1000;

    private long time = defaultTime;


    private Timer timer;

    private TimerTask task;


    private String defaultText = "立即获取";

    private String finishText = "重新发送";


    private OnClickListener onClickListener;


    public CountTextView(Context context) {
        super(context);
        initView();
    }


    public CountTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    public CountTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        if (!TextUtils.isEmpty(getText())) {
            defaultText = getText().toString().trim();
        }
        this.setText(defaultText);
        setOnClickListener(this);
    }


    private Handler handler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CountTextView.this.setText(time / 1000 + " 秒");
            time -= 1000;
            if (time < 0) {
                CountTextView.this.setEnabled(true);
                CountTextView.this.setText(finishText);
                clearTimer();
                time = defaultTime;
            }
        }

    };


    private void clearTimer() {
        if (task != null) {
            task.cancel();
            task = null;
        }
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    private void initTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        };
    }


/*
当activity或者fragment消亡的时候清除倒计时
 */


    @Override


    protected void onDetachedFromWindow() {
        clearTimer();
        super.onDetachedFromWindow();
    }


    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }


    public void setFinishText(String finishText) {
        this.finishText = finishText;
    }


    public void setDefaultTime(long defaultTime) {
        this.defaultTime = defaultTime;
    }


    @Override
    public void onClick(View view) {
        start();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }


    public void start() {
        initTimer();
        this.setText(time / 1000 + " 秒");
        this.setEnabled(false);
        timer.schedule(task, 0, 1000);
    }


    @Override


    public void setOnClickListener(OnClickListener l) {
        if (l instanceof CountTextView) {
            super.setOnClickListener(l);
        } else {
            this.onClickListener = l;
        }
    }

}

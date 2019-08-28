package com.ltqh.qh.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {

    private boolean mNoFocus = false;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        try {
            return !mNoFocus && super.onInterceptTouchEvent(event);
        } catch (Exception ignored) {
        }
        return false;
    }



    public void setmNoFocus(boolean mNoFocus) {
        this.mNoFocus = mNoFocus;
    }
}



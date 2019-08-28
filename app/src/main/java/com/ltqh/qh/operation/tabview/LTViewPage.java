package com.ltqh.qh.operation.tabview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * create by jiangtao
 * on 19/4/4.
 */
public class LTViewPage extends ViewPager {
    private boolean mNoFocus = false;

    public LTViewPage(@NonNull Context context) {
        this(context, null);
    }

    public LTViewPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        try {
            return !mNoFocus && super.onInterceptTouchEvent(event);
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return mNoFocus || super.onTouchEvent(ev);
    }

    public void setmNoFocus(boolean mNoFocus) {
        this.mNoFocus = mNoFocus;
    }
}

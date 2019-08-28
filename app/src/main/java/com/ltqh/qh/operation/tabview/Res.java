package com.ltqh.qh.operation.tabview;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

import com.ltqh.qh.R;

/**
 * Created by Rancune@126.com 2019/4/1.
 */
public class Res {
    public static String findString(@StringRes int id) {
        return Router.application().getString(id);
    }

    @ColorInt
    public static int findColor(@ColorRes int id) {
        return ContextCompat.getColor(Router.application(), id);
    }

    public static Drawable findDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(Router.application(), id);
    }

    public static int dp2px(float dpValue) {
        final float scale = Router.application().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2Px(float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spValue, Router.application().getResources().getDisplayMetrics());
    }

    public static int getPlaceHolder() {
        return R.color.place_holder;
    }

    public static final int red = Res.findColor(R.color.stock_index_red);
    public static final int green = Res.findColor(R.color.stock_index_green);
}

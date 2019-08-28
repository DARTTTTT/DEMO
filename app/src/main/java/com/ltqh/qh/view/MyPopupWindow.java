package com.ltqh.qh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class MyPopupWindow extends PopupWindow {
    public boolean isDissmiss = true;

    public MyPopupWindow() {
        super();
    }



    public MyPopupWindow(boolean isDissmiss) {
        this.isDissmiss = isDissmiss;
    }

    public MyPopupWindow(View contentView, boolean isDissmiss) {
        super(contentView);
        this.isDissmiss = isDissmiss;
    }

    public MyPopupWindow(int width, int height, boolean isDissmiss) {
        super(width, height);
        this.isDissmiss = isDissmiss;
    }

    public MyPopupWindow(View contentView, int width, int height, boolean isDissmiss) {
        super(contentView, width, height);
        this.isDissmiss = isDissmiss;
    }

    public MyPopupWindow(View contentView, int width, int height, boolean focusable, boolean isDissmiss) {
        super(contentView, width, height, focusable);
        this.isDissmiss = isDissmiss;
    }

    public MyPopupWindow(ViewGroup la, int w, int h) {
        super(la, w, h);

    }

    @Override
    public void dismiss(){
        if (isDissmiss)super.dismiss();
    }

    public void close(){
        super.dismiss();
    }

    public void setEditDismiss(boolean isDissmiss){
        isDissmiss=isDissmiss;
    }
}

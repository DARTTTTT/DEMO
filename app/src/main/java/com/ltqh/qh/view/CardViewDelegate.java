package com.ltqh.qh.view;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface CardViewDelegate {
    Drawable getCardBackground();

    void setCardBackground(Drawable drawable);

    boolean getUseCompatPadding();

    boolean getPreventCornerOverlap();

    void setShadowPadding(int left, int top, int right, int bottom);

    void setMinWidthHeightInternal(int width, int height);

    View getCardView();
}

package com.ltqh.qh.view;

import android.content.Context;
import android.content.res.ColorStateList;

 class CardViewApi17Impl extends CardViewBaseImpl{
     @Override
     public void initStatic() {
         RoundRectDrawableWithShadow.sRoundRectHelper =
                 (canvas, bounds, cornerRadius, paint) -> canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
     }
}

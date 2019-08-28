package com.ltqh.qh.view;

import android.content.Context;
import android.util.AttributeSet;

import com.necer.ncalendar.calendar.NWeekCalendar;

import skin.support.widget.SkinCompatImageHelper;
import skin.support.widget.SkinCompatSupportable;

import static android.support.v4.widget.ExploreByTouchHelper.INVALID_ID;

public class SkinNWeekCalendar extends NWeekCalendar  implements SkinCompatSupportable {
    private SkinCompatImageHelper mImageHelper;
    private int mFillColorResId = INVALID_ID;
    private int mBorderColorResId = INVALID_ID;

    public SkinNWeekCalendar(Context context) {
        super(context);
    }


    public SkinNWeekCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void applySkin() {

    }
}

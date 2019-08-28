package com.ltqh.qh.operation.tabview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;


/**
 * Description
 * Author zhaolizhi
 * Date  2019/1/8.
 */
public class MainTabView extends RelativeLayout implements ITabView {

    private TextView mTvName;
    private ImageView mIvIcon;
    private ImageView mIvIconSelected;
    private ImageView mIvRedDot;

    public MainTabView(Context context) {
        this(context, null);
    }

    public MainTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_main_tab, this, true);
        mTvName = findViewById(R.id.tv_name);
        mIvIcon = findViewById(R.id.iv_icon);
        mIvIconSelected = findViewById(R.id.iv_icon_selected);
        mIvRedDot = findViewById(R.id.iv_red_dot);

    }

    @Override
    public void setStateDrawable(int selected, int unSelected) {
        mIvIcon.setImageDrawable(Router.application().getDrawable(unSelected));
        mIvIconSelected.setImageDrawable(Router.application().getDrawable(selected));
    }

    @Override
    public void setStateImageUrl(String selectedUrl, String unSelectedUrl) {
        //TODO: zlz
    }

    @Override
    public void setSelected(boolean selected) {
        final boolean changed = (isSelected() != selected);
        super.setSelected(selected);
        if (changed) {

            if (selected) {
                mTvName.setTypeface(null, Typeface.BOLD);
                mIvIcon.setVisibility(INVISIBLE);
                mIvIconSelected.setVisibility(VISIBLE);
            } else {
                mIvIcon.setVisibility(VISIBLE);
                mIvIconSelected.setVisibility(INVISIBLE);
                mTvName.setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    @Override
    public void showDot(boolean show) {
        mIvRedDot.setVisibility(show ? VISIBLE : INVISIBLE);
    }

    public void setTabName(int resId) {
        mTvName.setText(Router.application().getText(resId));
    }

    public void setTabNameColor(int resId) {
        mTvName.setTextColor(ContextCompat.getColorStateList(Router.application(), resId));
    }
}

package com.ltqh.qh.operation.tabview;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class BottomTab extends LinearLayout {
    private static final String TAG = "BottomTab";

    private OnTabSelectionChanged mSelectionChangedListener;
    private int mRealHeight;
    private int currentIndex = -1;
    private ViewPager mPager;
    private List<View> mTabs = new ArrayList<>();

    public BottomTab(Context context) {
        this(context, null);
    }

    public BottomTab(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutTransition(new LayoutTransition());
        setOrientation(HORIZONTAL);
        mRealHeight = Res.dp2px(49);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(mRealHeight, MeasureSpec.EXACTLY));
    }

    public void setViewPager(ViewPager pager, List<View> tabs) {
        if (pager.getAdapter() == null || pager.getAdapter().getCount() != tabs.size()) {
            throw new IllegalStateException("ViewPager does not have adapter instance or count not equals tabs size.");
        }
        mPager = pager;
        mTabs.clear();
        mTabs.addAll(tabs);
        removeAllViews();
        for (int i = 0; i < mTabs.size(); i++) {
            addTabView(mTabs.get(i));
        }


    }

    /**
     * {@link #addTabView}
     */
    @Deprecated
    @Override
    public void addView(View child) {

    }

    private void addTabView(View child) {
        if (child.getLayoutParams() == null) {
            final LayoutParams lp = new LayoutParams(
                    0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            lp.gravity = Gravity.BOTTOM;
            lp.setMargins(0, 0, 0, 0);
            child.setLayoutParams(lp);
        }

        // Ensure you can navigate to the tab with the keyboard, and you can touch it
        child.setFocusable(true);
        child.setClickable(true);

        super.addView(child);

        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
    }

    public void setTabSelectionListener(OnTabSelectionChanged listener) {
        mSelectionChangedListener = listener;
    }

    public View getChildTabViewAt(int index) {
        return getChildAt(index);
    }

    public int getTabCount() {
        return getChildCount();
    }

    public void setSelectItem(int index) {
        final int oldTab = currentIndex;

        // set the tab
        setCurrentTab(index);

        // change the focus if applicable.
        if (oldTab != index) {
            getChildTabViewAt(index).requestFocus();
        }
    }

    private void setCurrentTab(int index) {
        if (index < 0 || index >= getTabCount() || index == currentIndex) {
            return;
        }

        if (currentIndex != -1) {
            getChildTabViewAt(currentIndex).setSelected(false);
        }
        currentIndex = index;
        getChildTabViewAt(currentIndex).setSelected(true);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.curTab = currentIndex;
        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        currentIndex = savedState.curTab;
        requestLayout();
    }

    public void showDot(int index, boolean show) {
        View tab = getChildTabViewAt(index);
        if (tab instanceof ITabView) {
            ((ITabView) tab).showDot(show);
        }
    }

    static class SavedState extends BaseSavedState {
        int curTab;

        SavedState(Parcelable superState) {
            super(superState);
        }

        SavedState(Parcel in) {
            super(in);
            curTab = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(curTab);
        }

        @Override
        public String toString() {
            return "BottomTab.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " curTab=" + curTab + "}";
        }

        public static final Creator<SavedState> CREATOR
                = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    private class TabClickListener implements OnClickListener {
        private final int mTabIndex;

        private TabClickListener(int tabIndex) {
            mTabIndex = tabIndex;
        }

        public void onClick(View v) {

            int prePosition = currentIndex;
            mPager.setCurrentItem(mTabIndex, false);
            setSelectItem(mTabIndex);
            mSelectionChangedListener.onTabSelectionChanged(prePosition, mTabIndex, true);
            currentIndex = mTabIndex;
        }
    }

    public interface OnTabSelectionChanged {
        void onTabSelectionChanged(int preIndex, int tabIndex, boolean clicked);
    }
}

package com.ltqh.qh.fragment.market;

import android.view.View;
import android.widget.RadioGroup;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;

import butterknife.BindView;

public class SkillAllFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;


    @Override
    protected void initView(View view) {
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.getChildAt(1).performClick();
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_skillall;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_0:
                showFragment(R.id.layout_fragment_containter, new StockToolFragment(), null, null);
                break;
            case R.id.radio_1:
                showFragment(R.id.layout_fragment_containter, new ToolFragment(), null, null);

                break;


        }
    }
}

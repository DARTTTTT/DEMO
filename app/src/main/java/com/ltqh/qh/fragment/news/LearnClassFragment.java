package com.ltqh.qh.fragment.news;

import android.view.View;
import android.widget.RadioGroup;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.fragment.market.IntroduceFragment;
import com.ltqh.qh.fragment.market.LearnFragment;
import com.ltqh.qh.fragment.market.SkillFragment;

import butterknife.BindView;

public class LearnClassFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;


    @Override
    protected void initView(View view) {
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.getChildAt(0).performClick();

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_class;
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
                showFragment(R.id.layout_fragment_containter, new LearnFragment(), null, null);
                break;
            case R.id.radio_1:
                showFragment(R.id.layout_fragment_containter, new IntroduceFragment(), null, null);

                break;

            case R.id.radio_2:
                showFragment(R.id.layout_fragment_containter, new SkillFragment(), null, null);

                break;

            case R.id.radio_3:
                showFragment(R.id.layout_fragment_containter, new StrategyFragment(), null, null);

                break;
        }
    }
}

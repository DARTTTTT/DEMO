package com.ltqh.qh.fragment.market;

import android.view.View;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;

import butterknife.BindView;

public class SkillFragment extends BaseFragment {
    @BindView(R.id.text_qh1)
    TextView text_qh1;
    @BindView(R.id.text_qh2)
    TextView text_qh2;
    @BindView(R.id.text_qh3)
    TextView text_qh3;
    @BindView(R.id.text_qh4)
    TextView text_qh4;
    @BindView(R.id.text_qh5)
    TextView text_qh5;
    @BindView(R.id.text_qh6)
    TextView text_qh6;
    @BindView(R.id.text_qh7)
    TextView text_qh7;
    @Override
    protected void initView(View view) {
        text_qh1.setLineSpacing(0,1.4f);
        text_qh2.setLineSpacing(0,1.4f);

        text_qh3.setLineSpacing(0,1.4f);
        text_qh4.setLineSpacing(0,1.4f);
        text_qh5.setLineSpacing(0,1.4f);
        text_qh6.setLineSpacing(0,1.4f);
        text_qh7.setLineSpacing(0,1.4f);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_skill;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

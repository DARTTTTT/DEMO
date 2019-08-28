package com.ltqh.qh.fragment.news;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;

import butterknife.BindView;

public class AudioVideoFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.layout_group)
    RelativeLayout layout_group;

    @BindView(R.id.radio_0)
    RadioButton radio_0;

    @BindView(R.id.radio_1)
    RadioButton radio_1;


    @Override
    protected void initView(View view) {


        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(0);
        radio_0.setChecked(true);
        radio_1.setChecked(false);


        view.findViewById(R.id.img_back).setOnClickListener(this);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_audiovideo;
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
                showFragment(R.id.layout_fragment_containter, new VideoFragment(), null, null);
                //layout_send.setVisibility(View.VISIBLE);

                break;

            case R.id.radio_1:
                showFragment(R.id.layout_fragment_containter, new AudioFragment(), null, null);
                // layout_send.setVisibility(View.GONE);

                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }
}

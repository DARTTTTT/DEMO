package com.ltqh.qh.operation.fragment.info;

import android.view.View;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.base.OBaseFragment;

public class OConversionFragment extends OBaseFragment implements View.OnClickListener {
    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected void initView(View view) {

        view.findViewById(R.id.img_back).setOnClickListener(this);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_conversion;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }
}

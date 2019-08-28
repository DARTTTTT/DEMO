package com.ltqh.qh.fragment.news;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.entity.BannerEntity;

public class BannerDetailFragment extends BaseFragment implements View.OnClickListener {

    private TextView text_title,text_content;

    private ImageView img_bg;
    private BannerEntity.DataBean dataBean;


    public static BannerDetailFragment newInstance(BannerEntity.DataBean alerts) {
        BannerDetailFragment fragment = new BannerDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("article", alerts);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataBean = (BannerEntity.DataBean) getArguments().getSerializable("article");
            Log.d("print", "onCreate: 30:" + dataBean);
        }
    }



    protected void initView(View view) {


        view.findViewById(R.id.img_back).setOnClickListener(this);

        text_title= (TextView) view.findViewById(R.id.tv_title);
        text_content= (TextView) view.findViewById(R.id.text_content);
        img_bg= (ImageView) view.findViewById(R.id.ig_banner);
        text_content.setLineSpacing(3.4f, 1.2f);


        text_title.setText(dataBean.getTitle());
        text_content.setText(dataBean.getContent());
        Glide.with(getActivity()).load(dataBean.getImage())
                .centerCrop().into(img_bg);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_bannerdetail;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }
}

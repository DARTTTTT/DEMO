package com.ltqh.qh.operation.fragment.info;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.activity.OMarketActivity;
import com.ltqh.qh.operation.adapter.OHomeMarketAdapter;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.quotebase.QuoteProxy;

import java.util.List;

import butterknife.BindView;

public class OAboutFragment extends OBaseFragment implements View.OnClickListener {


    @BindView(R.id.layout_view)
    LinearLayout layout_view;

    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected void initView(View view) {

        view.findViewById(R.id.layout_terms).setOnClickListener(this);
        view.findViewById(R.id.layout_risk).setOnClickListener(this);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_about;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_terms:
                showPopWindow("服务条款",getResources().getString(R.string.o_text_terms));
                break;

            case R.id.layout_risk:
                showPopWindow("风险披露",getResources().getString(R.string.o_text_risk));

                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow(String text, String content) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_about, null);
        TextView text_title = view.findViewById(R.id.text_title);
        TextView text_content = view.findViewById(R.id.text_content);

        text_content.setLineSpacing(0, 1.4f);
        text_content.setText(content);
        text_title.setText(text);

        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }
}

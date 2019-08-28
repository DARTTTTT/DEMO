package com.ltqh.qh.fragment.user;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;

import butterknife.BindView;

public class FeedbackFragment extends BaseFragment {

    @BindView(R.id.btn_submit)
    Button btn_submit;


    @BindView(R.id.edit_content)
    EditText edit_content;
    @BindView(R.id.text_count)
    TextView text_count;

    @Override
    protected void initView(View view) {
        btn_submit.setEnabled(false);

        edit_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text_count.setText(s.length() + "/500字已输入");
                if (s.length() > 0) {
                    btn_submit.setBackground(getResources().getDrawable(R.drawable.gradient_maincolor));
                    btn_submit.setTextColor(getResources().getColor(R.color.white));
                    btn_submit.setEnabled(true);
                } else {
                    btn_submit.setBackground(getResources().getDrawable(R.drawable.new_order_bg_grey));
                    btn_submit.setTextColor(getResources().getColor(R.color.text_secondcolor));

                    btn_submit.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();

                btn_submit.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismissProgressDialog();
                        showToast("反馈成功");
                        edit_content.setText("");

                    }
                }, 1500);
            }
        });

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_feedback;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }
}

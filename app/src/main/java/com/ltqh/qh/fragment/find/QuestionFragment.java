package com.ltqh.qh.fragment.find;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.cardslideview.CardAdapter;
import com.ltqh.qh.cardslideview.CardSlidePanel;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.QuestionEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class QuestionFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.cardSlidePanel)
    CardSlidePanel cardSlidePanel;

    private List<QuestionEntity.DataBean> Alldata = new ArrayList<>();


    @Override
    protected void initView(View view) {

        view.findViewById(R.id.text_change).setOnClickListener(this);
        view.findViewById(R.id.img_back).setOnClickListener(this);


        cardSlidePanel.setCardSwitchListener(new CardSlidePanel.CardSwitchListener() {
            @Override
            public void onShow(int index) {

            }

            @Override
            public void onCardVanish(int index, int type) {

            }
        });


        cardSlidePanel.setAdapter(new CardAdapter() {
            @Override
            public int getLayoutId() {
                return R.layout.item_question_card;

            }

            @Override
            public int getCount() {
                return Alldata.size();
            }

            @Override
            public void bindView(View view, int index) {
                Object tag = view.getTag();
                ViewHolder viewHolder;
                if (null != tag) {
                    viewHolder = (ViewHolder) tag;
                } else {
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                }
                viewHolder.bindData(Alldata.get(index), index);

            }

            @Override
            public Object getItem(int index) {
                return Alldata.get(index);
            }
        });


    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_question;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {
        getQuestionData();

    }


    private void getQuestionData() {
        OkGo.<String>get(Constant.URL_QUESTION)
                .tag(this)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            if (codeMsgEntity.getCode() == 1) {
                                QuestionEntity questionEntity = new Gson().fromJson(response.body(), QuestionEntity.class);
                                List<QuestionEntity.DataBean> data = questionEntity.getData();

                                Alldata = new ArrayList<>();
                                Alldata.addAll(data);
                                cardSlidePanel.getAdapter().notifyDataSetChanged();
                            }
                        }
                    }
                });
    }


    private void setCardSlidePanel(List<QuestionEntity.DataBean> data) {
        cardSlidePanel.setAdapter(new CardAdapter() {
            @Override
            public int getLayoutId() {
                return R.layout.item_question_card;

            }

            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public void bindView(View view, int index) {
                Object tag = view.getTag();
                ViewHolder viewHolder;
                if (null != tag) {
                    viewHolder = (ViewHolder) tag;
                } else {
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                }

                viewHolder.bindData(data.get(index), index);

            }

            @Override
            public Object getItem(int index) {
                return data.get(index);
            }


        });
    }

    class ViewHolder {
        TextView text_question, text_analysis, text_check, text_answer;
        TextView imageNumTv;
        LinearLayout layout_optionlist;
        EditText edit_input;
        ScrollView scrollView;

        public ViewHolder(View view) {
            text_question = view.findViewById(R.id.text_question);
            imageNumTv = view.findViewById(R.id.card_pic_num);
            layout_optionlist = view.findViewById(R.id.layout_optionlist);
            edit_input = view.findViewById(R.id.edit_input);
            text_analysis = view.findViewById(R.id.text_analysis);
            text_check = view.findViewById(R.id.text_check);
            scrollView = view.findViewById(R.id.scrollView);
            text_answer = view.findViewById(R.id.text_answer);
        }

        public void bindData(QuestionEntity.DataBean dataBean, int index) {
            text_question.setText(dataBean.getContent());
            imageNumTv.setText("第" + (index + 1) + "题/10题");

            layout_optionlist.removeAllViews();
            final String answer = dataBean.getAnswer();


            for (int i = 0; i < dataBean.getOptionList().size(); i++) {
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setTextColor(getContext().getResources().getColor(R.color.maincolor));
                // textView.setBackground(context.getResources().getDrawable(R.drawable.bg_kuang_mainclor));
                textView.setPadding(10, 3, 10, 3);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTextSize(15);
                textView.setText(i + ". " + dataBean.getOptionList().get(i));
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) textView.getLayoutParams();
                lp.setMargins(5, 5, 5, 5);
                textView.setLayoutParams(lp);
                layout_optionlist.addView(textView);

                if (answer.equals(dataBean.getOptionList().get(i))) {
                    text_answer.setText(i + "");

                }

            }


            text_analysis.setText(dataBean.getAnalysis());

            text_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    scrollView.setVisibility(View.VISIBLE);
                    text_answer.setVisibility(View.VISIBLE);
                }
            });


            edit_input.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() != 0 && Integer.valueOf(s.toString()) < 4) {
                        if (answer.equals(dataBean.getOptionList().get(Integer.valueOf(s.toString())))) {
                            Toast.makeText(getContext(), "回答正确", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "回答错误", Toast.LENGTH_SHORT).show();

                        }


                    } else {
                        Toast.makeText(getContext(), "0~3选择哦", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_change:
                getQuestionData();
                break;

            case R.id.img_back:
                getActivity().finish();

                break;
        }
    }
}

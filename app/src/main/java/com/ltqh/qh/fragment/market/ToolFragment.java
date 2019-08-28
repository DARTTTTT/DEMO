package com.ltqh.qh.fragment.market;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

public class ToolFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.edit_price)
    EditText edit_price;


    @BindView(R.id.btn_huansuan)
    Button btn_huansuan;

    @BindView(R.id.text_neiwai)
    TextView text_neiwai;

    @BindView(R.id.edit_result)
    EditText edit_result;

    private int neiwai=1;


    @Override
    protected void initView(View view) {

        text_neiwai.setOnClickListener(this);
        btn_huansuan.setOnClickListener(this);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_tool;
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
            case R.id.text_neiwai:
                showPopWindow();
                break;

            case R.id.btn_huansuan:
                 getResult(edit_price.getText().toString(),neiwai);
                break;
        }
    }

    private void getResult(String s, int neiwai) {
        OkGo.<String>get(Constant.URL_JINSHU)
                .tag(this)
                .params(Constant.PARAM_NUM,s)
                .params(Constant.PARAM_TYPE,neiwai)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())){
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            if (codeMsgEntity.getCode()==1){
                                edit_result.setText(codeMsgEntity.getMsg());
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                    }
                });
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_huaunsuan_layout, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.findViewById(R.id.layout_neipan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
                neiwai=1;
                text_neiwai.setText("内盘转外盘");


            }
        });


        view.findViewById(R.id.layout_waipan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
                neiwai=0;
                text_neiwai.setText("外盘转内盘");

            }
        });


        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(text_neiwai);

    }
}

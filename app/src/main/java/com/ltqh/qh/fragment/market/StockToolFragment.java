package com.ltqh.qh.fragment.market;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.CodeMsgEntity;
import com.ltqh.qh.entity.SunyiEnitiy;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

public class StockToolFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.edit_buyprice)
    EditText edit_buyprice;
    @BindView(R.id.edit_buyamt)
    EditText edit_buyamt;
    @BindView(R.id.edit_sellprice)
    EditText edit_sellprice;
    @BindView(R.id.edit_sellamt)
    EditText edit_sellamt;
    @BindView(R.id.edit_blokerrate)
    EditText edit_blokerrate;
    @BindView(R.id.edit_stamptax)
    EditText edit_stamptax;

    @BindView(R.id.jiesuanfei)
    FrameLayout fram_jiesuan;

    @BindView(R.id.btn_huansuan)
    Button btn_huansuan;

    @BindView(R.id.text_neiwai)
    TextView text_neiwai;

    @BindView(R.id.edit_result)
    EditText edit_result;
    @BindView(R.id.edit_transferFee)
    EditText edit_transferfee;

    private String type = "shena";


    @Override
    protected void initView(View view) {

        text_neiwai.setOnClickListener(this);
        btn_huansuan.setOnClickListener(this);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stocktool;
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
                getResult(type, edit_buyprice.getText().toString(), edit_buyamt.getText().toString(), edit_sellprice.getText().toString(), edit_sellamt.getText().toString()
                        , edit_blokerrate.getText().toString(), edit_stamptax.getText().toString(), edit_transferfee.getText().toString());
                break;
        }
    }

    private void getResult(String shenA, String buyprice, String buyamt, String sellprice, String sellamt, String blokerrate, String stamptax, String transferFee) {

        String url = Constant.URL_TOUZISUNYI + "/" + shenA;
        OkGo.<String>post(url)
                .tag(this)
                .params(Constant.PARAM_BUYPRICE, buyprice)
                .params(Constant.PARAM_BUYAMT, buyamt)
                .params(Constant.PARAM_SELLPRICE, sellprice)
                .params(Constant.PARAM_SELLAMT, sellamt)
                .params(Constant.PARAM_BLOKERRATE, blokerrate)
                .params(Constant.PARAM_STAMPTAX, stamptax)
                .params(Constant.PARAM_TRANSFERFEE, transferFee)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        showProgressDialog();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(response.body())) {
                            CodeMsgEntity codeMsgEntity = new Gson().fromJson(response.body(), CodeMsgEntity.class);
                            if (codeMsgEntity.getCode() == 1) {
                                SunyiEnitiy sunyiEnitiy = new Gson().fromJson(response.body(), SunyiEnitiy.class);
                                Log.d("print", "onSuccess:124 "+sunyiEnitiy);
                                Toast.makeText(getActivity(),sunyiEnitiy.getMsg(),Toast.LENGTH_SHORT).show();
                                edit_result.setText("结算费用是:"+sunyiEnitiy.getData().getTransferFeeOut()+"印花税费用是:"+sunyiEnitiy.getData().getStampTaxOut()
                                +"券商佣金费用是:"+sunyiEnitiy.getData().getBrokerAmt()+"总交易数量是:"+sunyiEnitiy.getData().getSumAmt()+"总资产是:"+sunyiEnitiy.getData().getPlAmt()
                                        +"个人收益所得:"+sunyiEnitiy.getData().getPlAmtRMB()+"费率:"+sunyiEnitiy.getData().getPlRatio()
                                );
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(),response.message(),Toast.LENGTH_SHORT).show();

                    }
                });
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_stocktool_layout, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.findViewById(R.id.layout_hushiA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();

                text_neiwai.setText("沪市A股");
                type = "lua";
                fram_jiesuan.setVisibility(View.VISIBLE);

            }
        });
        view.findViewById(R.id.layout_hushiB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
                text_neiwai.setText("沪市B股");
                type = "lub";
                fram_jiesuan.setVisibility(View.VISIBLE);


            }
        });

        view.findViewById(R.id.layout_shenshiA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
                text_neiwai.setText("深市A股");
                type = "shena";
                fram_jiesuan.setVisibility(View.GONE);

            }
        });
        view.findViewById(R.id.layout_shenshiB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupWindow.dismiss();
                text_neiwai.setText("深市B股");
                type = "shenb";
                fram_jiesuan.setVisibility(View.VISIBLE);

            }
        });

        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(text_neiwai);

    }
}

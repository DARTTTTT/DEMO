package com.ltqh.qh.operation.fragment.user;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.adapter.OAreaSelectAdapter;
import com.ltqh.qh.operation.adapter.OAreaSelectChildAdapter;
import com.ltqh.qh.operation.adapter.OBankListAdapter;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OAddressEntity;
import com.ltqh.qh.operation.entity.OBankListEntity;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;

public class OBankListFragment extends BaseFragment {

    @BindView(R.id.layout_view)
    RelativeLayout layout_view;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.layout_add)
    LinearLayout layout_add;

    private OBankListAdapter oBankListAdapter;
    private OBankListEntity oBankListEntity;
    private OAreaSelectAdapter oAreaSelectAdapter;
    private OAreaSelectChildAdapter oAreaSelectChildAdapter;
    private OAddressEntity oAddressEntity;

    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        String s = readTextFromSDcard("address.json");
        oAddressEntity = new Gson().fromJson(s, OAddressEntity.class);
        Log.d("print", "initView:53: " + oAddressEntity.getData().get(0));

        oBankListAdapter = new OBankListAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oBankListAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });


        oBankListAdapter.setOnItemClick(new OBankListAdapter.OnItemClick() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccessListener(OBankListEntity.BankCardsBean data) {
                Log.d("print", "onSuccessListener:97:   "+data);
                showEditPopWindow(data);
            }
        });

    }

    private String readTextFromSDcard(String name) {
        InputStreamReader inputStreamReader;
        String resultString = null;
        try {
            inputStreamReader = new InputStreamReader(getActivity().getAssets().open(name), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
            resultString = stringBuilder.toString();
            Log.i("TAG", stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showEditPopWindow(OBankListEntity.BankCardsBean data) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_editbank, null);

        TextView text_bankname = view.findViewById(R.id.text_name);
        String bank = data.getBank();

        ImageView img_card = view.findViewById(R.id.img_card);

        if (bank.contains("工商")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_gongshang));

        } else if (bank.contains("建设")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_jianhang));

        } else if (bank.contains("农业")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_nongye));

        } else if (bank.contains("招商")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_zhaoshang));

        } else if (bank.contains("中国")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_china));

        } else if (bank.contains("交通")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_jiaotong));

        } else if (bank.contains("邮政")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_youzheng));

        } else if (bank.contains("民生")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_minsheng));

        } else if (bank.contains("浦发")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_pufa));

        } else if (bank.contains("兴业")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_xingye));

        } else if (bank.contains("华夏")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_huaxia));

        } else if (bank.contains("光大")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_guangda));

        } else if (bank.contains("广发")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_guangfa));

        } else if (bank.contains("中信")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_zhongxin));

        } else if (bank.contains("平安")) {
            img_card.setImageDrawable(getResources().getDrawable(R.mipmap.bank_pingan));

        }


        text_bankname.setText(bank);
        TextView text_number = view.findViewById(R.id.text_cardnumber);

        text_number.setText("(尾号" + data.getCardNumber().substring(data.getCardNumber().length() - 4, data.getCardNumber().length()) + ")");
        TextView text_name = view.findViewById(R.id.text_realname);
        text_name.setText("开户姓名 " + oBankListEntity.getInfo().getName());
        TextView text_area = view.findViewById(R.id.text_area);
        text_area.setText(data.getProvince() + "、" + data.getCity());
        EditText edit_zhihang = view.findViewById(R.id.edit_zhihang);
        edit_zhihang.setText(data.getSubbranch());


        view.findViewById(R.id.layout_area).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(text_area);
            }
        });


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);


        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        view.findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postEditBank(popupWindow, text_area.getText().toString(), edit_zhihang.getText().toString(), data.getId());
            }
        });

        view.findViewById(R.id.text_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDeleteBank(popupWindow, data.getId());
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private void postDeleteBank(PopupWindow popupWindow, int id) {
        OkGo.<String>post(OConstant.URL_BANK_UPDATE)
                .params(OConstant.PARAM_ACTION, OConstant.STAY_DEL)
                .params(OConstant.PARAM_ID, id)
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
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                getBankList();
                                getBaseMine(popupWindow);
                               // popupWindow.dismiss();

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

    private void getBaseMine(PopupWindow popupWindow) {
        OkGo.<String>get(OConstant.URL_USER_BASE_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            OBaseMineEntity oBaseMineEntity = new Gson().fromJson(response.body(), OBaseMineEntity.class);

                            Log.d("print", "onSuccess:删完之后:  " + oBaseMineEntity.getBankCardCount());

                            QuoteProxy.getInstance().setoBaseMineEntity(oBaseMineEntity);
                            popupWindow.dismiss();


                        }

                    }
                });
    }

    private void postEditBank(PopupWindow popupWindow, String text_area, String edit_zhihang, int id) {
        String[] split = text_area.split("、");

        String url = OConstant.URL_BANK_UPDATE + "?" + OConstant.PARAM_ACTION + "=" + OConstant.STAY_UPDATE + "&" + OConstant.PARAM_PROVICE
                + "=" + split[0] + "&" + OConstant.PARAM_CITY + "=" + split[1] + "&" + OConstant.PARAM_SUBBRANCH + "=" + edit_zhihang
                + "&" + OConstant.PARAM_ID + "=" + id;

        OkGo.<String>post(url)
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
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                getBankList();
                                popupWindow.dismiss();
                            }
                        }
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow(TextView textView) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_area, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        oAreaSelectAdapter = new OAreaSelectAdapter(getActivity());
        recyclerView.setAdapter(oAreaSelectAdapter);


        oAreaSelectAdapter.setDatas(oAddressEntity.getData());


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        oAreaSelectAdapter.setOnItemClick(new OAreaSelectAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(OAddressEntity.DataBean data) {
                Log.d("print", "onSuccessListener:158:  " + data);
                showChildPopWindow(popupWindow, data, textView);
            }
        });
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showChildPopWindow(PopupWindow popupWindowparent, OAddressEntity.DataBean dataBean, TextView textView) {


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_pop_child_area, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        oAreaSelectChildAdapter = new OAreaSelectChildAdapter(getActivity());
        recyclerView.setAdapter(oAreaSelectChildAdapter);


        oAreaSelectChildAdapter.setDatas(dataBean.getShi());


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        oAreaSelectChildAdapter.setOnItemClick(new OAreaSelectChildAdapter.OnItemClick() {
            @Override
            public void onSuccessListener(String data) {
                Log.d("print", "onSuccessListener:218:  " + dataBean.getName() + data);
                textView.setText(dataBean.getName() + "、" + data);
                popupWindow.dismiss();
                popupWindowparent.dismiss();
            }
        });

        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData) {
        if (oEventData.getKey().equals(OUserConfig.O_BANKLIST)) {
            initData();
        }
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_banklist;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

        oBankListEntity = QuoteProxy.getInstance().getoBankListEntity();
        if (oBankListEntity == null) {
            getBankList();
        } else {
            List<OBankListEntity.BankCardsBean> bankCards = oBankListEntity.getBankCards();
            if (bankCards.size() == 0) {
                layout_add.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                oBankListAdapter.setDatas(bankCards);
                layout_add.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }

        }

    }


    private void getBankList() {
        OkGo.<String>get(OConstant.URL_BANKLIST)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OBankListEntity oBankListEntity = new Gson().fromJson(response.body(), OBankListEntity.class);
                            QuoteProxy.getInstance().setoBankListEntity(oBankListEntity);
                            List<OBankListEntity.BankCardsBean> bankCards = oBankListEntity.getBankCards();
                            if (bankCards.size() == 0) {
                                layout_add.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);
                            } else {
                                oBankListAdapter.setDatas(bankCards);
                                layout_add.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

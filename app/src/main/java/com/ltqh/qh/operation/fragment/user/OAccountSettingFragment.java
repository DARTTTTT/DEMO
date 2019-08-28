package com.ltqh.qh.operation.fragment.user;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.BaseFragment;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OBankListEntity;
import com.ltqh.qh.operation.entity.OBaseMineEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.OEventData;
import com.ltqh.qh.operation.entity.OMineEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class OAccountSettingFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.layout_view)
    RelativeLayout layout_view;

    private int isHide = 0;

    @BindView(R.id.text_isshiming)
    TextView text_isshiming;

    @BindView(R.id.text_isbank)
    TextView text_isbank;

    @BindView(R.id.text_phonenumber)
    TextView text_phonenumber;

    @BindView(R.id.text_ispass)
    TextView text_ispass;

    @BindView(R.id.text_changename)
    TextView text_changename;


    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        view.findViewById(R.id.layout_shiming).setOnClickListener(this);
        view.findViewById(R.id.layout_bank).setOnClickListener(this);
        view.findViewById(R.id.layout_loginpass).setOnClickListener(this);
        view.findViewById(R.id.layout_phone).setOnClickListener(this);
        view.findViewById(R.id.layout_password).setOnClickListener(this);
        view.findViewById(R.id.layout_changename).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getFirstBaseMine();
        /*OBaseMineEntity oBaseMineEntity = QuoteProxy.getInstance().getoBaseMineEntity();
        if (oBaseMineEntity==null){
        }else {
            Log.d("print", "onResume:78:得到:   "+oBaseMineEntity.getBankCardCount());

            String name = oBaseMineEntity.getInfo().getName();
            int bankCardCount = oBaseMineEntity.getBankCardCount();
            String mobile = oBaseMineEntity.getInfo().getMobile();
            String withdrawPw = oBaseMineEntity.getUser().getWithdrawPw();
            if (name.equals("")) {
                text_isshiming.setText("暂未实名");
            } else {
                text_isshiming.setText("*" + name.substring(name.length() - 1, name.length()));

            }

            if (bankCardCount == 0) {
                text_isbank.setText("绑定银行卡");
            } else {
                text_isbank.setText("已绑定" + bankCardCount + "张");
            }

            text_phonenumber.setText(mobile);

            if (withdrawPw.equals("")) {
                text_ispass.setText("未设置");
            } else {
                text_ispass.setText("已设置");
            }
        }*/

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_accountsetting;
    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {


    /*    OMineEntity data = SPUtils.getData(OUserConfig.USER, OMineEntity.class);

        boolean usernameChanged = data.isUsernameChanged();
        if (usernameChanged == true) {
            text_changename.setText("已修改过一次");
        } else {
            text_changename.setText("只能修改一次");

        }*/
        getBankList();

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        OBaseMineEntity oBaseMineEntity = QuoteProxy.getInstance().getoBaseMineEntity();

        switch (v.getId()) {
            case R.id.layout_shiming:
                if (oBaseMineEntity != null) {
                    OUserActivity.enter(getActivity(), OConstant.OREALNAME);

                } else {
                    getFirstBaseMine();
                }

                break;

            case R.id.layout_bank:
                if (oBaseMineEntity != null) {
                    if (oBaseMineEntity.getInfo().getName().equals("")) {
                        showItemPopWindow();
                    } else {
                        OUserActivity.enter(getActivity(), OConstant.BANK);
                    }

                } else {
                    getFirstBaseMine();
                }


                break;

            case R.id.layout_loginpass:
                OUserActivity.enter(getActivity(), OConstant.RESET);

                break;

            case R.id.layout_phone:

                OUserActivity.enter(getActivity(), OConstant.RESETPHONE);


                break;
            case R.id.layout_password:

                String withdrawPw = oBaseMineEntity.getUser().getWithdrawPw();
                if (withdrawPw.equals("")) {
                    OUserActivity.enter(getActivity(), OConstant.SETWITHDRAWPASS);

                } else {

                    OUserActivity.enter(getActivity(), OConstant.RESETWITHDRAWPASS);
                }


                break;

            case R.id.layout_changename:

                showChangeNamePopWindow();

                break;


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showChangeNamePopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_channame, null);

        EditText edit_name = view.findViewById(R.id.edit_name);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);


        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);

        TextView text_back = view.findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        //关键
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                postUsername(popupWindow, name);
            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }

    private void postUsername(PopupWindow popupWindow, String name) {
        String url = OConstant.URL_USERNAME + "?" + OConstant.PARAM_USERNAME + "=" + name;

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
                                popupWindow.dismiss();
                                getFirstBaseMine();
                                getMine();

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

    private void getMine() {
        OkGo.<String>get(OConstant.URL_USER_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OMineEntity oMineEntity = new Gson().fromJson(response.body(), OMineEntity.class);
                            SPUtils.putData(OUserConfig.USER, oMineEntity);
                            //登录成功需要更新下
                        }
                    }
                });

    }

    private void getBankList() {
        OkGo.<String>get(OConstant.URL_BANKLIST)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OBankListEntity oBankListEntity = new Gson().fromJson(response.body(), OBankListEntity.class);
                            QuoteProxy.getInstance().setoBankListEntity(oBankListEntity);
                        }
                    }
                });

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showItemPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_report_pop, null);


        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);


        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);

        TextView text_back = view.findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        //关键
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OUserActivity.enter(getActivity(), OConstant.OREALNAME);
                popupWindow.dismiss();

            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }

    public void backgroundAlpha(float bgalpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgalpha;
        getActivity().getWindow().setAttributes(lp);


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(OEventData oEventData) {
        if (oEventData.getKey().equals(OUserConfig.O_REALNAME)) {
            getFirstBaseMine();
        } else if (oEventData.getKey().equals(OUserConfig.O_BANKLIST)) {
            getFirstBaseMine();

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void getBaseMine() {
        OkGo.<String>get(OConstant.URL_USER_BASE_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            OBaseMineEntity oBaseMineEntity = new Gson().fromJson(response.body(), OBaseMineEntity.class);

                            QuoteProxy.getInstance().setoBaseMineEntity(oBaseMineEntity);


                        }

                    }
                });
    }

    private void getFirstBaseMine() {
        OkGo.<String>get(OConstant.URL_USER_BASE_MINE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            OBaseMineEntity oBaseMineEntity = new Gson().fromJson(response.body(), OBaseMineEntity.class);
                            Log.d("print", "onSuccess:317:   " + oBaseMineEntity);
                            QuoteProxy.getInstance().setoBaseMineEntity(oBaseMineEntity);

                            String name = oBaseMineEntity.getInfo().getName();
                            int bankCardCount = oBaseMineEntity.getBankCardCount();
                            String mobile = oBaseMineEntity.getInfo().getMobile();
                            String withdrawPw = oBaseMineEntity.getUser().getWithdrawPw();
                            String username = oBaseMineEntity.getUser().getUsername();

                            if (text_isshiming==null){
                                return;
                            }
                            if (name.equals("")) {

                                text_isshiming.setText("暂未实名");
                            } else {
                                text_isshiming.setText("*" + name.substring(name.length() - 1, name.length()));

                            }

                            if (bankCardCount == 0) {
                                text_isbank.setText("绑定银行卡");
                            } else {
                                text_isbank.setText("已绑定" + bankCardCount + "张");
                            }

                            text_phonenumber.setText(mobile);

                            if (withdrawPw.equals("")) {
                                text_ispass.setText("未设置");
                            } else {
                                text_ispass.setText("已设置");
                            }

                            text_changename.setText(username);


                        }

                    }
                });
    }
}

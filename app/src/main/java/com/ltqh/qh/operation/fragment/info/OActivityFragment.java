package com.ltqh.qh.operation.fragment.info;

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
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.operation.activity.OImmersiveActivity;
import com.ltqh.qh.operation.activity.OIntentActivity;
import com.ltqh.qh.operation.activity.OMarketActivity;
import com.ltqh.qh.operation.activity.OUserActivity;
import com.ltqh.qh.operation.adapter.OTaskAdapter;
import com.ltqh.qh.operation.base.OBaseFragment;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.entity.OCheckHisoryEntity;
import com.ltqh.qh.operation.entity.OCodeMsgEntity;
import com.ltqh.qh.operation.entity.ORechargeEntity;
import com.ltqh.qh.operation.entity.OTaskEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.view.MultiScrollNumber;
import com.ltqh.qh.view.NumberRunningTextView;
import com.ltqh.qh.view.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

import butterknife.BindView;

import static com.ltqh.qh.operation.base.OConstant.FIRSTLOAD;
import static com.ltqh.qh.operation.base.OConstant.NULLTYPE;
import static com.ltqh.qh.operation.base.OConstant.REFRESHTYPE;

public class OActivityFragment extends OBaseFragment implements View.OnClickListener {
    @BindView(R.id.layout_view)
    RelativeLayout layout_view;
    @BindView(R.id.text_eagle)
    NumberRunningTextView text_eagle;
    @BindView(R.id.text_eagle2)
    TextView text_eagle2;
    @BindView(R.id.layout_check)
    RelativeLayout layout_check;

    @BindView(R.id.text_check)
    TextView text_check;

    @BindView(R.id.img_check)
    ImageView img_check;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private OTaskAdapter oTaskAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.text_one)
    TextView text_one;
    @BindView(R.id.text_monday)
    TextView text_monday;

    @BindView(R.id.text_two)
    TextView text_two;
    @BindView(R.id.text_tuesday)
    TextView text_tuesday;

    @BindView(R.id.text_three)
    TextView text_three;
    @BindView(R.id.text_wednesday)
    TextView text_wednesday;

    @BindView(R.id.text_four)
    TextView text_four;
    @BindView(R.id.text_thursday)
    TextView text_thursday;

    @BindView(R.id.text_five)
    TextView text_five;
    @BindView(R.id.text_friday)
    TextView text_friday;

    @BindView(R.id.layout_one)
    LinearLayout layou_one;
    @BindView(R.id.layout_two)
    LinearLayout layou_two;
    @BindView(R.id.layout_three)
    LinearLayout layou_three;
    @BindView(R.id.layout_four)
    LinearLayout layou_four;
    @BindView(R.id.layout_five)
    LinearLayout layou_five;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.o_fragment_activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        getTask(NULLTYPE);
    }

    @Override
    protected void onLazyLoad() {
        getTask(FIRSTLOAD);
    }

    private void getTask(final String type) {
        double eagle = QuoteProxy.getInstance().getEagle();
        if (eagle != 0) {
            text_eagle.setContent(eagle + "");
        }
        OkGo.<String>get(OConstant.URL_TASK)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (type.equals(FIRSTLOAD)) {
                            showProgressDialog();
                        } else if (type.equals(REFRESHTYPE)) {
                            swipeRefreshLayout.setRefreshing(true);
                        } else if (type.equals(NULLTYPE)) {

                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        dismissProgressDialog();
                        if (isAdded()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                        if (!TextUtils.isEmpty(response.body())) {
                            OTaskEntity oTaskEntity = new Gson().fromJson(response.body(), OTaskEntity.class);
                            List<OTaskEntity.DataBean> data = oTaskEntity.getData();

                            Log.d("print", "onSuccess: 84:   " + oTaskEntity);

                            for (OTaskEntity.DataBean task : data) {
                                if (task.getName().contains("签到")) {
                                    if (text_check != null) {

                                        text_check.setText(task.getStatusName());
                                    }

                                }
                            }

                            oTaskAdapter.setDatas(data);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });


        OkGo.<String>get(OConstant.URL_TASK_CHECK_HISTORY)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OCheckHisoryEntity oCheckHisoryEntity = new Gson().fromJson(response.body(), OCheckHisoryEntity.class);

                            if (oCheckHisoryEntity.isSuccess() == true & isAdded() == true) {


                                OCheckHisoryEntity.DataBean data = oCheckHisoryEntity.getData();


                                String pointsStatus = data.getPointsStatus();
                                String pointsArray = data.getPointsArray();
                                String[] split = pointsStatus.split(",");
                                String[] split1 = pointsArray.split(",");
                                Log.d("print", "onSuccess:175:   " + split[0] + "- " + split[1] + "- " + split[2] + "- " + split[3] + "- " + split[4]);
                                if (split[0].equals("1")) {
                                    text_one.setText("√");
                                    text_one.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_blue));
                                    text_monday.setTextColor(getResources().getColor(R.color.maincolor));
                                } else if (split[0].equals("0")) {
                                    text_one.setText("+" + split1[0]);
                                    text_one.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_monday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                } else if (split[0].equals("-1")) {
                                    layou_one.setEnabled(false);
                                    text_one.setText("+" + split1[0]);
                                    text_one.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_monday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                }

                                if (split[1].equals("1")) {
                                    text_two.setText("√");
                                    text_two.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_blue));
                                    text_tuesday.setTextColor(getResources().getColor(R.color.maincolor));
                                } else if (split[1].equals("0")) {
                                    text_two.setText("+" + split1[1]);
                                    text_two.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_tuesday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                } else if (split[1].equals("-1")) {
                                    layou_two.setEnabled(false);
                                    text_two.setText("+" + split1[1]);
                                    text_two.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_tuesday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                }

                                if (split[2].equals("1")) {
                                    text_three.setText("√");
                                    text_three.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_blue));
                                    text_wednesday.setTextColor(getResources().getColor(R.color.maincolor));
                                } else if (split[2].equals("0")) {
                                    text_three.setText("+" + split1[2]);
                                    text_three.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_wednesday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                } else if (split[2].equals("-1")) {
                                    layou_three.setEnabled(false);
                                    text_three.setText("+" + split1[2]);
                                    text_three.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_wednesday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                }

                                if (split[3].equals("1")) {
                                    text_four.setText("√");
                                    text_four.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_blue));
                                    text_thursday.setTextColor(getResources().getColor(R.color.maincolor));
                                } else if (split[3].equals("0")) {
                                    text_four.setText("+" + split1[3]);
                                    text_four.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_thursday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                } else if (split[3].equals("-1")) {
                                    layou_four.setEnabled(false);
                                    text_four.setText("+" + split1[3]);
                                    text_four.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_thursday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                }

                                if (split[4].equals("1")) {
                                    text_five.setText("√");
                                    text_five.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_blue));
                                    text_friday.setTextColor(getResources().getColor(R.color.maincolor));
                                } else if (split[4].equals("0")) {
                                    text_five.setText("+" + split1[4]);
                                    text_five.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_friday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                } else if (split[4].equals("-1")) {
                                    layou_five.setEnabled(false);
                                    text_five.setText("+" + split1[4]);
                                    text_five.setBackground(getResources().getDrawable(R.drawable.o_bg_shape_circle_gray));
                                    text_friday.setTextColor(getResources().getColor(R.color.o_text_8289));
                                }

                            }
                        }
                    }
                });


    }

    @Override
    protected void initView(View view) {
        StatusBarUtil.setStatusBarDarkTheme(getActivity(), false);

        oTaskAdapter = new OTaskAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(oTaskAdapter);


        view.findViewById(R.id.img_back).setOnClickListener(this);
        view.findViewById(R.id.text_add).setOnClickListener(this);
        view.findViewById(R.id.layout_trade).setOnClickListener(this);
        view.findViewById(R.id.img_check).setOnClickListener(this);
        view.findViewById(R.id.layout_detail).setOnClickListener(this);

        view.findViewById(R.id.layout_one).setOnClickListener(this);
        view.findViewById(R.id.layout_two).setOnClickListener(this);
        view.findViewById(R.id.layout_three).setOnClickListener(this);
        view.findViewById(R.id.layout_four).setOnClickListener(this);
        view.findViewById(R.id.layout_five).setOnClickListener(this);

        view.findViewById(R.id.img_banner_one).setOnClickListener(this);
        view.findViewById(R.id.img_banner_two).setOnClickListener(this);


        text_eagle.setTextSize(18);

        double eagle = QuoteProxy.getInstance().getEagle();
        if (eagle != 0) {
            text_eagle.setContent(eagle + "");

        }


        view.findViewById(R.id.layout_check).setOnClickListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.maincolor);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTask(REFRESHTYPE);
            }
        });

        oTaskAdapter.setOnItemClick(new OTaskAdapter.OnItemClick() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccessListener(OTaskEntity.DataBean data) {
                String href = data.getHref();
                String statusName = data.getStatusName();
                int userActivityId = data.getUserActivityId();


                if (href.equals("")) {

                } else if (href.startsWith("/trade")) {
                    if (statusName.equals("未领取")) {
                        postTake(userActivityId);
                    } else if (statusName.equals("未参与")) {

                        List<String> dataList = QuoteProxy.getInstance().getDataList();

                        String subname = data.getSubname();
                        if (subname.contains("模拟交易")) {
                            if (dataList == null) {
                                return;
                            }

                            String s = dataList.get(0);
                            OMarketActivity.enter(getActivity(), OConstant.OQUETO, "2", s);
                        } else {
                            if (dataList == null) {
                                return;
                            }

                            String s2 = dataList.get(0);
                            OMarketActivity.enter(getActivity(), OConstant.OQUETO, "1", s2);
                        }
                    }


                } else if (href.startsWith("/realName")) {
                    if (statusName.equals("未领取")) {
                        postTake(userActivityId);
                    } else if (statusName.equals("未参与")) {
                        OUserActivity.enter(getActivity(), OConstant.OREALNAME);
                    }

                } else if (href.startsWith("/recharge")) {
                    if (statusName.equals("未领取")) {
                        postTake(userActivityId);
                    } else if (statusName.equals("未参与")) {

                        if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {
                            ORechargeEntity oRechargeEntity = QuoteProxy.getInstance().getoRechargeEntity();
                            if (oRechargeEntity == null) {
                                postRecharge();
                            } else {
                                int payFirst = oRechargeEntity.getPayFirst();
                                if (payFirst == 1) {
                                    showItemPopWindow();
                                } else {
                                    OUserActivity.enter(getActivity(), OConstant.O_RECHARGE);
                                }
                            }
                        } else {
                            OUserActivity.enter(getActivity(), OConstant.LOGIN);
                        }

                    }


                }
            }
        });
    }

    private void postTake(int userActivityId) {

        OkGo.<String>post(OConstant.URL_TASK)
                .params(OConstant.PARAM_USER_ACTIVITY_ID, userActivityId)
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
                            Log.d("print", "onSuccess:259:   " + oCodeMsgEntity);
                            if (oCodeMsgEntity.isSuccess() == true) {
                                Toast.makeText(getActivity(), "领取成功!", Toast.LENGTH_SHORT).show();
                                getTask(NULLTYPE);
                            } else {
                                Toast.makeText(getActivity(), "领取失败!", Toast.LENGTH_SHORT).show();

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

    /*充值*/
    private void postRecharge() {
        ORechargeEntity oRechargeEntity = QuoteProxy.getInstance().getoRechargeEntity();

        if (oRechargeEntity != null) {

        } else {


            OkGo.<String>post(OConstant.URL_RECHARGE)
                    .params(OConstant.PARAM_ACTION, OConstant.STAY_GET_PAY_LIST)
                    .params(OConstant.PARAM_SWITCH_TYPE, "1")
                    .params(OConstant.PARAM_PLATFORM, OConstant.STAY_ANDROID)
                    .execute(new StringCallback() {
                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            super.onStart(request);

                        }

                        @Override
                        public void onSuccess(Response<String> response) {
                            if (QuoteProxy.getInstance().isLogin() == true & isMineLogin() == true) {
                                if (!TextUtils.isEmpty(response.body())) {

                                    ORechargeEntity oRechargeEntity = new Gson().fromJson(response.body(), ORechargeEntity.class);

                                    QuoteProxy.getInstance().setoRechargeEntity(oRechargeEntity);

                                }
                            } else {

                            }
                        }
                    });

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showItemPopWindow() {


        View view = LayoutInflater.from(getContext()).inflate(R.layout.o_item_check_pop, null);

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
                postCheckName(name);
            }
        });

        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(layout_view, Gravity.CENTER, 0, 0);

    }

    //核实用户验证
    private void postCheckName(String name) {

        String url = OConstant.URL_RECHARGE + "?" + OConstant.PARAM_ACTION + "=" + OConstant.STAY_CHECKNAME + "&" + OConstant.PARAM_NAME + "=" + name;
        Log.d("print", "postCheckName:309:   " + url);
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
                            Log.d("print", "onSuccess:315:   " + response.body());
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                postRecharge();
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        dismissProgressDialog();
                        Toast.makeText(getActivity(), getString(R.string.o_text_err), Toast.LENGTH_SHORT).show();

                    }
                });

    }

    @Override
    protected void intPresenter() {

    }

    @Override
    protected void initData() {

    }

    private int flag = 1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;

            case R.id.layout_check:


                getCheck();
                getBond();

                break;

            case R.id.text_add:

                showPopWindow();
                break;

            case R.id.layout_trade:
                List<String> dataList2 = QuoteProxy.getInstance().getDataList();

                if (dataList2 == null) {
                    return;
                }

                String s2 = dataList2.get(1);

                OMarketActivity.enter(getActivity(), OConstant.OQUETO, "1", s2);
                break;


            case R.id.img_check:
                if (flag == 0) {
                    img_check.setImageDrawable(getResources().getDrawable(R.mipmap.o_my_eyeopen));
                    text_eagle2.setVisibility(View.GONE);
                    text_eagle.setVisibility(View.VISIBLE);
                    flag = 1;
                } else if (flag == 1) {
                    img_check.setImageDrawable(getResources().getDrawable(R.mipmap.o_my_eyeclose));
                    text_eagle2.setVisibility(View.VISIBLE);
                    text_eagle.setVisibility(View.GONE);
                    flag = 0;
                }
                break;

            case R.id.layout_detail:

                OUserActivity.enter(getActivity(), OConstant.O_MONEY_DETAIL);

                break;
            case R.id.layout_one:
            case R.id.layout_two:
            case R.id.layout_three:
            case R.id.layout_four:
            case R.id.layout_five:

                getBond();
                getCheck();

                break;

            case R.id.img_banner_one:
                OIntentActivity.enter(getActivity(), OConstant.O_NOVICE);
                break;

            case R.id.img_banner_two:
                OImmersiveActivity.enter(getActivity(), OConstant.O_LOTTERY);
                break;
        }
    }

    private void getBond() {
        OkGo.<String>get(OConstant.URL_TASK_CHECK_IN_HISTORY)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OCodeMsgEntity oCodeMsgEntity = new Gson().fromJson(response.body(), OCodeMsgEntity.class);
                            Toast.makeText(getActivity(), oCodeMsgEntity.getErrorMsg(), Toast.LENGTH_SHORT).show();
                            if (oCodeMsgEntity.isSuccess() == true) {
                                getTask(NULLTYPE);
                            }

                        }
                    }
                });
    }


    private void getCheck() {


        OkGo.<String>get(OConstant.URL_TASK_CHECK)
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
                                getTask(NULLTYPE);
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


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.o_item_red_envelope, null);
        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.6f;
        getActivity().getWindow().setAttributes(params);


        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.findViewById(R.id.text_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                backgroundAlpha(1f);

            }
        });


        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(layout_view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    public void backgroundAlpha(float bgalpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgalpha;
        getActivity().getWindow().setAttributes(lp);


    }
}

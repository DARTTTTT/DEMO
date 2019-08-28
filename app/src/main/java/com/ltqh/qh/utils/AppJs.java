package com.ltqh.qh.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.ltqh.qh.activity.MainActivity;
import com.ltqh.qh.activity.UserActivity;
import com.ltqh.qh.activity.WebActivity;
import com.ltqh.qh.base.Constant;

import java.net.URISyntaxException;

/**
 * 客服端和h5交互代码
 */
public class AppJs {

    private static final String TAG = "AppJs";

    private Activity activity;

    public AppJs(Activity activity) {
        this.activity = activity;
    }


    /**
     * 打开Android手机应用市场，让用户对app进行下载
     *
     * @author
     * @version 1
     */
    @JavascriptInterface
    public void openAppMarket() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=" + activity.getPackageName()));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        } else {
            //ToastUtil.showShortToastMsg(R.string.not_find_market_app);
        }
    }

    @JavascriptInterface
    public void setResolution() {

    }


    @JavascriptInterface
    public String getUnipueID() {
        String uniqueID = PhoneInfoUtil.getUniqueID(activity);
        return uniqueID;
    }

    /**
     * 打开app登陆页面
     *
     * @author
     * @version 1
     */
    @JavascriptInterface
    public void login() {
        UserActivity.enter(activity, Constant.LOGIN);
    }


    /**
     * 打开app大厅页面
     *
     * @author
     * @version 1
     */
    @JavascriptInterface
    public void gotoHall() {
        MainActivity.enter(activity, MainActivity.TAB_TYPE.TAB_HALL);
        activity.finish();
    }


    /**
     * 结束当前页面
     *
     * @author
     */
    @JavascriptInterface
    public void finishActivity() {
        activity.finish();
    }

    /**
     * 提供h5直接拨打电话
     *
     * @param number
     */
    @JavascriptInterface
    public void call(String number) {
        Uri uri = Uri.parse("tel:" + number);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        activity.startActivity(intent);
    }


    /**
     * 打开一个新的WebActivity,绝对地址
     */
  /*  @JavascriptInterface
    public void openNewWeb(String url, boolean hasTitle) {
        WebActivity.openNewWebActivity(activity, url, hasTitle, true);
    }*/

    /**
     * 打开一个新的WebActivity,相对地址
     */
  /*  @JavascriptInterface
    public void openNewWebNoHost(String url, boolean hasTitle) {
        WebActivity.openNewWebActivity(activity, url, hasTitle, false);
    }*/


    /**
     * 打开app客户端
     */
    @JavascriptInterface
    public void openApp(String url) {
        try {
            Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    @JavascriptInterface
    public void goBack() {
        if (isWebActivity()) webActivity().goBack();
    }

    @JavascriptInterface
    public void goFroward() {
        if (isWebActivity()) webActivity().goForward();
    }

    @JavascriptInterface
    public void goBottom() {
        if (isWebActivity()) webActivity().goBottom();
    }


    private boolean isWebActivity() {
        return activity instanceof WebActivity;
    }

    private WebActivity webActivity() {
        return (WebActivity) activity;
    }
}

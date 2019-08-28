package com.ltqh.qh.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求管理
 * 对OkHttp请求进行封装
 */
public class OkHttpManager {

    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");

    private volatile static OkHttpManager instance;
    private OkHttpClient mOkHttpClient;
    private Handler okHandler;

    private OkHttpManager() {
        okHandler = new Handler(Looper.getMainLooper());
       // HCookieJarImpl cookieJar = new HCookieJarImpl(new HPersistentCookieStore(TApplication.getApplication()));
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
              /*  .cookieJar(cookieJar)
                .addInterceptor(new LogInterceptor())*/
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        mOkHttpClient = builder.build();
    }

    /**
     * @return
     */
    public static OkHttpManager getInstance() {
        if (instance == null) {
            synchronized (OkHttpManager.class) {
                if (instance == null) {
                    instance = new OkHttpManager();
                }
            }
        }
        return instance;
    }

    /**
     * get请求
     *
     * @param url
     * @param resultCallback
     */
    public void getNet(String url, ResultCallback resultCallback) {
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)//此设置默认为get,可以不设置
                .build();
        dealNet(request, resultCallback);
    }


    public void postNet(String url, ResultCallback resultCallback, Map<String, String> map) {

        if (map == null) {
            map = new HashMap<>();
        }

       // map.put("token", TApplication.getApplication().getToken());
        List<String> mapKeyList = new ArrayList<String>(map.keySet());
        int size = mapKeyList.size();
        Param[] params = new Param[size];

        for (int i = 0; i < size; i++) {
            Param param = new Param();
            param.key = mapKeyList.get(i);
            param.value = map.get(param.key);
            params[i] = param;
        }
        postNet(url, resultCallback, params);
    }


  /*  public void postNet(String url, ResultCallback resultCallback, Map<String, String> map, MultipleStatusView statusView) {
        //        判断当前网络
        if (!NetworkUtils.isNetworkConnected(TApplication.context)) {
            if (statusView != null) {
                statusView.showNoNetwork();
            }
            return;
        }
        postNet(url, resultCallback, map);
    }*/

   /* public void postNet(String url, ResultCallback resultCallback, Map<String, String> map, MultipleStateView stateView) {
        //        判断当前网络
        if (!NetworkUtils.isNetworkConnected(TApplication.context)) {
            if (stateView != null) {
                stateView.showNoNetwork();
            }
            return;
        }
        postNet(url, resultCallback, map);
    }*/

    /**
     * post请求
     *
     * @param url
     * @param resultCallback
     * @param param
     */
    public void postNet(String url, ResultCallback resultCallback, Param... param) {
        if (param == null) {
            param = new Param[0];
        }
        FormBody.Builder formBody = new FormBody.Builder();
        for (Param p : param) {
            formBody.add(p.key, p.value == null ? "" : p.value);
        }

        List<Param> list = new ArrayList();

        for (int i = 0; i < param.length; i++) {
            if (!TextUtils.isEmpty(param[i].value)) {
                list.add(param[i]);
            }
        }
        String time = String.valueOf(System.currentTimeMillis());
        list.add(new Param("timeStamp", time));
        Collections.sort(list);
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Param p = list.get(i);
            stringBuffer.append(p.key);
            stringBuffer.append("=");
            stringBuffer.append(p.value);
            stringBuffer.append("&");
        }
        stringBuffer.append("key=123");
     //   String md5 = MD5Utils.md5(stringBuffer.toString());
     //   formBody.add("sign", md5);
        formBody.add("timeStamp", time);
        RequestBody requestBody = formBody.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        dealNet(request, resultCallback);
    }

    public void postNet(String url,Object tag, ResultCallback resultCallback, Param... param) {
        if (param == null) {
            param = new Param[0];
        }
        FormBody.Builder formBody = new FormBody.Builder();
        for (Param p : param) {
            formBody.add(p.key, p.value == null ? "" : p.value);
        }

        List<Param> list = new ArrayList();

        for (int i = 0; i < param.length; i++) {
            if (!TextUtils.isEmpty(param[i].value)) {
                list.add(param[i]);
            }
        }
        String time = String.valueOf(System.currentTimeMillis());
        list.add(new Param("timeStamp", time));
        Collections.sort(list);
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Param p = list.get(i);
            stringBuffer.append(p.key);
            stringBuffer.append("=");
            stringBuffer.append(p.value);
            stringBuffer.append("&");
        }
        stringBuffer.append("key=123");
      //  String md5 = MD5Utils.md5(stringBuffer.toString());
       // KLog.e("print", "stringBuffer:" + stringBuffer.toString());
      //  formBody.add("sign", md5);
        formBody.add("timeStamp", time);
        RequestBody requestBody = formBody.build();
        Request request = new Request.Builder()
                .url(url)
                .tag(tag)
                .post(requestBody)
                .build();
        dealNet(request, resultCallback);
    }

    public void postJson(String url, ResultCallback resultCallback,String json)
    {
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        dealNet(request, resultCallback);
    }

    /**
     * 发送网络请求
     *
     * @param request
     * @param resultCallback
     */
    private void dealNet(final Request request, final ResultCallback resultCallback) {

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                okHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultCallback.onFailed(request, e);

                        if (resultCallback instanceof FinishResultCallback) {
                            ((FinishResultCallback) resultCallback).onFinish(call);
                        }
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                String str = "";
                try {
                    str = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final String finalStr = str;
                okHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultCallback.onSuccess(finalStr);
                        if (resultCallback instanceof FinishResultCallback) {
                            ((FinishResultCallback) resultCallback).onFinish(call);
                        }
                    }
                });
            }
        });
    }



    public static abstract class ResultCallback {
        public abstract void onFailed(Request request, IOException e);

        public abstract void onSuccess(String response);
    }

    public static abstract class FinishResultCallback extends ResultCallback {
        public abstract void onFinish(Call call);
    }

    /**
     * 参数封装类
     */
    public static class Param implements Comparable {
        String key;
        String value;

        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(@NonNull Object another) {
            Param a1 = this;
            Param a2 = (Param) another;

            return a1.key.compareTo(a2.key);
        }
    }

    /**
     * 取消请求;
     * @param tag
     */
    public void cancelTag(Object tag)
    {
        for (Call call : mOkHttpClient.dispatcher().queuedCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
        }
        for (Call call : mOkHttpClient.dispatcher().runningCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
        }
    }
}

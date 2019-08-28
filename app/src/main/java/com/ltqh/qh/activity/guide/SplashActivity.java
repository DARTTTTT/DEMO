package com.ltqh.qh.activity.guide;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltqh.qh.R;
import com.ltqh.qh.base.Constant;
import com.ltqh.qh.entity.JsonEntity;
import com.ltqh.qh.operation.base.OConstant;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OApiEntity;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.utils.AES;
import com.ltqh.qh.utils.SPUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplashActivity extends Activity {

    private static final String TAG = "SplashActivity";

    private static final int SPLASH_DELAY = 1000;

    private static final int GO_NEXT = 10001;

    private static String KEY = "42980fcm2d3409d!";
    private static String HEX_KEY = "1111111122222222";
    public static String CHECKVERSION_URL1 = "http://blog.sina.com.cn/s/blog_166dde1070102y0m5.html";
    public static String CHECKVERSION_URL2 = "https://blog.csdn.net/nikiazhang/article/details/82828263";

    // public static String BASE_CHECKVERSION = "https://www.fengk76.com";

    public static String[] CHECKVERSION_LIST = new String[]{"https://api.wzwqh.com", "https://api.zjschjy.com"};
    // public static String[] CHECKVERSION_LIST = new String[]{"http://10.28.74.182:8080", "https://api.zjschjy.com"};


    public static String RGEX = "@@(.*?)@@";

    private int url1Count = 0;
    private int url2Count = 0;
    // private static String QUDAO = BuildConfig.QUDAO;
    // XHQH-OFFICAL
    private static String QUDAO = "ltqhtest";

    private boolean isPause;
    private List<String> urlList1;
    private List<String> urlList2;
    private HashMap map;

    private List<String> contractsList, getContractsList, getalllist;
    private List<String> foreignList, getForeignList;
    private List<String> stockindexList, getStockindexList;
    private List<String> domesList, getDomesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 测试 SDK 是否正常工作的代码

        map = new HashMap<>();
        map.put(Constant.PARAM_NAME, QUDAO);
        getApi();
        getisLogin();
        //测试
       /* GuideActivity.enter(SplashActivity.this);
        SplashActivity.this.finish();*/
         startActivity();


    }

    //实盘持仓
    private void getisLogin() {
        OkGo.<String>get(OConstant.URL_POSITION)
                .tag(this)
                .params(OConstant.PARAM_SCHEMESORT, "1")
                .params(OConstant.PARAM_TRADETYPE, "1")
                .params(OConstant.PARAM_BEGINTIME, "")
                .params(OConstant.PARAM_XIAHUAXIAN, System.currentTimeMillis())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            OPositionEntity oPositionEntity = new Gson().fromJson(response.body(), OPositionEntity.class);
                            boolean isLogin = oPositionEntity.isIsLogin();
                            QuoteProxy.getInstance().setLogin(isLogin);

                        }

                    }
                });

    }


    private void getApi() {
        OkGo.<String>get(OConstant.URL_API)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            OApiEntity oApiEntity = new Gson().fromJson(response.body(), OApiEntity.class);

                            QuoteProxy.getInstance().setoApiEntity(oApiEntity);

                            SPUtils.putData(OUserConfig.API, oApiEntity);
                            String contracts = oApiEntity.getContracts().replaceAll("\"", "")
                                    .replaceAll("\\[", "").replaceAll("]", "");

                            String[] split = contracts.split(",");

                            contractsList = new ArrayList<>();

                            for (String x : split) {
                                contractsList.add(x);
                            }


                            foreignList = new ArrayList<>();
                            List<OApiEntity.ForeignCommdsBean> foreignCommds = oApiEntity.getForeignCommds();
                            for (int i = 0; i < foreignCommds.size(); i++) {
                                foreignList.add(foreignCommds.get(i).getCode());
                            }

                            QuoteProxy.getInstance().setForeignList(foreignList);


                            List<OApiEntity.StockIndexCommdsBean> stockIndexCommds = oApiEntity.getStockIndexCommds();
                            stockindexList = new ArrayList<>();
                            for (OApiEntity.StockIndexCommdsBean y :
                                    stockIndexCommds) {
                                stockindexList.add(y.getCode());
                            }

                            QuoteProxy.getInstance().setStockindexList(stockindexList);

                            domesList = new ArrayList<>();
                            List<OApiEntity.DomesticCommdsBean> domesticCommds = oApiEntity.getDomesticCommds();
                            for (OApiEntity.DomesticCommdsBean y :
                                    domesticCommds) {
                                domesList.add(y.getCode());
                            }

                            QuoteProxy.getInstance().setDomesList(domesList);

                            Log.d("SplashActivity", "onSuccess:splash 197: " + contractsList);
                            Log.d("SplashActivity", "onSuccess:splash 198:" + foreignList);
                            Log.d("SplashActivity", "onSuccess:splash 199: " + stockindexList);
                            Log.d("SplashActivity", "onSuccess:splash 200: " + domesList);
                            getForeignList = new ArrayList<>();
                            for (int i = 0; i < contractsList.size(); i++) {
                                for (int j = 0; j < foreignList.size(); j++) {
                                    if (contractsList.get(i).startsWith(foreignList.get(j))) {
                                        getForeignList.add(contractsList.get(i));
                                    }
                                }
                            }

                            getStockindexList = new ArrayList<>();
                            for (int i = 0; i < contractsList.size(); i++) {
                                for (int j = 0; j < stockindexList.size(); j++) {
                                    if (contractsList.get(i).startsWith(stockindexList.get(j))) {
                                        getStockindexList.add(contractsList.get(i));
                                    }
                                }
                            }

                            getDomesList = new ArrayList<>();
                            for (int i = 0; i < contractsList.size(); i++) {
                                for (int j = 0; j < domesList.size(); j++) {
                                    if (contractsList.get(i).startsWith(domesList.get(j))) {
                                        getDomesList.add(contractsList.get(i));
                                    }
                                }
                            }


                         /*   Log.d("print", "onSuccess:234: " + getForeignList);
                            Log.d("print", "onSuccess:235:" + getStockindexList);
                            Log.d("print", "onSuccess:236: " + getDomesList);*/
                            getalllist = new ArrayList<>();
                            getalllist.addAll(getForeignList);
                            getalllist.addAll(getStockindexList);
                            getalllist.addAll(getDomesList);

                            SPUtils.putString(OUserConfig.ALLDEX, getalllist.toString());
                         /*   SPUtils.putString(OUserConfig.FOREIGN, getForeignList.toString());
                            SPUtils.putString(OUserConfig.STOCKINDEX, getStockindexList.toString());
                            SPUtils.putString(OUserConfig.DOMESTIC, getDomesList.toString());*/


                        }

                    }


                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }


    public static String getSubUtilSimple(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(1);
        }
        return "";
    }

    public static List<String> getUrlList(String urls) {
        List<String> list = new ArrayList<>();
        String[] split = urls.split(";");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }

        return list;
    }

    int count = 0;

    //Aaron 修改直接跳到主页
    private void startActivity() {
        //1.首先判断当前的是否有缓存 ,第一次是去备用的
        JsonEntity data = SPUtils.getData(OUserConfig.CHECKVERSION, JsonEntity.class);
        Log.d("print", "startActivity:259:   " + data);
        if (data != null) {
            if (data.getDPool() != null) {
                List<String> dPool = data.getDPool();
                if (count < dPool.size()) {
                    getCacheCheckVersion(data);
                }
            } else {
                if (data.getDBlog() != null) {
                    getBlog(data.getDBlog().get(0));
                    getBlog2(data.getDBlog().get(1));
                } else {
                    getCheckVersion(CHECKVERSION_LIST[0]);
                }
            }

        } else {
            getCheckVersion(CHECKVERSION_LIST[0]);
        }
    }


    private void getCacheCheckVersion(JsonEntity data) {
        Log.d("print", "getCacheCheckVersion:270:    " + count);
        OkGo.<String>post(data.getDPool().get(count) + "/checkVersion")
                .tag("url1")
                .params("name", QUDAO)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        Log.d("print", "onSuccess:106 " + response.body());


                        if (!TextUtils.isEmpty(response.body())) {
                            try {
                                String decrypt = AES.Decrypt(response.body().getBytes(), KEY);
                                Log.d("print", "onSuccess:缓存解密后数据1: " + decrypt);
                                JsonEntity jsonEntity = new Gson().fromJson(decrypt, JsonEntity.class);
                                Log.d("print", "onSuccess:缓存1: " + jsonEntity);
                                SPUtils.putData(OUserConfig.CHECKVERSION, jsonEntity);


                                if (jsonEntity.getStatus().equals("true") || jsonEntity.getStatus().equals("1")) {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

                                    GuideActivity.enter(SplashActivity.this);

                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();

                                } else {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                                    //   MainActivity.enter(SplashActivity.this, MainActivity.TAB_TYPE.TAB_HOME);
                                    GuideActivity.enter(SplashActivity.this);

                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        if (count >= data.getDPool().size() - 1) {
                            count = 0;
                            SPUtils.remove(OUserConfig.CHECKVERSION);
                            getBlog(data.getDBlog().get(0));
                            getBlog2(data.getDBlog().get(1));

                        }
                        count++;
                        getCacheCheckVersion(data);

                    }
                });

    }

    private void getCheckVersion(String url) {
        OkGo.<String>post(url + "/checkVersion")
                .tag("url1")
                .params("name", QUDAO)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {


                        if (!TextUtils.isEmpty(response.body())) {
                            try {
                                String decrypt = AES.Decrypt(response.body().getBytes(), KEY);
                                Log.d("print", "onSuccess:解密后数据1: " + decrypt);
                                JsonEntity jsonEntity = new Gson().fromJson(decrypt, JsonEntity.class);
                                Log.d("print", "onSuccess:131 1: " + jsonEntity);
                                SPUtils.putData(OUserConfig.CHECKVERSION, jsonEntity);

                                if (jsonEntity.getStatus().equals("true") || jsonEntity.getStatus().equals("1")) {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                                    GuideActivity.enter(SplashActivity.this);


                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();

                                } else {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                                    // MainActivity.enter(SplashActivity.this, MainActivity.TAB_TYPE.TAB_HOME);
                                    GuideActivity.enter(SplashActivity.this);

                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        //2.备用的第一条无效 用第二条
                        getCheckVersion2(CHECKVERSION_LIST[1]);


                    }
                });

    }

    private void getCheckVersion2(String url) {
        OkGo.<String>post(url + "/checkVersion")
                .tag("url1")
                .params("name", QUDAO)
                .execute(new StringCallback() {


                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {
                            Log.d("print", "onSuccess:411  " + response.body());
                            try {
                                String decrypt = AES.Decrypt(response.body().getBytes(), KEY);
                                Log.d("print", "onSuccess:解密后数据2: " + decrypt);
                                JsonEntity jsonEntity = new Gson().fromJson(decrypt, JsonEntity.class);
                                SPUtils.putData(OUserConfig.CHECKVERSION, jsonEntity);

                                if (jsonEntity.getStatus().equals("true") || jsonEntity.getStatus().equals("1")) {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                                    GuideActivity.enter(SplashActivity.this);

                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();

                                } else {
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                                    // MainActivity.enter(SplashActivity.this, MainActivity.TAB_TYPE.TAB_HOME);
                                    GuideActivity.enter(SplashActivity.this);

                                    SplashActivity.this.finish();
                                    OkGo.getInstance().cancelAll();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        Toast.makeText(SplashActivity.this, "当前网络不好,再尝试", Toast.LENGTH_SHORT).show();
                        SplashActivity.this.finish();


                    }
                });

    }

    private void getBlog(String blogUrl) {
        OkGo.<String>get(blogUrl)
                .tag(this)
                .cacheKey("version")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {

                            Document document = Jsoup.parse(response.body());
                            String subUtilSimple = getSubUtilSimple(document.toString(), RGEX);

                            String s1 = null;
                            try {
                                s1 = AES.HexDecrypt(subUtilSimple.getBytes(), HEX_KEY);
                                urlList1 = getUrlList(s1);

                                if (urlList1.size() > 0) {
                                    Log.d("print", "onSuccess:169: " + urlList1);
                                    for (int i = 0; i < urlList1.size(); i++) {
                                        getCheckVersion2(urlList1.get(i));

                                    }


                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }


                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        Toast.makeText(SplashActivity.this, "当前网络不好,已退出", Toast.LENGTH_SHORT).show();
                        SplashActivity.this.finish();

                    }
                });
    }

    private void getBlog2(String blogUrl) {
        OkGo.<String>get(blogUrl)
                .tag(this)
                .cacheKey("version")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        if (!TextUtils.isEmpty(response.body())) {

                            Document document = Jsoup.parse(response.body());
                            String subUtilSimple = getSubUtilSimple(document.toString(), RGEX);

                            String s1 = null;
                            try {
                                s1 = AES.HexDecrypt(subUtilSimple.getBytes(), HEX_KEY);
                                urlList1 = getUrlList(s1);

                                if (urlList1.size() > 0) {
                                    Log.d("print", "onSuccess:169: " + urlList1);
                                    for (int i = 0; i < urlList1.size(); i++) {
                                        getCheckVersion2(urlList1.get(i));

                                    }


                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }


                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);

                        Toast.makeText(SplashActivity.this, "当前网络不好,已退出", Toast.LENGTH_SHORT).show();

                        SplashActivity.this.finish();

                    }
                });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


}

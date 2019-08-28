package com.ltqh.qh.utils;

import android.content.Context;

import com.google.gson.JsonObject;
import com.ltqh.qh.BuildConfig;
import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ParamUrlUtil {
    private Context context;
    private static   String SUFFIX="LT7";

    public ParamUrlUtil(Context context) {
        this.context = context;

    }



    public static String getStrategyParamUrl(String key, Object object) {
        final Map<String, Object> map = new HashMap<>();


        map.put(key, object);
        map.put("pageSize","10");

        Map<String, Object> map1 = new HashMap<>();
        map1.put("data", map);
        String s = params2Json(map).toString();

        map1.put("brand", "000019");
        map1.put("clientVersion", BuildConfig.VERSION_NAME);
        map1.put("cmd", "news");
        map1.put("deviceType", "Android");
        map1.put("func", "strategyList");
        try {
            map1.put("md5", SecurityUtil.md5Encrypt(s + "LT7"));
        } catch (NoSuchAlgorithmException e) {
            map1.put("md5", MD5(s + "LT7"));
        }
        map1.put("timestamp", System.currentTimeMillis());
       // map1.put("token", UserInfoManager.getInstance().getToken());
        String url ="https://aassdd.kk05.cn/lt-interface/api" + "?msg=" + JSON.toJSON(map1);
        return url;
    }

    public static JsonObject params2Json(Map<String, Object> map) {
        JsonObject jsonObject = new JsonObject();
        for(Map.Entry<String, Object> entry : map.entrySet()) {
            jsonObject.addProperty(entry.getKey(),
                    entry.getValue() == null ? null : entry.getValue().toString());
        }
        return jsonObject;
    }
    /**
     * Md5
     */
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public static String getStrategyDetailParamUrl(String key, Object object) {
        final Map<String, Object> map = new HashMap<>();


        map.put(key, object);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("data", map);
        String s = params2Json(map).toString();

        map1.put("brand", "000019");
        map1.put("clientVersion", BuildConfig.VERSION_NAME);
        map1.put("cmd", "news");
        map1.put("deviceType", "Android");
        map1.put("func", "detail");
        try {
            map1.put("md5", SecurityUtil.md5Encrypt(s + SUFFIX));
        } catch (NoSuchAlgorithmException e) {
            map1.put("md5", MD5(s + SUFFIX));
        }
        map1.put("timestamp", System.currentTimeMillis());
        map1.put("deviceNum", PhoneInfoUtil.getDeviceId());
       // map1.put("token", UserInfoManager.getInstance().getToken());
        String url = "https://aassdd.kk05.cn/lt-interface/api" + "?msg=" + JSON.toJSON(map1);
        return url;
    }
}

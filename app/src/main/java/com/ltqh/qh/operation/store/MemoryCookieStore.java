package com.ltqh.qh.operation.store;


import android.util.Log;

import com.ltqh.qh.entity.CookieEntity;
import com.ltqh.qh.operation.store.CookieStore;
import com.ltqh.qh.utils.SPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Created by zhy on 16/3/10.
 */
public class MemoryCookieStore implements CookieStore {
    private final HashMap<String, List<Cookie>> allCookies = new HashMap<>();

    @Override
    public void add(HttpUrl url, List<Cookie> cookies) {
        Log.d("print", "get_url:26:" + url+"  -----    "+cookies);


//        Log.e("print","cookies:" + cookies.size());
        if (cookies != null) {
            for (int i = 0; i < cookies.size(); i++) {
              //  Log.d("print", "cookies:33:" + cookies);
            }
        }

        List<Cookie> oldCookies = allCookies.get(url.host());

        if (oldCookies != null) {
            Iterator<Cookie> itNew = cookies.iterator();
            Iterator<Cookie> itOld = oldCookies.iterator();
            while (itNew.hasNext()) {
                String va = itNew.next().name();
                while (va != null && itOld.hasNext()) {
                    String v = itOld.next().name();
                    if (v != null && va.equals(v)) {
                        itOld.remove();
                    }
                }
            }
            oldCookies.addAll(cookies);
        } else {
            allCookies.put(url.host(), cookies);
        }


    }

    @Override
    public List<Cookie> get(HttpUrl uri) {
        List<Cookie> cookies = allCookies.get(uri.host());
        if (cookies == null) {
            cookies = new ArrayList<>();
            allCookies.put(uri.host(), cookies);
        }
        Log.d("print", "get_url:63:" + uri+"  -----    "+cookies);
        //        Log.e("print","cookies:" + cookies.size());

        if (cookies != null) {
            for (int i = 0; i < cookies.size(); i++) {

            }
        }
        return cookies;

    }

    @Override
    public boolean removeAll() {
        allCookies.clear();
        return true;
    }

    @Override
    public List<Cookie> getCookies() {
        List<Cookie> cookies = new ArrayList<>();
        Set<String> httpUrls = allCookies.keySet();
        for (String url : httpUrls) {
            cookies.addAll(allCookies.get(url));
        }
        return cookies;
    }


    @Override
    public boolean remove(HttpUrl uri, Cookie cookie) {
        List<Cookie> cookies = allCookies.get(uri.host());
        if (cookie != null) {
            return cookies.remove(cookie);
        }
        return false;
    }


}

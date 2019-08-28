package com.ltqh.qh.entity;

import java.io.Serializable;

public class CookieEntity implements Serializable {
    private Object cookie;

    @Override
    public String toString() {
        return "CookieEntity{" +
                "cookie=" + cookie +
                '}';
    }

    public CookieEntity(Object cookie) {
        this.cookie = cookie;
    }

    public Object getCookie() {
        return cookie;
    }

    public void setCookie(Object cookie) {
        this.cookie = cookie;
    }
}

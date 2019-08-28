package com.ltqh.qh.operation.tabview;

import android.util.Log;

/**
 * Created by Rancune@126.com 2019/4/1.
 */
public class L {
    private static boolean sDebug = false;

    public static void setLogEnabled(boolean enalbe) {
        sDebug = enalbe;
    }

    public static void v(String tag, String msg) {
        if (sDebug) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (sDebug) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (sDebug) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (sDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (sDebug) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (sDebug) {
            Log.d(tag, msg, throwable);
        }
    }
}

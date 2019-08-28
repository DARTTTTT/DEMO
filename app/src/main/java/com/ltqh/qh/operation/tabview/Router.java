package com.ltqh.qh.operation.tabview;

import android.annotation.SuppressLint;
import android.app.Application;

/**
 * Created by Rancune@126.com 2019/4/1.
 */
public class Router {
    private static volatile boolean sDebug = false;
    private static volatile Application sApplication;

    public static synchronized void init(boolean debug, Application application) {
        sDebug = debug;
        L.setLogEnabled(debug);
        sApplication = application;
    }

    public static boolean debug() {
        return sDebug;
    }

    @SuppressLint("PrivateApi")
    public static Application application() {
        if (sApplication != null) {
            return sApplication;
        }
        if (sApplication == null) {
            synchronized (Router.class) {
                if (sApplication == null) {
                    try {
                        sApplication = (Application) Class.forName("android.app.ActivityThread")
                                .getMethod("currentApplication").invoke(null, (Object[]) null);
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        return sApplication;
    }

}

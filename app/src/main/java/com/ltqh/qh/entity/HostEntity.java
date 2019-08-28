package com.ltqh.qh.entity;

public class HostEntity {


    /**
     * brandName : 魅族
     * failMsg : // CRASH: com.xhqhtz.jrxx (pid 9301)
     // Short Msg: java.lang.NullPointerException
     // Long Msg: java.lang.NullPointerException: Attempt to invoke virtual method 'com.ltqh.qh.entity.LoginEntity$DataBean com.ltqh.qh.entity.LoginEntity.getData()' on a null object reference
     // Build Label: Meizu/meizu_PRO7S_CN/PRO7S:7.0/NRD90M/1532290370:user/release-keys
     // Build Changelist: 1532290370
     // Build Time: 1536524143000
     // java.lang.NullPointerException: Attempt to invoke virtual method 'com.ltqh.qh.entity.LoginEntity$DataBean com.ltqh.qh.entity.LoginEntity.getData()' on a null object reference
     // 	at com.ltqh.qh.activity.WebActivity.openZhiChiService(WebActivity.java:169)
     // 	at com.ltqh.qh.fragment.MyFragment.onClick(MyFragment.java:133)
     // 	at android.view.View.performClick(View.java:5730)
     // 	at android.view.View$PerformClick.run(View.java:22806)
     // 	at android.os.Handler.handleCallback(Handler.java:836)
     // 	at android.os.Handler.dispatchMessage(Handler.java:103)
     // 	at android.os.Looper.loop(Looper.java:203)
     // 	at android.app.ActivityThread.main(ActivityThread.java:6527)
     // 	at java.lang.reflect.Method.invoke(Native Method)
     // 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1113)
     // 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:974)
     //

     * modelName : PRO7 标准版
     * osVersion : Flyme 7.1.0.0A
     */

    private String brandName;
    private String failMsg;
    private String modelName;
    private String osVersion;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
}

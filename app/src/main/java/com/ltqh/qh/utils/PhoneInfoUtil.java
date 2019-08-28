
/**
 * @Title: PhoneInfoUtil.java
 * @Package com.luckin.magnifier.utils
 * @Description:
 * @ClassName: PhoneInfoUtil
 *
 * @author 于泽坤
 * @date 2015-7-2 上午10:14:08 
*/

package com.ltqh.qh.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import com.ltqh.qh.base.AppContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static cn.jpush.android.api.JThirdPlatFormInterface.toMD5;

public class PhoneInfoUtil {

    private static final String TAG = "PhoneInfoUtil";

    /**
     * 请求的附加信息,手机型号、IMEI、系统版本、app版本、运营商等
     * @return List<NameValuePair>
     */
  /*  public static List<NameValuePair> getRequestExtra() {
        List<NameValuePair> extra = new ArrayList<NameValuePair>();
        extra.add(new BasicNameValuePair("deviceModel", android.os.Build.MODEL));
        extra.add(new BasicNameValuePair("deviceImei", getDeviceId()));
        extra.add(new BasicNameValuePair("deviceVersion", android.os.Build.VERSION.RELEASE));
        extra.add(new BasicNameValuePair("clientVersion", AppInfoUtil.getVersionName(App.getAppContext())));
        extra.add(new BasicNameValuePair("regSource", ApiConfig.REGSOURCE));
        extra.add(new BasicNameValuePair("carrieroperator", getIMSI()));
        //extra.add(new BasicNameValuePair("version", ApiConfig.API_VERSION));
        extra.add(new BasicNameValuePair("systemName", "1"));
        extra.add(new BasicNameValuePair("recordIP", getIP()));
        extra.add(new BasicNameValuePair("recordVersion", AppInfoUtil.getVersionName(App.getAppContext())));
        extra.add(new BasicNameValuePair("recordLoginMode", "手机号登录"));
        extra.add(new BasicNameValuePair("recordImei", getDeviceId()));
        extra.add(new BasicNameValuePair("recordDevice", getDeviceMode()));
        extra.add(new BasicNameValuePair("recordCarrierOperator", getIMSI()));
        extra.add(new BasicNameValuePair("recordAccessMode", getNetType(App.getAppContext())));
        return extra;
    }*/

    public static String getDeviceMode(){
        return android.os.Build.MODEL;
    }

    /** 获取运营商 */
   /* public static String getIMSI() {
        if("WIFI".equals(getNetType(AppContext.getAppContext())))  return "";
        TelephonyManager tm = (TelephonyManager)AppContext.getAppContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = tm.getSubscriberId();
        if(imsi != null) {
            if(imsi.startsWith("46000") || imsi.startsWith("46002") || imsi.startsWith("46007")){
                //因为移动网络编号46000下的IMSI已经用完，所以虚拟了一个46002编号，134/159号段使用了此编号 //中国移动
                imsi = "中国移动";
            } else if(imsi.startsWith("46001") || imsi.startsWith("46006")){
                imsi = "中国联通";
            } else if(imsi.startsWith("46003") || imsi.startsWith("46005") || imsi.startsWith("46011")){
                imsi = "中国电信";
            } else {
                imsi = "";
            }
        } else {//避免空指针，传空
            imsi = "";
        }
        return imsi;
    }*/

    /**
     * @return 友盟获取设备的唯一id
     */
    public static String getDeviceId(){
        return getDeviceInfo(AppContext.getAppContext());
    }



    public static String getDeviceInfo(Context context) {
        try {
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String typePrefix = "DEVICE_ID_";
            @SuppressLint("MissingPermission") String deviceId = tm.getDeviceId();

            if (TextUtils.isEmpty(deviceId)) {
                deviceId = android.os.Build.SERIAL;
                typePrefix = "SERIAL_";
            }

            if (TextUtils.isEmpty(deviceId)) {
                android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                String mac = wifi.getConnectionInfo().getMacAddress();
                deviceId = mac;
                typePrefix = "MAC_";
            }

            if (TextUtils.isEmpty(deviceId)) {
                deviceId = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
                typePrefix = "ANDROID_ID_";
            }

            return typePrefix + deviceId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUniqueID(Context context){
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
      /*  String id = androidID + Build.SERIAL;
        try {
            return toMD5(id);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return id;
        }*/
      return androidID;
    }

    private static String toMD5(String text) throws NoSuchAlgorithmException {
        //获取摘要器 MessageDigest
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //通过摘要器对字符串的二进制字节数组进行hash计算
        byte[] digest = messageDigest.digest(text.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            //循环每个字符 将计算结果转化为正整数;
            int digestInt = digest[i] & 0xff;
            //将10进制转化为较短的16进制
            String hexString = Integer.toHexString(digestInt);
            //转化结果如果是个位数会省略0,因此判断并补0
            if (hexString.length() < 2) {
                sb.append(0);
            }
            //将循环结果添加到缓冲区
            sb.append(hexString);
        }
        //返回整个结果
        return sb.toString();
    }

}

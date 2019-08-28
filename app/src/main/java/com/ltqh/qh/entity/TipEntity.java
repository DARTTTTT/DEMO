package com.ltqh.qh.entity;

public class TipEntity {


    /**
     * code : 603
     * msg : 无效的短信验证码
     * data :
     */

    private int code;
    private String msg;
    private String data;

    @Override
    public String toString() {
        return "TipEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

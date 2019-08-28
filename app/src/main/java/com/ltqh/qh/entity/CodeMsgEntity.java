package com.ltqh.qh.entity;

public class CodeMsgEntity {


    /**
     * code : 603
     * msg : 无效的短信验证码
     * data :
     */

    private int code;
    private String msg;

    @Override
    public String toString() {
        return "CodeMsgEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
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


}

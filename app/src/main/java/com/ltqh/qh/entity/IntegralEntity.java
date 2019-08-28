package com.ltqh.qh.entity;

public class IntegralEntity {


    /**
     * code : 400
     * errparam :
     * msg : 自定义错误
     * msgType : 0
     */

    private String code;
    private String errparam;
    private String msg;
    private int msgType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrparam() {
        return errparam;
    }

    public void setErrparam(String errparam) {
        this.errparam = errparam;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "IntegralEntity{" +
                "code='" + code + '\'' +
                ", errparam='" + errparam + '\'' +
                ", msg='" + msg + '\'' +
                ", msgType=" + msgType +
                '}';
    }
}

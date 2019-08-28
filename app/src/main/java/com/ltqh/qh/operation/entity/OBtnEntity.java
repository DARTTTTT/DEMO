package com.ltqh.qh.operation.entity;

public class OBtnEntity {


    /**
     * button : {"ok":{"name":"马上交易","url":"/trade/?back"},"no":{"name":"暂不提款"}}
     * code : 200
     * success : false
     * errorCode : 500
     * errorMsg : 您现可提现229.69元<br/>（网站活动送的6元，还需实盘交易10手后方可提款）
     * resultMsg :
     */

    private String button;
    private int code;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private String resultMsg;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

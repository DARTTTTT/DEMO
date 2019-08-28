package com.ltqh.qh.operation.entity;

public class OCodeMsgEntity {


    /**
     * errorCode : 900
     * success : false
     * errorMsg : 验证码错误
     */

    private int errorCode;
    private boolean success;
    private String errorMsg;
    private String redirectUrl;
    private String successNumber;
    private String failNumber;
    private String redirect;
    private int code;
    private String resultMsg;
    private String button;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(String successNumber) {
        this.successNumber = successNumber;
    }

    public String getFailNumber() {
        return failNumber;
    }

    public void setFailNumber(String failNumber) {
        this.failNumber = failNumber;
    }


    /**
     * redirect : http://test.6006.com/sso/login.htm
     * code : 200
     */
    @Override
    public String toString() {
        return "OCodeMsgEntity{" +
                "errorCode=" + errorCode +
                ", success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", successNumber='" + successNumber + '\'' +
                ", failNumber='" + failNumber + '\'' +
                ", redirect='" + redirect + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", button='" + button + '\'' +
                '}';
    }

    /**
     * button : {"ok":{"name":"马上领取","url":"/user/task.htm?back"}}
     */




    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

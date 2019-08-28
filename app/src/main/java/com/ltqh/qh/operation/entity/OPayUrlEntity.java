package com.ltqh.qh.operation.entity;

public class OPayUrlEntity {


    /**
     * redirectURL : http://www.fn858.com/pay?id=1661718&token=521fd2c4b1bf12eb46874572adca6dfd
     * payOrderId : P201907231058082419
     * data : null
     * success : true
     * errorCode : 200
     * errorMsg : success
     * code : 200
     * resultMsg :
     */

    private String redirectURL;
    private String payOrderId;
    private Object data;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private int code;
    private String resultMsg;

    @Override
    public String toString() {
        return "OPayUrlEntity{" +
                "redirectURL='" + redirectURL + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

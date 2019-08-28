package com.ltqh.qh.operation.entity;

public class ORegisterEntity {


    /**
     * button : {"ok":{"name":"马上领取","url":"/user/task.htm?back"}}
     * errorCode : 200
     * success : true
     * errorMsg : 恭喜您！注册成功
     */

    private ButtonBean button;
    private int errorCode;
    private boolean success;
    private String errorMsg;

    public ButtonBean getButton() {
        return button;
    }

    public void setButton(ButtonBean button) {
        this.button = button;
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

    public static class ButtonBean {
        /**
         * ok : {"name":"马上领取","url":"/user/task.htm?back"}
         */

        private OkBean ok;

        public OkBean getOk() {
            return ok;
        }

        public void setOk(OkBean ok) {
            this.ok = ok;
        }

        public static class OkBean {
            /**
             * name : 马上领取
             * url : /user/task.htm?back
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}

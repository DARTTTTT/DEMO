package com.ltqh.qh.entity;

public class SunyiEnitiy {


    /**
     * code : 1
     * msg : 泸市B股股票投资损益计算成功
     * data : {"transferFeeOut":"2200.00","stampTaxOut":"120.00","brokerAmt":"220.00","sumAmt":"2540.00","plAmt":"17460.00","plAmtRMB":"120805.74","plRatio":"17.27"}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "SunyiEnitiy{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * transferFeeOut : 2200.00
         * stampTaxOut : 120.00
         * brokerAmt : 220.00
         * sumAmt : 2540.00
         * plAmt : 17460.00
         * plAmtRMB : 120805.74
         * plRatio : 17.27
         */

        private String transferFeeOut;
        private String stampTaxOut;
        private String brokerAmt;
        private String sumAmt;
        private String plAmt;
        private String plAmtRMB;
        private String plRatio;

        @Override
        public String toString() {
            return "DataBean{" +
                    "transferFeeOut='" + transferFeeOut + '\'' +
                    ", stampTaxOut='" + stampTaxOut + '\'' +
                    ", brokerAmt='" + brokerAmt + '\'' +
                    ", sumAmt='" + sumAmt + '\'' +
                    ", plAmt='" + plAmt + '\'' +
                    ", plAmtRMB='" + plAmtRMB + '\'' +
                    ", plRatio='" + plRatio + '\'' +
                    '}';
        }

        public String getTransferFeeOut() {
            return transferFeeOut;
        }

        public void setTransferFeeOut(String transferFeeOut) {
            this.transferFeeOut = transferFeeOut;
        }

        public String getStampTaxOut() {
            return stampTaxOut;
        }

        public void setStampTaxOut(String stampTaxOut) {
            this.stampTaxOut = stampTaxOut;
        }

        public String getBrokerAmt() {
            return brokerAmt;
        }

        public void setBrokerAmt(String brokerAmt) {
            this.brokerAmt = brokerAmt;
        }

        public String getSumAmt() {
            return sumAmt;
        }

        public void setSumAmt(String sumAmt) {
            this.sumAmt = sumAmt;
        }

        public String getPlAmt() {
            return plAmt;
        }

        public void setPlAmt(String plAmt) {
            this.plAmt = plAmt;
        }

        public String getPlAmtRMB() {
            return plAmtRMB;
        }

        public void setPlAmtRMB(String plAmtRMB) {
            this.plAmtRMB = plAmtRMB;
        }

        public String getPlRatio() {
            return plRatio;
        }

        public void setPlRatio(String plRatio) {
            this.plRatio = plRatio;
        }
    }
}

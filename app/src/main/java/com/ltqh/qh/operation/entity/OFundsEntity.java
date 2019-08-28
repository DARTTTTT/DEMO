package com.ltqh.qh.operation.entity;

import java.util.List;

public class OFundsEntity {


    @Override
    public String toString() {
        return "OFundsEntity{" +
                "pageCount=" + pageCount +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }





    private int pageCount;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private int code;
    private String resultMsg;
    private List<DataBean> data;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "assetMoney=" + assetMoney +
                    ", bizId=" + bizId +
                    ", bizType=" + bizType +
                    ", brand='" + brand + '\'' +
                    ", detail='" + detail + '\'' +
                    ", explain='" + explain + '\'' +
                    ", id=" + id +
                    ", money=" + money +
                    ", remark='" + remark + '\'' +
                    ", time=" + time +
                    ", type=" + type +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * assetMoney : 135.686
         * bizId : 1395961
         * bizType : 3
         * brand : LT
         * detail :
         * explain : 提款取出
         * id : 17958101
         * money : 100
         * remark :
         * time : 1561598724457
         * type : 200
         * userId : 922459
         */



        private double assetMoney;
        private int bizId;
        private int bizType;
        private String brand;
        private String detail;
        private String explain;
        private int id;
        private double money;
        private String remark;
        private long time;
        private int type;
        private int userId;

        public double getAssetMoney() {
            return assetMoney;
        }

        public void setAssetMoney(double assetMoney) {
            this.assetMoney = assetMoney;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getBizType() {
            return bizType;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}

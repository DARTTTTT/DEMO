package com.ltqh.qh.operation.entity;

import java.io.Serializable;
import java.util.List;

public class ORechargeEntity implements Serializable {


    @Override
    public String toString() {
        return "ORechargeEntity{" +
                "payFirst=" + payFirst +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", payList=" + payList +
                '}';
    }

    /**
     * payList : [{"area":"","brand":"LT","description":"支持微信、支付宝、云闪付、手机银行、网银转账！单笔充值限额300-20000元。","endTime":0,"id":582,"name":"支付宝/微信转账","paySwitch":1,"paymentWay":0,"picType":"","platform":"ios,android,h5,web,pc","remark":"","sort":1,"startTime":0,"url":"/rechargeXXPay?type=LTFW1001&min=300&max=20000&device=wap","urlId":522,"urlName":"LT#福旺银行卡"},{"area":"","brand":"LT","description":"每次充值前请重新获取收款账号！单笔最低300，最高20000","endTime":0,"id":224,"name":"银行卡转账","paySwitch":1,"paymentWay":0,"picType":"","platform":"ios,android,h5,web,pc","remark":"","sort":2,"startTime":0,"url":"/rechargeXXPayCPBank?type=LTCY10001&min=300&max=20000&device=wap","urlId":199,"urlName":"LT#CPAY卡到卡"},{"area":"","brand":"LT","description":"每次充值前请重新获取收款账号！单笔最低300，最高20000","endTime":0,"id":550,"name":"支付宝转卡","paySwitch":1,"paymentWay":0,"picType":"","platform":"ios,android,h5,web,pc","remark":"","sort":3,"startTime":0,"url":"/rechargeXXPayCP?type=LTCY10002&min=300&max=20000&device=wap","urlId":493,"urlName":"LT#CPAY宝到卡"},{"area":"","brand":"LT","description":"单笔最低300，最高20000","endTime":0,"id":551,"name":"支付宝转账","paySwitch":1,"paymentWay":0,"picType":"","platform":"ios,android,h5,web,pc","remark":"对外；5-23从FK借来收款。","sort":4,"startTime":0,"url":"/rechargeXXPay?type=LTAL10029&min=300&max=20000&device=wap","urlId":494,"urlName":"LT#企业支付宝29（广州风歌商贸-FK）"}]
     * payFirst : 1
     * success : true
     * errorCode : 200
     * errorMsg :
     * code : 200
     * resultMsg :
     */



    private int payFirst;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private int code;
    private String resultMsg;
    private List<PayListBean> payList;

    public int getPayFirst() {
        return payFirst;
    }

    public void setPayFirst(int payFirst) {
        this.payFirst = payFirst;
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

    public List<PayListBean> getPayList() {
        return payList;
    }

    public void setPayList(List<PayListBean> payList) {
        this.payList = payList;
    }

    public static class PayListBean implements Serializable{
        @Override
        public String toString() {
            return "PayListBean{" +
                    "area='" + area + '\'' +
                    ", brand='" + brand + '\'' +
                    ", description='" + description + '\'' +
                    ", endTime=" + endTime +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", paySwitch=" + paySwitch +
                    ", paymentWay=" + paymentWay +
                    ", picType='" + picType + '\'' +
                    ", platform='" + platform + '\'' +
                    ", remark='" + remark + '\'' +
                    ", sort=" + sort +
                    ", startTime=" + startTime +
                    ", url='" + url + '\'' +
                    ", urlId=" + urlId +
                    ", urlName='" + urlName + '\'' +
                    '}';
        }

        /**
         * area :
         * brand : LT
         * description : 支持微信、支付宝、云闪付、手机银行、网银转账！单笔充值限额300-20000元。
         * endTime : 0
         * id : 582
         * name : 支付宝/微信转账
         * paySwitch : 1
         * paymentWay : 0
         * picType :
         * platform : ios,android,h5,web,pc
         * remark :
         * sort : 1
         * startTime : 0
         * url : /rechargeXXPay?type=LTFW1001&min=300&max=20000&device=wap
         * urlId : 522
         * urlName : LT#福旺银行卡
         */



        private String area;
        private String brand;
        private String description;
        private int endTime;
        private int id;
        private String name;
        private int paySwitch;
        private int paymentWay;
        private String picType;
        private String platform;
        private String remark;
        private int sort;
        private int startTime;
        private String url;
        private int urlId;
        private String urlName;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPaySwitch() {
            return paySwitch;
        }

        public void setPaySwitch(int paySwitch) {
            this.paySwitch = paySwitch;
        }

        public int getPaymentWay() {
            return paymentWay;
        }

        public void setPaymentWay(int paymentWay) {
            this.paymentWay = paymentWay;
        }

        public String getPicType() {
            return picType;
        }

        public void setPicType(String picType) {
            this.picType = picType;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUrlId() {
            return urlId;
        }

        public void setUrlId(int urlId) {
            this.urlId = urlId;
        }

        public String getUrlName() {
            return urlName;
        }

        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }
    }
}

package com.ltqh.qh.operation.entity;

import java.util.List;

public class OTaskEntity {


    /**
     * data : [{"category":1,"createTime":{"date":17,"day":0,"hours":22,"minutes":11,"month":2,"seconds":38,"time":1552831898020,"timezoneOffset":-480,"year":119},"expireTime":{"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119},"href":"/register","id":7,"name":"注册送现金","prizeType":1,"prizeValue":"18","status":2,"statusName":"已过期","subname":"奖励现金18元","type":1,"userActivityId":129673,"userId":978196},{"category":3,"createTime":{"date":4,"day":4,"hours":17,"minutes":52,"month":6,"seconds":25,"time":1562233945890,"timezoneOffset":-480,"year":119},"expireTime":{"date":29,"day":2,"hours":17,"minutes":52,"month":2,"seconds":25,"time":1648547545890,"timezoneOffset":-480,"year":122},"href":"","id":8,"name":"签到送红包","prizeType":2,"prizeValue":"20","status":1,"statusName":"已领取","subname":"每日签到送20红包","type":5,"userActivityId":407316,"userId":978196},{"category":2,"createTime":{"date":18,"day":1,"hours":6,"minutes":24,"month":2,"seconds":17,"time":1552861457027,"timezoneOffset":-480,"year":119},"expireTime":{"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119},"href":"/trade","id":41,"name":"操场练习","prizeType":2,"prizeValue":"180","status":2,"statusName":"已过期","subname":"新注册模拟交易3次奖励180红包","type":6,"userActivityId":129741,"userId":978196},{"category":2,"createTime":{"date":18,"day":1,"hours":6,"minutes":28,"month":2,"seconds":22,"time":1552861702883,"timezoneOffset":-480,"year":119},"expireTime":{"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119},"href":"/realName","id":42,"name":"拜入门下","prizeType":2,"prizeValue":"280","status":2,"statusName":"已过期","subname":"实名认证奖励280红包","type":4,"userActivityId":129742,"userId":978196},{"category":2,"createTime":null,"expireTime":null,"href":"/recharge","id":43,"name":"投石问路","prizeType":2,"prizeValue":"380","status":-1,"statusName":"未参与","subname":"新注册首次入金奖励380红包","type":2,"userActivityId":0,"userId":978196},{"category":2,"createTime":{"date":18,"day":1,"hours":6,"minutes":5,"month":2,"seconds":44,"time":1552860344027,"timezoneOffset":-480,"year":119},"expireTime":{"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119},"href":"/trade","id":44,"name":"小试牛刀","prizeType":2,"prizeValue":"280","status":2,"statusName":"已过期","subname":"新注册首次交易迷你模式奖励280红包","type":7,"userActivityId":129730,"userId":978196},{"category":2,"createTime":{"date":18,"day":1,"hours":6,"minutes":4,"month":2,"seconds":32,"time":1552860272040,"timezoneOffset":-480,"year":119},"expireTime":{"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119},"href":"/trade","id":45,"name":"正式登场","prizeType":2,"prizeValue":"160","status":2,"statusName":"已过期","subname":"新注册首次交易标准模式奖励160红包","type":8,"userActivityId":129728,"userId":978196}]
     * success : true
     * errorCode : 200
     * errorMsg :
     * code : 200
     * resultMsg :
     */

    private boolean success;
    private int errorCode;
    private String errorMsg;
    private int code;
    private String resultMsg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "OTaskEntity{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
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
                    "category=" + category +
                    ", createTime=" + createTime +
                    ", expireTime=" + expireTime +
                    ", href='" + href + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", prizeType=" + prizeType +
                    ", prizeValue='" + prizeValue + '\'' +
                    ", status=" + status +
                    ", statusName='" + statusName + '\'' +
                    ", subname='" + subname + '\'' +
                    ", type=" + type +
                    ", userActivityId=" + userActivityId +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * category : 1
         * createTime : {"date":17,"day":0,"hours":22,"minutes":11,"month":2,"seconds":38,"time":1552831898020,"timezoneOffset":-480,"year":119}
         * expireTime : {"date":16,"day":0,"hours":6,"minutes":28,"month":5,"seconds":22,"time":1560637702883,"timezoneOffset":-480,"year":119}
         * href : /register
         * id : 7
         * name : 注册送现金
         * prizeType : 1
         * prizeValue : 18
         * status : 2
         * statusName : 已过期
         * subname : 奖励现金18元
         * type : 1
         * userActivityId : 129673
         * userId : 978196
         */



        private int category;
        private CreateTimeBean createTime;
        private ExpireTimeBean expireTime;
        private String href;
        private int id;
        private String name;
        private int prizeType;
        private String prizeValue;
        private int status;
        private String statusName;
        private String subname;
        private int type;
        private int userActivityId;
        private int userId;

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public ExpireTimeBean getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(ExpireTimeBean expireTime) {
            this.expireTime = expireTime;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
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

        public int getPrizeType() {
            return prizeType;
        }

        public void setPrizeType(int prizeType) {
            this.prizeType = prizeType;
        }

        public String getPrizeValue() {
            return prizeValue;
        }

        public void setPrizeValue(String prizeValue) {
            this.prizeValue = prizeValue;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getSubname() {
            return subname;
        }

        public void setSubname(String subname) {
            this.subname = subname;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserActivityId() {
            return userActivityId;
        }

        public void setUserActivityId(int userActivityId) {
            this.userActivityId = userActivityId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public static class CreateTimeBean {
            /**
             * date : 17
             * day : 0
             * hours : 22
             * minutes : 11
             * month : 2
             * seconds : 38
             * time : 1552831898020
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class ExpireTimeBean {
            /**
             * date : 16
             * day : 0
             * hours : 6
             * minutes : 28
             * month : 5
             * seconds : 22
             * time : 1560637702883
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}

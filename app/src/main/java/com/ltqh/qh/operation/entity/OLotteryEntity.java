package com.ltqh.qh.operation.entity;

import java.util.List;

public class OLotteryEntity {


    @Override
    public String toString() {
        return "OLotteryEntity{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * data : [{"brand":"ZY","createTime":{"date":8,"day":4,"hours":18,"minutes":32,"month":7,"seconds":39,"time":1565260359130,"timezoneOffset":-480,"year":119},"descr":"","eagle":50,"effectTime":{"date":8,"day":4,"hours":18,"minutes":32,"month":7,"seconds":2,"time":1565260322000,"timezoneOffset":-480,"year":119},"expireTime":{"date":31,"day":4,"hours":0,"minutes":0,"month":9,"seconds":0,"time":1572451200000,"timezoneOffset":-480,"year":119},"fundExplain":"网站活动","id":8,"limit":1000,"name":"星际大转盘","valid":1}]
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
                    "brand='" + brand + '\'' +
                    ", createTime=" + createTime +
                    ", descr='" + descr + '\'' +
                    ", eagle=" + eagle +
                    ", effectTime=" + effectTime +
                    ", expireTime=" + expireTime +
                    ", fundExplain='" + fundExplain + '\'' +
                    ", id=" + id +
                    ", limit=" + limit +
                    ", name='" + name + '\'' +
                    ", valid=" + valid +
                    '}';
        }

        /**
         * brand : ZY
         * createTime : {"date":8,"day":4,"hours":18,"minutes":32,"month":7,"seconds":39,"time":1565260359130,"timezoneOffset":-480,"year":119}
         * descr :
         * eagle : 50
         * effectTime : {"date":8,"day":4,"hours":18,"minutes":32,"month":7,"seconds":2,"time":1565260322000,"timezoneOffset":-480,"year":119}
         * expireTime : {"date":31,"day":4,"hours":0,"minutes":0,"month":9,"seconds":0,"time":1572451200000,"timezoneOffset":-480,"year":119}
         * fundExplain : 网站活动
         * id : 8
         * limit : 1000
         * name : 星际大转盘
         * valid : 1
         */



        private String brand;
        private CreateTimeBean createTime;
        private String descr;
        private int eagle;
        private EffectTimeBean effectTime;
        private ExpireTimeBean expireTime;
        private String fundExplain;
        private int id;
        private int limit;
        private String name;
        private int valid;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public String getDescr() {
            return descr;
        }

        public void setDescr(String descr) {
            this.descr = descr;
        }

        public int getEagle() {
            return eagle;
        }

        public void setEagle(int eagle) {
            this.eagle = eagle;
        }

        public EffectTimeBean getEffectTime() {
            return effectTime;
        }

        public void setEffectTime(EffectTimeBean effectTime) {
            this.effectTime = effectTime;
        }

        public ExpireTimeBean getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(ExpireTimeBean expireTime) {
            this.expireTime = expireTime;
        }

        public String getFundExplain() {
            return fundExplain;
        }

        public void setFundExplain(String fundExplain) {
            this.fundExplain = fundExplain;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValid() {
            return valid;
        }

        public void setValid(int valid) {
            this.valid = valid;
        }

        public static class CreateTimeBean {
            /**
             * date : 8
             * day : 4
             * hours : 18
             * minutes : 32
             * month : 7
             * seconds : 39
             * time : 1565260359130
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

        public static class EffectTimeBean {
            /**
             * date : 8
             * day : 4
             * hours : 18
             * minutes : 32
             * month : 7
             * seconds : 2
             * time : 1565260322000
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
             * date : 31
             * day : 4
             * hours : 0
             * minutes : 0
             * month : 9
             * seconds : 0
             * time : 1572451200000
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

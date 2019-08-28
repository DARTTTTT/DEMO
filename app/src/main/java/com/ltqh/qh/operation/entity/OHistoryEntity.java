package com.ltqh.qh.operation.entity;

import java.util.List;

public class OHistoryEntity {


    /**
     * data : [{"brand":"ZY","createTime":{"date":9,"day":5,"hours":17,"minutes":51,"month":7,"seconds":35,"time":1565344295700,"timezoneOffset":-480,"year":119},"eagle":0,"id":12506,"lotteryId":8,"lotteryName":"星际大转盘","prizeName":"再接再厉！","prizeType":2,"prizeValue":0,"userId":1040204}]
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
        return "OHistoryEntity{" +
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
                    "brand='" + brand + '\'' +
                    ", createTime=" + createTime +
                    ", eagle=" + eagle +
                    ", id=" + id +
                    ", lotteryId=" + lotteryId +
                    ", lotteryName='" + lotteryName + '\'' +
                    ", prizeName='" + prizeName + '\'' +
                    ", prizeType=" + prizeType +
                    ", prizeValue=" + prizeValue +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * brand : ZY
         * createTime : {"date":9,"day":5,"hours":17,"minutes":51,"month":7,"seconds":35,"time":1565344295700,"timezoneOffset":-480,"year":119}
         * eagle : 0
         * id : 12506
         * lotteryId : 8
         * lotteryName : 星际大转盘
         * prizeName : 再接再厉！
         * prizeType : 2
         * prizeValue : 0
         * userId : 1040204
         */



        private String brand;
        private CreateTimeBean createTime;
        private int eagle;
        private int id;
        private int lotteryId;
        private String lotteryName;
        private String prizeName;
        private int prizeType;
        private int prizeValue;
        private int userId;

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

        public int getEagle() {
            return eagle;
        }

        public void setEagle(int eagle) {
            this.eagle = eagle;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLotteryId() {
            return lotteryId;
        }

        public void setLotteryId(int lotteryId) {
            this.lotteryId = lotteryId;
        }

        public String getLotteryName() {
            return lotteryName;
        }

        public void setLotteryName(String lotteryName) {
            this.lotteryName = lotteryName;
        }

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public int getPrizeType() {
            return prizeType;
        }

        public void setPrizeType(int prizeType) {
            this.prizeType = prizeType;
        }

        public int getPrizeValue() {
            return prizeValue;
        }

        public void setPrizeValue(int prizeValue) {
            this.prizeValue = prizeValue;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public static class CreateTimeBean {
            /**
             * date : 9
             * day : 5
             * hours : 17
             * minutes : 51
             * month : 7
             * seconds : 35
             * time : 1565344295700
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

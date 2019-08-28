package com.ltqh.qh.operation.entity;

import java.util.List;

public class OMessageEntity {


    /**
     * code : 200
     * data : [{"content":"五月五，到端午，又是佳节好时光。亲爱的操盘手，端午安康。平台推出特惠活动 指尖端午 粽情一夏积分赠与您！ 详情请见活动图","escapeXml":true,"status":4,"time":{"date":7,"day":5,"hours":11,"minutes":3,"month":5,"seconds":39,"time":1559876619747,"timezoneOffset":-480,"year":119}}]
     * success : true
     * errorCode : 200
     * errorMsg :
     * resultMsg :
     */

    private int code;
    private boolean success;
    private int errorCode;
    private String errorMsg;
    private String resultMsg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "OMessageEntity{" +
                "code=" + code +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 五月五，到端午，又是佳节好时光。亲爱的操盘手，端午安康。平台推出特惠活动 指尖端午 粽情一夏积分赠与您！ 详情请见活动图
         * escapeXml : true
         * status : 4
         * time : {"date":7,"day":5,"hours":11,"minutes":3,"month":5,"seconds":39,"time":1559876619747,"timezoneOffset":-480,"year":119}
         */

        private String content;
        private boolean escapeXml;
        private int status;
        private TimeBean time;

        @Override
        public String toString() {
            return "DataBean{" +
                    "content='" + content + '\'' +
                    ", escapeXml=" + escapeXml +
                    ", status=" + status +
                    ", time=" + time +
                    '}';
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isEscapeXml() {
            return escapeXml;
        }

        public void setEscapeXml(boolean escapeXml) {
            this.escapeXml = escapeXml;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public static class TimeBean {
            /**
             * date : 7
             * day : 5
             * hours : 11
             * minutes : 3
             * month : 5
             * seconds : 39
             * time : 1559876619747
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

            @Override
            public String toString() {
                return "TimeBean{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }

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

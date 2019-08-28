package com.ltqh.qh.operation.entity;

import java.util.List;

public class OWithdrawHistoryEntity {


    /**
     * inouts : [{"admin":10187,"bankCard":"民生银行(6226220132701003)","brand":"LT","channel":"","charge":0,"detail":"MP提款LTHP10005","device":"","disposeTime":{"date":24,"day":1,"hours":17,"minutes":15,"month":5,"seconds":23,"time":1561367723480,"timezoneOffset":-480,"year":119},"explain":"提款取出","finishTime":null,"id":1387857,"money":1211.08,"payNumber":"LW6OHEUQFZ6UHSLO","payOrder":"H201906241715231418","remark":"[系统] 提现失败","requestTime":{"date":24,"day":1,"hours":17,"minutes":14,"month":5,"seconds":31,"time":1561367671907,"timezoneOffset":-480,"year":119},"status":2,"type":200,"userId":923421}]
     * code : 200
     * resultMsg :
     */

    private int code;
    private String resultMsg;
    private List<InoutsBean> inouts;

    @Override
    public String toString() {
        return "OWithdrawHistoryEntity{" +
                "code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", inouts=" + inouts +
                '}';
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

    public List<InoutsBean> getInouts() {
        return inouts;
    }

    public void setInouts(List<InoutsBean> inouts) {
        this.inouts = inouts;
    }

    public static class InoutsBean {
        @Override
        public String toString() {
            return "InoutsBean{" +
                    "admin=" + admin +
                    ", bankCard='" + bankCard + '\'' +
                    ", brand='" + brand + '\'' +
                    ", channel='" + channel + '\'' +
                    ", charge=" + charge +
                    ", detail='" + detail + '\'' +
                    ", device='" + device + '\'' +
                    ", disposeTime=" + disposeTime +
                    ", explain='" + explain + '\'' +
                    ", finishTime=" + finishTime +
                    ", id=" + id +
                    ", money=" + money +
                    ", payNumber='" + payNumber + '\'' +
                    ", payOrder='" + payOrder + '\'' +
                    ", remark='" + remark + '\'' +
                    ", requestTime=" + requestTime +
                    ", status=" + status +
                    ", type=" + type +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * admin : 10187
         * bankCard : 民生银行(6226220132701003)
         * brand : LT
         * channel :
         * charge : 0
         * detail : MP提款LTHP10005
         * device :
         * disposeTime : {"date":24,"day":1,"hours":17,"minutes":15,"month":5,"seconds":23,"time":1561367723480,"timezoneOffset":-480,"year":119}
         * explain : 提款取出
         * finishTime : null
         * id : 1387857
         * money : 1211.08
         * payNumber : LW6OHEUQFZ6UHSLO
         * payOrder : H201906241715231418
         * remark : [系统] 提现失败
         * requestTime : {"date":24,"day":1,"hours":17,"minutes":14,"month":5,"seconds":31,"time":1561367671907,"timezoneOffset":-480,"year":119}
         * status : 2
         * type : 200
         * userId : 923421
         */

        private int admin;
        private String bankCard;
        private String brand;
        private String channel;
        private int charge;
        private String detail;
        private String device;
        private DisposeTimeBean disposeTime;
        private String explain;
        private Object finishTime;
        private int id;
        private String money;
        private String payNumber;
        private String payOrder;
        private String remark;
        private RequestTimeBean requestTime;
        private int status;
        private int type;
        private int userId;

        public int getAdmin() {
            return admin;
        }

        public void setAdmin(int admin) {
            this.admin = admin;
        }

        public String getBankCard() {
            return bankCard;
        }

        public void setBankCard(String bankCard) {
            this.bankCard = bankCard;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public int getCharge() {
            return charge;
        }

        public void setCharge(int charge) {
            this.charge = charge;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public DisposeTimeBean getDisposeTime() {
            return disposeTime;
        }

        public void setDisposeTime(DisposeTimeBean disposeTime) {
            this.disposeTime = disposeTime;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public Object getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(Object finishTime) {
            this.finishTime = finishTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getPayNumber() {
            return payNumber;
        }

        public void setPayNumber(String payNumber) {
            this.payNumber = payNumber;
        }

        public String getPayOrder() {
            return payOrder;
        }

        public void setPayOrder(String payOrder) {
            this.payOrder = payOrder;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public RequestTimeBean getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(RequestTimeBean requestTime) {
            this.requestTime = requestTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public static class DisposeTimeBean {
            /**
             * date : 24
             * day : 1
             * hours : 17
             * minutes : 15
             * month : 5
             * seconds : 23
             * time : 1561367723480
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
                return "DisposeTimeBean{" +
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

        public static class RequestTimeBean {
            @Override
            public String toString() {
                return "RequestTimeBean{" +
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

            /**
             * date : 24
             * day : 1
             * hours : 17
             * minutes : 14
             * month : 5
             * seconds : 31
             * time : 1561367671907
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

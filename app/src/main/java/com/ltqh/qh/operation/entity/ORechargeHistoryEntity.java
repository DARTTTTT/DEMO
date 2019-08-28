package com.ltqh.qh.operation.entity;

import java.util.List;

public class ORechargeHistoryEntity {


    @Override
    public String toString() {
        return "ORechargeHistoryEntity{" +
                "pageSize=" + pageSize +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", inouts=" + inouts +
                '}';
    }

    private int pageSize;
    private int code;
    private String resultMsg;
    private List<InoutsBean> inouts;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
         * admin : 0
         * bankCard :
         * brand : LT
         * channel : LT福旺支付（卡到卡）
         * charge : 0
         * detail : LT福旺银行卡
         * device : WEB
         * disposeTime : {"date":25,"day":2,"hours":17,"minutes":51,"month":5,"seconds":9,"time":1561456269340,"timezoneOffset":-480,"year":119}
         * explain : 充值存入
         * finishTime : null
         * id : 1391253
         * money : 300
         * payNumber : R41F5TEPWK5QZTOR
         * payOrder : P201906251749098394
         * remark : 充值成功，充值金额：300.00元，实际到账：300.00元
         * requestTime : {"date":25,"day":2,"hours":17,"minutes":49,"month":5,"seconds":9,"time":1561456149173,"timezoneOffset":-480,"year":119}
         * status : 1
         * type : 100
         * userId : 922459
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
             * date : 25
             * day : 2
             * hours : 17
             * minutes : 51
             * month : 5
             * seconds : 9
             * time : 1561456269340
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
             * date : 25
             * day : 2
             * hours : 17
             * minutes : 49
             * month : 5
             * seconds : 9
             * time : 1561456149173
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

package com.ltqh.qh.operation.entity;

public class OUnionEntity {


    /**
     * asset : {"comm":0,"commApply":0,"commExchange":0,"dataMD5":"7d12112bed88f5c0847b0310cd1a9090","discount":"","eagle":380,"fundIn":0,"fundOut":0,"game":76878,"money":18,"signString":"1040209`18.0000`0.0000`0.0000","userId":1040209}
     * union : {"commRatio":0.05,"commRatioExtra":"","commTime":183,"userConsume":0,"userCount":0,"userId":1040209,"visitCount":0,"visitIp":"","visitTime":{"date":1,"day":4,"hours":8,"minutes":0,"month":0,"seconds":0,"time":0,"timezoneOffset":-480,"year":70}}
     * unionTotal : 0
     * unionVolume : 0
     * code : 200
     * resultMsg :
     */

    private AssetBean asset;
    private UnionBean union;
    private int unionTotal;
    private int unionVolume;
    private int code;
    private String resultMsg;

    @Override
    public String toString() {
        return "OUnionEntity{" +
                "asset=" + asset +
                ", union=" + union +
                ", unionTotal=" + unionTotal +
                ", unionVolume=" + unionVolume +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public AssetBean getAsset() {
        return asset;
    }

    public void setAsset(AssetBean asset) {
        this.asset = asset;
    }

    public UnionBean getUnion() {
        return union;
    }

    public void setUnion(UnionBean union) {
        this.union = union;
    }

    public int getUnionTotal() {
        return unionTotal;
    }

    public void setUnionTotal(int unionTotal) {
        this.unionTotal = unionTotal;
    }

    public int getUnionVolume() {
        return unionVolume;
    }

    public void setUnionVolume(int unionVolume) {
        this.unionVolume = unionVolume;
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

    public static class AssetBean {
        @Override
        public String toString() {
            return "AssetBean{" +
                    "comm=" + comm +
                    ", commApply=" + commApply +
                    ", commExchange=" + commExchange +
                    ", dataMD5='" + dataMD5 + '\'' +
                    ", discount='" + discount + '\'' +
                    ", eagle=" + eagle +
                    ", fundIn=" + fundIn +
                    ", fundOut=" + fundOut +
                    ", game=" + game +
                    ", money=" + money +
                    ", signString='" + signString + '\'' +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * comm : 0
         * commApply : 0
         * commExchange : 0
         * dataMD5 : 7d12112bed88f5c0847b0310cd1a9090
         * discount :
         * eagle : 380
         * fundIn : 0
         * fundOut : 0
         * game : 76878
         * money : 18
         * signString : 1040209`18.0000`0.0000`0.0000
         * userId : 1040209
         */



        private double comm;
        private double commApply;
        private double commExchange;
        private String dataMD5;
        private String discount;
        private int eagle;
        private double fundIn;
        private double fundOut;
        private double game;
        private double money;
        private String signString;
        private int userId;

        public double getComm() {
            return comm;
        }

        public void setComm(double comm) {
            this.comm = comm;
        }

        public double getCommApply() {
            return commApply;
        }

        public void setCommApply(double commApply) {
            this.commApply = commApply;
        }

        public double getCommExchange() {
            return commExchange;
        }

        public void setCommExchange(double commExchange) {
            this.commExchange = commExchange;
        }

        public String getDataMD5() {
            return dataMD5;
        }

        public void setDataMD5(String dataMD5) {
            this.dataMD5 = dataMD5;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public int getEagle() {
            return eagle;
        }

        public void setEagle(int eagle) {
            this.eagle = eagle;
        }

        public double getFundIn() {
            return fundIn;
        }

        public void setFundIn(double fundIn) {
            this.fundIn = fundIn;
        }

        public double getFundOut() {
            return fundOut;
        }

        public void setFundOut(double fundOut) {
            this.fundOut = fundOut;
        }

        public double getGame() {
            return game;
        }

        public void setGame(double game) {
            this.game = game;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public String getSignString() {
            return signString;
        }

        public void setSignString(String signString) {
            this.signString = signString;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

    public static class UnionBean {
        @Override
        public String toString() {
            return "UnionBean{" +
                    "commRatio=" + commRatio +
                    ", commRatioExtra='" + commRatioExtra + '\'' +
                    ", commTime=" + commTime +
                    ", userConsume=" + userConsume +
                    ", userCount=" + userCount +
                    ", userId=" + userId +
                    ", visitCount=" + visitCount +
                    ", visitIp='" + visitIp + '\'' +
                    ", visitTime=" + visitTime +
                    '}';
        }

        /**
         * commRatio : 0.05
         * commRatioExtra :
         * commTime : 183
         * userConsume : 0
         * userCount : 0
         * userId : 1040209
         * visitCount : 0
         * visitIp :
         * visitTime : {"date":1,"day":4,"hours":8,"minutes":0,"month":0,"seconds":0,"time":0,"timezoneOffset":-480,"year":70}
         */



        private double commRatio;
        private String commRatioExtra;
        private int commTime;
        private int userConsume;
        private int userCount;
        private int userId;
        private int visitCount;
        private String visitIp;
        private VisitTimeBean visitTime;

        public double getCommRatio() {
            return commRatio;
        }

        public void setCommRatio(double commRatio) {
            this.commRatio = commRatio;
        }

        public String getCommRatioExtra() {
            return commRatioExtra;
        }

        public void setCommRatioExtra(String commRatioExtra) {
            this.commRatioExtra = commRatioExtra;
        }

        public int getCommTime() {
            return commTime;
        }

        public void setCommTime(int commTime) {
            this.commTime = commTime;
        }

        public int getUserConsume() {
            return userConsume;
        }

        public void setUserConsume(int userConsume) {
            this.userConsume = userConsume;
        }

        public int getUserCount() {
            return userCount;
        }

        public void setUserCount(int userCount) {
            this.userCount = userCount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(int visitCount) {
            this.visitCount = visitCount;
        }

        public String getVisitIp() {
            return visitIp;
        }

        public void setVisitIp(String visitIp) {
            this.visitIp = visitIp;
        }

        public VisitTimeBean getVisitTime() {
            return visitTime;
        }

        public void setVisitTime(VisitTimeBean visitTime) {
            this.visitTime = visitTime;
        }

        public static class VisitTimeBean {
            @Override
            public String toString() {
                return "VisitTimeBean{" +
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
             * date : 1
             * day : 4
             * hours : 8
             * minutes : 0
             * month : 0
             * seconds : 0
             * time : 0
             * timezoneOffset : -480
             * year : 70
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

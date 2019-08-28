package com.ltqh.qh.operation.entity;

import java.util.List;

public class OPositionEntity {


    /**
     * isLogin : true
     * code : 200
     * data : [{"closeSource":"","commodity":"美原油","contCode":"CL1907","contract":"CL1907","cpPrice":0,"cpVolume":0,"id":11708973,"income":0,"investUserId":0,"investUsername":"","isBuy":true,"moneyType":0,"opPrice":53.49,"opVolume":15,"orVolume":0,"price":0,"priceDigit":2,"stopLoss":-36750,"stopLossBegin":-36750,"stopProfit":110250,"stopProfitBegin":110250,"time":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":41,"time":1559896601187,"timezoneOffset":-480,"year":119},"tradeMsg":"","tradeStatus":8,"tradeTime":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":41,"time":1559896601187,"timezoneOffset":-480,"year":119},"volume":15},{"closeSource":"","commodity":"美原油","contCode":"CL1907","contract":"CL1907","cpPrice":0,"cpVolume":0,"id":11708967,"income":0,"investUserId":0,"investUsername":"","isBuy":true,"moneyType":0,"opPrice":53.5,"opVolume":15,"orVolume":0,"price":0,"priceDigit":2,"stopLoss":-47250,"stopLossBegin":-47250,"stopProfit":141750,"stopProfitBegin":141750,"time":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":20,"time":1559896580153,"timezoneOffset":-480,"year":119},"tradeMsg":"","tradeStatus":8,"tradeTime":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":20,"time":1559896580153,"timezoneOffset":-480,"year":119},"volume":15},{"closeSource":"","commodity":"美原油","contCode":"CL1907","contract":"CL1907","cpPrice":0,"cpVolume":0,"id":11708964,"income":0,"investUserId":0,"investUsername":"","isBuy":false,"moneyType":0,"opPrice":53.5,"opVolume":1,"orVolume":0,"price":0,"priceDigit":2,"stopLoss":-1050,"stopLossBegin":-1050,"stopProfit":3150,"stopProfitBegin":3150,"time":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":15,"time":1559896575793,"timezoneOffset":-480,"year":119},"tradeMsg":"","tradeStatus":8,"tradeTime":{"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":15,"time":1559896575793,"timezoneOffset":-480,"year":119},"volume":1}]
     * success : true
     * schemeSort : 1
     * eagleDeduction : 0
     * errorCode : 200
     * asset : {"comm":0,"commApply":0,"commExchange":0,"dataMD5":"9f4314d02cf7dbd52a8f18aff81df9c7","discount":"","eagle":0,"fundIn":0,"fundOut":0,"game":9144,"money":18,"signString":"1027884`18.0000`0.0000`0.0000","userId":1027884}
     * tradeType : 1
     * errorMsg :
     * resultMsg :
     */

    private boolean isLogin;
    private int code;
    private boolean success;
    private int schemeSort;
    private double eagleDeduction;
    private int errorCode;
    private AssetBean asset;
    private int tradeType;
    private String errorMsg;
    private String resultMsg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "OPositionEntity{" +
                "isLogin=" + isLogin +
                ", code=" + code +
                ", success=" + success +
                ", schemeSort=" + schemeSort +
                ", eagleDeduction=" + eagleDeduction +
                ", errorCode=" + errorCode +
                ", asset=" + asset +
                ", tradeType=" + tradeType +
                ", errorMsg='" + errorMsg + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
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

    public int getSchemeSort() {
        return schemeSort;
    }

    public void setSchemeSort(int schemeSort) {
        this.schemeSort = schemeSort;
    }

    public double getEagleDeduction() {
        return eagleDeduction;
    }

    public void setEagleDeduction(double eagleDeduction) {
        this.eagleDeduction = eagleDeduction;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public AssetBean getAsset() {
        return asset;
    }

    public void setAsset(AssetBean asset) {
        this.asset = asset;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
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

    public static class AssetBean {
        /**
         * comm : 0
         * commApply : 0
         * commExchange : 0
         * dataMD5 : 9f4314d02cf7dbd52a8f18aff81df9c7
         * discount :
         * eagle : 0
         * fundIn : 0
         * fundOut : 0
         * game : 9144
         * money : 18
         * signString : 1027884`18.0000`0.0000`0.0000
         * userId : 1027884
         */

        private int comm;
        private int commApply;
        private int commExchange;
        private String dataMD5;
        private String discount;
        private int eagle;
        private double fundIn;
        private double fundOut;
        private double game;
        private double money;
        private String signString;
        private int userId;

        public int getComm() {
            return comm;
        }

        public void setComm(int comm) {
            this.comm = comm;
        }

        public int getCommApply() {
            return commApply;
        }

        public void setCommApply(int commApply) {
            this.commApply = commApply;
        }

        public int getCommExchange() {
            return commExchange;
        }

        public void setCommExchange(int commExchange) {
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

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "closeSource='" + closeSource + '\'' +
                    ", commodity='" + commodity + '\'' +
                    ", contCode='" + contCode + '\'' +
                    ", contract='" + contract + '\'' +
                    ", cpPrice=" + cpPrice +
                    ", cpVolume=" + cpVolume +
                    ", id=" + id +
                    ", income=" + income +
                    ", investUserId=" + investUserId +
                    ", investUsername='" + investUsername + '\'' +
                    ", isBuy=" + isBuy +
                    ", moneyType=" + moneyType +
                    ", opPrice=" + opPrice +
                    ", opVolume=" + opVolume +
                    ", orVolume=" + orVolume +
                    ", price=" + price +
                    ", priceDigit=" + priceDigit +
                    ", stopLoss=" + stopLoss +
                    ", stopLossBegin=" + stopLossBegin +
                    ", stopProfit=" + stopProfit +
                    ", stopProfitBegin=" + stopProfitBegin +
                    ", time=" + time +
                    ", tradeMsg='" + tradeMsg + '\'' +
                    ", tradeStatus=" + tradeStatus +
                    ", tradeTime=" + tradeTime +
                    ", volume=" + volume +
                    '}';
        }

        /**
         * closeSource :
         * commodity : 美原油
         * contCode : CL1907
         * contract : CL1907
         * cpPrice : 0
         * cpVolume : 0
         * id : 11708973
         * income : 0
         * investUserId : 0
         * investUsername :
         * isBuy : true
         * moneyType : 0
         * opPrice : 53.49
         * opVolume : 15
         * orVolume : 0
         * price : 0
         * priceDigit : 2
         * stopLoss : -36750
         * stopLossBegin : -36750
         * stopProfit : 110250
         * stopProfitBegin : 110250
         * time : {"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":41,"time":1559896601187,"timezoneOffset":-480,"year":119}
         * tradeMsg :
         * tradeStatus : 8
         * tradeTime : {"date":7,"day":5,"hours":16,"minutes":36,"month":5,"seconds":41,"time":1559896601187,"timezoneOffset":-480,"year":119}
         * volume : 15
         */



        private String closeSource;
        private String commodity;
        private String contCode;
        private String contract;
        private double cpPrice;
        private int cpVolume;
        private String id;
        private double income;
        private int investUserId;
        private String investUsername;
        private boolean isBuy;
        private int moneyType;
        private double opPrice;
        private int opVolume;
        private int orVolume;
        private double price;
        private int priceDigit;
        private double stopLoss;
        private double stopLossBegin;
        private double stopProfit;
        private double stopProfitBegin;
        private TimeBean time;
        private String tradeMsg;
        private int tradeStatus;
        private TradeTimeBean tradeTime;
        private int volume;




        public String getCloseSource() {
            return closeSource;
        }

        public void setCloseSource(String closeSource) {
            this.closeSource = closeSource;
        }

        public String getCommodity() {
            return commodity;
        }

        public void setCommodity(String commodity) {
            this.commodity = commodity;
        }

        public String getContCode() {
            return contCode;
        }

        public void setContCode(String contCode) {
            this.contCode = contCode;
        }

        public String getContract() {
            return contract;
        }

        public void setContract(String contract) {
            this.contract = contract;
        }

        public double getCpPrice() {
            return cpPrice;
        }

        public void setCpPrice(double cpPrice) {
            this.cpPrice = cpPrice;
        }

        public int getCpVolume() {
            return cpVolume;
        }

        public void setCpVolume(int cpVolume) {
            this.cpVolume = cpVolume;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public int getInvestUserId() {
            return investUserId;
        }

        public void setInvestUserId(int investUserId) {
            this.investUserId = investUserId;
        }

        public String getInvestUsername() {
            return investUsername;
        }

        public void setInvestUsername(String investUsername) {
            this.investUsername = investUsername;
        }

        public boolean isIsBuy() {
            return isBuy;
        }

        public void setIsBuy(boolean isBuy) {
            this.isBuy = isBuy;
        }

        public int getMoneyType() {
            return moneyType;
        }

        public void setMoneyType(int moneyType) {
            this.moneyType = moneyType;
        }

        public double getOpPrice() {
            return opPrice;
        }

        public void setOpPrice(double opPrice) {
            this.opPrice = opPrice;
        }

        public int getOpVolume() {
            return opVolume;
        }

        public void setOpVolume(int opVolume) {
            this.opVolume = opVolume;
        }

        public int getOrVolume() {
            return orVolume;
        }

        public void setOrVolume(int orVolume) {
            this.orVolume = orVolume;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPriceDigit() {
            return priceDigit;
        }

        public void setPriceDigit(int priceDigit) {
            this.priceDigit = priceDigit;
        }

        public double getStopLoss() {
            return stopLoss;
        }

        public void setStopLoss(double stopLoss) {
            this.stopLoss = stopLoss;
        }

        public double getStopLossBegin() {
            return stopLossBegin;
        }

        public void setStopLossBegin(double stopLossBegin) {
            this.stopLossBegin = stopLossBegin;
        }

        public double getStopProfit() {
            return stopProfit;
        }

        public void setStopProfit(double stopProfit) {
            this.stopProfit = stopProfit;
        }

        public double getStopProfitBegin() {
            return stopProfitBegin;
        }

        public void setStopProfitBegin(double stopProfitBegin) {
            this.stopProfitBegin = stopProfitBegin;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public String getTradeMsg() {
            return tradeMsg;
        }

        public void setTradeMsg(String tradeMsg) {
            this.tradeMsg = tradeMsg;
        }

        public int getTradeStatus() {
            return tradeStatus;
        }

        public void setTradeStatus(int tradeStatus) {
            this.tradeStatus = tradeStatus;
        }

        public TradeTimeBean getTradeTime() {
            return tradeTime;
        }

        public void setTradeTime(TradeTimeBean tradeTime) {
            this.tradeTime = tradeTime;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public static class TimeBean {
            /**
             * date : 7
             * day : 5
             * hours : 16
             * minutes : 36
             * month : 5
             * seconds : 41
             * time : 1559896601187
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

        public static class TradeTimeBean {
            /**
             * date : 7
             * day : 5
             * hours : 16
             * minutes : 36
             * month : 5
             * seconds : 41
             * time : 1559896601187
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
                return "TradeTimeBean{" +
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

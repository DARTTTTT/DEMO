package com.ltqh.qh.operation.entity;

import java.util.List;

public class OTradeListEntity {




    private int code;
    private boolean vipAvailable;
    private String signed;
    private int errorCode;
    private boolean standandAlert;
    private boolean tradeQuick;
    private String errorMsg;
    private String resultMsg;
    private boolean isLogin;
    private boolean success;
    private int schemeSort;
    private AssetBean asset;
    private int tradeType;
    private List<TradeListBean> tradeList;

    @Override
    public String toString() {
        return "OTradeListEntity{" +
                "code=" + code +
                ", vipAvailable=" + vipAvailable +
                ", signed='" + signed + '\'' +
                ", errorCode=" + errorCode +
                ", standandAlert=" + standandAlert +
                ", tradeQuick=" + tradeQuick +
                ", errorMsg='" + errorMsg + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", isLogin=" + isLogin +
                ", success=" + success +
                ", schemeSort=" + schemeSort +
                ", asset=" + asset +
                ", tradeType=" + tradeType +
                ", tradeList=" + tradeList +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isVipAvailable() {
        return vipAvailable;
    }

    public void setVipAvailable(boolean vipAvailable) {
        this.vipAvailable = vipAvailable;
    }

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isStandandAlert() {
        return standandAlert;
    }

    public void setStandandAlert(boolean standandAlert) {
        this.standandAlert = standandAlert;
    }

    public boolean isTradeQuick() {
        return tradeQuick;
    }

    public void setTradeQuick(boolean tradeQuick) {
        this.tradeQuick = tradeQuick;
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

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
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

    public List<TradeListBean> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<TradeListBean> tradeList) {
        this.tradeList = tradeList;
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
         * dataMD5 : 9f4314d02cf7dbd52a8f18aff81df9c7
         * discount :
         * eagle : 0
         * fundIn : 0
         * fundOut : 0
         * game : 25659
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

    public static class TradeListBean {
        @Override
        public String toString() {
            return "TradeListBean{" +
                    "chargeOriginal=" + chargeOriginal +
                    ", chargeUnit=" + chargeUnit +
                    ", commCode='" + commCode + '\'' +
                    ", commName='" + commName + '\'' +
                    ", commValid=" + commValid +
                    ", contCode='" + contCode + '\'' +
                    ", contName='" + contName + '\'' +
                    ", currency='" + currency + '\'' +
                    ", discountDesp='" + discountDesp + '\'' +
                    ", exchange='" + exchange + '\'' +
                    ", exgRate=" + exgRate +
                    ", isForeign=" + isForeign +
                    ", offset=" + offset +
                    ", priceChange=" + priceChange +
                    ", priceDigit=" + priceDigit +
                    ", priceUnit=" + priceUnit +
                    ", range=" + range +
                    ", signed=" + signed +
                    ", spread=" + spread +
                    ", stopPlCur=" + stopPlCur +
                    ", stopPlShow=" + stopPlShow +
                    ", volumeCur=" + volumeCur +
                    ", volumeShow=" + volumeShow +
                    ", chargeUnitList=" + chargeUnitList +
                    ", closeTime=" + closeTime +
                    ", depositList=" + depositList +
                    ", moneyTypeList=" + moneyTypeList +
                    ", stopLossList=" + stopLossList +
                    ", stopProfitList=" + stopProfitList +
                    ", volumeList=" + volumeList +
                    '}';
        }

        /**
         * chargeOriginal : 0
         * chargeUnit : 298
         * chargeUnitList : [298]
         * closeTime : [1560495300000]
         * commCode : IF
         * commName : 沪深300
         * commValid : true
         * contCode : IF1906
         * contName : IF1906
         * currency : CNY
         * depositList : []
         * discountDesp :
         * exchange : 中金所
         * exgRate : 1
         * isForeign : false
         * moneyTypeList : [0]
         * offset : 0
         * priceChange : 0.2
         * priceDigit : 1
         * priceUnit : 300
         * range : false
         * signed : false
         * spread : 0
         * stopLossList : [-3000,-4500,-6000,-7500,-9000]
         * stopPlCur : 1
         * stopPlShow : 3
         * stopProfitList : [9000,13500,18000,22500,27000]
         * volumeCur : 0
         * volumeList : [1,2,5,10,15,20]
         * volumeShow : 3
         */




        private int chargeOriginal;
        private int chargeUnit;
        private String commCode;
        private String commName;
        private boolean commValid;
        private String contCode;
        private String contName;
        private String currency;
        private String discountDesp;
        private String exchange;
        private double exgRate;
        private boolean isForeign;
        private int offset;
        private double priceChange;
        private int priceDigit;
        private double priceUnit;
        private boolean range;
        private boolean signed;
        private int spread;
        private int stopPlCur;
        private int stopPlShow;
        private int volumeCur;
        private int volumeShow;
        private List<Integer> chargeUnitList;
        private List<Long> closeTime;
        private List<Integer> depositList;
        private List<Integer> moneyTypeList;
        private List<Integer> stopLossList;
        private List<Integer> stopProfitList;
        private List<Integer> volumeList;

        public int getChargeOriginal() {
            return chargeOriginal;
        }

        public void setChargeOriginal(int chargeOriginal) {
            this.chargeOriginal = chargeOriginal;
        }

        public int getChargeUnit() {
            return chargeUnit;
        }

        public void setChargeUnit(int chargeUnit) {
            this.chargeUnit = chargeUnit;
        }

        public String getCommCode() {
            return commCode;
        }

        public void setCommCode(String commCode) {
            this.commCode = commCode;
        }

        public String getCommName() {
            return commName;
        }

        public void setCommName(String commName) {
            this.commName = commName;
        }

        public boolean isCommValid() {
            return commValid;
        }

        public void setCommValid(boolean commValid) {
            this.commValid = commValid;
        }

        public String getContCode() {
            return contCode;
        }

        public void setContCode(String contCode) {
            this.contCode = contCode;
        }

        public String getContName() {
            return contName;
        }

        public void setContName(String contName) {
            this.contName = contName;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getDiscountDesp() {
            return discountDesp;
        }

        public void setDiscountDesp(String discountDesp) {
            this.discountDesp = discountDesp;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public double getExgRate() {
            return exgRate;
        }

        public void setExgRate(double exgRate) {
            this.exgRate = exgRate;
        }

        public boolean isIsForeign() {
            return isForeign;
        }

        public void setIsForeign(boolean isForeign) {
            this.isForeign = isForeign;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public double getPriceChange() {
            return priceChange;
        }

        public void setPriceChange(double priceChange) {
            this.priceChange = priceChange;
        }

        public int getPriceDigit() {
            return priceDigit;
        }

        public void setPriceDigit(int priceDigit) {
            this.priceDigit = priceDigit;
        }

        public double getPriceUnit() {
            return priceUnit;
        }

        public void setPriceUnit(double priceUnit) {
            this.priceUnit = priceUnit;
        }

        public boolean isRange() {
            return range;
        }

        public void setRange(boolean range) {
            this.range = range;
        }

        public boolean isSigned() {
            return signed;
        }

        public void setSigned(boolean signed) {
            this.signed = signed;
        }

        public int getSpread() {
            return spread;
        }

        public void setSpread(int spread) {
            this.spread = spread;
        }

        public int getStopPlCur() {
            return stopPlCur;
        }

        public void setStopPlCur(int stopPlCur) {
            this.stopPlCur = stopPlCur;
        }

        public int getStopPlShow() {
            return stopPlShow;
        }

        public void setStopPlShow(int stopPlShow) {
            this.stopPlShow = stopPlShow;
        }

        public int getVolumeCur() {
            return volumeCur;
        }

        public void setVolumeCur(int volumeCur) {
            this.volumeCur = volumeCur;
        }

        public int getVolumeShow() {
            return volumeShow;
        }

        public void setVolumeShow(int volumeShow) {
            this.volumeShow = volumeShow;
        }

        public List<Integer> getChargeUnitList() {
            return chargeUnitList;
        }

        public void setChargeUnitList(List<Integer> chargeUnitList) {
            this.chargeUnitList = chargeUnitList;
        }

        public List<Long> getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(List<Long> closeTime) {
            this.closeTime = closeTime;
        }

        public List<Integer> getDepositList() {
            return depositList;
        }

        public void setDepositList(List<Integer> depositList) {
            this.depositList = depositList;
        }

        public List<Integer> getMoneyTypeList() {
            return moneyTypeList;
        }

        public void setMoneyTypeList(List<Integer> moneyTypeList) {
            this.moneyTypeList = moneyTypeList;
        }

        public List<Integer> getStopLossList() {
            return stopLossList;
        }

        public void setStopLossList(List<Integer> stopLossList) {
            this.stopLossList = stopLossList;
        }

        public List<Integer> getStopProfitList() {
            return stopProfitList;
        }

        public void setStopProfitList(List<Integer> stopProfitList) {
            this.stopProfitList = stopProfitList;
        }

        public List<Integer> getVolumeList() {
            return volumeList;
        }

        public void setVolumeList(List<Integer> volumeList) {
            this.volumeList = volumeList;
        }
    }
}

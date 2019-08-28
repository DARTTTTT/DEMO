package com.ltqh.qh.operation.entity;

import java.util.List;

public class OwithdrawEntity {



    private boolean identityAuth;
    private UserBean user;
    private AssetBean asset;
    private String cardJson;
    private int supportBank;
    private int supportAlipay;
    private String realname;
    private Object alipayNo;
    private int code;
    private String resultMsg;
    private List<BankCardsBean> bankCards;

    @Override
    public String toString() {
        return "OwithdrawEntity{" +
                "identityAuth=" + identityAuth +
                ", user=" + user +
                ", asset=" + asset +
                ", cardJson='" + cardJson + '\'' +
                ", supportBank=" + supportBank +
                ", supportAlipay=" + supportAlipay +
                ", realname='" + realname + '\'' +
                ", alipayNo=" + alipayNo +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", bankCards=" + bankCards +
                '}';
    }

    public boolean isIdentityAuth() {
        return identityAuth;
    }

    public void setIdentityAuth(boolean identityAuth) {
        this.identityAuth = identityAuth;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public AssetBean getAsset() {
        return asset;
    }

    public void setAsset(AssetBean asset) {
        this.asset = asset;
    }

    public String getCardJson() {
        return cardJson;
    }

    public void setCardJson(String cardJson) {
        this.cardJson = cardJson;
    }

    public int getSupportBank() {
        return supportBank;
    }

    public void setSupportBank(int supportBank) {
        this.supportBank = supportBank;
    }

    public int getSupportAlipay() {
        return supportAlipay;
    }

    public void setSupportAlipay(int supportAlipay) {
        this.supportAlipay = supportAlipay;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Object getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(Object alipayNo) {
        this.alipayNo = alipayNo;
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

    public List<BankCardsBean> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCardsBean> bankCards) {
        this.bankCards = bankCards;
    }

    public static class UserBean {
        /**
         * accStatus : 1
         * avatar :
         * brand : LT
         * id : 1027884
         * loginEmail :
         * loginError : 0
         * loginFail : 20
         * loginFrozen : {"date":25,"day":2,"hours":15,"minutes":27,"month":5,"seconds":1,"time":1561447621197,"timezoneOffset":-480,"year":119}
         * loginIp : 116.93.90.182
         * loginMobile : 18989898989
         * loginSucceed : 218
         * loginTime : {"date":26,"day":3,"hours":14,"minutes":53,"month":5,"seconds":30,"time":1561532010250,"timezoneOffset":-480,"year":119}
         * openId :
         * openType : 0
         * password : 200820e3227815ed1756a6b531e7e0d2
         * registerIp : 116.93.90.182
         * registerTime : {"date":22,"day":3,"hours":18,"minutes":35,"month":4,"seconds":45,"time":1558521345913,"timezoneOffset":-480,"year":119}
         * source :
         * sourceKw :
         * sourceKwg :
         * sourceKwp :
         * sourceUrl :
         * superiorId : 0
         * superiorLayer :
         * terminal : H5
         * type : 1
         * username : 用户7177670
         * visitCount : 0
         * visitPage :
         * visitTime : {"date":22,"day":3,"hours":18,"minutes":35,"month":4,"seconds":45,"time":1558521345913,"timezoneOffset":-480,"year":119}
         * withdrawPw : 46f94c8de14fb36680850768ff1b7f2a
         */

        private int accStatus;
        private String avatar;
        private String brand;
        private int id;
        private String loginEmail;
        private int loginError;
        private int loginFail;
        private LoginFrozenBean loginFrozen;
        private String loginIp;
        private String loginMobile;
        private int loginSucceed;
        private LoginTimeBean loginTime;
        private String openId;
        private int openType;
        private String password;
        private String registerIp;
        private RegisterTimeBean registerTime;
        private String source;
        private String sourceKw;
        private String sourceKwg;
        private String sourceKwp;
        private String sourceUrl;
        private int superiorId;
        private String superiorLayer;
        private String terminal;
        private int type;
        private String username;
        private int visitCount;
        private String visitPage;
        private VisitTimeBean visitTime;
        private String withdrawPw;

        @Override
        public String toString() {
            return "UserBean{" +
                    "accStatus=" + accStatus +
                    ", avatar='" + avatar + '\'' +
                    ", brand='" + brand + '\'' +
                    ", id=" + id +
                    ", loginEmail='" + loginEmail + '\'' +
                    ", loginError=" + loginError +
                    ", loginFail=" + loginFail +
                    ", loginFrozen=" + loginFrozen +
                    ", loginIp='" + loginIp + '\'' +
                    ", loginMobile='" + loginMobile + '\'' +
                    ", loginSucceed=" + loginSucceed +
                    ", loginTime=" + loginTime +
                    ", openId='" + openId + '\'' +
                    ", openType=" + openType +
                    ", password='" + password + '\'' +
                    ", registerIp='" + registerIp + '\'' +
                    ", registerTime=" + registerTime +
                    ", source='" + source + '\'' +
                    ", sourceKw='" + sourceKw + '\'' +
                    ", sourceKwg='" + sourceKwg + '\'' +
                    ", sourceKwp='" + sourceKwp + '\'' +
                    ", sourceUrl='" + sourceUrl + '\'' +
                    ", superiorId=" + superiorId +
                    ", superiorLayer='" + superiorLayer + '\'' +
                    ", terminal='" + terminal + '\'' +
                    ", type=" + type +
                    ", username='" + username + '\'' +
                    ", visitCount=" + visitCount +
                    ", visitPage='" + visitPage + '\'' +
                    ", visitTime=" + visitTime +
                    ", withdrawPw='" + withdrawPw + '\'' +
                    '}';
        }

        public int getAccStatus() {
            return accStatus;
        }

        public void setAccStatus(int accStatus) {
            this.accStatus = accStatus;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLoginEmail() {
            return loginEmail;
        }

        public void setLoginEmail(String loginEmail) {
            this.loginEmail = loginEmail;
        }

        public int getLoginError() {
            return loginError;
        }

        public void setLoginError(int loginError) {
            this.loginError = loginError;
        }

        public int getLoginFail() {
            return loginFail;
        }

        public void setLoginFail(int loginFail) {
            this.loginFail = loginFail;
        }

        public LoginFrozenBean getLoginFrozen() {
            return loginFrozen;
        }

        public void setLoginFrozen(LoginFrozenBean loginFrozen) {
            this.loginFrozen = loginFrozen;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getLoginMobile() {
            return loginMobile;
        }

        public void setLoginMobile(String loginMobile) {
            this.loginMobile = loginMobile;
        }

        public int getLoginSucceed() {
            return loginSucceed;
        }

        public void setLoginSucceed(int loginSucceed) {
            this.loginSucceed = loginSucceed;
        }

        public LoginTimeBean getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(LoginTimeBean loginTime) {
            this.loginTime = loginTime;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public int getOpenType() {
            return openType;
        }

        public void setOpenType(int openType) {
            this.openType = openType;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRegisterIp() {
            return registerIp;
        }

        public void setRegisterIp(String registerIp) {
            this.registerIp = registerIp;
        }

        public RegisterTimeBean getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(RegisterTimeBean registerTime) {
            this.registerTime = registerTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSourceKw() {
            return sourceKw;
        }

        public void setSourceKw(String sourceKw) {
            this.sourceKw = sourceKw;
        }

        public String getSourceKwg() {
            return sourceKwg;
        }

        public void setSourceKwg(String sourceKwg) {
            this.sourceKwg = sourceKwg;
        }

        public String getSourceKwp() {
            return sourceKwp;
        }

        public void setSourceKwp(String sourceKwp) {
            this.sourceKwp = sourceKwp;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

        public int getSuperiorId() {
            return superiorId;
        }

        public void setSuperiorId(int superiorId) {
            this.superiorId = superiorId;
        }

        public String getSuperiorLayer() {
            return superiorLayer;
        }

        public void setSuperiorLayer(String superiorLayer) {
            this.superiorLayer = superiorLayer;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(int visitCount) {
            this.visitCount = visitCount;
        }

        public String getVisitPage() {
            return visitPage;
        }

        public void setVisitPage(String visitPage) {
            this.visitPage = visitPage;
        }

        public VisitTimeBean getVisitTime() {
            return visitTime;
        }

        public void setVisitTime(VisitTimeBean visitTime) {
            this.visitTime = visitTime;
        }

        public String getWithdrawPw() {
            return withdrawPw;
        }

        public void setWithdrawPw(String withdrawPw) {
            this.withdrawPw = withdrawPw;
        }

        public static class LoginFrozenBean {
            @Override
            public String toString() {
                return "LoginFrozenBean{" +
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
             * hours : 15
             * minutes : 27
             * month : 5
             * seconds : 1
             * time : 1561447621197
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

        public static class LoginTimeBean {
            /**
             * date : 26
             * day : 3
             * hours : 14
             * minutes : 53
             * month : 5
             * seconds : 30
             * time : 1561532010250
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

        public static class RegisterTimeBean {
            @Override
            public String toString() {
                return "RegisterTimeBean{" +
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
             * date : 22
             * day : 3
             * hours : 18
             * minutes : 35
             * month : 4
             * seconds : 45
             * time : 1558521345913
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
             * date : 22
             * day : 3
             * hours : 18
             * minutes : 35
             * month : 4
             * seconds : 45
             * time : 1558521345913
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
         * game : 57670
         * money : 18
         * signString : 1027884`18.0000`0.0000`0.0000
         * userId : 1027884
         */



        private int comm;
        private int commApply;
        private int commExchange;
        private String dataMD5;
        private String discount;
        private double eagle;
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

        public double getEagle() {
            return eagle;
        }

        public void setEagle(double eagle) {
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

    public static class BankCardsBean {
        /**
         * bank : 工商银行
         * card : 11111111111 **** 1126
         * id : 146891
         */

        private String bank;
        private String card;
        private String id;

        @Override
        public String toString() {
            return "BankCardsBean{" +
                    "bank='" + bank + '\'' +
                    ", card='" + card + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

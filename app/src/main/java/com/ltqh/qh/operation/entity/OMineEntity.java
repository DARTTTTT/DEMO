package com.ltqh.qh.operation.entity;

import android.util.Log;

import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.utils.SPUtils;

import java.io.Serializable;

public class OMineEntity implements Serializable {

    private static OMineEntity instance;

    public static OMineEntity getInstance() {
        if (instance == null) {
            instance = new OMineEntity();
        }
        return instance;
    }

    public static OMineEntity getMine() {
        OMineEntity data = SPUtils.getData(OUserConfig.USER, OMineEntity.class);
        return data;
    }

    public boolean isMineLogin() {
        return OMineEntity.getMine() != null;
    }


    private boolean usernameChanged;
    private int unread;
    private int msgCount;
    private UnionBean union;
    private double eagleRatio;
    private AssetBean asset;
    private UserBean user;
    private boolean isVip;
    private String hello;
    private int code;
    private String resultMsg;

    @Override
    public String toString() {
        return "OMineEntity{" +
                "usernameChanged=" + usernameChanged +
                ", unread=" + unread +
                ", msgCount=" + msgCount +
                ", union=" + union +
                ", eagleRatio=" + eagleRatio +
                ", asset=" + asset +
                ", user=" + user +
                ", isVip=" + isVip +
                ", hello='" + hello + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public boolean isUsernameChanged() {
        return usernameChanged;
    }

    public void setUsernameChanged(boolean usernameChanged) {
        this.usernameChanged = usernameChanged;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public UnionBean getUnion() {
        return union;
    }

    public void setUnion(UnionBean union) {
        this.union = union;
    }

    public double getEagleRatio() {
        return eagleRatio;
    }

    public void setEagleRatio(double eagleRatio) {
        this.eagleRatio = eagleRatio;
    }

    public AssetBean getAsset() {
        return asset;
    }

    public void setAsset(AssetBean asset) {
        this.asset = asset;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
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

    public static class UnionBean implements Serializable {
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
         * userId : 1061581
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

        public static class VisitTimeBean implements Serializable {
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

    public static class AssetBean implements Serializable {
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
         * dataMD5 : 36a00635fde33bfb4111aab7bcab32dc
         * discount :
         * eagle : 150
         * fundIn : 0
         * fundOut : 0
         * game : 100000
         * money : 18
         * signString : 1061581`18.0000`0.0000`0.0000
         * userId : 1061581
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

    public static class UserBean implements Serializable {
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

        /**
         * accStatus : 1
         * avatar :
         * brand : FK
         * id : 1061581
         * loginEmail :
         * loginError : 0
         * loginFail : 0
         * loginFrozen : {"date":1,"day":4,"hours":8,"minutes":0,"month":0,"seconds":0,"time":0,"timezoneOffset":-480,"year":70}
         * loginIp : 10.28.74.225
         * loginMobile : 15655665566
         * loginSucceed : 9
         * loginTime : {"date":22,"day":3,"hours":10,"minutes":7,"month":4,"seconds":24,"time":1558490844580,"timezoneOffset":-480,"year":119}
         * openId :
         * openType : 0
         * password : aeb0f28887b82a90a105351454153522
         * registerIp : 10.28.74.225
         * registerTime : {"date":22,"day":3,"hours":9,"minutes":41,"month":4,"seconds":26,"time":1558489286263,"timezoneOffset":-480,"year":119}
         * source :
         * sourceKw :
         * sourceKwg :
         * sourceKwp :
         * sourceUrl :
         * superiorId : 0
         * superiorLayer :
         * terminal : H5
         * type : 1
         * username : 用户4591710
         * visitCount : 0
         * visitPage :
         * visitTime : {"date":22,"day":3,"hours":9,"minutes":41,"month":4,"seconds":26,"time":1558489286263,"timezoneOffset":-480,"year":119}
         * withdrawPw :
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
        private VisitTimeBeanX visitTime;
        private String withdrawPw;

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

        public VisitTimeBeanX getVisitTime() {
            return visitTime;
        }

        public void setVisitTime(VisitTimeBeanX visitTime) {
            this.visitTime = visitTime;
        }

        public String getWithdrawPw() {
            return withdrawPw;
        }

        public void setWithdrawPw(String withdrawPw) {
            this.withdrawPw = withdrawPw;
        }

        public static class LoginFrozenBean implements Serializable {
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

        public static class LoginTimeBean implements Serializable {
            @Override
            public String toString() {
                return "LoginTimeBean{" +
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
             * hours : 10
             * minutes : 7
             * month : 4
             * seconds : 24
             * time : 1558490844580
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

        public static class RegisterTimeBean implements Serializable {
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
             * hours : 9
             * minutes : 41
             * month : 4
             * seconds : 26
             * time : 1558489286263
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

        public static class VisitTimeBeanX implements Serializable {
            @Override
            public String toString() {
                return "VisitTimeBeanX{" +
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
             * hours : 9
             * minutes : 41
             * month : 4
             * seconds : 26
             * time : 1558489286263
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

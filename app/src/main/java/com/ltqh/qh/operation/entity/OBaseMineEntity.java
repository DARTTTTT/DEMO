package com.ltqh.qh.operation.entity;

import java.io.Serializable;

public class OBaseMineEntity implements Serializable {


    /**
     * level : 2
     * bankCardCount : 0
     * user : {"accStatus":1,"avatar":"","brand":"FK","id":1061581,"loginEmail":"","loginError":0,"loginFail":2,"loginFrozen":{"date":22,"day":3,"hours":17,"minutes":31,"month":4,"seconds":3,"time":1558517463557,"timezoneOffset":-480,"year":119},"loginIp":"10.28.74.225","loginMobile":"15655665566","loginSucceed":36,"loginTime":{"date":22,"day":3,"hours":17,"minutes":35,"month":4,"seconds":8,"time":1558517708027,"timezoneOffset":-480,"year":119},"openId":"","openType":0,"password":"aeb0f28887b82a90a105351454153522","registerIp":"10.28.74.225","registerTime":{"date":22,"day":3,"hours":9,"minutes":41,"month":4,"seconds":26,"time":1558489286263,"timezoneOffset":-480,"year":119},"source":"","sourceKw":"","sourceKwg":"","sourceKwp":"","sourceUrl":"","superiorId":0,"superiorLayer":"","terminal":"H5","type":1,"username":"用户4591710","visitCount":0,"visitPage":"","visitTime":{"date":22,"day":3,"hours":9,"minutes":41,"month":4,"seconds":26,"time":1558489286263,"timezoneOffset":-480,"year":119},"withdrawPw":""}
     * info : {"alipay":"","birthday":0,"category":0,"email":"","huawei":-1,"identityNumber":"","identityNumberValid":false,"identityPhoto":"","identityPhotoValid":false,"identityType":1,"lottery":1,"mobile":"15655665566","name":"","nameChanged":0,"nameValid":-1,"remark":"","sex":0,"signed":"","userId":1061581,"uuid":"","withdrawCountDay":2,"withdrawLimit":0,"zhima":-1}
     * code : 200
     * resultMsg :
     */

    private int level;
    private int bankCardCount;
    private UserBean user;
    private InfoBean info;
    private int code;
    private String resultMsg;

    @Override
    public String toString() {
        return "OBaseMineEntity{" +
                "level=" + level +
                ", bankCardCount=" + bankCardCount +
                ", user=" + user +
                ", info=" + info +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBankCardCount() {
        return bankCardCount;
    }

    public void setBankCardCount(int bankCardCount) {
        this.bankCardCount = bankCardCount;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
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
         * loginFail : 2
         * loginFrozen : {"date":22,"day":3,"hours":17,"minutes":31,"month":4,"seconds":3,"time":1558517463557,"timezoneOffset":-480,"year":119}
         * loginIp : 10.28.74.225
         * loginMobile : 15655665566
         * loginSucceed : 36
         * loginTime : {"date":22,"day":3,"hours":17,"minutes":35,"month":4,"seconds":8,"time":1558517708027,"timezoneOffset":-480,"year":119}
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
        private VisitTimeBean visitTime;
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

        public static class LoginFrozenBean implements  Serializable{
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
             * date : 22
             * day : 3
             * hours : 17
             * minutes : 31
             * month : 4
             * seconds : 3
             * time : 1558517463557
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

        public static class LoginTimeBean implements Serializable{
            /**
             * date : 22
             * day : 3
             * hours : 17
             * minutes : 35
             * month : 4
             * seconds : 8
             * time : 1558517708027
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

        public static class RegisterTimeBean implements Serializable{
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

        public static class VisitTimeBean implements  Serializable{
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

    public static class InfoBean implements Serializable{
        /**
         * alipay :
         * birthday : 0
         * category : 0
         * email :
         * huawei : -1
         * identityNumber :
         * identityNumberValid : false
         * identityPhoto :
         * identityPhotoValid : false
         * identityType : 1
         * lottery : 1
         * mobile : 15655665566
         * name :
         * nameChanged : 0
         * nameValid : -1
         * remark :
         * sex : 0
         * signed :
         * userId : 1061581
         * uuid :
         * withdrawCountDay : 2
         * withdrawLimit : 0
         * zhima : -1
         */

        private String alipay;
        private int birthday;
        private int category;
        private String email;
        private int huawei;
        private String identityNumber;
        private boolean identityNumberValid;
        private String identityPhoto;
        private boolean identityPhotoValid;
        private int identityType;
        private int lottery;
        private String mobile;
        private String name;
        private int nameChanged;
        private int nameValid;
        private String remark;
        private int sex;
        private String signed;
        private int userId;
        private String uuid;
        private int withdrawCountDay;
        private int withdrawLimit;
        private int zhima;

        @Override
        public String toString() {
            return "InfoBean{" +
                    "alipay='" + alipay + '\'' +
                    ", birthday=" + birthday +
                    ", category=" + category +
                    ", email='" + email + '\'' +
                    ", huawei=" + huawei +
                    ", identityNumber='" + identityNumber + '\'' +
                    ", identityNumberValid=" + identityNumberValid +
                    ", identityPhoto='" + identityPhoto + '\'' +
                    ", identityPhotoValid=" + identityPhotoValid +
                    ", identityType=" + identityType +
                    ", lottery=" + lottery +
                    ", mobile='" + mobile + '\'' +
                    ", name='" + name + '\'' +
                    ", nameChanged=" + nameChanged +
                    ", nameValid=" + nameValid +
                    ", remark='" + remark + '\'' +
                    ", sex=" + sex +
                    ", signed='" + signed + '\'' +
                    ", userId=" + userId +
                    ", uuid='" + uuid + '\'' +
                    ", withdrawCountDay=" + withdrawCountDay +
                    ", withdrawLimit=" + withdrawLimit +
                    ", zhima=" + zhima +
                    '}';
        }

        public String getAlipay() {
            return alipay;
        }

        public void setAlipay(String alipay) {
            this.alipay = alipay;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getHuawei() {
            return huawei;
        }

        public void setHuawei(int huawei) {
            this.huawei = huawei;
        }

        public String getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
        }

        public boolean isIdentityNumberValid() {
            return identityNumberValid;
        }

        public void setIdentityNumberValid(boolean identityNumberValid) {
            this.identityNumberValid = identityNumberValid;
        }

        public String getIdentityPhoto() {
            return identityPhoto;
        }

        public void setIdentityPhoto(String identityPhoto) {
            this.identityPhoto = identityPhoto;
        }

        public boolean isIdentityPhotoValid() {
            return identityPhotoValid;
        }

        public void setIdentityPhotoValid(boolean identityPhotoValid) {
            this.identityPhotoValid = identityPhotoValid;
        }

        public int getIdentityType() {
            return identityType;
        }

        public void setIdentityType(int identityType) {
            this.identityType = identityType;
        }

        public int getLottery() {
            return lottery;
        }

        public void setLottery(int lottery) {
            this.lottery = lottery;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNameChanged() {
            return nameChanged;
        }

        public void setNameChanged(int nameChanged) {
            this.nameChanged = nameChanged;
        }

        public int getNameValid() {
            return nameValid;
        }

        public void setNameValid(int nameValid) {
            this.nameValid = nameValid;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSigned() {
            return signed;
        }

        public void setSigned(String signed) {
            this.signed = signed;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public int getWithdrawCountDay() {
            return withdrawCountDay;
        }

        public void setWithdrawCountDay(int withdrawCountDay) {
            this.withdrawCountDay = withdrawCountDay;
        }

        public int getWithdrawLimit() {
            return withdrawLimit;
        }

        public void setWithdrawLimit(int withdrawLimit) {
            this.withdrawLimit = withdrawLimit;
        }

        public int getZhima() {
            return zhima;
        }

        public void setZhima(int zhima) {
            this.zhima = zhima;
        }
    }
}

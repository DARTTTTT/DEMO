package com.ltqh.qh.operation.entity;

import java.util.List;

public class OBankListEntity {


    @Override
    public String toString() {
        return "OBankListEntity{" +
                "info=" + info +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", bankCards=" + bankCards +
                '}';
    }

    /**
     * info : {"alipay":"","birthday":0,"category":0,"email":"","huawei":0,"identityNumber":"130821196708161515","identityNumberValid":true,"identityPhoto":"","identityPhotoValid":false,"identityType":1,"lottery":1,"mobile":"15510401132","name":"孙瑞刚","nameChanged":0,"nameValid":1,"remark":"","sex":0,"signed":"","userId":923421,"uuid":"","withdrawCountDay":2,"withdrawLimit":0,"zhima":-1}
     * bankCards : [{"bank":"民生银行","brand":"LT","cardNumber":"6226220132701003","city":"110100","defaultCard":0,"id":83162,"mobile":"","province":"110000","subbranch":"","userId":923421}]
     * code : 200
     * resultMsg :
     */

    private InfoBean info;
    private int code;
    private String resultMsg;
    private List<BankCardsBean> bankCards;

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

    public List<BankCardsBean> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCardsBean> bankCards) {
        this.bankCards = bankCards;
    }

    public static class InfoBean {
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

        /**
         * alipay :
         * birthday : 0
         * category : 0
         * email :
         * huawei : 0
         * identityNumber : 130821196708161515
         * identityNumberValid : true
         * identityPhoto :
         * identityPhotoValid : false
         * identityType : 1
         * lottery : 1
         * mobile : 15510401132
         * name : 孙瑞刚
         * nameChanged : 0
         * nameValid : 1
         * remark :
         * sex : 0
         * signed :
         * userId : 923421
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

    public static class BankCardsBean {
        /**
         * bank : 民生银行
         * brand : LT
         * cardNumber : 6226220132701003
         * city : 110100
         * defaultCard : 0
         * id : 83162
         * mobile :
         * province : 110000
         * subbranch :
         * userId : 923421
         */

        private String bank;
        private String brand;
        private String cardNumber;
        private String city;
        private int defaultCard;
        private int id;
        private String mobile;
        private String province;
        private String subbranch;
        private int userId;

        @Override
        public String toString() {
            return "BankCardsBean{" +
                    "bank='" + bank + '\'' +
                    ", brand='" + brand + '\'' +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", city='" + city + '\'' +
                    ", defaultCard=" + defaultCard +
                    ", id=" + id +
                    ", mobile='" + mobile + '\'' +
                    ", province='" + province + '\'' +
                    ", subbranch='" + subbranch + '\'' +
                    ", userId=" + userId +
                    '}';
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getDefaultCard() {
            return defaultCard;
        }

        public void setDefaultCard(int defaultCard) {
            this.defaultCard = defaultCard;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSubbranch() {
            return subbranch;
        }

        public void setSubbranch(String subbranch) {
            this.subbranch = subbranch;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}

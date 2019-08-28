package com.ltqh.qh.entity;

import java.io.Serializable;

public class UserInfoEntity implements Serializable{


    /**
     * code : 1
     * msg : 获取成功！
     * data : {"user_type":2,"user_login":"","mobile":"13207704405","user_email":"","user_nickname":"","avatar":"","signature":"","user_url":"","sex":0,"birthday":0,"score":0,"coin":0,"user_status":1,"user_activation_key":"","create_time":1545015229,"last_login_time":0,"last_login_ip":""}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        @Override
        public String toString() {
            return "DataBean{" +
                    "user_type=" + user_type +
                    ", user_login='" + user_login + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", user_email='" + user_email + '\'' +
                    ", user_nickname='" + user_nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", signature='" + signature + '\'' +
                    ", user_url='" + user_url + '\'' +
                    ", sex=" + sex +
                    ", birthday=" + birthday +
                    ", score=" + score +
                    ", coin=" + coin +
                    ", user_status=" + user_status +
                    ", user_activation_key='" + user_activation_key + '\'' +
                    ", create_time=" + create_time +
                    ", last_login_time=" + last_login_time +
                    ", last_login_ip='" + last_login_ip + '\'' +
                    '}';
        }

        /**
         * user_type : 2
         * user_login :
         * mobile : 13207704405
         * user_email :
         * user_nickname :
         * avatar :
         * signature :
         * user_url :
         * sex : 0
         * birthday : 0
         * score : 0
         * coin : 0
         * user_status : 1
         * user_activation_key :
         * create_time : 1545015229
         * last_login_time : 0
         * last_login_ip :
         */


        private int user_type;
        private String user_login;
        private String mobile;
        private String user_email;
        private String user_nickname;
        private String avatar;
        private String signature;
        private String user_url;
        private int sex;
        private int birthday;
        private int score;
        private int coin;
        private int user_status;
        private String user_activation_key;
        private int create_time;
        private int last_login_time;
        private String last_login_ip;

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public String getUser_login() {
            return user_login;
        }

        public void setUser_login(String user_login) {
            this.user_login = user_login;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getUser_url() {
            return user_url;
        }

        public void setUser_url(String user_url) {
            this.user_url = user_url;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getUser_status() {
            return user_status;
        }

        public void setUser_status(int user_status) {
            this.user_status = user_status;
        }

        public String getUser_activation_key() {
            return user_activation_key;
        }

        public void setUser_activation_key(String user_activation_key) {
            this.user_activation_key = user_activation_key;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(int last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getLast_login_ip() {
            return last_login_ip;
        }

        public void setLast_login_ip(String last_login_ip) {
            this.last_login_ip = last_login_ip;
        }
    }
}

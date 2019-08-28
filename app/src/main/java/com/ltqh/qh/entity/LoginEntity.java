package com.ltqh.qh.entity;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ltqh.qh.config.UserConfig;
import com.ltqh.qh.utils.SPUtils;

import java.io.Serializable;

public class LoginEntity implements Serializable {
    private static LoginEntity instance;

    public static LoginEntity getInstance() {
        if (instance == null) {
            instance = new LoginEntity();
        }
        return instance;
    }

    public static LoginEntity getUser() {
        LoginEntity data = SPUtils.getData(UserConfig.LOGIN_USER, LoginEntity.class);
        return data;
    }

    public boolean isLogin() {
        return LoginEntity.getUser() != null;
    }

    /**
     * code : 1
     * msg : 登录成功!
     * data : {"token":"7662bb23f5e63c3ab096c197493fa7e8dfe8280c84413ccfef1b769bc0a3d59c","user":{"id":46,"user_type":2,"sex":0,"birthday":0,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1544756318,"user_status":1,"user_login":"","user_pass":"###3cb35fb2134f40f807e26c61e5779130","user_nickname":"","user_email":"","user_url":"","avatar":"","signature":"","last_login_ip":"","user_activation_key":"","mobile":"13296457715","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "LoginEntity{" +
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

    public static class DataBean implements Serializable {
        /**
         * token : 7662bb23f5e63c3ab096c197493fa7e8dfe8280c84413ccfef1b769bc0a3d59c
         * user : {"id":46,"user_type":2,"sex":0,"birthday":0,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1544756318,"user_status":1,"user_login":"","user_pass":"###3cb35fb2134f40f807e26c61e5779130","user_nickname":"","user_email":"","user_url":"","avatar":"","signature":"","last_login_ip":"","user_activation_key":"","mobile":"13296457715","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}
         */

        private String token;
        private UserBean user;

        @Override
        public String toString() {
            return "DataBean{" +
                    "token='" + token + '\'' +
                    ", user=" + user +
                    '}';
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean implements Serializable {
            /**
             * id : 46
             * user_type : 2
             * sex : 0
             * birthday : 0
             * last_login_time : 0
             * score : 0
             * coin : 0
             * balance : 0.00
             * create_time : 1544756318
             * user_status : 1
             * user_login :
             * user_pass : ###3cb35fb2134f40f807e26c61e5779130
             * user_nickname :
             * user_email :
             * user_url :
             * avatar :
             * signature :
             * last_login_ip :
             * user_activation_key :
             * mobile : 13296457715
             * more : null
             * app :
             * lc_id : null
             * lc_key : null
             * lc_url : null
             */

            private int id;
            private int user_type;
            private int sex;
            private int birthday;
            private int last_login_time;
            private int score;
            private int coin;
            private String balance;
            private int create_time;
            private int user_status;
            private String user_login;
            private String user_pass;
            private String user_nickname;
            private String user_email;
            private String user_url;
            private String avatar;
            private String signature;
            private String last_login_ip;
            private String user_activation_key;
            private String mobile;
            private Object more;
            private String app;
            private Object lc_id;
            private Object lc_key;
            private Object lc_url;

            @Override
            public String toString() {
                return "UserBean{" +
                        "id=" + id +
                        ", user_type=" + user_type +
                        ", sex=" + sex +
                        ", birthday=" + birthday +
                        ", last_login_time=" + last_login_time +
                        ", score=" + score +
                        ", coin=" + coin +
                        ", balance='" + balance + '\'' +
                        ", create_time=" + create_time +
                        ", user_status=" + user_status +
                        ", user_login='" + user_login + '\'' +
                        ", user_pass='" + user_pass + '\'' +
                        ", user_nickname='" + user_nickname + '\'' +
                        ", user_email='" + user_email + '\'' +
                        ", user_url='" + user_url + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", signature='" + signature + '\'' +
                        ", last_login_ip='" + last_login_ip + '\'' +
                        ", user_activation_key='" + user_activation_key + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", more=" + more +
                        ", app='" + app + '\'' +
                        ", lc_id=" + lc_id +
                        ", lc_key=" + lc_key +
                        ", lc_url=" + lc_url +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_type() {
                return user_type;
            }

            public void setUser_type(int user_type) {
                this.user_type = user_type;
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

            public int getLast_login_time() {
                return last_login_time;
            }

            public void setLast_login_time(int last_login_time) {
                this.last_login_time = last_login_time;
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

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getUser_status() {
                return user_status;
            }

            public void setUser_status(int user_status) {
                this.user_status = user_status;
            }

            public String getUser_login() {
                return user_login;
            }

            public void setUser_login(String user_login) {
                this.user_login = user_login;
            }

            public String getUser_pass() {
                return user_pass;
            }

            public void setUser_pass(String user_pass) {
                this.user_pass = user_pass;
            }

            public String getUser_nickname() {
                return user_nickname;
            }

            public void setUser_nickname(String user_nickname) {
                this.user_nickname = user_nickname;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public String getUser_url() {
                return user_url;
            }

            public void setUser_url(String user_url) {
                this.user_url = user_url;
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

            public String getLast_login_ip() {
                return last_login_ip;
            }

            public void setLast_login_ip(String last_login_ip) {
                this.last_login_ip = last_login_ip;
            }

            public String getUser_activation_key() {
                return user_activation_key;
            }

            public void setUser_activation_key(String user_activation_key) {
                this.user_activation_key = user_activation_key;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public Object getMore() {
                return more;
            }

            public void setMore(Object more) {
                this.more = more;
            }

            public String getApp() {
                return app;
            }

            public void setApp(String app) {
                this.app = app;
            }

            public Object getLc_id() {
                return lc_id;
            }

            public void setLc_id(Object lc_id) {
                this.lc_id = lc_id;
            }

            public Object getLc_key() {
                return lc_key;
            }

            public void setLc_key(Object lc_key) {
                this.lc_key = lc_key;
            }

            public Object getLc_url() {
                return lc_url;
            }

            public void setLc_url(Object lc_url) {
                this.lc_url = lc_url;
            }
        }
    }
}

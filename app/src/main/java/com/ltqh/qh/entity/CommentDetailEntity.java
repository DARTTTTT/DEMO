package com.ltqh.qh.entity;

import java.util.List;

public class CommentDetailEntity {


    /**
     * code : 1
     * msg : 评论获取成功!
     * data : [[{"id":111,"parent_id":0,"user_id":18,"to_user_id":20,"object_id":37,"like_count":0,"dislike_count":0,"floor":0,"create_time":1542598428,"delete_time":0,"status":1,"type":1,"table_name":"share_post","full_name":"小小S","email":"","path":"0,","url":"","content":"加油(ง \u2022̀_\u2022́)ง","more":null,"is_landlord":0,"user":{"id":18,"user_type":2,"sex":0,"birthday":1540742400,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539746266,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"小小S","user_email":"","user_url":"https://www.eolinker.com","avatar":"http://data.yingju8.com/upload/20181204/b7538e54e3033f5c8f47aee2f318b31f.jpg","signature":"开开心心又一天","last_login_ip":"","user_activation_key":"","mobile":"18609263478","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null},"to_user":{"id":20,"user_type":2,"sex":2,"birthday":0,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539841730,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"Blue lee","user_email":"","user_url":"","avatar":"http://data.yingju8.com/upload/20181101/1f8bd7d84897480ddbd688ce245054b6.png","signature":"KunFu","last_login_ip":"","user_activation_key":"","mobile":"15014228365","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}},{"id":112,"parent_id":0,"user_id":18,"to_user_id":20,"object_id":37,"like_count":0,"dislike_count":0,"floor":0,"create_time":1542598431,"delete_time":0,"status":1,"type":1,"table_name":"share_post","full_name":"小小S","email":"","path":"0,","url":"","content":"加油(ง \u2022̀_\u2022́)ง","more":null,"is_landlord":0,"user":{"id":18,"user_type":2,"sex":0,"birthday":1540742400,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539746266,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"小小S","user_email":"","user_url":"https://www.eolinker.com","avatar":"http://data.yingju8.com/upload/20181204/b7538e54e3033f5c8f47aee2f318b31f.jpg","signature":"开开心心又一天","last_login_ip":"","user_activation_key":"","mobile":"18609263478","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null},"to_user":{"id":20,"user_type":2,"sex":2,"birthday":0,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539841730,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"Blue lee","user_email":"","user_url":"","avatar":"http://data.yingju8.com/upload/20181101/1f8bd7d84897480ddbd688ce245054b6.png","signature":"KunFu","last_login_ip":"","user_activation_key":"","mobile":"15014228365","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}}]]
     */

    private int code;
    private String msg;
    private List<List<DataBean>> data;

    @Override
    public String toString() {
        return "CommentDetailEntity{" +
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

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", parent_id=" + parent_id +
                    ", user_id=" + user_id +
                    ", to_user_id=" + to_user_id +
                    ", object_id=" + object_id +
                    ", like_count=" + like_count +
                    ", dislike_count=" + dislike_count +
                    ", floor=" + floor +
                    ", create_time=" + create_time +
                    ", delete_time=" + delete_time +
                    ", status=" + status +
                    ", type=" + type +
                    ", table_name='" + table_name + '\'' +
                    ", full_name='" + full_name + '\'' +
                    ", email='" + email + '\'' +
                    ", path='" + path + '\'' +
                    ", url='" + url + '\'' +
                    ", content='" + content + '\'' +
                    ", more=" + more +
                    ", is_landlord=" + is_landlord +
                    ", user=" + user +
                    ", to_user=" + to_user +
                    '}';
        }

        /**
         * id : 111
         * parent_id : 0
         * user_id : 18
         * to_user_id : 20
         * object_id : 37
         * like_count : 0
         * dislike_count : 0
         * floor : 0
         * create_time : 1542598428
         * delete_time : 0
         * status : 1
         * type : 1
         * table_name : share_post
         * full_name : 小小S
         * email :
         * path : 0,
         * url :
         * content : 加油(ง •̀_•́)ง
         * more : null
         * is_landlord : 0
         * user : {"id":18,"user_type":2,"sex":0,"birthday":1540742400,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539746266,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"小小S","user_email":"","user_url":"https://www.eolinker.com","avatar":"http://data.yingju8.com/upload/20181204/b7538e54e3033f5c8f47aee2f318b31f.jpg","signature":"开开心心又一天","last_login_ip":"","user_activation_key":"","mobile":"18609263478","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}
         * to_user : {"id":20,"user_type":2,"sex":2,"birthday":0,"last_login_time":0,"score":0,"coin":0,"balance":"0.00","create_time":1539841730,"user_status":1,"user_login":"","user_pass":"###5a3bd207c6224613fe1f78202c48fcca","user_nickname":"Blue lee","user_email":"","user_url":"","avatar":"http://data.yingju8.com/upload/20181101/1f8bd7d84897480ddbd688ce245054b6.png","signature":"KunFu","last_login_ip":"","user_activation_key":"","mobile":"15014228365","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}
         */


        private int id;
        private int parent_id;
        private int user_id;
        private int to_user_id;
        private int object_id;
        private int like_count;
        private int dislike_count;
        private int floor;
        private int create_time;
        private int delete_time;
        private int status;
        private int type;
        private String table_name;
        private String full_name;
        private String email;
        private String path;
        private String url;
        private String content;
        private Object more;
        private int is_landlord;
        private UserBean user;
        private ToUserBean to_user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getTo_user_id() {
            return to_user_id;
        }

        public void setTo_user_id(int to_user_id) {
            this.to_user_id = to_user_id;
        }

        public int getObject_id() {
            return object_id;
        }

        public void setObject_id(int object_id) {
            this.object_id = object_id;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getDislike_count() {
            return dislike_count;
        }

        public void setDislike_count(int dislike_count) {
            this.dislike_count = dislike_count;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getDelete_time() {
            return delete_time;
        }

        public void setDelete_time(int delete_time) {
            this.delete_time = delete_time;
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

        public String getTable_name() {
            return table_name;
        }

        public void setTable_name(String table_name) {
            this.table_name = table_name;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getMore() {
            return more;
        }

        public void setMore(Object more) {
            this.more = more;
        }

        public int getIs_landlord() {
            return is_landlord;
        }

        public void setIs_landlord(int is_landlord) {
            this.is_landlord = is_landlord;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ToUserBean getTo_user() {
            return to_user;
        }

        public void setTo_user(ToUserBean to_user) {
            this.to_user = to_user;
        }

        public static class UserBean {
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

            /**
             * id : 18
             * user_type : 2
             * sex : 0
             * birthday : 1540742400
             * last_login_time : 0
             * score : 0
             * coin : 0
             * balance : 0.00
             * create_time : 1539746266
             * user_status : 1
             * user_login :
             * user_pass : ###5a3bd207c6224613fe1f78202c48fcca
             * user_nickname : 小小S
             * user_email :
             * user_url : https://www.eolinker.com
             * avatar : http://data.yingju8.com/upload/20181204/b7538e54e3033f5c8f47aee2f318b31f.jpg
             * signature : 开开心心又一天
             * last_login_ip :
             * user_activation_key :
             * mobile : 18609263478
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

        public static class ToUserBean {
            @Override
            public String toString() {
                return "ToUserBean{" +
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

            /**
             * id : 20
             * user_type : 2
             * sex : 2
             * birthday : 0
             * last_login_time : 0
             * score : 0
             * coin : 0
             * balance : 0.00
             * create_time : 1539841730
             * user_status : 1
             * user_login :
             * user_pass : ###5a3bd207c6224613fe1f78202c48fcca
             * user_nickname : Blue lee
             * user_email :
             * user_url :
             * avatar : http://data.yingju8.com/upload/20181101/1f8bd7d84897480ddbd688ce245054b6.png
             * signature : KunFu
             * last_login_ip :
             * user_activation_key :
             * mobile : 15014228365
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

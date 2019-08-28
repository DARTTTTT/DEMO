package com.ltqh.qh.entity;

import java.util.List;

public class MyMessageEntity {


    /**
     * code : 1
     * msg : 获取我评论的列表成功！
     * data : {"total":1,"per_page":"20","current_page":1,"last_page":1,"data":[{"id":185,"parent_id":0,"user_id":68,"to_user_id":68,"object_id":78,"like_count":0,"dislike_count":0,"floor":0,"create_time":1545817709,"delete_time":0,"status":1,"type":1,"table_name":"share_post","full_name":"股吧","email":"","path":"0,","url":"","content":"A股三大股指维持震荡沪指失守2500点 特高压板块掀涨停潮\n","more":null,"is_landlord":0,"share":{"id":78,"user_id":68,"post_status":1,"comment_status":1,"post_hits":2,"post_like":0,"comment_count":1,"update_time":0,"published_time":"12-26 17:47","post_title":"A股三大股指维持震荡沪指失守2500点 特高压板块掀","post_excerpt":"","post_content":"A股三大股指今日维持震荡，沪指失守2500点，收盘下跌0.26%，报2498.29点；深成指收跌0.58%，报7289.55点；创业板指收跌0.74%，报1264.07点；市场成交量低迷，两市合计成交2313亿元；行业板块涨跌互现，特高压板块掀涨停潮，逾10股封板，创投概念股尾盘表现活跃，5G概念股、券商等板块跌幅靠前。","post_content_filtered":null,"more":null,"share_id":22,"last_time":null,"favorite_count":0,"report_count":0,"report_status":0},"user":{"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null},"to_user":{"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

    @Override
    public String toString() {
        return "MyMessageEntity{" +
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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 1
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":185,"parent_id":0,"user_id":68,"to_user_id":68,"object_id":78,"like_count":0,"dislike_count":0,"floor":0,"create_time":1545817709,"delete_time":0,"status":1,"type":1,"table_name":"share_post","full_name":"股吧","email":"","path":"0,","url":"","content":"A股三大股指维持震荡沪指失守2500点 特高压板块掀涨停潮\n","more":null,"is_landlord":0,"share":{"id":78,"user_id":68,"post_status":1,"comment_status":1,"post_hits":2,"post_like":0,"comment_count":1,"update_time":0,"published_time":"12-26 17:47","post_title":"A股三大股指维持震荡沪指失守2500点 特高压板块掀","post_excerpt":"","post_content":"A股三大股指今日维持震荡，沪指失守2500点，收盘下跌0.26%，报2498.29点；深成指收跌0.58%，报7289.55点；创业板指收跌0.74%，报1264.07点；市场成交量低迷，两市合计成交2313亿元；行业板块涨跌互现，特高压板块掀涨停潮，逾10股封板，创投概念股尾盘表现活跃，5G概念股、券商等板块跌幅靠前。","post_content_filtered":null,"more":null,"share_id":22,"last_time":null,"favorite_count":0,"report_count":0,"report_status":0},"user":{"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null},"to_user":{"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}}]
         */

        private int total;
        private String per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        @Override
        public String toString() {
            return "DataBeanX{" +
                    "total=" + total +
                    ", per_page='" + per_page + '\'' +
                    ", current_page=" + current_page +
                    ", last_page=" + last_page +
                    ", data=" + data +
                    '}';
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 185
             * parent_id : 0
             * user_id : 68
             * to_user_id : 68
             * object_id : 78
             * like_count : 0
             * dislike_count : 0
             * floor : 0
             * create_time : 1545817709
             * delete_time : 0
             * status : 1
             * type : 1
             * table_name : share_post
             * full_name : 股吧
             * email :
             * path : 0,
             * url :
             * content : A股三大股指维持震荡沪指失守2500点 特高压板块掀涨停潮

             * more : null
             * is_landlord : 0
             * share : {"id":78,"user_id":68,"post_status":1,"comment_status":1,"post_hits":2,"post_like":0,"comment_count":1,"update_time":0,"published_time":"12-26 17:47","post_title":"A股三大股指维持震荡沪指失守2500点 特高压板块掀","post_excerpt":"","post_content":"A股三大股指今日维持震荡，沪指失守2500点，收盘下跌0.26%，报2498.29点；深成指收跌0.58%，报7289.55点；创业板指收跌0.74%，报1264.07点；市场成交量低迷，两市合计成交2313亿元；行业板块涨跌互现，特高压板块掀涨停潮，逾10股封板，创投概念股尾盘表现活跃，5G概念股、券商等板块跌幅靠前。","post_content_filtered":null,"more":null,"share_id":22,"last_time":null,"favorite_count":0,"report_count":0,"report_status":0}
             * user : {"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}
             * to_user : {"id":68,"sex":0,"user_status":1,"user_login":"","user_nickname":"股吧","user_email":"","user_url":"","avatar":"","signature":"","mobile":"13097702737","more":null,"app":"","lc_id":null,"lc_key":null,"lc_url":null}
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
            private ShareBean share;
            private UserBean user;
            private ToUserBean to_user;

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
                        ", share=" + share +
                        ", user=" + user +
                        ", to_user=" + to_user +
                        '}';
            }

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

            public ShareBean getShare() {
                return share;
            }

            public void setShare(ShareBean share) {
                this.share = share;
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

            public static class ShareBean {
                @Override
                public String toString() {
                    return "ShareBean{" +
                            "id=" + id +
                            ", user_id=" + user_id +
                            ", post_status=" + post_status +
                            ", comment_status=" + comment_status +
                            ", post_hits=" + post_hits +
                            ", post_like=" + post_like +
                            ", comment_count=" + comment_count +
                            ", update_time=" + update_time +
                            ", published_time='" + published_time + '\'' +
                            ", post_title='" + post_title + '\'' +
                            ", post_excerpt='" + post_excerpt + '\'' +
                            ", post_content='" + post_content + '\'' +
                            ", post_content_filtered=" + post_content_filtered +
                            ", more=" + more +
                            ", share_id=" + share_id +
                            ", last_time=" + last_time +
                            ", favorite_count=" + favorite_count +
                            ", report_count=" + report_count +
                            ", report_status=" + report_status +
                            '}';
                }

                /**
                 * id : 78
                 * user_id : 68
                 * post_status : 1
                 * comment_status : 1
                 * post_hits : 2
                 * post_like : 0
                 * comment_count : 1
                 * update_time : 0
                 * published_time : 12-26 17:47
                 * post_title : A股三大股指维持震荡沪指失守2500点 特高压板块掀
                 * post_excerpt :
                 * post_content : A股三大股指今日维持震荡，沪指失守2500点，收盘下跌0.26%，报2498.29点；深成指收跌0.58%，报7289.55点；创业板指收跌0.74%，报1264.07点；市场成交量低迷，两市合计成交2313亿元；行业板块涨跌互现，特高压板块掀涨停潮，逾10股封板，创投概念股尾盘表现活跃，5G概念股、券商等板块跌幅靠前。
                 * post_content_filtered : null
                 * more : null
                 * share_id : 22
                 * last_time : null
                 * favorite_count : 0
                 * report_count : 0
                 * report_status : 0
                 */

                private int id;
                private int user_id;
                private int post_status;
                private int comment_status;
                private int post_hits;
                private int post_like;
                private int comment_count;
                private int update_time;
                private String published_time;
                private String post_title;
                private String post_excerpt;
                private String post_content;
                private Object post_content_filtered;
                private Object more;
                private int share_id;
                private Object last_time;
                private int favorite_count;
                private int report_count;
                private int report_status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getPost_status() {
                    return post_status;
                }

                public void setPost_status(int post_status) {
                    this.post_status = post_status;
                }

                public int getComment_status() {
                    return comment_status;
                }

                public void setComment_status(int comment_status) {
                    this.comment_status = comment_status;
                }

                public int getPost_hits() {
                    return post_hits;
                }

                public void setPost_hits(int post_hits) {
                    this.post_hits = post_hits;
                }

                public int getPost_like() {
                    return post_like;
                }

                public void setPost_like(int post_like) {
                    this.post_like = post_like;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(int update_time) {
                    this.update_time = update_time;
                }

                public String getPublished_time() {
                    return published_time;
                }

                public void setPublished_time(String published_time) {
                    this.published_time = published_time;
                }

                public String getPost_title() {
                    return post_title;
                }

                public void setPost_title(String post_title) {
                    this.post_title = post_title;
                }

                public String getPost_excerpt() {
                    return post_excerpt;
                }

                public void setPost_excerpt(String post_excerpt) {
                    this.post_excerpt = post_excerpt;
                }

                public String getPost_content() {
                    return post_content;
                }

                public void setPost_content(String post_content) {
                    this.post_content = post_content;
                }

                public Object getPost_content_filtered() {
                    return post_content_filtered;
                }

                public void setPost_content_filtered(Object post_content_filtered) {
                    this.post_content_filtered = post_content_filtered;
                }

                public Object getMore() {
                    return more;
                }

                public void setMore(Object more) {
                    this.more = more;
                }

                public int getShare_id() {
                    return share_id;
                }

                public void setShare_id(int share_id) {
                    this.share_id = share_id;
                }

                public Object getLast_time() {
                    return last_time;
                }

                public void setLast_time(Object last_time) {
                    this.last_time = last_time;
                }

                public int getFavorite_count() {
                    return favorite_count;
                }

                public void setFavorite_count(int favorite_count) {
                    this.favorite_count = favorite_count;
                }

                public int getReport_count() {
                    return report_count;
                }

                public void setReport_count(int report_count) {
                    this.report_count = report_count;
                }

                public int getReport_status() {
                    return report_status;
                }

                public void setReport_status(int report_status) {
                    this.report_status = report_status;
                }
            }

            public static class UserBean {
                @Override
                public String toString() {
                    return "UserBean{" +
                            "id=" + id +
                            ", sex=" + sex +
                            ", user_status=" + user_status +
                            ", user_login='" + user_login + '\'' +
                            ", user_nickname='" + user_nickname + '\'' +
                            ", user_email='" + user_email + '\'' +
                            ", user_url='" + user_url + '\'' +
                            ", avatar='" + avatar + '\'' +
                            ", signature='" + signature + '\'' +
                            ", mobile='" + mobile + '\'' +
                            ", more=" + more +
                            ", app='" + app + '\'' +
                            ", lc_id=" + lc_id +
                            ", lc_key=" + lc_key +
                            ", lc_url=" + lc_url +
                            '}';
                }

                /**
                 * id : 68
                 * sex : 0
                 * user_status : 1
                 * user_login :
                 * user_nickname : 股吧
                 * user_email :
                 * user_url :
                 * avatar :
                 * signature :
                 * mobile : 13097702737
                 * more : null
                 * app :
                 * lc_id : null
                 * lc_key : null
                 * lc_url : null
                 */

                private int id;
                private int sex;
                private int user_status;
                private String user_login;
                private String user_nickname;
                private String user_email;
                private String user_url;
                private String avatar;
                private String signature;
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

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
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
                            ", sex=" + sex +
                            ", user_status=" + user_status +
                            ", user_login='" + user_login + '\'' +
                            ", user_nickname='" + user_nickname + '\'' +
                            ", user_email='" + user_email + '\'' +
                            ", user_url='" + user_url + '\'' +
                            ", avatar='" + avatar + '\'' +
                            ", signature='" + signature + '\'' +
                            ", mobile='" + mobile + '\'' +
                            ", more=" + more +
                            ", app='" + app + '\'' +
                            ", lc_id=" + lc_id +
                            ", lc_key=" + lc_key +
                            ", lc_url=" + lc_url +
                            '}';
                }

                /**
                 * id : 68
                 * sex : 0
                 * user_status : 1
                 * user_login :
                 * user_nickname : 股吧
                 * user_email :
                 * user_url :
                 * avatar :
                 * signature :
                 * mobile : 13097702737
                 * more : null
                 * app :
                 * lc_id : null
                 * lc_key : null
                 * lc_url : null
                 */

                private int id;
                private int sex;
                private int user_status;
                private String user_login;
                private String user_nickname;
                private String user_email;
                private String user_url;
                private String avatar;
                private String signature;
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

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
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
}

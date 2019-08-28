package com.ltqh.qh.entity;

import java.util.List;

public class GuliaoDetailEntity {


    /**
     * code : 0
     * msg : 获取数据成功
     * data : {"id":69,"user_id":57,"post_status":1,"comment_status":1,"post_hits":1,"post_like":0,"comment_count":0,"create_time":1545205574,"update_time":0,"published_time":"12-19 15:46","delete_time":0,"post_title":"test","post_excerpt":"","post_content":"helloworld","post_content_filtered":null,"more":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1545215476663&amp;di=7147217b231e78026305a64d647a5525&amp;imgtype=0&amp;src=http%3A%2F%2Fapp.yzinter.com%2Fd%2Ffile%2Fnews%2Ffashion%2F2018-11-10%2F177d344d615b6893643b18469a231824.jpg","share_id":22,"last_time":null,"favorite_count":0,"report_count":0,"report_status":0,"zan":[],"user":{"id":57,"user_nickname":"helloworld","avatar":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1545200165282&amp;di=8883459e3c99cbb5745b26e75682b91b&amp;imgtype=0&amp;src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fa1ae409cfab3db09293e42a1436bd2375d2f7aba9528a-ITiCgS_fw658\n\n"}}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "GuliaoDetailEntity{" +
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

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", user_id=" + user_id +
                    ", post_status=" + post_status +
                    ", comment_status=" + comment_status +
                    ", post_hits=" + post_hits +
                    ", post_like=" + post_like +
                    ", comment_count=" + comment_count +
                    ", create_time=" + create_time +
                    ", update_time=" + update_time +
                    ", published_time='" + published_time + '\'' +
                    ", delete_time=" + delete_time +
                    ", post_title='" + post_title + '\'' +
                    ", post_excerpt='" + post_excerpt + '\'' +
                    ", post_content='" + post_content + '\'' +
                    ", post_content_filtered=" + post_content_filtered +
                    ", more='" + more + '\'' +
                    ", share_id=" + share_id +
                    ", last_time=" + last_time +
                    ", favorite_count=" + favorite_count +
                    ", report_count=" + report_count +
                    ", report_status=" + report_status +
                    ", user=" + user +
                    ", zan=" + zan +
                    '}';
        }

        /**
         * id : 69
         * user_id : 57
         * post_status : 1
         * comment_status : 1
         * post_hits : 1
         * post_like : 0
         * comment_count : 0
         * create_time : 1545205574
         * update_time : 0
         * published_time : 12-19 15:46
         * delete_time : 0
         * post_title : test
         * post_excerpt :
         * post_content : helloworld
         * post_content_filtered : null
         * more : https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1545215476663&amp;di=7147217b231e78026305a64d647a5525&amp;imgtype=0&amp;src=http%3A%2F%2Fapp.yzinter.com%2Fd%2Ffile%2Fnews%2Ffashion%2F2018-11-10%2F177d344d615b6893643b18469a231824.jpg
         * share_id : 22
         * last_time : null
         * favorite_count : 0
         * report_count : 0
         * report_status : 0
         * zan : []
         * user : {"id":57,"user_nickname":"helloworld","avatar":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1545200165282&amp;di=8883459e3c99cbb5745b26e75682b91b&amp;imgtype=0&amp;src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fa1ae409cfab3db09293e42a1436bd2375d2f7aba9528a-ITiCgS_fw658\n\n"}
         */



        private int id;
        private int user_id;
        private int post_status;
        private int comment_status;
        private int post_hits;
        private int post_like;
        private int comment_count;
        private int create_time;
        private int update_time;
        private String published_time;
        private int delete_time;
        private String post_title;
        private String post_excerpt;
        private String post_content;
        private Object post_content_filtered;
        private String more;
        private int share_id;
        private Object last_time;
        private int favorite_count;
        private int report_count;
        private int report_status;
        private UserBean user;
        private List<?> zan;

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

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
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

        public int getDelete_time() {
            return delete_time;
        }

        public void setDelete_time(int delete_time) {
            this.delete_time = delete_time;
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

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getZan() {
            return zan;
        }

        public void setZan(List<?> zan) {
            this.zan = zan;
        }

        public static class UserBean {
            /**
             * id : 57
             * user_nickname : helloworld
             * avatar : https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1545200165282&amp;di=8883459e3c99cbb5745b26e75682b91b&amp;imgtype=0&amp;src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fa1ae409cfab3db09293e42a1436bd2375d2f7aba9528a-ITiCgS_fw658


             */

            private int id;
            private String user_nickname;
            private String avatar;

            @Override
            public String toString() {
                return "UserBean{" +
                        "id=" + id +
                        ", user_nickname='" + user_nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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
        }
    }
}

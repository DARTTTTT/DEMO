package com.ltqh.qh.entity;

import java.util.List;

public class GubaEntity {


    /**
     * code : 1
     * msg : 请求成功
     * data : {"total":13,"per_page":"20","current_page":1,"last_page":1,"data":[{"id":13,"name":"格力电器","code":100012,"share_url":"","status":1,"shareit":0},{"id":12,"name":"一带一路","code":100011,"share_url":"","status":1,"shareit":0},{"id":11,"name":"乐视网","code":100010,"share_url":"","status":1,"shareit":0},{"id":10,"name":"互联网","code":100009,"share_url":"","status":1,"shareit":0},{"id":9,"name":"新能源","code":100008,"share_url":"","status":1,"shareit":0},{"id":8,"name":"房地产","code":100007,"share_url":"","status":1,"shareit":0},{"id":7,"name":"人工智能","code":100006,"share_url":"","status":1,"shareit":0},{"id":6,"name":"中小板","code":100005,"share_url":"","status":1,"shareit":0},{"id":5,"name":"创业板","code":100004,"share_url":"","status":1,"shareit":0},{"id":4,"name":"金融盛典","code":100003,"share_url":"","status":1,"shareit":0},{"id":3,"name":"我是新手我怕谁","code":100002,"share_url":"","status":1,"shareit":0},{"id":2,"name":"港股吧","code":100001,"share_url":"","status":1,"shareit":0},{"id":1,"name":"优享大家谈","code":100000,"share_url":"","status":1,"shareit":0}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

    @Override
    public String toString() {
        return "GubaEntity{" +
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
         * total : 13
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":13,"name":"格力电器","code":100012,"share_url":"","status":1,"shareit":0},{"id":12,"name":"一带一路","code":100011,"share_url":"","status":1,"shareit":0},{"id":11,"name":"乐视网","code":100010,"share_url":"","status":1,"shareit":0},{"id":10,"name":"互联网","code":100009,"share_url":"","status":1,"shareit":0},{"id":9,"name":"新能源","code":100008,"share_url":"","status":1,"shareit":0},{"id":8,"name":"房地产","code":100007,"share_url":"","status":1,"shareit":0},{"id":7,"name":"人工智能","code":100006,"share_url":"","status":1,"shareit":0},{"id":6,"name":"中小板","code":100005,"share_url":"","status":1,"shareit":0},{"id":5,"name":"创业板","code":100004,"share_url":"","status":1,"shareit":0},{"id":4,"name":"金融盛典","code":100003,"share_url":"","status":1,"shareit":0},{"id":3,"name":"我是新手我怕谁","code":100002,"share_url":"","status":1,"shareit":0},{"id":2,"name":"港股吧","code":100001,"share_url":"","status":1,"shareit":0},{"id":1,"name":"优享大家谈","code":100000,"share_url":"","status":1,"shareit":0}]
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
            @Override
            public String toString() {
                return "DataBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", code=" + code +
                        ", share_url='" + share_url + '\'' +
                        ", status=" + status +
                        ", shareit=" + shareit +
                        '}';
            }

            /**
             * id : 13
             * name : 格力电器
             * code : 100012
             * share_url :
             * status : 1
             * shareit : 0
             */



            private int id;
            private String name;
            private int code;
            private String share_url;
            private int status;
            private int shareit;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getShareit() {
                return shareit;
            }

            public void setShareit(int shareit) {
                this.shareit = shareit;
            }
        }
    }
}

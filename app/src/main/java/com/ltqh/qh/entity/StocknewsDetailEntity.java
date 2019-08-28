package com.ltqh.qh.entity;

public class StocknewsDetailEntity {


    /**
     * code : 1
     * msg : 获取成功
     * data : {"title":"","time":"2019-03-28 18:21:19　","source":"中访网","content":" "}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "StocknewsDetailEntity{" +
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
        /**
         * title :
         * time : 2019-03-28 18:21:19　
         * source : 中访网
         * content :
         */

        private String title;
        private String time;
        private String source;
        private String content;

        @Override
        public String toString() {
            return "DataBean{" +
                    "title='" + title + '\'' +
                    ", time='" + time + '\'' +
                    ", source='" + source + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

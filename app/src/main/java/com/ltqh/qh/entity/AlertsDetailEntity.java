package com.ltqh.qh.entity;

public class AlertsDetailEntity {


    /**
     * news : {"content":"","date":"2018-10-11 12:05:04","title":" 油市飓风警报解除！今晨API已前瞻今夜EIA油价命运？ ","titleBg":"https://cdn.jin10.com/pic/ff/24c9c3b74701bbef3508c964dd139947.jpg"}
     * code : 200
     * resultMsg :
     */

    private NewsBean news;
    private int code;
    private String resultMsg;

    @Override
    public String toString() {
        return "AlertsDetailEntity{" +
                "news=" + news +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public NewsBean getNews() {
        return news;
    }

    public void setNews(NewsBean news) {
        this.news = news;
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

    public static class NewsBean {
        @Override
        public String toString() {
            return "NewsBean{" +
                    "content='" + content + '\'' +
                    ", date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", titleBg='" + titleBg + '\'' +
                    '}';
        }

        /**
         * content :
         * date : 2018-10-11 12:05:04
         * title :  油市飓风警报解除！今晨API已前瞻今夜EIA油价命运？
         * titleBg : https://cdn.jin10.com/pic/ff/24c9c3b74701bbef3508c964dd139947.jpg
         */



        private String content;
        private String date;
        private String title;
        private String titleBg;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleBg() {
            return titleBg;
        }

        public void setTitleBg(String titleBg) {
            this.titleBg = titleBg;
        }
    }
}

package com.ltqh.qh.entity;

public class ImgEntity {


    /**
     * code : 1
     * msg : 上传成功!
     * data : {"url":"20190325/212911850e5dcdc4694545483bf06828.jpg","filename":"mmexport1552199935596.jpg","host_name":"https://data.fk7h.com","complete_url":"https://data.fk7h.com/upload/20190325/212911850e5dcdc4694545483bf06828.jpg"}
     */

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "ImgEntity{" +
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
                    "url='" + url + '\'' +
                    ", filename='" + filename + '\'' +
                    ", host_name='" + host_name + '\'' +
                    ", complete_url='" + complete_url + '\'' +
                    '}';
        }

        /**
         * url : 20190325/212911850e5dcdc4694545483bf06828.jpg
         * filename : mmexport1552199935596.jpg
         * host_name : https://data.fk7h.com
         * complete_url : https://data.fk7h.com/upload/20190325/212911850e5dcdc4694545483bf06828.jpg
         */



        private String url;
        private String filename;
        private String host_name;
        private String complete_url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getHost_name() {
            return host_name;
        }

        public void setHost_name(String host_name) {
            this.host_name = host_name;
        }

        public String getComplete_url() {
            return complete_url;
        }

        public void setComplete_url(String complete_url) {
            this.complete_url = complete_url;
        }
    }
}

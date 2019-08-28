package com.ltqh.qh.operation.entity;

import java.util.List;

public class OAddressEntity {


    @Override
    public String toString() {
        return "OAddressEntity{" +
                "data=" + data +
                '}';
    }

    private List<DataBean> data;

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
                    "name='" + name + '\'' +
                    ", shi=" + shi +
                    '}';
        }

        /**
         * name : 北京市
         * shi : ["北京市"]
         */



        private String name;
        private List<String> shi;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getShi() {
            return shi;
        }

        public void setShi(List<String> shi) {
            this.shi = shi;
        }
    }
}

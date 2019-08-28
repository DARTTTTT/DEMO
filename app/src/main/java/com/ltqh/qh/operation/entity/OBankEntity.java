package com.ltqh.qh.operation.entity;

import java.util.List;

public class OBankEntity {


    @Override
    public String toString() {
        return "OBankEntity{" +
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
                    "label='" + label + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }

        /**
         * label : 工商银行
         * value : 工商银行
         */


        private String label;
        private String value;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

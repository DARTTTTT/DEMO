package com.ltqh.qh.entity;

import java.io.Serializable;
import java.util.List;

public class TitleEntity implements Serializable {

    public TitleEntity(List<DataBean> data) {
        this.data = data;
    }

    /**
     * code : 1
     * msg : 获取数据成功
     * data : [{"title":"日本上市公司LINE受邀参加TEAMZ区块链峰会"}]
     */


    private List<DataBean> data;

    @Override
    public String toString() {
        return "TitleEntity{" +
                "data=" + data +
                '}';
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        public DataBean(String title) {
            this.title = title;
        }

        /**
         * title : 日本上市公司LINE受邀参加TEAMZ区块链峰会
         */



        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}

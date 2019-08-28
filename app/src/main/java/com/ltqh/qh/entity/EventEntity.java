package com.ltqh.qh.entity;

import java.io.Serializable;
import java.util.List;

public class EventEntity implements Serializable {


    /**
     * code : 200
     * resultMsg : 请求成功
     * data : [{"id":"c22","title":"直击EIA数据 行情异动大战在即","content":"今晚又将迎来EIA原油库存数据的公布，该数据对原油市场影响会比较大，行情势必会有异动，原油库存的变化实际上反映了美国政府对油价的态度，投资者需密切关注。","imgUrl":"https://res.cngoldres.com/upload/kuaixun/2017/1025/9dacdf24f7d923b4177835bb27d243c2.jpg","detailsUrl":"https://kuaixun.cngold.org/event/c22.html"},{"id":"c21","title":"下一任美联储主席会是谁？","content":"据央视报道，美国总统特朗普最快下周决定谁出任美联储新一任主席。在包括现任主席耶伦在内的5名最终人选当中，\u201c鸽派\u201d人物鲍威尔处于领先位置，且获得财长姆努钦支持。那么最终得主会是谁呢？","imgUrl":"https://res.cngoldres.com/upload/kuaixun/2017/1023/a476968494875f1a17bfd6b67d9d4cbf.png","detailsUrl":"https://kuaixun.cngold.org/event/c21.html"},{"id":"c20","title":"聚焦欧洲央行利率决议 暴风将袭","content":"本周四，欧洲央行将公布利率决议，市场认为欧央行将发布关于下调量化宽松政策(QE)的声明，普遍预期欧洲央行行长德拉基将会宣布延长9个月的资产购买计划，购债规模为每月300亿欧元。","imgUrl":"https://res.cngoldres.com/upload/kuaixun/2017/1023/b6413ba34a06213ed4a01d87c4c1801c.jpg","detailsUrl":"https://kuaixun.cngold.org/event/c20.html"},{"id":"c19","title":"三季度GDP 中国经济数据有看点","content":"随着三季度中国GDP数据的临近发布，市场的猜测与议论持续增多。那么，三季度经济究竟会怎样？中国经济前景又将如何？","imgUrl":"https://res.cngoldres.com/upload/kuaixun/2017/1018/c89011ada3dd10c394c7ce1c89a0a1f5.png","detailsUrl":"https://kuaixun.cngold.org/event/c19.html"},{"id":"c17","title":"荷兰大选序幕拉开 打响2017年欧洲大选第一炮","content":"3月15日，随着荷兰大选序幕的拉开，其打响了2017年欧洲大选的第一炮。若威德尔斯当选，欧洲政治风险或将被引爆，风险情绪短期内剧增，影响势必加大，欧盟的大后方堪忧，金融市场恐波涛汹涌。","imgUrl":"https://res.cngoldres.com/upload/kuaixun/2017/0315/e1971ac4bc1e9dcfb4963757bb6f62bc.jpg","detailsUrl":"https://kuaixun.cngold.org/event/c17.html"}]
     */

    private int code;
    private String resultMsg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "EventEntity{" +
                "code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : c22
         * title : 直击EIA数据 行情异动大战在即
         * content : 今晚又将迎来EIA原油库存数据的公布，该数据对原油市场影响会比较大，行情势必会有异动，原油库存的变化实际上反映了美国政府对油价的态度，投资者需密切关注。
         * imgUrl : https://res.cngoldres.com/upload/kuaixun/2017/1025/9dacdf24f7d923b4177835bb27d243c2.jpg
         * detailsUrl : https://kuaixun.cngold.org/event/c22.html
         */

        private String id;
        private String title;
        private String content;
        private String imgUrl;
        private String detailsUrl;
        private String time;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }


        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", detailsUrl='" + detailsUrl + '\'' +
                    ", time='" + time + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getDetailsUrl() {
            return detailsUrl;
        }

        public void setDetailsUrl(String detailsUrl) {
            this.detailsUrl = detailsUrl;
        }
    }
}

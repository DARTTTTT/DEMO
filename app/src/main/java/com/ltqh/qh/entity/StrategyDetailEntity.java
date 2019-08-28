package com.ltqh.qh.entity;

public class StrategyDetailEntity {


    /**
     * code : 200
     * data : {"bannerUrl":"http://cos.speedycloud.org/cainiu-lt/2018-10-19_market1539955163417.png","cmtCount":0,"content":"<p><span style=\"font-family: 微软雅黑; font-size: 15px; white-space: normal;\">黄金1812合约：目前黄金短线上来看，金价短期的隔夜回落后行情在低位弱势盘整，短期反弹的压制仍然是在4小时线布林带中轨1225，进一步才是1235；不过当前布林带有轻微缩口迹象，因此短期的行情还是偏弱势的，因此操作上建议反弹高点做空。上方重点关注1235一线阻力，下方关注1225一线支撑。1232附近轻仓空单，止损1234，止盈1230/1228/1225.<\/span><\/p><p><span style=\"font-family: 微软雅黑; font-size: 15px; white-space: normal;\">策略仅供参考<\/span><\/p>","createDate":"2018-10-19 21:19:55.0","hot":0,"id":1848,"modifyDate":"2018-10-19 21:19:50.0","outSourceName":"Rain","permitComment":1,"picFlag":1,"plateName":"行情分析","readCount":1283,"section":57,"sectionName":"策略","sourceType":0,"summary":"黄金1812合约：目前黄金短线上来看，金价短期的隔夜回落后行情在低位弱势盘整，短期反弹的压制仍然是在4小","title":"10月19日晚间行情分析","top":0}
     * errparam :
     * msg : 操作成功
     * msgType : 0
     */

    private String code;
    private DataBean data;
    private String errparam;
    private String msg;
    private int msgType;

    @Override
    public String toString() {
        return "StrategyDetailEntity{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", errparam='" + errparam + '\'' +
                ", msg='" + msg + '\'' +
                ", msgType=" + msgType +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrparam() {
        return errparam;
    }

    public void setErrparam(String errparam) {
        this.errparam = errparam;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public static class DataBean {
        /**
         * bannerUrl : http://cos.speedycloud.org/cainiu-lt/2018-10-19_market1539955163417.png
         * cmtCount : 0
         * content : <p><span style="font-family: 微软雅黑; font-size: 15px; white-space: normal;">黄金1812合约：目前黄金短线上来看，金价短期的隔夜回落后行情在低位弱势盘整，短期反弹的压制仍然是在4小时线布林带中轨1225，进一步才是1235；不过当前布林带有轻微缩口迹象，因此短期的行情还是偏弱势的，因此操作上建议反弹高点做空。上方重点关注1235一线阻力，下方关注1225一线支撑。1232附近轻仓空单，止损1234，止盈1230/1228/1225.</span></p><p><span style="font-family: 微软雅黑; font-size: 15px; white-space: normal;">策略仅供参考</span></p>
         * createDate : 2018-10-19 21:19:55.0
         * hot : 0
         * id : 1848
         * modifyDate : 2018-10-19 21:19:50.0
         * outSourceName : Rain
         * permitComment : 1
         * picFlag : 1
         * plateName : 行情分析
         * readCount : 1283
         * section : 57
         * sectionName : 策略
         * sourceType : 0
         * summary : 黄金1812合约：目前黄金短线上来看，金价短期的隔夜回落后行情在低位弱势盘整，短期反弹的压制仍然是在4小
         * title : 10月19日晚间行情分析
         * top : 0
         */

        private String bannerUrl;
        private int cmtCount;
        private String content;
        private String createDate;
        private int hot;
        private int id;
        private String modifyDate;
        private String outSourceName;
        private int permitComment;
        private int picFlag;
        private String plateName;
        private int readCount;
        private int section;
        private String sectionName;
        private int sourceType;
        private String summary;
        private String title;
        private int top;

        @Override
        public String toString() {
            return "DataBean{" +
                    "bannerUrl='" + bannerUrl + '\'' +
                    ", cmtCount=" + cmtCount +
                    ", content='" + content + '\'' +
                    ", createDate='" + createDate + '\'' +
                    ", hot=" + hot +
                    ", id=" + id +
                    ", modifyDate='" + modifyDate + '\'' +
                    ", outSourceName='" + outSourceName + '\'' +
                    ", permitComment=" + permitComment +
                    ", picFlag=" + picFlag +
                    ", plateName='" + plateName + '\'' +
                    ", readCount=" + readCount +
                    ", section=" + section +
                    ", sectionName='" + sectionName + '\'' +
                    ", sourceType=" + sourceType +
                    ", summary='" + summary + '\'' +
                    ", title='" + title + '\'' +
                    ", top=" + top +
                    '}';
        }

        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }

        public int getCmtCount() {
            return cmtCount;
        }

        public void setCmtCount(int cmtCount) {
            this.cmtCount = cmtCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(String modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getOutSourceName() {
            return outSourceName;
        }

        public void setOutSourceName(String outSourceName) {
            this.outSourceName = outSourceName;
        }

        public int getPermitComment() {
            return permitComment;
        }

        public void setPermitComment(int permitComment) {
            this.permitComment = permitComment;
        }

        public int getPicFlag() {
            return picFlag;
        }

        public void setPicFlag(int picFlag) {
            this.picFlag = picFlag;
        }

        public String getPlateName() {
            return plateName;
        }

        public void setPlateName(String plateName) {
            this.plateName = plateName;
        }

        public int getReadCount() {
            return readCount;
        }

        public void setReadCount(int readCount) {
            this.readCount = readCount;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public int getSourceType() {
            return sourceType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }
    }
}

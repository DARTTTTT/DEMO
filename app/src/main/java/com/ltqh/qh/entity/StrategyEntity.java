package com.ltqh.qh.entity;

import java.io.Serializable;
import java.util.List;

public class StrategyEntity implements Serializable {



    private String code;
    private String errparam;
    private String msg;
    private int msgType;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "StrategyEntity{" +
                "code='" + code + '\'' +
                ", errparam='" + errparam + '\'' +
                ", msg='" + msg + '\'' +
                ", msgType=" + msgType +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * bannerUrl : http://cos.speedycloud.org/cainiu-lt/2018-10-19_market1539955163417.png
         * cmtCount : 0
         * content :
         * createDate : 2018-10-19 21:19:55.0
         * hot : 0
         * id : 1848
         * modifyDate : 2018-10-19 21:19:50.0
         * outSourceName : Rain
         * permitComment : 1
         * picFlag : 1
         * plateName : 琛屾儏鍒嗘瀽
         * readCount : 1279
         * section : 57
         * sectionName : 绛栫暐
         * sourceType : 0
         * summary : 榛勯噾1812鍚堢害锛氱洰鍓嶉粍閲戠煭绾夸笂鏉ョ湅锛岄噾浠风煭鏈熺殑闅斿鍥炶惤鍚庤鎯呭湪浣庝綅寮卞娍鐩樻暣锛岀煭鏈熷弽寮圭殑鍘嬪埗浠嶇劧鏄湪4灏�
         * title : 10鏈�19鏃ユ櫄闂磋鎯呭垎鏋�
         * top : 0
         */

        private String bannerUrl;
        private int cmtCount;
        private String content;
        private String createDate;
        private int hot;
        private String id;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

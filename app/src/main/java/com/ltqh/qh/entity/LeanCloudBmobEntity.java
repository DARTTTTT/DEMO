package com.ltqh.qh.entity;

import java.util.List;

public class LeanCloudBmobEntity {


    private List<ResultsBean> results;

    @Override
    public String toString() {
        return "LeanCloudBmobEntity{" +
                "results=" + results +
                '}';
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * versionCol : 0x000000
         * updatedAt : 2019-04-30T02:37:47.295Z
         * name : ltkdqhxt360
         * objectId : 5cc7b077a91c93006c25e2ad
         * versionUrl : https://www.xmpandaqh.com/?f=test111111
         * createdAt : 2019-04-30T02:18:31.068Z
         * hv : 1
         * blackOrWhite : 0
         * versionCode : 0
         */

        private String versionCol;
        private String updatedAt;
        private String name;
        private String objectId;
        private String versionUrl;
        private String createdAt;
        private int hv;
        private int blackOrWhite;
        private int versionCode;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "versionCol='" + versionCol + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", name='" + name + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", versionUrl='" + versionUrl + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", hv=" + hv +
                    ", blackOrWhite=" + blackOrWhite +
                    ", versionCode=" + versionCode +
                    '}';
        }

        public String getVersionCol() {
            return versionCol;
        }

        public void setVersionCol(String versionCol) {
            this.versionCol = versionCol;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getVersionUrl() {
            return versionUrl;
        }

        public void setVersionUrl(String versionUrl) {
            this.versionUrl = versionUrl;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getHv() {
            return hv;
        }

        public void setHv(int hv) {
            this.hv = hv;
        }

        public int getBlackOrWhite() {
            return blackOrWhite;
        }

        public void setBlackOrWhite(int blackOrWhite) {
            this.blackOrWhite = blackOrWhite;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }
    }
}

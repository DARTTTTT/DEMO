package com.ltqh.qh.operation.entity;

public class OCheckHisoryEntity {


    @Override
    public String toString() {
        return "OCheckHisoryEntity{" +
                "data=" + data +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }




    private DataBean data;
    private boolean success;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "checked=" + checked +
                    ", history=" + history +
                    ", id=" + id +
                    ", points=" + points +
                    ", pointsArray='" + pointsArray + '\'' +
                    ", pointsStatus='" + pointsStatus + '\'' +
                    ", updateTime=" + updateTime +
                    ", userId=" + userId +
                    '}';
        }

        /**
         * checked : false
         * history : 0
         * id : 0
         * points : 0
         * pointsArray : 10,10,20,30,50
         * pointsStatus : -1,0,-1,-1,-1
         * updateTime : null
         * userId : 0
         */



        private boolean checked;
        private int history;
        private int id;
        private int points;
        private String pointsArray;
        private String pointsStatus;
        private Object updateTime;
        private int userId;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public int getHistory() {
            return history;
        }

        public void setHistory(int history) {
            this.history = history;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getPointsArray() {
            return pointsArray;
        }

        public void setPointsArray(String pointsArray) {
            this.pointsArray = pointsArray;
        }

        public String getPointsStatus() {
            return pointsStatus;
        }

        public void setPointsStatus(String pointsStatus) {
            this.pointsStatus = pointsStatus;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}

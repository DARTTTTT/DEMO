package com.ltqh.qh.operation.entity;

public class OPrizesEntity {


    /**
     * code : 200
     * success : true
     * errorCode : 200
     * prize : {"createTime":null,"id":53,"lotteryId":8,"prizeName":"38元","prizeType":1,"prizeValue":38,"prizeWeight":0}
     * errorMsg : 中奖啦
     * resultMsg :
     */

    private int code;
    private boolean success;
    private int errorCode;
    private PrizeBean prize;
    private String errorMsg;
    private String resultMsg;

    @Override
    public String toString() {
        return "OPrizesEntity{" +
                "code=" + code +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", prize=" + prize +
                ", errorMsg='" + errorMsg + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public PrizeBean getPrize() {
        return prize;
    }

    public void setPrize(PrizeBean prize) {
        this.prize = prize;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public static class PrizeBean {
        /**
         * createTime : null
         * id : 53
         * lotteryId : 8
         * prizeName : 38元
         * prizeType : 1
         * prizeValue : 38
         * prizeWeight : 0
         */

        private Object createTime;
        private int id;
        private int lotteryId;
        private String prizeName;
        private int prizeType;
        private int prizeValue;
        private int prizeWeight;

        @Override
        public String toString() {
            return "PrizeBean{" +
                    "createTime=" + createTime +
                    ", id=" + id +
                    ", lotteryId=" + lotteryId +
                    ", prizeName='" + prizeName + '\'' +
                    ", prizeType=" + prizeType +
                    ", prizeValue=" + prizeValue +
                    ", prizeWeight=" + prizeWeight +
                    '}';
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLotteryId() {
            return lotteryId;
        }

        public void setLotteryId(int lotteryId) {
            this.lotteryId = lotteryId;
        }

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public int getPrizeType() {
            return prizeType;
        }

        public void setPrizeType(int prizeType) {
            this.prizeType = prizeType;
        }

        public int getPrizeValue() {
            return prizeValue;
        }

        public void setPrizeValue(int prizeValue) {
            this.prizeValue = prizeValue;
        }

        public int getPrizeWeight() {
            return prizeWeight;
        }

        public void setPrizeWeight(int prizeWeight) {
            this.prizeWeight = prizeWeight;
        }
    }
}

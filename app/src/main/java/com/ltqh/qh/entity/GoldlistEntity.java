package com.ltqh.qh.entity;

import java.util.List;

public class GoldlistEntity {


    /**
     * code : 1
     * msg : 获取成功
     * data : [{"symbol":"GC","last":"1274.2000","pricechange":"2.4000","bid":"1274.2000","ask":"1274.3000","high":"1274.9000","low":"1267.5000","timeupdate":"09:42:40","dateupdate":"2018-12-26","prev":"1271.8000","open":"1272.4000","totalvol":"2187","asksize":"0","bidsize":"0","currentvol":null,"localdatetime":"2018-12-26 09:42:46","name":"COMEX黄金","market":"CMX"},{"symbol":"XAG","last":"14.8337","pricechange":"0.0703","bid":"14.8337","ask":"14.8537","high":"14.8460","low":"14.7188","timeupdate":"09:42:53","dateupdate":"2018-12-26","prev":"14.7634","open":"14.7873","totalvol":"0","asksize":"0","bidsize":"0","currentvol":"0","localdatetime":"2018-12-26 09:43:01","name":"伦敦银","market":"LIFFE"},{"symbol":"XAU","last":"1270.8400","pricechange":"1.7701","bid":"1270.8400","ask":"1271.1400","high":"1271.3600","low":"1264.3900","timeupdate":"09:42:53","dateupdate":"2018-12-26","prev":"1269.0699","open":"1269.2899","totalvol":"0","asksize":"0","bidsize":"0","currentvol":"0","localdatetime":"2018-12-26 09:43:01","name":"伦敦金","market":"LIFFE"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "GoldlistEntity{" +
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * symbol : GC
         * last : 1274.2000
         * pricechange : 2.4000
         * bid : 1274.2000
         * ask : 1274.3000
         * high : 1274.9000
         * low : 1267.5000
         * timeupdate : 09:42:40
         * dateupdate : 2018-12-26
         * prev : 1271.8000
         * open : 1272.4000
         * totalvol : 2187
         * asksize : 0
         * bidsize : 0
         * currentvol : null
         * localdatetime : 2018-12-26 09:42:46
         * name : COMEX黄金
         * market : CMX
         */

        private String symbol;
        private String last;
        private String pricechange;
        private String bid;
        private String ask;
        private String high;
        private String low;
        private String timeupdate;
        private String dateupdate;
        private String prev;
        private String open;
        private String totalvol;
        private String asksize;
        private String bidsize;
        private Object currentvol;
        private String localdatetime;
        private String name;
        private String market;

        @Override
        public String toString() {
            return "DataBean{" +
                    "symbol='" + symbol + '\'' +
                    ", last='" + last + '\'' +
                    ", pricechange='" + pricechange + '\'' +
                    ", bid='" + bid + '\'' +
                    ", ask='" + ask + '\'' +
                    ", high='" + high + '\'' +
                    ", low='" + low + '\'' +
                    ", timeupdate='" + timeupdate + '\'' +
                    ", dateupdate='" + dateupdate + '\'' +
                    ", prev='" + prev + '\'' +
                    ", open='" + open + '\'' +
                    ", totalvol='" + totalvol + '\'' +
                    ", asksize='" + asksize + '\'' +
                    ", bidsize='" + bidsize + '\'' +
                    ", currentvol=" + currentvol +
                    ", localdatetime='" + localdatetime + '\'' +
                    ", name='" + name + '\'' +
                    ", market='" + market + '\'' +
                    '}';
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getPricechange() {
            return pricechange;
        }

        public void setPricechange(String pricechange) {
            this.pricechange = pricechange;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getAsk() {
            return ask;
        }

        public void setAsk(String ask) {
            this.ask = ask;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getTimeupdate() {
            return timeupdate;
        }

        public void setTimeupdate(String timeupdate) {
            this.timeupdate = timeupdate;
        }

        public String getDateupdate() {
            return dateupdate;
        }

        public void setDateupdate(String dateupdate) {
            this.dateupdate = dateupdate;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getTotalvol() {
            return totalvol;
        }

        public void setTotalvol(String totalvol) {
            this.totalvol = totalvol;
        }

        public String getAsksize() {
            return asksize;
        }

        public void setAsksize(String asksize) {
            this.asksize = asksize;
        }

        public String getBidsize() {
            return bidsize;
        }

        public void setBidsize(String bidsize) {
            this.bidsize = bidsize;
        }

        public Object getCurrentvol() {
            return currentvol;
        }

        public void setCurrentvol(Object currentvol) {
            this.currentvol = currentvol;
        }

        public String getLocaldatetime() {
            return localdatetime;
        }

        public void setLocaldatetime(String localdatetime) {
            this.localdatetime = localdatetime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }
    }
}

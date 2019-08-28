package com.ltqh.qh.entity;

import java.util.List;

public class GoldShowEntity {


    /**
     * code : 1
     * msg : 获取成功
     * data : [{"symbol":"AU1912","market":"shfe","contract":"黄金","name":"黄金1912","trade":"290.50","settlement":"290.80","prevsettlement":"290.80","open":"291.00","high":"291.00","low":"290.05","close":"290.75","bid":"290.50","ask":"290.70","bidvol":"1","askvol":"1","volume":"34","position":"978","currentvol":"0","ticktime":"09:28:17","tradedate":"2018-12-26","changepercent":"-0.0010316"},{"symbol":"AU1908","market":"shfe","contract":"黄金","name":"黄金1908","trade":"288.80","settlement":"288.00","prevsettlement":"287.85","open":"288.00","high":"288.85","low":"287.10","close":"288.80","bid":"287.70","ask":"288.45","bidvol":"3","askvol":"6","volume":"20","position":"92","currentvol":"0","ticktime":"09:25:58","tradedate":"2018-12-26","changepercent":"0.0033003"},{"symbol":"AU1910","market":"shfe","contract":"黄金","name":"黄金1910","trade":"287.20","settlement":"287.20","prevsettlement":"287.20","open":"0.00","high":"287.20","low":"287.20","close":"287.20","bid":"288.70","ask":"290.70","bidvol":"1","askvol":"5","volume":"0","position":"0","currentvol":"0","ticktime":"09:28:19","tradedate":"2018-12-26","changepercent":"0.0000000"},{"symbol":"AU0","market":"shfe","contract":"黄金","name":"黄金连续","trade":"286.90","settlement":"286.76","prevsettlement":"286.55","open":"287.05","high":"287.45","low":"285.90","close":"287.10","bid":"286.85","ask":"286.90","bidvol":"160","askvol":"181","volume":"37404","position":"262674","currentvol":"4","ticktime":"09:28:45","tradedate":"2018-12-26","changepercent":"0.0012214"},{"symbol":"AU1906","market":"shfe","contract":"黄金","name":"黄金1906","trade":"286.85","settlement":"286.76","prevsettlement":"286.55","open":"287.05","high":"287.45","low":"285.90","close":"287.10","bid":"286.85","ask":"286.90","bidvol":"145","askvol":"198","volume":"37412","position":"262670","currentvol":"2","ticktime":"09:29:00","tradedate":"2018-12-26","changepercent":"0.0010469"},{"symbol":"AU1904","market":"shfe","contract":"黄金","name":"黄金1904","trade":"285.55","settlement":"285.51","prevsettlement":"285.10","open":"285.90","high":"286.10","low":"284.70","close":"285.70","bid":"285.55","ask":"285.60","bidvol":"11","askvol":"40","volume":"3520","position":"54462","currentvol":"0","ticktime":"09:28:54","tradedate":"2018-12-26","changepercent":"0.0015784"},{"symbol":"AU1812","market":"shfe","contract":"黄金","name":"黄金1812","trade":"284.90","settlement":"284.39","prevsettlement":"283.45","open":"283.95","high":"284.90","low":"283.95","close":"283.75","bid":"282.20","ask":"286.00","bidvol":"6","askvol":"5","volume":"42","position":"412","currentvol":"0","ticktime":"02:29:54","tradedate":"2018-12-18","changepercent":"0.0051155"},{"symbol":"AU1901","market":"shfe","contract":"黄金","name":"黄金1901","trade":"284.60","settlement":"283.10","prevsettlement":"283.10","open":"279.35","high":"284.70","low":"279.35","close":"284.60","bid":"284.05","ask":"286.70","bidvol":"1","askvol":"1","volume":"0","position":"8","currentvol":"0","ticktime":"09:16:49","tradedate":"2018-12-26","changepercent":"0.0052985"},{"symbol":"AU1902","market":"shfe","contract":"黄金","name":"黄金1902","trade":"284.10","settlement":"284.33","prevsettlement":"283.90","open":"284.55","high":"284.55","low":"284.10","close":"284.30","bid":"283.95","ask":"284.45","bidvol":"1","askvol":"3","volume":"4","position":"78","currentvol":"0","ticktime":"09:27:59","tradedate":"2018-12-26","changepercent":"0.0007045"},{"symbol":"AU1903","market":"shfe","contract":"黄金","name":"黄金1903","trade":"281.10","settlement":"281.10","prevsettlement":"281.10","open":"0.00","high":"281.10","low":"281.10","close":"281.10","bid":"283.50","ask":"287.60","bidvol":"3","askvol":"3","volume":"0","position":"0","currentvol":"0","ticktime":"09:28:04","tradedate":"2018-12-26","changepercent":"0.0000000"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;


    @Override
    public String toString() {
        return "GoldShowEntity{" +
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
         * symbol : AU1912
         * market : shfe
         * contract : 黄金
         * name : 黄金1912
         * trade : 290.50
         * settlement : 290.80
         * prevsettlement : 290.80
         * open : 291.00
         * high : 291.00
         * low : 290.05
         * close : 290.75
         * bid : 290.50
         * ask : 290.70
         * bidvol : 1
         * askvol : 1
         * volume : 34
         * position : 978
         * currentvol : 0
         * ticktime : 09:28:17
         * tradedate : 2018-12-26
         * changepercent : -0.0010316
         */

        private String symbol;
        private String market;
        private String contract;
        private String name;
        private String trade;
        private String settlement;
        private String prevsettlement;
        private String open;
        private String high;
        private String low;
        private String close;
        private String bid;
        private String ask;
        private String bidvol;
        private String askvol;
        private String volume;
        private String position;
        private String currentvol;
        private String ticktime;
        private String tradedate;
        private String changepercent;

        @Override
        public String toString() {
            return "DataBean{" +
                    "symbol='" + symbol + '\'' +
                    ", market='" + market + '\'' +
                    ", contract='" + contract + '\'' +
                    ", name='" + name + '\'' +
                    ", trade='" + trade + '\'' +
                    ", settlement='" + settlement + '\'' +
                    ", prevsettlement='" + prevsettlement + '\'' +
                    ", open='" + open + '\'' +
                    ", high='" + high + '\'' +
                    ", low='" + low + '\'' +
                    ", close='" + close + '\'' +
                    ", bid='" + bid + '\'' +
                    ", ask='" + ask + '\'' +
                    ", bidvol='" + bidvol + '\'' +
                    ", askvol='" + askvol + '\'' +
                    ", volume='" + volume + '\'' +
                    ", position='" + position + '\'' +
                    ", currentvol='" + currentvol + '\'' +
                    ", ticktime='" + ticktime + '\'' +
                    ", tradedate='" + tradedate + '\'' +
                    ", changepercent='" + changepercent + '\'' +
                    '}';
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getContract() {
            return contract;
        }

        public void setContract(String contract) {
            this.contract = contract;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTrade() {
            return trade;
        }

        public void setTrade(String trade) {
            this.trade = trade;
        }

        public String getSettlement() {
            return settlement;
        }

        public void setSettlement(String settlement) {
            this.settlement = settlement;
        }

        public String getPrevsettlement() {
            return prevsettlement;
        }

        public void setPrevsettlement(String prevsettlement) {
            this.prevsettlement = prevsettlement;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
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

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
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

        public String getBidvol() {
            return bidvol;
        }

        public void setBidvol(String bidvol) {
            this.bidvol = bidvol;
        }

        public String getAskvol() {
            return askvol;
        }

        public void setAskvol(String askvol) {
            this.askvol = askvol;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCurrentvol() {
            return currentvol;
        }

        public void setCurrentvol(String currentvol) {
            this.currentvol = currentvol;
        }

        public String getTicktime() {
            return ticktime;
        }

        public void setTicktime(String ticktime) {
            this.ticktime = ticktime;
        }

        public String getTradedate() {
            return tradedate;
        }

        public void setTradedate(String tradedate) {
            this.tradedate = tradedate;
        }

        public String getChangepercent() {
            return changepercent;
        }

        public void setChangepercent(String changepercent) {
            this.changepercent = changepercent;
        }
    }
}

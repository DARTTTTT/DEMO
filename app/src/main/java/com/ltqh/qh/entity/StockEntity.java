package com.ltqh.qh.entity;

import java.util.List;

public class StockEntity {


    /**
     * code : 1
     * msg : 请求成功
     * data : [{"symbol":"sh600519","code":"600519","name":"贵州茅台","trade":"899.000","pricechange":"34.000","changepercent":"3.931","buy":"899.600","sell":"899.600","settlement":"865.000","open":"900.000","high":"908.000","low":"890.120","volume":6521823,"amount":5851726965,"ticktime":"14:57:17","per":32.084,"pb":10.008,"mktcap":1.1293218222E8,"nmc":1.1293218222E8,"turnoverratio":0.51917},{"symbol":"sh603383","code":"603383","name":"顶点软件","trade":"118.670","pricechange":"10.790","changepercent":"10.002","buy":"118.670","sell":"118.670","settlement":"107.880","open":"109.950","high":"118.670","low":"104.760","volume":4941257,"amount":545171285,"ticktime":"14:57:17","per":117.495,"pb":13.755,"mktcap":1426577.1646,"nmc":688489.16304,"turnoverratio":8.51689},{"symbol":"sh600486","code":"600486","name":"扬农化工","trade":"71.870","pricechange":"6.530","changepercent":"9.994","buy":"0.000","sell":"0.000","settlement":"65.340","open":"71.870","high":"71.870","low":"70.100","volume":9216943,"amount":661758001,"ticktime":"14:57:14","per":24.877,"pb":4.812,"mktcap":2227243.444609,"nmc":2227243.444609,"turnoverratio":2.97418},{"symbol":"sh603379","code":"603379","name":"三美股份","trade":"62.160","pricechange":"5.650","changepercent":"9.998","buy":"0.000","sell":"0.000","settlement":"56.510","open":"62.160","high":"62.160","low":"62.160","volume":188843,"amount":11738481,"ticktime":"14:57:11","per":21.143,"pb":9.404,"mktcap":2710526.92428,"nmc":371305.058376,"turnoverratio":0.31614},{"symbol":"sh603086","code":"603086","name":"先达股份","trade":"44.450","pricechange":"4.040","changepercent":"9.998","buy":"0.000","sell":"0.000","settlement":"40.410","open":"44.450","high":"44.450","low":"44.450","volume":329653,"amount":14653076,"ticktime":"14:57:02","per":28.864,"pb":3.871,"mktcap":497840,"nmc":322323.587635,"turnoverratio":0.45461},{"symbol":"sh603639","code":"603639","name":"海利尔","trade":"42.500","pricechange":"3.860","changepercent":"9.990","buy":"0.000","sell":"0.000","settlement":"38.640","open":"42.500","high":"42.500","low":"42.500","volume":1204440,"amount":51188700,"ticktime":"14:57:11","per":17.49,"pb":3.785,"mktcap":719949.405,"nmc":230793.89125,"turnoverratio":2.21794},{"symbol":"sh603026","code":"603026","name":"石大胜华","trade":"39.250","pricechange":"3.570","changepercent":"10.006","buy":"39.250","sell":"39.250","settlement":"35.680","open":"37.680","high":"39.250","low":"36.580","volume":17505635,"amount":663148057,"ticktime":"14:57:17","per":38.861,"pb":4.923,"mktcap":795519,"nmc":795519,"turnoverratio":8.63708},{"symbol":"sh603709","code":"603709","name":"中源家居","trade":"39.440","pricechange":"3.560","changepercent":"9.922","buy":"39.450","sell":"39.450","settlement":"35.880","open":"36.580","high":"39.470","low":"36.000","volume":2360965,"amount":91186343,"ticktime":"14:57:19","per":28.58,"pb":5.6,"mktcap":315520,"nmc":78880,"turnoverratio":11.80483},{"symbol":"sh603896","code":"603896","name":"寿仙谷","trade":"45.060","pricechange":"2.970","changepercent":"7.056","buy":"45.070","sell":"45.070","settlement":"42.090","open":"42.280","high":"45.450","low":"42.030","volume":7404833,"amount":323154357,"ticktime":"14:57:17","per":59.289,"pb":6.559,"mktcap":645865.7076,"nmc":275120.589,"turnoverratio":12.12784},{"symbol":"sh600801","code":"600801","name":"华新水泥","trade":"31.430","pricechange":"2.860","changepercent":"10.011","buy":"31.430","sell":"31.430","settlement":"28.570","open":"28.980","high":"31.430","low":"28.500","volume":63562884,"amount":1878706003,"ticktime":"14:57:18","per":9.084,"pb":2.823,"mktcap":4706866.674475,"nmc":3057420.274475,"turnoverratio":6.53421}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "StockEntity{" +
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "symbol='" + symbol + '\'' +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", trade='" + trade + '\'' +
                    ", pricechange='" + pricechange + '\'' +
                    ", changepercent='" + changepercent + '\'' +
                    ", buy='" + buy + '\'' +
                    ", sell='" + sell + '\'' +
                    ", settlement='" + settlement + '\'' +
                    ", open='" + open + '\'' +
                    ", high='" + high + '\'' +
                    ", low='" + low + '\'' +
                    ", volume=" + volume +
                    ", amount=" + amount +
                    ", ticktime='" + ticktime + '\'' +
                    ", per=" + per +
                    ", pb=" + pb +
                    ", mktcap=" + mktcap +
                    ", nmc=" + nmc +
                    ", turnoverratio=" + turnoverratio +
                    '}';
        }

        /**
         * symbol : sh600519
         * code : 600519
         * name : 贵州茅台
         * trade : 899.000
         * pricechange : 34.000
         * changepercent : 3.931
         * buy : 899.600
         * sell : 899.600
         * settlement : 865.000
         * open : 900.000
         * high : 908.000
         * low : 890.120
         * volume : 6521823
         * amount : 5851726965
         * ticktime : 14:57:17
         * per : 32.084
         * pb : 10.008
         * mktcap : 1.1293218222E8
         * nmc : 1.1293218222E8
         * turnoverratio : 0.51917
         */



        private String symbol;
        private String code;
        private String name;
        private String trade;
        private String pricechange;
        private String changepercent;
        private String buy;
        private String sell;
        private String settlement;
        private String open;
        private String high;
        private String low;
        private int volume;
        private long amount;
        private String ticktime;
        private double per;
        private double pb;
        private double mktcap;
        private double nmc;
        private double turnoverratio;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public String getPricechange() {
            return pricechange;
        }

        public void setPricechange(String pricechange) {
            this.pricechange = pricechange;
        }

        public String getChangepercent() {
            return changepercent;
        }

        public void setChangepercent(String changepercent) {
            this.changepercent = changepercent;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }

        public String getSell() {
            return sell;
        }

        public void setSell(String sell) {
            this.sell = sell;
        }

        public String getSettlement() {
            return settlement;
        }

        public void setSettlement(String settlement) {
            this.settlement = settlement;
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

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public String getTicktime() {
            return ticktime;
        }

        public void setTicktime(String ticktime) {
            this.ticktime = ticktime;
        }

        public double getPer() {
            return per;
        }

        public void setPer(double per) {
            this.per = per;
        }

        public double getPb() {
            return pb;
        }

        public void setPb(double pb) {
            this.pb = pb;
        }

        public double getMktcap() {
            return mktcap;
        }

        public void setMktcap(double mktcap) {
            this.mktcap = mktcap;
        }

        public double getNmc() {
            return nmc;
        }

        public void setNmc(double nmc) {
            this.nmc = nmc;
        }

        public double getTurnoverratio() {
            return turnoverratio;
        }

        public void setTurnoverratio(double turnoverratio) {
            this.turnoverratio = turnoverratio;
        }
    }
}

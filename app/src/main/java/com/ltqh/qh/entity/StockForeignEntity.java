package com.ltqh.qh.entity;

import java.util.List;

public class StockForeignEntity {


    /**
     * code : 1
     * msg : 获取数据成功
     * data : {"count":"4536","data":[{"name":"BancoSantanderMexicoSAInstituciondeBancaMultiple","cname":"桑坦德银行墨西","category":"银行","symbol":"BSMX","price":"6.86","diff":"-0.08","chg":"-1.15","preclose":"6.94","open":"6.92","high":"6.93","low":"6.82","amplitude":"1.66%","volume":"856674","mktcap":"554668057869","pe":"9.14666684","market":"NYSE","category_id":"61"},{"name":"HSBCHoldingsPlc","cname":"HSBCHoldingsPlc","category":null,"symbol":"HSEA","price":"26.36","diff":"0.00","chg":"0.00","preclose":"26.36","open":"0.00","high":"0.00","low":"0.00","amplitude":"0.53%","volume":"0","mktcap":"539312419835","pe":"376.57143569","market":"NYSE","category_id":null},{"name":"BerkshireHathaway,Inc.","cname":"伯克希尔-哈撒韦B","category":"保险","symbol":"BRK.B","price":"203.88","diff":"-1.12","chg":"-0.55","preclose":"205.00","open":"204.91","high":"205.43","low":"203.59","amplitude":"0.90%","volume":"2599673","mktcap":"505622412109","pe":"125.85185450","market":"NYSE","category_id":"25"},{"name":"BerkshireHathaway,Inc.","cname":"伯克希尔-哈撒韦","category":"保险","symbol":"BRK.A","price":"306000.00","diff":"-1800.00","chg":"-0.58","preclose":"307800.00","open":"307000.00","high":"307900.00","low":"305417.00","amplitude":"0.81%","volume":"248","mktcap":"501840000000","pe":"126.33195885","market":"NYSE","category_id":"25"},{"name":"AlibabaGroupHoldingLtd.","cname":"阿里巴巴","category":null,"symbol":"BABA","price":"181.74","diff":"0.85","chg":"0.47","preclose":"180.89","open":"181.46","high":"183.56","low":"180.95","amplitude":"1.44%","volume":"8021500","mktcap":"469616174194","pe":"45.66331774","market":"NYSE","category_id":null},{"name":"DiageoPlc","cname":"帝亚吉欧公司","category":"饮料","symbol":"DEO","price":"163.90","diff":"0.53","chg":"0.32","preclose":"163.37","open":"163.75","high":"164.20","low":"163.32","amplitude":"0.54%","volume":"244308","mktcap":"411957709792","pe":"35.32327556","market":"NYSE","category_id":"74"},{"name":"Johnson&Johnson","cname":"强生公司","category":"制药","symbol":"JNJ","price":"137.71","diff":"-1.27","chg":"-0.91","preclose":"138.98","open":"139.01","high":"139.01","low":"136.91","amplitude":"1.51%","volume":"5517817","mktcap":"369358879084","pe":"24.20210990","market":"NYSE","category_id":"10"},{"name":"ExxonMobilCorp.","cname":"埃克森美孚公司","category":"","symbol":"XOM","price":"81.38","diff":"-0.35","chg":"-0.43","preclose":"81.73","open":"81.75","high":"81.95","low":"81.11","amplitude":"1.03%","volume":"7646036","mktcap":"344549064657","pe":"16.67622855","market":"NYSE","category_id":"710"},{"name":"JPMorganChase&Co.","cname":"摩根大通公司","category":"","symbol":"JPM","price":"105.14","diff":"0.50","chg":"0.48","preclose":"104.64","open":"104.60","high":"105.44","low":"104.33","amplitude":"1.06%","volume":"10295539","mktcap":"344228358002","pe":"11.64341113","market":"NYSE","category_id":"695"},{"name":"Visa,Inc.","cname":"维萨卡公司","category":"","symbol":"V","price":"157.78","diff":"0.52","chg":"0.33","preclose":"157.26","open":"157.66","high":"158.15","low":"156.75","amplitude":"0.89%","volume":"6215113","mktcap":"342382597351","pe":"33.85836995","market":"NYSE","category_id":"726"},{"name":"FomentoEconomicoMexicanoSABdeCV","cname":"FomentoEconomicoMexicanoSABdeCV","category":"饮料","symbol":"FMX","price":"92.81","diff":"-0.95","chg":"-1.01","preclose":"93.76","open":"93.72","high":"94.99","low":"92.50","amplitude":"2.66%","volume":"334761","mktcap":"332095519049","pe":"26.90144820","market":"NYSE","category_id":"74"},{"name":"HDFCBankLtd.","cname":"HDFC银行","category":"银行","symbol":"HDB","price":"115.59","diff":"0.29","chg":"0.25","preclose":"115.30","open":"115.15","high":"116.09","low":"114.75","amplitude":"1.16%","volume":"645452","mktcap":"296205146965","pe":null,"market":"NYSE","category_id":"61"},{"name":"Walmart,Inc.","cname":"沃尔玛公司","category":"零售","symbol":"WMT","price":"96.94","diff":"-0.88","chg":"-0.90","preclose":"97.82","open":"97.76","high":"98.31","low":"96.90","amplitude":"1.44%","volume":"6274042","mktcap":"286054443008","pe":"42.51754546","market":"NYSE","category_id":"52"},{"name":"BankofAmericaCorp.","cname":"美国银行公司","category":"银行","symbol":"BAC","price":"28.87","diff":"0.33","chg":"1.16","preclose":"28.54","open":"28.47","high":"28.87","low":"28.35","amplitude":"1.82%","volume":"66693996","mktcap":"278276494589","pe":"10.89433955","market":"NYSE","category_id":"61"},{"name":"BHPGroupPlc","cname":"必和必拓公司","category":"","symbol":"BBL","price":"49.85","diff":"0.10","chg":"0.20","preclose":"49.75","open":"49.74","high":"49.95","low":"49.62","amplitude":"0.66%","volume":"2149432","mktcap":"265201991882","pe":"53.60214848","market":"NYSE","category_id":"747"},{"name":"RoyalDutchShellPlc","cname":"荷兰皇家壳牌石油公司","category":"","symbol":"RDS.A","price":"63.51","diff":"0.23","chg":"0.36","preclose":"63.28","open":"63.44","high":"63.62","low":"63.25","amplitude":"0.58%","volume":"1947671","mktcap":"264836693001","pe":"11.32085505","market":"NYSE","category_id":"710"},{"name":"Procter&GambleCo.","cname":"宝洁公司","category":"","symbol":"PG","price":"103.75","diff":"0.11","chg":"0.11","preclose":"103.64","open":"103.61","high":"104.02","low":"103.27","amplitude":"0.72%","volume":"6088847","mktcap":"260889743360","pe":"24.64370524","market":"NYSE","category_id":"761"},{"name":"RoyalDutchShellPlc","cname":"荷兰皇家壳牌石油公司","category":null,"symbol":"RDS.B","price":"64.79","diff":"0.15","chg":"0.23","preclose":"64.64","open":"64.67","high":"64.97","low":"64.55","amplitude":"0.65%","volume":"1059913","mktcap":"259807903671","pe":"11.54901950","market":"NYSE","category_id":null},{"name":"EnelChileSA","cname":"EnelChileSA","category":null,"symbol":"ENIC","price":"5.17","diff":"-0.07","chg":"-1.34","preclose":"5.24","open":"5.25","high":"5.25","low":"5.17","amplitude":"1.53%","volume":"605698","mktcap":"253809782393","pe":"11.75000024","market":"NYSE","category_id":null},{"name":"NovartisAG","cname":"诺华公司","category":"生物技术和制药","symbol":"NVS","price":"94.88","diff":"-0.83","chg":"-0.87","preclose":"95.71","open":"94.82","high":"95.03","low":"94.68","amplitude":"0.37%","volume":"1606494","mktcap":"249260189584","pe":"17.50553430","market":"NYSE","category_id":"700"}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

    @Override
    public String toString() {
        return "StockForeignEntity{" +
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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 4536
         * data : [{"name":"BancoSantanderMexicoSAInstituciondeBancaMultiple","cname":"桑坦德银行墨西","category":"银行","symbol":"BSMX","price":"6.86","diff":"-0.08","chg":"-1.15","preclose":"6.94","open":"6.92","high":"6.93","low":"6.82","amplitude":"1.66%","volume":"856674","mktcap":"554668057869","pe":"9.14666684","market":"NYSE","category_id":"61"},{"name":"HSBCHoldingsPlc","cname":"HSBCHoldingsPlc","category":null,"symbol":"HSEA","price":"26.36","diff":"0.00","chg":"0.00","preclose":"26.36","open":"0.00","high":"0.00","low":"0.00","amplitude":"0.53%","volume":"0","mktcap":"539312419835","pe":"376.57143569","market":"NYSE","category_id":null},{"name":"BerkshireHathaway,Inc.","cname":"伯克希尔-哈撒韦B","category":"保险","symbol":"BRK.B","price":"203.88","diff":"-1.12","chg":"-0.55","preclose":"205.00","open":"204.91","high":"205.43","low":"203.59","amplitude":"0.90%","volume":"2599673","mktcap":"505622412109","pe":"125.85185450","market":"NYSE","category_id":"25"},{"name":"BerkshireHathaway,Inc.","cname":"伯克希尔-哈撒韦","category":"保险","symbol":"BRK.A","price":"306000.00","diff":"-1800.00","chg":"-0.58","preclose":"307800.00","open":"307000.00","high":"307900.00","low":"305417.00","amplitude":"0.81%","volume":"248","mktcap":"501840000000","pe":"126.33195885","market":"NYSE","category_id":"25"},{"name":"AlibabaGroupHoldingLtd.","cname":"阿里巴巴","category":null,"symbol":"BABA","price":"181.74","diff":"0.85","chg":"0.47","preclose":"180.89","open":"181.46","high":"183.56","low":"180.95","amplitude":"1.44%","volume":"8021500","mktcap":"469616174194","pe":"45.66331774","market":"NYSE","category_id":null},{"name":"DiageoPlc","cname":"帝亚吉欧公司","category":"饮料","symbol":"DEO","price":"163.90","diff":"0.53","chg":"0.32","preclose":"163.37","open":"163.75","high":"164.20","low":"163.32","amplitude":"0.54%","volume":"244308","mktcap":"411957709792","pe":"35.32327556","market":"NYSE","category_id":"74"},{"name":"Johnson&Johnson","cname":"强生公司","category":"制药","symbol":"JNJ","price":"137.71","diff":"-1.27","chg":"-0.91","preclose":"138.98","open":"139.01","high":"139.01","low":"136.91","amplitude":"1.51%","volume":"5517817","mktcap":"369358879084","pe":"24.20210990","market":"NYSE","category_id":"10"},{"name":"ExxonMobilCorp.","cname":"埃克森美孚公司","category":"","symbol":"XOM","price":"81.38","diff":"-0.35","chg":"-0.43","preclose":"81.73","open":"81.75","high":"81.95","low":"81.11","amplitude":"1.03%","volume":"7646036","mktcap":"344549064657","pe":"16.67622855","market":"NYSE","category_id":"710"},{"name":"JPMorganChase&Co.","cname":"摩根大通公司","category":"","symbol":"JPM","price":"105.14","diff":"0.50","chg":"0.48","preclose":"104.64","open":"104.60","high":"105.44","low":"104.33","amplitude":"1.06%","volume":"10295539","mktcap":"344228358002","pe":"11.64341113","market":"NYSE","category_id":"695"},{"name":"Visa,Inc.","cname":"维萨卡公司","category":"","symbol":"V","price":"157.78","diff":"0.52","chg":"0.33","preclose":"157.26","open":"157.66","high":"158.15","low":"156.75","amplitude":"0.89%","volume":"6215113","mktcap":"342382597351","pe":"33.85836995","market":"NYSE","category_id":"726"},{"name":"FomentoEconomicoMexicanoSABdeCV","cname":"FomentoEconomicoMexicanoSABdeCV","category":"饮料","symbol":"FMX","price":"92.81","diff":"-0.95","chg":"-1.01","preclose":"93.76","open":"93.72","high":"94.99","low":"92.50","amplitude":"2.66%","volume":"334761","mktcap":"332095519049","pe":"26.90144820","market":"NYSE","category_id":"74"},{"name":"HDFCBankLtd.","cname":"HDFC银行","category":"银行","symbol":"HDB","price":"115.59","diff":"0.29","chg":"0.25","preclose":"115.30","open":"115.15","high":"116.09","low":"114.75","amplitude":"1.16%","volume":"645452","mktcap":"296205146965","pe":null,"market":"NYSE","category_id":"61"},{"name":"Walmart,Inc.","cname":"沃尔玛公司","category":"零售","symbol":"WMT","price":"96.94","diff":"-0.88","chg":"-0.90","preclose":"97.82","open":"97.76","high":"98.31","low":"96.90","amplitude":"1.44%","volume":"6274042","mktcap":"286054443008","pe":"42.51754546","market":"NYSE","category_id":"52"},{"name":"BankofAmericaCorp.","cname":"美国银行公司","category":"银行","symbol":"BAC","price":"28.87","diff":"0.33","chg":"1.16","preclose":"28.54","open":"28.47","high":"28.87","low":"28.35","amplitude":"1.82%","volume":"66693996","mktcap":"278276494589","pe":"10.89433955","market":"NYSE","category_id":"61"},{"name":"BHPGroupPlc","cname":"必和必拓公司","category":"","symbol":"BBL","price":"49.85","diff":"0.10","chg":"0.20","preclose":"49.75","open":"49.74","high":"49.95","low":"49.62","amplitude":"0.66%","volume":"2149432","mktcap":"265201991882","pe":"53.60214848","market":"NYSE","category_id":"747"},{"name":"RoyalDutchShellPlc","cname":"荷兰皇家壳牌石油公司","category":"","symbol":"RDS.A","price":"63.51","diff":"0.23","chg":"0.36","preclose":"63.28","open":"63.44","high":"63.62","low":"63.25","amplitude":"0.58%","volume":"1947671","mktcap":"264836693001","pe":"11.32085505","market":"NYSE","category_id":"710"},{"name":"Procter&GambleCo.","cname":"宝洁公司","category":"","symbol":"PG","price":"103.75","diff":"0.11","chg":"0.11","preclose":"103.64","open":"103.61","high":"104.02","low":"103.27","amplitude":"0.72%","volume":"6088847","mktcap":"260889743360","pe":"24.64370524","market":"NYSE","category_id":"761"},{"name":"RoyalDutchShellPlc","cname":"荷兰皇家壳牌石油公司","category":null,"symbol":"RDS.B","price":"64.79","diff":"0.15","chg":"0.23","preclose":"64.64","open":"64.67","high":"64.97","low":"64.55","amplitude":"0.65%","volume":"1059913","mktcap":"259807903671","pe":"11.54901950","market":"NYSE","category_id":null},{"name":"EnelChileSA","cname":"EnelChileSA","category":null,"symbol":"ENIC","price":"5.17","diff":"-0.07","chg":"-1.34","preclose":"5.24","open":"5.25","high":"5.25","low":"5.17","amplitude":"1.53%","volume":"605698","mktcap":"253809782393","pe":"11.75000024","market":"NYSE","category_id":null},{"name":"NovartisAG","cname":"诺华公司","category":"生物技术和制药","symbol":"NVS","price":"94.88","diff":"-0.83","chg":"-0.87","preclose":"95.71","open":"94.82","high":"95.03","low":"94.68","amplitude":"0.37%","volume":"1606494","mktcap":"249260189584","pe":"17.50553430","market":"NYSE","category_id":"700"}]
         */

        private String count;
        private List<DataBean> data;

        @Override
        public String toString() {
            return "DataBeanX{" +
                    "count='" + count + '\'' +
                    ", data=" + data +
                    '}';
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * name : BancoSantanderMexicoSAInstituciondeBancaMultiple
             * cname : 桑坦德银行墨西
             * category : 银行
             * symbol : BSMX
             * price : 6.86
             * diff : -0.08
             * chg : -1.15
             * preclose : 6.94
             * open : 6.92
             * high : 6.93
             * low : 6.82
             * amplitude : 1.66%
             * volume : 856674
             * mktcap : 554668057869
             * pe : 9.14666684
             * market : NYSE
             * category_id : 61
             */

            private String name;
            private String cname;
            private String category;
            private String symbol;
            private String price;
            private String diff;
            private String chg;
            private String preclose;
            private String open;
            private String high;
            private String low;
            private String amplitude;
            private String volume;
            private String mktcap;
            private String pe;
            private String market;
            private String category_id;

            @Override
            public String toString() {
                return "DataBean{" +
                        "name='" + name + '\'' +
                        ", cname='" + cname + '\'' +
                        ", category='" + category + '\'' +
                        ", symbol='" + symbol + '\'' +
                        ", price='" + price + '\'' +
                        ", diff='" + diff + '\'' +
                        ", chg='" + chg + '\'' +
                        ", preclose='" + preclose + '\'' +
                        ", open='" + open + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", amplitude='" + amplitude + '\'' +
                        ", volume='" + volume + '\'' +
                        ", mktcap='" + mktcap + '\'' +
                        ", pe='" + pe + '\'' +
                        ", market='" + market + '\'' +
                        ", category_id='" + category_id + '\'' +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDiff() {
                return diff;
            }

            public void setDiff(String diff) {
                this.diff = diff;
            }

            public String getChg() {
                return chg;
            }

            public void setChg(String chg) {
                this.chg = chg;
            }

            public String getPreclose() {
                return preclose;
            }

            public void setPreclose(String preclose) {
                this.preclose = preclose;
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

            public String getAmplitude() {
                return amplitude;
            }

            public void setAmplitude(String amplitude) {
                this.amplitude = amplitude;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getMktcap() {
                return mktcap;
            }

            public void setMktcap(String mktcap) {
                this.mktcap = mktcap;
            }

            public String getPe() {
                return pe;
            }

            public void setPe(String pe) {
                this.pe = pe;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }
        }
    }
}

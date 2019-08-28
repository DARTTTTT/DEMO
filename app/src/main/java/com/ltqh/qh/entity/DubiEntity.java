package com.ltqh.qh.entity;

import java.util.List;

public class DubiEntity {


    /**
     * code : 1
     * msg : 获取数据成功
     * data : [{"date":"2019-02-26 10:10","title":"阿森纳俱乐部推出收藏品App 使用区块链记录交易","good":"182","low":"75","txt":"据MobileMarketer消息，英国职业足球队阿森纳俱乐部近日发布公告，将与体育科技公司Fantastec合作，推出名为Fantastec Swap的App，球迷可在App上查找、收集和交易官方授权的俱乐部收藏品。Fantastec Swap使用区块链技术记录在线交易记录，可实时反馈库存情况。"},{"date":"2019-02-26 10:04","title":"OceanEx交易所宣布与CertiK展开战略合作","good":"160","low":"215","txt":"近日，数字交易平台OceanEx与区块链安全公司CertiK达成战略合作。OceanEx是唯链（VeChain）旗下的AI数字资产交易平台，此次与CertiK的合作旨在通过其全球领先的形式化验证技术为平台提供代码审计、渗透测试、防御部署等一系列安全解决方案，共同为广大用户提供安全流畅的数字资产交易环境。"},{"date":"2019-02-26 10:02","title":"世界经济论坛区块链负责人：WEF将很快发布CBDC相关白皮书","good":"255","low":"382","txt":"据Crypto Globe消息，近日，世界经济论坛（World Economic Forum）区块链负责人Sheila Warren在接受采访时表示，相信央行数字*会有实际用例。她称，世界经济论坛正在全球范围内积极跟踪央行数字*（CBDC）实验，并创建了一个由全球大约40家央行（包括前沿和七国集团经济体）组成的值得信赖的共同体，这些央行正在分享经验和新发现。世界经济论坛很快将发布一份与CBDC相关的白皮书，将包括了解您的客户(KYC)和反洗钱(AML)要求内容。"},{"date":"2019-02-26 10:01","title":"区块链或成今年两会热点话题","good":"258","low":"287","txt":"据中国科技网消息，统计显示，今年各省市两会期间，越来越多的地方政府在报告中提到要发展区块链技术。区块链技术或许会成为今年全国两会期间另一个值得关注的话题。2019年，有四个省级政府工作报告将区块链列入其中。云南、福建提出将区块链作为当地数字化建设的组成部分；山东省提出将区块链应用到融媒体领域；重庆市直接提出要推动区块链的发展。此外，河北省会石家庄和湖南省会长沙市也明确提出了要发展区块链产业。"},{"date":"2019-02-26 10:00","title":"EOS、TRX、BCH、XMR、DASH、MKR等项目已偏离正常市值区间","good":"244","low":"220","txt":"据TokenGazer量化研究模型显示，当前（2月26日）EOS、TRX、BCH、XMR、DASH、MKR等项目已偏离正常市值区间，投资者应谨慎投资。"},{"date":"2019-02-26 09:54","title":"ENJ大幅拉升 24h涨幅达119.56%","good":"393","low":"380","txt":"CoinMarketCap数据显示，ENJ从昨日早间开始持续拉升，今早再创反弹新高，短短一日内最高涨幅达超200%。ENJ现报0.085*，24h涨幅达119.56%。昨日据知情人士称，Enjin Wallet已被三星委托负责其新款Galaxy S10智能手机中的区块链钱包。"},{"date":"2019-02-26 09:50","title":"XRP领涨主流币 24小时涨幅超8%","good":"292","low":"256","txt":"据huobi global数据显示，XRP领涨主流币，日内涨幅达到4.96%，24小时涨幅达8.25%，当前在0.325 USDT附近盘整。行情变化较大，请做好风险控制。"},{"date":"2019-02-26 09:42","title":"天津开发区信息技术产业将开拓区块链等崭新领域","good":"607","low":"423","txt":"据人民网消息，2月25日，天津开发区管委会召开新闻发布会。据介绍，天津开发区将继续做大做强四大优势产业集群，分别为新一代信息技术、汽车制造和服务、新型石化、以新经济为代表的现代服务业。到2025年，开发区信息技术产业要巩固终端、元件等优势基础，开拓人工智能、区块链等崭新领域，主营业务收入达2000亿元。"},{"date":"2019-02-26 09:41","title":"A股开盘：区块链板块开涨2.27%","good":"552","low":"383","txt":"A股开盘，区块链板块开涨2.27%。80只概念股中，31涨2平47跌。上涨前三为：华软科技（+10.08%）、奥马电器（+10.06%）、梦网集团（+10.05%）；跌幅前三为：数字认证（-3.84%）、暴风集团（-2.59%）、中元股份（-2.12%）。"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "DubiEntity{" +
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
         * date : 2019-02-26 10:10
         * title : 阿森纳俱乐部推出收藏品App 使用区块链记录交易
         * good : 182
         * low : 75
         * txt : 据MobileMarketer消息，英国职业足球队阿森纳俱乐部近日发布公告，将与体育科技公司Fantastec合作，推出名为Fantastec Swap的App，球迷可在App上查找、收集和交易官方授权的俱乐部收藏品。Fantastec Swap使用区块链技术记录在线交易记录，可实时反馈库存情况。
         */

        private String date;
        private String title;
        private String good;
        private String low;
        private String txt;

        @Override
        public String toString() {
            return "DataBean{" +
                    "date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", good='" + good + '\'' +
                    ", low='" + low + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }
}

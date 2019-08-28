package com.ltqh.qh.entity;

import java.io.Serializable;
import java.util.List;

public class StocknewsEntity implements Serializable{


    /**
     * code : 1
     * msg : 获取成功
     * data : [{"title":"超越日本！香港股市成为全球第三大股票市场","time":"2019-04-10 15:29:39","images":"http://cms-bucket.ws.126.net/2019/04/10/6181a93c803948518b731f516a0b9bd8.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0410/15/ECDMQBSM00258152.html","keywords":["港股","股市","a股"]},{"title":"小米发言人透露：雷军年薪至少达98.18亿元","time":"2019-04-09 09:11:15","images":"http://cms-bucket.ws.126.net/2019/04/09/39c2b77029d94cf7a615cdd152626889.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0409/10/ECAKB47J002580S6.html","keywords":["雷军","小米","华为"]},{"title":"联想拟出清安华农险7200万股股权 保险版图再收缩","time":"2019-04-09 00:00:00","images":"http://cms-bucket.ws.126.net/2019/04/09/649008a1be1749b597d8853560567e75.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0409/02/EC9OHKK2002580S6.html","keywords":["农险","安华","股权"]},{"title":"恒指重上3万点 港股市场生态有哪些变化","time":"2019-04-09 00:00:00","images":"http://cms-bucket.ws.126.net/2019/04/09/3fcfe257c1034ea290ab6bbc777c827e.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0409/02/EC9OHKDM002580S6.html","keywords":["港股","恒生电子","恒指"]},{"title":"清明节港股休市 下周五起港股将迎来4天小长假","time":"2019-04-05 11:04:23","images":"http://cms-bucket.ws.126.net/2019/04/05/d78cb4b0b1a14fc19ab16451be5dc1f8.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0405/11/EC0BL1MM00258152.html","keywords":["休市","港股","港交所"]},{"title":"连亏4年 80后祝媛＂接班＂雨润食品能翻身吗","time":"2019-04-04 10:03:38","images":"http://cms-bucket.ws.126.net/2019/04/04/0f14cb3b293e4565974b086bb6ee5dfd.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0404/10/EBTLP3CS0025813E.html","keywords":["雨润食品","祝媛","雨润集团"]},{"title":"岁宝百货放量大涨近17% 低价港股频现异动","time":"2019-04-04 00:00:00","images":"http://cms-bucket.ws.126.net/2019/04/04/e063ca36688c4e9eabc5b08f638af49e.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0404/03/EBSUA64E002580S6.html","keywords":["港股","股价","个股"]},{"title":"欢喜传媒去年亏损近5亿港元 试水影视前景难料","time":"2019-04-03 08:39:43","images":"http://cms-bucket.ws.126.net/2019/04/03/322edba2885c4a02a8c6163ce58d7716.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0403/09/EBR18SG3002580S6.html","keywords":["影视","张艺谋","王家卫"]},{"title":"海底捞\u201c涮\u201d出历史新高 \u201c后厨股\u201d涨势更凶","time":"2019-04-03 08:08:30","images":"http://cms-bucket.ws.126.net/2019/04/03/b7ee04feb5f44b79b462f6546c423646.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0403/08/EBQSPI8T00258152.html","keywords":["海底捞","餐饮","火锅"]},{"title":"凶猛！3月北向资金成交首破万亿 约6成港股交易额","time":"2019-04-02 07:47:06","images":"http://cms-bucket.ws.126.net/2019/04/02/02cf4496919549a5ab6296cce5f0f8d5.png?imageView&thumbnail=140y88","content_url":"https://money.163.com/19/0402/07/EBO95L7100258152.html","keywords":["孖展","港股","融资"]},{"title":"香港恒生指数涨0.56% 中国恒大跌3.33%","time":"2019-03-27 16:18:01","images":"http://cms-bucket.ws.126.net/2019/03/27/645e035412594248900b910d7c021699.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0327/16/EB9OBLB8002580S6.html","keywords":["恒生电子","恒指","美股"]},{"title":"香港恒生指数涨0.15% 腾讯控股跌0.68%","time":"2019-03-26 16:19:01","images":"http://cms-bucket.ws.126.net/2019/03/26/032b07af0f774527bc419dc5dcdd26b7.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0326/16/EB75SRNE002580S6.html","keywords":["美债","恒生电子","恒指"]},{"title":"获中金看高至70元评级＂买入＂瑞声科技续涨5%","time":"2019-03-25 11:01:13","images":"http://cms-bucket.ws.126.net/2019/03/25/65533e73e0ab4fa696689f57d35a4891.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0325/11/EB413BBB0025813E.html","keywords":["瑞声","中金"]},{"title":"私有化议案获得通过 合和实业股价走强","time":"2019-03-22 10:49:13","images":"http://cms-bucket.ws.126.net/2019/03/22/fd5266693c6c44e191bd65eb15ffb9ef.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0322/10/EAS976U70025813E.html","keywords":["私有化","合和","股价"]},{"title":"美股收跌 港股接下来如何表演?","time":"2019-03-22 09:45:55","images":"http://cms-bucket.ws.126.net/2019/03/22/399e0a7d68094388a4d29b80c54edc18.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0322/09/EAS5JA130025813E.html","keywords":["美股","港股","*指数"]},{"title":"三大运营商\u201c成绩单\u201d：中国移动超电信联通总和","time":"2019-03-21 14:26:47","images":"http://cms-bucket.ws.126.net/2019/03/21/3b21c0ed7f7041d1b0f7d0265f5069ca.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0321/14/EAQ3RE0O002580S6.html","keywords":["中国移动","三大运营商"]},{"title":"富汇建筑控股大跌 港证监会指其股权集中","time":"2019-03-20 15:17:19","images":"http://cms-bucket.ws.126.net/2019/03/20/b3eff68d8cbc468bbb7cba41877769fb.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0320/15/EANJOMFU0025813E.html","keywords":["证监会","富汇","股权"]},{"title":"敏实集团挫逾4%：曾遭野村重申\u201c减持\u201d","time":"2019-03-20 15:10:03","images":"http://cms-bucket.ws.126.net/2019/03/20/0eae8c8b7dca495cbd171240eafb2519.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0320/15/EANJBC490025813E.html","keywords":["敏实","野村","年报"]},{"title":"小米转型中高端市场 阵痛之中强调不做饥饿营销","time":"2019-03-20 12:46:37","images":"http://cms-bucket.ws.126.net/2019/03/20/589f6e7eabb64e0e949942a75b9f0967.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0320/13/EANCFQQU002580S6.html","keywords":["小米","饥饿营销","雷军"]},{"title":"小米半天市值缩水100亿港元 股权激励开支拖累利润","time":"2019-03-20 12:10:00","images":"http://cms-bucket.ws.126.net/2019/03/20/fa0f91711d6248888e69967b60d642c9.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0320/13/EANE0MGL002580S6.html","keywords":["雷军","小米","股权"]},{"title":"腾讯被曝启动中层管理干部裁撤 比例高达10%","time":"2019-03-19 09:15:32","images":"http://cms-bucket.ws.126.net/2019/03/19/7b70dc7d7a3348e6b1757411db5ea46e.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0319/09/EAKCLH7200258105.html","keywords":["腾讯","刘炽平","马化腾"]},{"title":"终止港股转投科创板 赛特斯六年五换赛道","time":"2019-03-19 02:21:51","images":"http://cms-bucket.ws.126.net/2019/03/19/7cf409ec6b2542839a0af3e90becd0a6.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0319/02/EAJLB3J8002580S6.html","keywords":["赛特斯","港股","ipo"]},{"title":"奥园健康每股定价3.66港元 3月18日上市","time":"2019-03-15 11:50:25","images":"http://cms-bucket.ws.126.net/2019/03/15/bf3e1360420f4edf87bf5cba953f8ce1.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0315/11/EAABU8L90025813E.html","keywords":["奥园","上市","发售"]},{"title":"香港证监会出手\u201c亮剑\u201d 4家国际巨头被罚8亿港元","time":"2019-03-15 08:00:15","images":"http://cms-bucket.ws.126.net/2019/03/15/9436e1c541c84b72866fef047bc8ecf0.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0315/08/EA9UOPG400258152.html","keywords":["证监会","香港","投行"]},{"title":"受A股猪肉板块走弱拖累 雨润食品跌近9%","time":"2019-03-14 14:34:06","images":"http://cms-bucket.ws.126.net/2019/03/14/a51e8ff4eb1c4eba900980f017a28edf.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0314/14/EA82T8650025813E.html","keywords":["雨润食品","a股","万洲国际"]},{"title":"A股市场又开始转向 恒指向下机会大","time":"2019-03-14 09:37:36","images":"http://cms-bucket.ws.126.net/2019/03/14/f83a74fd12ac4fca90dd354a1907a67a.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0314/09/EA7HUBAU0025813E.html","keywords":["a股市场","港股","恒指"]},{"title":"平安回应科创板:银行证券等一条龙服务科创企业","time":"2019-03-13 16:46:41","images":"http://cms-bucket.ws.126.net/2019/03/13/7609f7fdf9d04af08a52181d2a30e9a5.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0313/16/EA5OCQ16002580S6.html","keywords":["中国平安","证券","信托"]},{"title":"鼎益丰被剔出恒生指数 又遭基金下调估值至","time":"2019-03-13 14:24:07","images":"http://cms-bucket.ws.126.net/2019/03/13/56d8162f0c3e4fc79c68e70f78437a26.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0313/14/EA5FU8DE0025813E.html","keywords":["恒生电子","益丰","基金"]},{"title":"18年净利预增2.3-2.6倍 嘉瑞国际午后一度涨50%","time":"2019-03-13 14:10:57","images":"http://cms-bucket.ws.126.net/2019/03/13/297f8632318a48f4bfcc33f96ea51336.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0313/14/EA5F64EO0025813E.html","keywords":["嘉瑞","持有人","成交额"]},{"title":"美团点评一度大跌:网络订餐食品问题被约谈","time":"2019-03-13 14:03:38","images":"http://cms-bucket.ws.126.net/2019/03/13/6c06e9e251084d38b1873d3fd6383cbf.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0313/14/EA5EOO1Q0025813E.html","keywords":["美团","外卖","饿了么"]},{"title":"＂羚邦集团＂赴港上市 九成以上收益源于日本动画","time":"2019-03-13 11:25:47","images":"","content_url":"http://money.163.com/19/0313/11/EA55NMH90025813D.html","keywords":["日本","动画","羚邦"]},{"title":"财通证券技术人员吃警示函 引发交易系统登录异常","time":"2019-03-12 12:11:13","images":"","content_url":"http://money.163.com/19/0312/12/EA2LU6960025812C.html","keywords":["证券"]},{"title":"年度股东应占溢利降25.67% 当代置业跌近7%","time":"2019-03-12 10:19:05","images":"http://cms-bucket.ws.126.net/2019/03/12/e332371f90f24121a3f2fa89aecafe10.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0312/10/EA2FGRDN0025813E.html","keywords":["置业","*贬值","溢利"]},{"title":"转主板上市获批 展程控股升逾6%","time":"2019-03-12 09:55:44","images":"http://cms-bucket.ws.126.net/2019/03/12/e2d90e533cfc4b658cb23dd89d8c7715.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0312/09/EA2E63S40025813E.html","keywords":["程控股","上市","联交所"]},{"title":"欧美股市向好 港股今日继续反弹?","time":"2019-03-12 09:30:21","images":"http://cms-bucket.ws.126.net/2019/03/12/4b4518168e474024b3bfd1c2c19a88d9.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0312/09/EA2CNKBH0025813E.html","keywords":["港股","股市","美股"]},{"title":"外资将添风险对冲工具:港交所与MSCI推A股期指","time":"2019-03-12 08:32:00","images":"http://cms-bucket.ws.126.net/2019/03/12/54238eb8334a4dde93c057010c6945bd.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0312/08/EA29P0SS002580S6.html","keywords":["msci","港交所","a股"]},{"title":"周黑鸭回应沽空机构质疑 坚持直营模式业绩掉队","time":"2019-03-12 04:48:38","images":"http://cms-bucket.ws.126.net/2019/03/12/c9e7bb28dfc64bf88e722148c3c24d60.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0312/05/EA1TKFAG002580S6.html","keywords":["周黑鸭","直营","煌上煌"]},{"title":"遭\u201c空军\u201d狙击 中国中药股价为何仍坚挺？","time":"2019-03-08 09:58:09","images":"http://cms-bucket.ws.126.net/2019/03/08/1195631818f24d7abab92e9b7d59b58b.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0308/09/E9O4NKPG0025813E.html","keywords":["中国","中药","股价"]},{"title":"美股持续调整 恒指今日或窄幅震荡向下","time":"2019-03-08 09:12:35","images":"http://cms-bucket.ws.126.net/2019/03/08/46ef2611397b4ddebb2eb55458cc940f.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0308/09/E9O247GR0025813E.html","keywords":["美股","恒指","港股"]},{"title":"将于3月20号披露年报 美图(01357涨近10%","time":"2019-03-07 11:43:31","images":"http://cms-bucket.ws.126.net/2019/03/07/4486e5a910ed436bbb108e8203217829.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/11/E9LOBS0D0025813E.html","keywords":["股价","app","年报"]},{"title":"遭大摩看淡至9元评级\u201c减持\u201d 吉利跌6.45%","time":"2019-03-07 11:40:07","images":"http://cms-bucket.ws.126.net/2019/03/07/01cbc1ae495f402a8e038982345e1607.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/11/E9LO5KIQ0025813E.html","keywords":["吉利汽车","成交额"]},{"title":"彩客化学延续强势 早盘升幅一度扩大至28%","time":"2019-03-07 11:19:06","images":"http://cms-bucket.ws.126.net/2019/03/07/af608dca334747b88accbebc911b1471.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/11/E9LMV4S40025813E.html","keywords":["早盘","化学","app"]},{"title":"2018年度业绩增长不及预期 IGG复牌跌超5%","time":"2019-03-07 10:46:12","images":"http://cms-bucket.ws.126.net/2019/03/07/929751b9f51f467f84699b71520dc968.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/10/E9LL2T8B0025813E.html","keywords":["igg","复牌","财务"]},{"title":"拟进行股本重组 港股中国金控飙涨60%","time":"2019-03-07 10:11:46","images":"http://cms-bucket.ws.126.net/2019/03/07/7b964e96b2484a13ab15b6fa068881ca.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/10/E9LJ3RRQ0025813E.html","keywords":["股本","金控","中国"]},{"title":"外围无重大利空 恒指或企稳29000","time":"2019-03-07 09:15:51","images":"http://cms-bucket.ws.126.net/2019/03/07/35956c446662431fb469e22021f6285d.png?imageView&thumbnail=140y88","content_url":"http://money.163.com/19/0307/09/E9LFTFA10025813E.html","keywords":["恒指","港股","美股"]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "StocknewsEntity{" +
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

    public static class DataBean implements Serializable {
        /**
         * title : 超越日本！香港股市成为全球第三大股票市场
         * time : 2019-04-10 15:29:39
         * images : http://cms-bucket.ws.126.net/2019/04/10/6181a93c803948518b731f516a0b9bd8.png?imageView&thumbnail=140y88
         * content_url : https://money.163.com/19/0410/15/ECDMQBSM00258152.html
         * keywords : ["港股","股市","a股"]
         */

        private String title;
        private String time;
        private String images;
        private String content_url;
        private List<String> keywords;

        @Override
        public String toString() {
            return "DataBean{" +
                    "title='" + title + '\'' +
                    ", time='" + time + '\'' +
                    ", images='" + images + '\'' +
                    ", content_url='" + content_url + '\'' +
                    ", keywords=" + keywords +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getContent_url() {
            return content_url;
        }

        public void setContent_url(String content_url) {
            this.content_url = content_url;
        }

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }
    }
}

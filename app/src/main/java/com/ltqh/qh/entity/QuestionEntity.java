package com.ltqh.qh.entity;

import java.util.List;

public class QuestionEntity {


    /**
     * code : 1
     * msg : 获取成功
     * data : [{"id":4975237,"content":"某公司拟上市发行股票，已知股票每股面额为1元，按照我国《公司法》要求，该公司的股票发行价格可以是()元。 ①20 ②0．5 ③1 ④5．4","answer":"①③④","analysis":"考点：我国《公司法》规定，股票发行价格可以按票面金额，也可以超过票面金额，但不得低于票面金额。","optionList":["①④","①③④","①②④","②③"]},{"id":5025569,"content":"负责提升证券化产品信用等级的机构是( )。","answer":"信用增级机构","analysis":"信用增级机构负责提升证券化产品的信用等级，为此要向特定目的机构收取相应费用，并在证券违约时承担赔偿责任。","optionList":["资金和资产存管机构","特定目的机构","信用评级机构","信用增级机构"]},{"id":4975405,"content":"非证券金融市场包括()。 ①信托市场 ②股权投资市场 ③保险市场 ④债券市场","answer":"①②③","analysis":"考点：本题主要考查非证券金融市场的外延。非证券金融市场，是指以有价证券以外的金融资产为对象的发行和交易关系的总和，包括股权投资市场、信托市场、融资租赁市场、市场、黄金市场、保险市场、银行理财产品市场、长期贷款市场等。","optionList":["①②③","①②④","②③④","①③④"]},{"id":4975362,"content":"中央政府发行债券被视为()。","answer":"无风险债券","analysis":"考点：考查政府和政府机构发行债券特点。通常情况下，中央政府债券不存在违约风险，因此，被视为无风险债券。","optionList":["高风险债券","低风险债券","无风险债券","一般风险债券"]},{"id":5065521,"content":"中央银行票据，是央行为调节基础*而直接面向公开市场业务一级交易商发行的短期债券，期限通常在（ ）。","answer":"3个月到3年","analysis":"中国人民银行从2003年起开始发行中央银行票据，期限从3个月到3年。","optionList":["3个月到3年","3个月到6个月","6个月到3年","3个月到1年"]},{"id":5025562,"content":"下列关于股东表决权的说法中，不正确的是( )。","answer":"普通股股东只能自己出席股东大会，不得委托他人代理出席并代其行使表决权","analysis":"D项，股东可以亲自出席股东大会，也可委托代理人出席股东会议。代理人应当向公司提交股东授权委托书，并在授权范围内行使表决权。","optionList":["普通股票股东对公司重大决策参与权是通过参加股东大会，行使表决权实现的","股东每持有一份股份，就有一份表决权","对于各个股东来说，其表决权的数量视其购买的股票份数而定","普通股股东只能自己出席股东大会，不得委托他人代理出席并代其行使表决权"]},{"id":4161838,"content":"回购交易通常情况下只有（\u2003\u2003）小时，是一种超短期的金融工具。","answer":"24","analysis":"回购交易长的有几个月，但通常情况下只有24小时，是一种超短期的金融工具。","optionList":["6","12","18","24"]},{"id":4161809,"content":"在资本市场上占有重要地位的国债是（\u2003\u2003）。","answer":"长期国债","analysis":"长期国债是指偿还期限在10年或l0年以上的国债。长期国债由于期限长，政府短期内无偿还的负担，而且可以较长时间占用国债认购者的资金，所以常被用作政府投资的资金来源。长期国债在资本市场上有着重要的地位。","optionList":["无期限国债","长期国债","*","短期国债"]},{"id":4975438,"content":"以下关于封闭式基金的说法正确的有()。 ①封闭式基金的基金份额在封闭期内不能赎回 ②持有人可以进行场外交易 ③封闭式基金的存续期固定但可以适当延长 ④封闭式基金的基金规模在封闭期限内未经法定程序认可不能增加发行","answer":"①③④","analysis":"解析：考查关于封闭式基金的特点，封闭式基金的持有人只能在证券交易场所交易。","optionList":["①②③","②③④","①②④","①③④"]},{"id":4770161,"content":"中央银行充当商业银行和其他金融机构的最后贷款人，体现了中央银行是( )职能。","answer":"银行的银行","analysis":"银行的银行职能是指中央银行充当商业银行和其他金融机构的最后贷款人。银行的银行这一职能体现了中央银行是特殊金融机构的性质，是中央银行作为金融体系核心的基本条件。","optionList":["银行的银行","发行的银行","政府的银行","市场的银行"]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "QuestionEntity{" +
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
         * id : 4975237
         * content : 某公司拟上市发行股票，已知股票每股面额为1元，按照我国《公司法》要求，该公司的股票发行价格可以是()元。 ①20 ②0．5 ③1 ④5．4
         * answer : ①③④
         * analysis : 考点：我国《公司法》规定，股票发行价格可以按票面金额，也可以超过票面金额，但不得低于票面金额。
         * optionList : ["①④","①③④","①②④","②③"]
         */

        private int id;
        private String content;
        private String answer;
        private String analysis;
        private List<String> optionList;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", content='" + content + '\'' +
                    ", answer='" + answer + '\'' +
                    ", analysis='" + analysis + '\'' +
                    ", optionList=" + optionList +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getAnalysis() {
            return analysis;
        }

        public void setAnalysis(String analysis) {
            this.analysis = analysis;
        }

        public List<String> getOptionList() {
            return optionList;
        }

        public void setOptionList(List<String> optionList) {
            this.optionList = optionList;
        }
    }
}

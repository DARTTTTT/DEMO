package com.ltqh.qh.entity;

import java.util.List;

public class TestEntity {


    /**
     * code : 200
     * key : ez
     * data : [{"code":"ok","id":1,"type":"Android","value":"https://dl10.jytqh.com"},{"code":"ok","id":2,"type":"Android","value":"https://dl11.jytqh.com"},{"code":"ok","id":3,"name":"信仰原油交易","type":"Android","value":"https://wy1.zcmrr.com"},{"code":"ok","id":4,"name":"牛人期货","type":"Android","value":"https://wy2.zcmrr.com"},{"code":"ok","id":5,"name":"指金期货","type":"Android","value":"https://wy3.zcmrr.com"},{"code":"ok","id":6,"name":"鸿运期货","type":"Android","value":"https://wy4.zcmrr.com"},{"code":"ok","id":7,"name":"期货原油交易大师","type":"Android","value":"https://dl2.jytqh.com"},{"code":"ok","id":8,"name":"日盛操盘","type":"Android","value":"https://qs7.zcmrr.com"},{"code":"ok","id":9,"name":"原油期货通","type":"Android","value":"https://www.jytqh.com"},{"code":"ok","id":10,"name":"丁焱期货","type":"Android","value":"https://www.dyqh88.com"},{"code":"ok","id":11,"name":"众投期货","type":"Android","value":"https://ry8.zcmrr.com"},{"code":"ok","id":12,"name":"文华期货","type":"Android","value":"https://js9.zcmrr.com"},{"code":"ok","id":13,"name":"贵金属期货宝","type":"Android","value":"https://gf1.jytqh.com"},{"code":"ok","id":14,"name":"pro测试版","type":"Android","value":"https://pro.sd338online.com"},{"code":"ok","id":15,"name":"犇鑫国际","type":"Android","value":"https://qs7.zcmrr.com"}]
     * msg : 查询成功
     */

    private int code;
    private String key;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "TestEntity{" +
                "code=" + code +
                ", key='" + key + '\'' +
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
         * code : ok
         * id : 1
         * type : Android
         * value : https://dl10.jytqh.com
         * name : 信仰原油交易
         */

        private String code;
        private int id;
        private String type;
        private String value;
        private String name;

        @Override
        public String toString() {
            return "DataBean{" +
                    "code='" + code + '\'' +
                    ", id=" + id +
                    ", type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

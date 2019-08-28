package com.ltqh.qh.operation.entity;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

public class OBannerEntity  {


    /**
     * carousels : [{"brand":"LT","expire":{"date":1,"day":6,"hours":0,"minutes":0,"month":5,"seconds":0,"time":1559318400000,"timezoneOffset":-480,"year":119},"key":"/trade&CL1907","mcname":"XM恭喜","time":{"date":27,"day":1,"hours":9,"minutes":0,"month":4,"seconds":0,"time":1558918800000,"timezoneOffset":-480,"year":119},"url":"https://julian.oss-cn-beijing.aliyuncs.com/panda/XM恭喜6.png"},{"brand":"LT","expire":{"date":1,"day":0,"hours":0,"minutes":0,"month":2,"seconds":0,"time":1582992000000,"timezoneOffset":-480,"year":120},"key":"#/activity/freeGift","mcname":"XMAPP下载","time":{"date":12,"day":2,"hours":13,"minutes":30,"month":2,"seconds":27,"time":1552368627000,"timezoneOffset":-480,"year":119},"url":"https://julian.oss-cn-beijing.aliyuncs.com/panda/XMAPP下载.png"},{"brand":"LT","expire":{"date":1,"day":0,"hours":0,"minutes":0,"month":2,"seconds":0,"time":1582992000000,"timezoneOffset":-480,"year":120},"key":"/activity/freeGift","mcname":"XM双重送","time":{"date":12,"day":2,"hours":13,"minutes":30,"month":2,"seconds":27,"time":1552368627000,"timezoneOffset":-480,"year":119},"url":"https://julian.oss-cn-beijing.aliyuncs.com/panda/XM%E5%8F%8C%E9%87%8D%E9%80%81.png"}]
     * notices : [{"brand":"","content":"<p>尊敬的用户：<\/p>\r\n\r\n<p>因5月27日为美国阵亡将士纪念日，<b><font  color=\"CORAL\">EIA原油库存数据<\/font><\/b>将推迟至<b><font  color=\"MAGENTA\">2019年05月30日23:00分<\/font><\/b>公布，请广大用户知悉。<\/p>\r\n<p><font  color=\"DODGERBLUE\">为降低剧烈行情造成的风险，请用户合理选择保证金档位，祝您操盘顺利！<\/font><\/p>","expire":{"date":5,"day":3,"hours":0,"minutes":0,"month":5,"seconds":0,"time":1559664000000,"timezoneOffset":-480,"year":119},"id":11917,"time":{"date":29,"day":3,"hours":15,"minutes":10,"month":4,"seconds":37,"time":1559113837000,"timezoneOffset":-480,"year":119},"title":"EIA数据延迟公布通知","top":false,"url":""},{"brand":"","content":"<p>尊敬的用户：<\/p>\r\n<p>根据纽约交易所、香港交易所、新加坡交易所合约交易规则，<font  color=\"CORAL\">美黄金（GC1906）、恒指（HSI1905）、小恒指（MHI1905）、富时A50（CN1905）<\/font>合约到期<font  color=\"CORAL\">不再交易<\/font>，交易合约更换为<b><font  color=\"MAGENTA\">GC1908、HSI1906、MHI1906、CN1906。<\/font><\/b>。<\/p>\r\n<p><font  color=\"DODGERBLUE\">请用户留意新旧合约价格差异，以最新合约成交价为准。<\/font><\/p>","expire":{"date":5,"day":3,"hours":0,"minutes":0,"month":5,"seconds":0,"time":1559664000000,"timezoneOffset":-480,"year":119},"id":11910,"time":{"date":29,"day":3,"hours":9,"minutes":25,"month":4,"seconds":43,"time":1559093143000,"timezoneOffset":-480,"year":119},"title":"美黄金，恒指，小恒指，富时A50合约更换提醒","top":false,"url":""},{"brand":"","content":"<p>尊敬的用户：<\/p>\r\n<p>　　根据上海国际能源交易中心合约交易规则，<font  color=\"CORAL\">原油期货（SC1906）<\/font>合约到期<font  color=\"CORAL\">不再交易<\/font>，交易合约更换为<b><font  color=\"MAGENTA\">SC1907<\/font><\/b>。<\/p>\r\n<p><font  color=\"DODGERBLUE\">请用户留意新旧合约价格差异，以最新合约成交价为准。<\/font><\/p>","expire":{"date":30,"day":4,"hours":0,"minutes":0,"month":4,"seconds":0,"time":1559145600000,"timezoneOffset":-480,"year":119},"id":11831,"time":{"date":22,"day":3,"hours":5,"minutes":13,"month":4,"seconds":38,"time":1558473218000,"timezoneOffset":-480,"year":119},"title":"原油期货合约更换通知","top":false,"url":""}]
     * alertFlag : wed
     * code : 200
     * resultMsg :
     */

    private String alertFlag;
    private int code;
    private String resultMsg;
    private List<CarouselsBean> carousels;
    private List<NoticesBean> notices;


    @Override
    public String toString() {
        return "OBannerEntity{" +
                "alertFlag='" + alertFlag + '\'' +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", carousels=" + carousels +
                ", notices=" + notices +
                '}';
    }

    public String getAlertFlag() {
        return alertFlag;
    }

    public void setAlertFlag(String alertFlag) {
        this.alertFlag = alertFlag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public List<CarouselsBean> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<CarouselsBean> carousels) {
        this.carousels = carousels;
    }

    public List<NoticesBean> getNotices() {
        return notices;
    }

    public void setNotices(List<NoticesBean> notices) {
        this.notices = notices;
    }


    public static class CarouselsBean extends SimpleBannerInfo {
        @Override
        public String toString() {
            return "CarouselsBean{" +
                    "brand='" + brand + '\'' +
                    ", expire=" + expire +
                    ", key='" + key + '\'' +
                    ", mcname='" + mcname + '\'' +
                    ", time=" + time +
                    ", url='" + url + '\'' +
                    '}';
        }

        /**
         * brand : LT
         * expire : {"date":1,"day":6,"hours":0,"minutes":0,"month":5,"seconds":0,"time":1559318400000,"timezoneOffset":-480,"year":119}
         * key : /trade&CL1907
         * mcname : XM恭喜
         * time : {"date":27,"day":1,"hours":9,"minutes":0,"month":4,"seconds":0,"time":1558918800000,"timezoneOffset":-480,"year":119}
         * url : https://julian.oss-cn-beijing.aliyuncs.com/panda/XM恭喜6.png
         */

        private String brand;
        private ExpireBean expire;
        private String key;
        private String mcname;
        private TimeBean time;
        private String url;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public ExpireBean getExpire() {
            return expire;
        }

        public void setExpire(ExpireBean expire) {
            this.expire = expire;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getMcname() {
            return mcname;
        }

        public void setMcname(String mcname) {
            this.mcname = mcname;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public Object getXBannerUrl() {
            return url;
        }

        public static class ExpireBean {
            @Override
            public String toString() {
                return "ExpireBean{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }

            /**
             * date : 1
             * day : 6
             * hours : 0
             * minutes : 0
             * month : 5
             * seconds : 0
             * time : 1559318400000
             * timezoneOffset : -480
             * year : 119
             */



            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class TimeBean {
            @Override
            public String toString() {
                return "TimeBean{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }

            /**
             * date : 27
             * day : 1
             * hours : 9
             * minutes : 0
             * month : 4
             * seconds : 0
             * time : 1558918800000
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }

    public static class NoticesBean {
        @Override
        public String toString() {
            return "NoticesBean{" +
                    "brand='" + brand + '\'' +
                    ", content='" + content + '\'' +
                    ", expire=" + expire +
                    ", id=" + id +
                    ", time=" + time +
                    ", title='" + title + '\'' +
                    ", top=" + top +
                    ", url='" + url + '\'' +
                    '}';
        }

        /**
         * brand :
         * content : <p>尊敬的用户：</p>

         <p>因5月27日为美国阵亡将士纪念日，<b><font  color="CORAL">EIA原油库存数据</font></b>将推迟至<b><font  color="MAGENTA">2019年05月30日23:00分</font></b>公布，请广大用户知悉。</p>
         <p><font  color="DODGERBLUE">为降低剧烈行情造成的风险，请用户合理选择保证金档位，祝您操盘顺利！</font></p>
         * expire : {"date":5,"day":3,"hours":0,"minutes":0,"month":5,"seconds":0,"time":1559664000000,"timezoneOffset":-480,"year":119}
         * id : 11917
         * time : {"date":29,"day":3,"hours":15,"minutes":10,"month":4,"seconds":37,"time":1559113837000,"timezoneOffset":-480,"year":119}
         * title : EIA数据延迟公布通知
         * top : false
         * url :
         */

        private String brand;
        private String content;
        private ExpireBeanX expire;
        private int id;
        private TimeBeanX time;
        private String title;
        private boolean top;
        private String url;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExpireBeanX getExpire() {
            return expire;
        }

        public void setExpire(ExpireBeanX expire) {
            this.expire = expire;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public TimeBeanX getTime() {
            return time;
        }

        public void setTime(TimeBeanX time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class ExpireBeanX {
            @Override
            public String toString() {
                return "ExpireBeanX{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }

            /**
             * date : 5
             * day : 3
             * hours : 0
             * minutes : 0
             * month : 5
             * seconds : 0
             * time : 1559664000000
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class TimeBeanX {
            @Override
            public String toString() {
                return "TimeBeanX{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }

            /**
             * date : 29
             * day : 3
             * hours : 15
             * minutes : 10
             * month : 4
             * seconds : 37
             * time : 1559113837000
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}

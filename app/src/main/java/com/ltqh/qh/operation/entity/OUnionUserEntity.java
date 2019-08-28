package com.ltqh.qh.operation.entity;

import java.util.List;

public class OUnionUserEntity {


    /**
     * pageSize : 100
     * users : [{"comm":0,"dayTradeVolume":0,"loginTime":{"date":12,"day":5,"hours":16,"minutes":30,"month":6,"seconds":18,"time":1562920218503,"timezoneOffset":-480,"year":119},"registerTime":{"date":12,"day":5,"hours":16,"minutes":30,"month":6,"seconds":18,"time":1562920218493,"timezoneOffset":-480,"year":119},"source":"","tradeVolume":0,"username":"用户7283240"}]
     * code : 200
     * resultMsg :
     */

    private int pageSize;
    private int code;
    private String resultMsg;
    private List<UsersBean> users;

    @Override
    public String toString() {
        return "OUnionUserEntity{" +
                "pageSize=" + pageSize +
                ", code=" + code +
                ", resultMsg='" + resultMsg + '\'' +
                ", users=" + users +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public static class UsersBean {
        /**
         * comm : 0
         * dayTradeVolume : 0
         * loginTime : {"date":12,"day":5,"hours":16,"minutes":30,"month":6,"seconds":18,"time":1562920218503,"timezoneOffset":-480,"year":119}
         * registerTime : {"date":12,"day":5,"hours":16,"minutes":30,"month":6,"seconds":18,"time":1562920218493,"timezoneOffset":-480,"year":119}
         * source :
         * tradeVolume : 0
         * username : 用户7283240
         */

        private int comm;
        private int dayTradeVolume;
        private LoginTimeBean loginTime;
        private RegisterTimeBean registerTime;
        private String source;
        private int tradeVolume;
        private String username;

        @Override
        public String toString() {
            return "UsersBean{" +
                    "comm=" + comm +
                    ", dayTradeVolume=" + dayTradeVolume +
                    ", loginTime=" + loginTime +
                    ", registerTime=" + registerTime +
                    ", source='" + source + '\'' +
                    ", tradeVolume=" + tradeVolume +
                    ", username='" + username + '\'' +
                    '}';
        }

        public int getComm() {
            return comm;
        }

        public void setComm(int comm) {
            this.comm = comm;
        }

        public int getDayTradeVolume() {
            return dayTradeVolume;
        }

        public void setDayTradeVolume(int dayTradeVolume) {
            this.dayTradeVolume = dayTradeVolume;
        }

        public LoginTimeBean getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(LoginTimeBean loginTime) {
            this.loginTime = loginTime;
        }

        public RegisterTimeBean getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(RegisterTimeBean registerTime) {
            this.registerTime = registerTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getTradeVolume() {
            return tradeVolume;
        }

        public void setTradeVolume(int tradeVolume) {
            this.tradeVolume = tradeVolume;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public static class LoginTimeBean {
            @Override
            public String toString() {
                return "LoginTimeBean{" +
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
             * date : 12
             * day : 5
             * hours : 16
             * minutes : 30
             * month : 6
             * seconds : 18
             * time : 1562920218503
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

        public static class RegisterTimeBean {
            @Override
            public String toString() {
                return "RegisterTimeBean{" +
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
             * date : 12
             * day : 5
             * hours : 16
             * minutes : 30
             * month : 6
             * seconds : 18
             * time : 1562920218493
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

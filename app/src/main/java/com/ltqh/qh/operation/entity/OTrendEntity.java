package com.ltqh.qh.operation.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OTrendEntity  {


    /**
     * s : ok
     * t : [1559268000,1559268060,1559268120,1559268180,1559268240,1559268300,1559268360,1559268420,1559268480,1559268540]
     * c : [56.14,56.13,56.13,56.12000000000001,56.13,56.15,56.16,56.13,56.1,56.11]
     * o : [56.1,56.14,56.13,56.13,56.12000000000001,56.13,56.15,56.16,56.13,56.09]
     * h : [56.15,56.14,56.15,56.13,56.13,56.15,56.16,56.16,56.13,56.11]
     * l : [56.1,56.09,56.1,56.11,56.1,56.12000000000001,56.14,56.13,56.07,56.08]
     * v : [9371211,18897317,11382284,6023121,6088670,7623243,9282779,10845974,19569545,6857644]
     */

    private String s;
    private List<Long> t;
    private List<Double> c;
    private List<Double> o;
    private List<Double> h;
    private List<Double> l;
    private List<Double> v;

    @Override
    public String toString() {
        return "OTrendEntity{" +
                "s='" + s + '\'' +
                ", t=" + t +
                ", c=" + c +
                ", o=" + o +
                ", h=" + h +
                ", l=" + l +
                ", v=" + v +
                '}';
    }

    public static String dateToStamp(Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        Date date = new Date(time);
        String format = simpleDateFormat.format(date);
        return format;
    }




    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public List<Long> getT() {
        return t;
    }

    public void setT(List<Long> t) {
        this.t = t;
    }

    public List<Double> getC() {
        return c;
    }

    public void setC(List<Double> c) {
        this.c = c;
    }

    public List<Double> getO() {
        return o;
    }

    public void setO(List<Double> o) {
        this.o = o;
    }

    public List<Double> getH() {
        return h;
    }

    public void setH(List<Double> h) {
        this.h = h;
    }

    public List<Double> getL() {
        return l;
    }

    public void setL(List<Double> l) {
        this.l = l;
    }

    public List<Double> getV() {
        return v;
    }

    public void setV(List<Double> v) {
        this.v = v;
    }
}

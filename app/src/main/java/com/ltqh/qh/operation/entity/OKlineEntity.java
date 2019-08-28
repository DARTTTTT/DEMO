package com.ltqh.qh.operation.entity;

public class OKlineEntity {

    private long time;
    private double openPrice;
    private double cloasePrice;
    private double highPrice;
    private double lowPrice;
    private double volume;


    public OKlineEntity(long time, double openPrice, double cloasePrice, double highPrice, double lowPrice, double volume) {
        this.time = time;
        this.openPrice = openPrice;
        this.cloasePrice = cloasePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "OKlineEntity{" +
                "time=" + time +
                ", openPrice=" + openPrice +
                ", cloasePrice=" + cloasePrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", volume=" + volume +
                '}';
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getCloasePrice() {
        return cloasePrice;
    }

    public void setCloasePrice(double cloasePrice) {
        this.cloasePrice = cloasePrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

package com.ltqh.qh.operation.entity;

public class OProfitEntity {

    private String id;
    private double sub;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return "OProfitEntity{" +
                "id='" + id + '\'' +
                ", sub=" + sub +
                ", volume='" + volume + '\'' +
                '}';
    }

    public OProfitEntity(String id, double sub, int volume) {
        this.id = id;
        this.sub = sub;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public double getSub() {
        return sub;
    }

    public void setSub(double sub) {
        this.sub = sub;
    }
}

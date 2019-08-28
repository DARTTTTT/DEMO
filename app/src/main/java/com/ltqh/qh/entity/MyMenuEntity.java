package com.ltqh.qh.entity;

public class MyMenuEntity {


    @Override
    public String toString() {
        return "MyMenuEntity{" +
                "name='" + name + '\'' +
                ", img=" + img +
                '}';
    }

    public MyMenuEntity(String name, int img) {
        this.name = name;
        this.img = img;
    }

    private String name;

    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

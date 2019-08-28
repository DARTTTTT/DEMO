package com.ltqh.qh.operation.entity;

public class OEventData {
    private String key;
    private Object object;

    @Override
    public String toString() {
        return "OEventData{" +
                "key='" + key + '\'' +
                ", object=" + object +
                '}';
    }

    public OEventData(String key, Object object) {
        this.key = key;
        this.object = object;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

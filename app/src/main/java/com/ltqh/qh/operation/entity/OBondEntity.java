package com.ltqh.qh.operation.entity;

import java.io.Serializable;
import java.util.List;

public class OBondEntity implements Serializable {
    private String contcode;
    private int volume;
    private double div;
    private List<Integer> stopLossList;
    private List<Integer> tradeBeanDepositList;
    private int chargeUnit;

    public OBondEntity(String contcode,  int volume, double div, List<Integer> stopLossList, List<Integer> tradeBeanDepositList, int chargeUnit) {
        this.contcode = contcode;
        this.volume = volume;
        this.div = div;
        this.stopLossList = stopLossList;
        this.tradeBeanDepositList = tradeBeanDepositList;
        this.chargeUnit = chargeUnit;
    }

    @Override
    public String toString() {
        return "OBondEntity{" +
                "contcode='" + contcode + '\'' +
                ", volume=" + volume +
                ", div=" + div +
                ", stopLossList=" + stopLossList +
                ", tradeBeanDepositList=" + tradeBeanDepositList +
                ", chargeUnit=" + chargeUnit +
                '}';
    }

    public String getContcode() {
        return contcode;
    }

    public void setContcode(String contcode) {
        this.contcode = contcode;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getDiv() {
        return div;
    }

    public void setDiv(double div) {
        this.div = div;
    }

    public List<Integer> getStopLossList() {
        return stopLossList;
    }

    public void setStopLossList(List<Integer> stopLossList) {
        this.stopLossList = stopLossList;
    }

    public List<Integer> getTradeBeanDepositList() {
        return tradeBeanDepositList;
    }

    public void setTradeBeanDepositList(List<Integer> tradeBeanDepositList) {
        this.tradeBeanDepositList = tradeBeanDepositList;
    }

    public int getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(int chargeUnit) {
        this.chargeUnit = chargeUnit;
    }
}

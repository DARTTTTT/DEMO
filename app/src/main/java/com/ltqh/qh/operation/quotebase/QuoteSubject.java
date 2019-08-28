package com.ltqh.qh.operation.quotebase;

import com.ltqh.qh.operation.entity.OMarketEntity;

import java.util.ArrayList;
import java.util.List;

public class QuoteSubject implements Subject {
    private List<String> dataList;


    //存放订阅者
    private List<Observer> observers = new ArrayList<Observer>();
    private OMarketEntity oMarketEntity;


    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if (i >= 0) {
            observers.remove(obj);
        }
    }


    public void refreshData() {
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            Observer o = observer;
            o.justRefresh();
        }
    }


}

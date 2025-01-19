package Notification.Observer.Observable;

import Notification.Observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationImpl implements IObservalble{
    List<IObserver> observerList = new ArrayList<>();

//    public String message;

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void update(String event) {
        for(IObserver observer: observerList){
            observer.update(event);
        }
    }



}

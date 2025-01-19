package Notification.Observer.Observable;

import Notification.Observer.IObserver;

public interface IObservalble {
    public void addObserver(IObserver iObserver);

    public void removeObserver(IObserver iObserver);

    public void update(String event);
}

package com.tw.step.assignment4;

import java.util.ArrayList;

public class Notifier {
    ArrayList<Notifiable> listeners;

    public Notifier() {
        this.listeners = new ArrayList<>();
    }

    boolean addListener(Notifiable notifiable){
        return this.listeners.add(notifiable);
    }

    void emit(int parkingLotId, ParkingLotCapacity event){
        this.listeners.forEach(listener->{
            if (listener.getSubscribedEvent().equals(event)){
                listener.receiveNotification(parkingLotId, event);
            }
        });
    }
}

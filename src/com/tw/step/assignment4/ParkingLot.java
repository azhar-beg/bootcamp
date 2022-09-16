package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private final int maxNoOfSlots;
    private final Notifier notifier;
    private final static  int MIN_SLOTS = 0;

    private ParkingLot(int maxNoOfSlots) {
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new ArrayList<>();
        this.notifier = new Notifier();
    }

    boolean addListener(Notifiable notifiable){
        return this.notifier.addListener(notifiable);
    }

    public static ParkingLot create(int maxNoOfSlots) throws InvalidParkingSlotsException {
        if (maxNoOfSlots <= MIN_SLOTS){
            throw new InvalidParkingSlotsException(maxNoOfSlots);
        }

        return new ParkingLot(maxNoOfSlots);
    }

    boolean park(Car car){
        if (this.isFull()){
            this.notifier.sendNotifications(ParkingLotCapacity.FULL);
            return false;
        }

        boolean isCarParked = cars.add(car);

        sendNotifications();
        return isCarParked;
    }

    private void sendNotifications() {
        double capacity = Math.round((this.cars.size() * 100.0) / this.maxNoOfSlots);

        if (capacity >= 80){
            this.notifier.sendNotifications(ParkingLotCapacity.OVER_80);
            return;
        }

        if (capacity <= 20){
            this.notifier.sendNotifications(ParkingLotCapacity.LESS_THAN_20);
        }
    }

    public boolean isFull() {
        return this.cars.size() == this.maxNoOfSlots;
    }
}

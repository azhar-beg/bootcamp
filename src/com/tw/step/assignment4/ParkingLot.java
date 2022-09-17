package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private final int id;
    private final int maxNoOfSlots;
    private final Notifier notifier;
    private final static  int MIN_SLOTS = 0;

    private ParkingLot(int id, int maxNoOfSlots) {
        this.id = id;
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new ArrayList<>();
        this.notifier = new Notifier();
    }

    boolean addListener(Notifiable notifiable){
        return this.notifier.addListener(notifiable);
    }

    public static ParkingLot create(int id, int maxNoOfSlots) throws InvalidParkingSlotsException {
        if (maxNoOfSlots <= MIN_SLOTS){
            throw new InvalidParkingSlotsException(maxNoOfSlots);
        }

        return new ParkingLot(id, maxNoOfSlots);
    }

    boolean park(Car car){
        if (this.isFull()){
            this.notifier.sendNotifications(this.id, ParkingLotCapacity.FULL);
            return false;
        }

        boolean isCarParked = cars.add(car);

        sendNotifications();
        return isCarParked;
    }

    private void sendNotifications() {
        double capacity = Math.round((this.cars.size() * 100.0) / this.maxNoOfSlots);

        if (capacity >= 80){
            this.notifier.sendNotifications(this.id, ParkingLotCapacity.OVER_80);
            return;
        }

        if (capacity <= 20){
            this.notifier.sendNotifications(this.id, ParkingLotCapacity.BELOW_20);
        }
    }

    public boolean isFull() {
        return this.cars.size() == this.maxNoOfSlots;
    }
}

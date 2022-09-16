package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private final int maxNoOfSlots;
    private final Notifier notifier;

    private ParkingLot(int maxNoOfSlots) {
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new ArrayList<>();
        this.notifier = new Notifier();
    }

    boolean addListener(Notifiable notifiable){
        return this.notifier.addListener(notifiable);
    }

    public static ParkingLot create(int maxNoOfSlots) throws InvalidParkingSlotsException {
        if (maxNoOfSlots <=0){
            throw new InvalidParkingSlotsException(maxNoOfSlots);
        }
        return new ParkingLot(maxNoOfSlots);
    }

    boolean park(Car car){
        if (this.isFull()){
            return false;
        }

        boolean isCarParked = cars.add(car);
        int capacity = calculateCapacity();
        this.notifier.sendNotifications(capacity);

        return isCarParked;
    }

    private int calculateCapacity() {
        return Math.round((this.cars.size() / this.maxNoOfSlots) * 100);
    }

    public boolean isFull() {
        return this.cars.size() == this.maxNoOfSlots;
    }
}

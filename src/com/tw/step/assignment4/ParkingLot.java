package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;

import java.util.ArrayList;

public class ParkingLot {
    public static final double MAX_PERCENTAGE = 100.0;
    private final static  int MIN_SLOTS = 0;

    private final ArrayList<Car> cars;
    private final int id;
    private final int maxNoOfSlots;
    private final Notifier notifier;

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
            this.notifier.emit(this.id, ParkingLotCapacity.FULL);
            return false;
        }

        boolean isCarParked = cars.add(car);

        sendNotifications();
        return isCarParked;
    }

    private void sendNotifications() {
        double capacity = Math.round((this.cars.size() * MAX_PERCENTAGE) / this.maxNoOfSlots);

        if (capacity >= 80){
            this.notifier.emit(this.id, ParkingLotCapacity.ABOVE_80);
        }

        if (capacity <= 20){
            this.notifier.emit(this.id, ParkingLotCapacity.BELOW_20);
        }
    }

    public boolean isFull() {
        return this.cars.size() == this.maxNoOfSlots;
    }
}

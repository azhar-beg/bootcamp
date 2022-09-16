package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private final int maxNoOfSlots;

    private ParkingLot(int maxNoOfSlots) {
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new ArrayList<>();
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

        return cars.add(car);
    }

    public boolean isFull() {
        return this.cars.size() == this.maxNoOfSlots;
    }
}

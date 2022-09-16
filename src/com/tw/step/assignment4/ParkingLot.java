package com.tw.step.assignment4;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private final int maxNoOfSlots;

    public ParkingLot(int maxNoOfSlots) {
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new ArrayList<>();
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

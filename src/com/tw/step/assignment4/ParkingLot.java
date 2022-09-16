package com.tw.step.assignment4;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final Set<Car> cars;
    private final int maxNoOfSlots;

    public ParkingLot(int maxNoOfSlots) {
        this.maxNoOfSlots = maxNoOfSlots;
        this.cars = new HashSet<>();
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

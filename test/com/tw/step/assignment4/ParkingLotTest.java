package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldAssertWhenCarIsParked() {
        Car car = new Car("KL123");
        ParkingLot parkingLot = new ParkingLot(2);

        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotParkCarWhenLotIsFull() {
        Car klCar = new Car("KL123");
        Car mhCar = new Car("MH123");
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.park(klCar);

        assertFalse(parkingLot.park(mhCar));
    }

    @Test
    void shouldTellWhenLotIsFull() {
        Car car = new Car("KL123");
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.park(car);

        assertTrue(parkingLot.isFull());
    }
}
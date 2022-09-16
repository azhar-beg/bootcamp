package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldAssertWhenCarIsParked() throws InvalidParkingSlotsException {
        Car car = new Car("KL123");
        ParkingLot parkingLot = ParkingLot.create(2);

        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotParkCarWhenLotIsFull() throws InvalidParkingSlotsException {
        Car klCar = new Car("KL123");
        Car mhCar = new Car("MH123");
        ParkingLot parkingLot = ParkingLot.create(1);

        parkingLot.park(klCar);

        assertFalse(parkingLot.park(mhCar));
    }

    @Test
    void shouldTellWhenLotIsFull() throws InvalidParkingSlotsException {
        Car car = new Car("KL123");
        ParkingLot parkingLot = ParkingLot.create(1);

        parkingLot.park(car);

        assertTrue(parkingLot.isFull());
    }

    @Test
    void shouldAssertWhenLotIsNotFull() throws InvalidParkingSlotsException {
        Car car = new Car("KL123");
        ParkingLot parkingLot = ParkingLot.create(2);

        parkingLot.park(car);

        assertFalse(parkingLot.isFull());
    }

    @Test
    void shouldThrowExceptionForNegativeParkingSlots()  {
        assertThrows(InvalidParkingSlotsException.class, ()-> {
            ParkingLot.create(-2);
        });
    }

    @Test
    void shouldReceiveCapacityWhenItIsOverEighty() throws InvalidParkingSlotsException {
        ParkingLot parkingLot = ParkingLot.create(5);
        parkingLot.park(new Car("123"));
        parkingLot.park(new Car("456"));
        parkingLot.park(new Car("789"));
        AtomicReference<ParkingLotCapacity> actual = new AtomicReference<>();

        parkingLot.addListener((capacity)->{
            actual.set(capacity);
        });
        parkingLot.park(new Car("456"));
        ParkingLotCapacity expected = ParkingLotCapacity.OVER_80;

        assertEquals(actual.get(),expected);
    }

    @Test
    void shouldReceiveCapacityWhenItIsLessThanTwenty() throws InvalidParkingSlotsException {
        ParkingLot parkingLot = ParkingLot.create(5);
        AtomicReference<ParkingLotCapacity> actual = new AtomicReference<>();

        parkingLot.addListener((capacity)->{
            actual.set(capacity);
        });
        parkingLot.park(new Car("456"));
        ParkingLotCapacity expected = ParkingLotCapacity.LESS_THAN_20;

        assertEquals(actual.get(),expected);
    }

    @Test
    void shouldReceiveCapacityWhenTheLotIsFull() throws InvalidParkingSlotsException {
        ParkingLot parkingLot = ParkingLot.create(1);
        parkingLot.park(new Car("456"));
        AtomicReference<ParkingLotCapacity> actual = new AtomicReference<>();

        parkingLot.addListener((capacity)->{
            actual.set(capacity);
        });
        parkingLot.park(new Car("456"));
        ParkingLotCapacity expected = ParkingLotCapacity.FULL;

        assertEquals(actual.get(),expected);
    }
}
package com.tw.step.assignment4;

import com.tw.step.assignment4.exception.InvalidParkingSlotsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotsTest {

    @Test
    void shouldGiveIdOfNewlyAddedParkingLot() throws InvalidParkingSlotsException {
        ParkingLot parkingLot = ParkingLot.create(2);
        ParkingLots parkingLots = new ParkingLots();

        Integer lotId = parkingLots.add(parkingLot);
        assertEquals(1, lotId);
    }
}
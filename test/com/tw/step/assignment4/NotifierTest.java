package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

    @Test
    void shouldAddListenerToBeNotified() {
        Notifier notifier = new Notifier();

        boolean actual = notifier.addListener(new Notifiable() {
            @Override
            public void receiveNotification(int parkingLotId, ParkingLotCapacity capacity) {
            }

            @Override
            public ParkingLotCapacity getSubscribedEvent() {
                return ParkingLotCapacity.ABOVE_80;
            }
        });

        assertTrue(actual);
    }

    @Test
    void shouldSendNotificationsToAllListeners(){
        Notifier notifier = new Notifier();
        AtomicInteger count = new AtomicInteger();

        notifier.addListener(new Notifiable() {
            @Override
            public void receiveNotification(int parkingLotId, ParkingLotCapacity capacity) {
                count.getAndIncrement();
            }

            @Override
            public ParkingLotCapacity getSubscribedEvent() {
                return ParkingLotCapacity.ABOVE_80;
            }
        });

        notifier.emit(1, ParkingLotCapacity.ABOVE_80);

        assertEquals(1, count.get());
    }
}
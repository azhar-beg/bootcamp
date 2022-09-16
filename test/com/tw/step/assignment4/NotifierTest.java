package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

    @Test
    void shouldAddListenerToBeNotified() {
        Notifier notifier = new Notifier();

        boolean actual = notifier.addListener((capacity) -> {});

        assertTrue(actual);
    }

    @Test
    void shouldSendNotificationsToAllListeners(){
        Notifier notifier = new Notifier();
        AtomicInteger count = new AtomicInteger();

        notifier.addListener((number)->{
            count.getAndIncrement();
        });

        notifier.sendNotifications(1);

        assertEquals(1, count.get());
    }
}
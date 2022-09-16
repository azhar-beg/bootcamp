package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

    @Test
    void shouldAddListenerToBeNotified() {
        Notifier notifier = new Notifier();

        boolean actual = notifier.addListener(() -> {});

        assertTrue(actual);
    }

    @Test
    void shouldSendNotificationsToAllListeners(){
        Notifier notifier = new Notifier();
        AtomicInteger count = new AtomicInteger();

        notifier.addListener(()->{
            count.getAndIncrement();
        });
        notifier.sendNotifications();

        assertEquals(1, count.get());
    }
}
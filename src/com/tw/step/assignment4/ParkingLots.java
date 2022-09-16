package com.tw.step.assignment4;

import java.util.HashMap;

public class ParkingLots {
    private final HashMap<Integer, ParkingLot> lots;
    private Integer index = 1;

    public ParkingLots() {
        this.lots = new HashMap<>();
    }

    Integer add(ParkingLot parkingLot){
        Integer id = index;
        lots.put(id,parkingLot);
        index++;
        return id;
    }

    ParkingLot get(Integer id){
        return this.lots.get(id);
    }
}

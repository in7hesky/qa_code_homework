package com.homework.collections.main.devices;

import com.homework.collections.main.Manufacturer;

public class NormalDevice extends Device {
    private boolean isOnBatteries;

    public NormalDevice(String name, int price, int consumption, Manufacturer manufacturer, boolean isOnBatteries) {
        super(name, price, consumption, manufacturer);
        this.isOnBatteries = isOnBatteries;
    }

    public boolean isOnBatteries() {
        return isOnBatteries;
    }
}

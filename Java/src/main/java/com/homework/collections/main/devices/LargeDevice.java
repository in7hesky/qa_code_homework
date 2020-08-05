package com.homework.collections.main.devices;

import com.homework.collections.main.Manufacturer;

public class LargeDevice extends Device {
    private int volume;

    public LargeDevice(String name, int price, int consumption, Manufacturer manufacturer, int volume) {
        super(name, price, consumption, manufacturer);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}

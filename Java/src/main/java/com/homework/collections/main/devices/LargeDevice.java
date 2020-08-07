package com.homework.collections.main.devices;

import com.homework.collections.main.Manufacturer;

import java.util.Objects;

public class LargeDevice extends Device {
    private int volume;

    public LargeDevice(String name, int price, int consumption, Manufacturer manufacturer, int volume) {
        super(name, price, consumption, manufacturer);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "LargeDevice{" +
                "volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LargeDevice that = (LargeDevice) o;
        return volume == that.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}

package com.homework.collections.main.devices;

import com.homework.collections.main.Manufacturer;

import java.util.Objects;

public class CompactDevice extends Device {
    private boolean isOnBatteries;

    public CompactDevice(String name, int price, int consumption, Manufacturer manufacturer, boolean isOnBatteries) {
        super(name, price, consumption, manufacturer);
        this.isOnBatteries = isOnBatteries;
    }

    public boolean isOnBatteries() {
        return isOnBatteries;
    }

    @Override
    public String toString() {
        return "CompactDevice{" +
                "isOnBatteries=" + isOnBatteries +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompactDevice that = (CompactDevice) o;
        return isOnBatteries == that.isOnBatteries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOnBatteries);
    }
}

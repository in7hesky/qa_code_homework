package com.homework.collections.main.devices;

import com.homework.collections.main.Manufacturer;

import java.util.Objects;

abstract public class Device {
    private String name;
    private boolean isOn;
    private int price;
    private int consumption;
    private Manufacturer manufacturer;

    public Device(String name, int price, int consumption, Manufacturer manufacturer) {
        this.name = name;
        this.isOn = false;
        this.price = price;
        this.consumption = consumption;
        this.manufacturer = manufacturer;
    }

    public void setStage(boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getPrice() {
        return price;
    }

    public int getConsumption() {
        return consumption;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", isOn=" + isOn +
                ", price=" + price +
                ", consumption=" + consumption +
                ", manufacturer=" + manufacturer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return isOn == device.isOn &&
                price == device.price &&
                consumption == device.consumption &&
                Objects.equals(name, device.name) &&
                manufacturer == device.manufacturer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isOn, price, consumption, manufacturer);
    }
}

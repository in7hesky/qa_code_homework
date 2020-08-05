package com.homework.collections.main.environment;

import com.homework.collections.main.Manufacturer;
import com.homework.collections.main.devices.Device;
import com.homework.collections.main.devices.LargeDevice;

import java.util.*;

public class House {

    public static final int VOLUME_LIMIT = 30;
    private int totalTakenVolume = 0;
    private List<Socket> sockets = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();

    public House(int socketsAmount) {
        for (int i = 0; i < socketsAmount; i++) {
            this.sockets.add(new Socket());
        }
    }

    public void addNewDevice(Device device) {
        if (device instanceof LargeDevice)
            if (((LargeDevice) device).getVolume() + this.totalTakenVolume > VOLUME_LIMIT)
                return;
            else {
                this.totalTakenVolume += ((LargeDevice) device).getVolume();
            }
        devices.add(device);
    }

    public List<Device> sortDevicesByConsumption() {
        devices.sort(Comparator.comparingInt(Device::getConsumption));
        return devices;
    }

    //REFACTOR!!!!!
    public void turnOnDeviceByIndex(int deviceIndex) {
        for (int i = 0; i < sockets.size(); i++) {
            if(sockets.get(i).connectDevice(devices.get(deviceIndex))) {
                break;
            }
        }
    }

    public void turnOffDeviceByIndex(int deviceIndex) {
        for (Socket socket: sockets) {
            for (Device pluggedDevice : socket.getPluggedDevices()) {
                if(pluggedDevice.equals(devices.get(deviceIndex))) {
                    socket.disconnectDevice(pluggedDevice);
                }
                    //System.out.println("TRUEEEEEE");
                    //socket.getPluggedDevices().remove(pluggedDevice);
            }
        }
    }

    public List<Device> getPoweredOnDevices() {
        List<Device> poweredOnDevices = new ArrayList<>();
        for (Socket socket : this.sockets)
            poweredOnDevices.addAll(socket.getPluggedDevices());

        return poweredOnDevices;
    }

    public int getDevicesTotalCost() {
        int totalDevicesCost = 0;
        for (Device device: devices )
            totalDevicesCost += device.getPrice();

        return totalDevicesCost;
    }

    public List<Device> getDevicesByManufacturers(Manufacturer ... manufacturers) {
        List<Device> devicesByManufacturers = new ArrayList<>();
        for (Device device : this.devices) {
            for (Manufacturer manufacturer: manufacturers) {
                if (device.getManufacturer() == manufacturer)
                    devicesByManufacturers.add(device);
            }
        }

        return devicesByManufacturers;
    }

    public int getDevicesActiveConsumption() {
        int totalActiveConsumption = 0;
        for (Socket socket : sockets) {
            totalActiveConsumption += socket.getTotalConsumption();
        }
        return totalActiveConsumption;
    }

    public int getTotalTakenVolume() {
        return totalTakenVolume;
    }

    public int getSocketsAmount() {
        return sockets.size();
    }

    public int getDevicesAmount() {
        return devices.size();
    }



}

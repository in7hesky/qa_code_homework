package com.homework.collections.main;

import com.homework.collections.main.devices.Device;
import com.homework.collections.main.devices.LargeDevice;
import com.homework.collections.main.devices.CompactDevice;
import com.homework.collections.main.environment.House;
import com.homework.collections.main.environment.Socket;


public class Runner {

    static private House house = new House(2);

    public static void main(String[] args) {
        house.addNewDevice(new LargeDevice("Oven", 150, 30, Manufacturer.CHINA, 3));
        house.addNewDevice(new LargeDevice("Fridge", 200, 60, Manufacturer.BELARUS, 4));
        house.addNewDevice(new LargeDevice("TV", 175, 20, Manufacturer.JAPAN, 2));
        house.addNewDevice(new LargeDevice("Washer", 140, 30, Manufacturer.CHINA, 3));

        house.addNewDevice(new CompactDevice("Controller", 40, 4,
                Manufacturer.JAPAN, true));
        house.addNewDevice(new CompactDevice("Table_Lamp", 15, 30,
                Manufacturer.BELARUS, false));
        house.addNewDevice(new CompactDevice("Laptop", 300, 30,
                Manufacturer.JAPAN, false));

        printHouseStatistics(house);
        printDevicesSortedByConsumption(house);

        //indexes of previously sorted list!!!
        house.turnOnDeviceByIndex(0); //will be ignored: controller is wireless(on batteries)
        house.turnOnDeviceByIndex(1);
        house.turnOnDeviceByIndex(2);
        house.turnOnDeviceByIndex(1); //will be ignored: already added
        house.turnOnDeviceByIndex(6);
        house.turnOnDeviceByIndex(5); //will be ignored: not enough energy in any available socket
        printPoweredOnDevices(house);

        house.turnOffDeviceByIndex(3); //will be ignored: not found in pluggedDevices lists
        house.turnOffDeviceByIndex(2);
        printPoweredOnDevices(house);

        printDevicesByManufacturers(house);
        printHouseStatistics(house);


    }

    public static void printPoweredOnDevices(House house) {
        System.out.println("--------POWERED_ON_DEVICES:");
        for (Device device : house.getPoweredOnDevices())
            System.out.println(device.getName());
    }

    public static void printDevicesByManufacturers(House house) {
        System.out.println("--------DEVICES_BY_MANUFACTURERS:");
        for (Device device : house.getDevicesByManufacturers(Manufacturer.BELARUS, Manufacturer.CHINA))
            System.out.println(device.getName() + "[" + device.getManufacturer() + "]");

    }

    private static void printDevicesSortedByConsumption(House house) {
        System.out.println("--------DEVICES_SORTED_BY_CONSUMPTION:");
        for (Device device : house.sortDevicesByConsumption())
            System.out.println(device.getName() + "(" + device.getConsumption() + ")");

    }

    private static void printHouseStatistics(House house) {
        System.out.println(String.format(
                "--HOUSE'S STATISTICS--\n" +
                "SOCKETS_AMOUNT: %d\n" +
                "DEVICES_AMOUNT: %d\n" +
                "TOTAL_DEVICES_COST: %d\n" +
                "APARTMENTS_VOLUME_LIMIT: %d\n" +
                "TOTAL_SOCKETS_CONSUMPTION_LIMIT: %d\n" +
                "ACTIVE_CONSUMPTION: %d\n" +
                "VOLUME_TAKEN: %d", house.getSocketsAmount(), house.getDevicesAmount(),
                house.getDevicesTotalCost(), House.VOLUME_LIMIT,
                house.getSocketsAmount() * Socket.CONSUMPTION_LIMIT,
                house.getDevicesActiveConsumption(), house.getTotalTakenVolume()));
    }

}

package com.homework.threads.main;

import com.homework.threads.main.exceptions.IllegalCarsAmountException;
import com.homework.threads.main.exceptions.NoSpacesProvidedForParkingLotException;

public class Runner {
    public static void main(String[] args) {
        try {
            CarsActivator carsActivator = new CarsActivator(5, 50);
            carsActivator.createParkingLot(2);
            carsActivator.createParkingLot(3);

            System.out.println(carsActivator.getParkingLotsAmount());
        } catch (IllegalCarsAmountException | NoSpacesProvidedForParkingLotException e) {
            e.printStackTrace();
        }
    }
}

package com.homework.threads.main;

import com.homework.threads.main.exceptions.IllegalCarsAmountException;
import com.homework.threads.main.exceptions.NoSpacesProvidedForParkingLotException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class CarsActivator {
    private int departureDifferenceInMillis;

    private List<Semaphore> parkingLots = new ArrayList<>();
    private List<Car> cars;

    public int getParkingLotsAmount() {
        return this.parkingLots.size();
    }

    public CarsActivator(int carsAmount, int departureDifferenceInMillis) throws IllegalCarsAmountException {
        if (carsAmount < 1)
            throw new IllegalCarsAmountException("You should set up at least one car");

        this.departureDifferenceInMillis = departureDifferenceInMillis;
        createCars(carsAmount);
    }

    public void createParkingLot(int availableSpacesAmount) throws NoSpacesProvidedForParkingLotException {
        if (availableSpacesAmount < 1)
            throw new NoSpacesProvidedForParkingLotException("Parking should have at least one space to park");
        this.parkingLots.add(new Semaphore(availableSpacesAmount, true));
    }

    private void createCars(int carsAmount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carsAmount; i++) {
            this.cars.add(new Car(i));
        }
    }


    private class Car implements Runnable {
        private int number;

        Car(int number) {
            this.number = number;
        }

        @Override
        public void run() {

        }
    }

}

package com.homework.threads.main;


import com.homework.threads.main.exceptions.NoParkingLotsForCompetitionException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Competition {
    private int departureDifferenceInMillis;

    private List<Semaphore> parkingLots = new ArrayList<>();
    private List<Car> cars;

    public Competition(int carsAmount, int departureDifferenceInMillis)  {
        if (carsAmount < 1)
            carsAmount = 1;

        this.departureDifferenceInMillis = departureDifferenceInMillis;
        createCars(carsAmount);
    }

    public void start() throws NoParkingLotsForCompetitionException {
        int timeDifferenceTracker = this.departureDifferenceInMillis;

        if (getParkingLotsAmount() == 0)
            throw new NoParkingLotsForCompetitionException("Create some parking lots before starting competition.");

        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(this.cars.size());
        for (Car car: this.cars) {
            scheduler.schedule(car, timeDifferenceTracker, TimeUnit.MILLISECONDS);
            timeDifferenceTracker += departureDifferenceInMillis;
        }
        scheduler.shutdown();
    }

    public int getParkingLotsAmount() {
        return this.parkingLots.size();
    }

    public void createParkingLot(int availableSpacesAmount) {
        if (availableSpacesAmount < 1)
            availableSpacesAmount = 1;
        this.parkingLots.add(new Semaphore(availableSpacesAmount, true));
    }

    private void createCars(int carsAmount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carsAmount; i++) {
            this.cars.add(new Car(i));
        }
    }


    private class Car implements Runnable {
        private static final int IDLE_PARKED_IN_MILLIS = 300;
        private static final int IDLE_WAITING_FOR_SPACE = 200;
        private int number;

        Car(int number) {
            this.number = number;
        }

        private boolean tryPark(Semaphore parkingLot, int parkingLotIndex) throws InterruptedException {
            String carName = "Car #" + this.number;
            String lotName = "parkingLot #" + parkingLotIndex;

            System.out.println(carName + " is searching for any space at " + lotName + "!");

            if (parkingLot.tryAcquire(IDLE_WAITING_FOR_SPACE, TimeUnit.MILLISECONDS)) {
                System.out.println(carName + " parked at " + lotName + "!");

                TimeUnit.MILLISECONDS.sleep(IDLE_PARKED_IN_MILLIS);
                parkingLot.release();

                System.out.println(carName + " goes home satisfied!");

                return true;
            } else {
                System.out.println(carName + " waited at " + lotName +
                        ", but didn't got any space.");
                return false;
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < parkingLots.size(); i++) {
                try {
                    if (tryPark(parkingLots.get(i), i))
                        return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

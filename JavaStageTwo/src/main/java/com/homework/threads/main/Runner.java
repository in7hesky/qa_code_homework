package com.homework.threads.main;

import com.homework.threads.main.exceptions.NoParkingLotsForCompetitionException;

//Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
// Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

public class Runner {
    public static void main(String[] args) {
        //departureDifference - разница времени старта машин в заезде. Например, с этой конфигурацие, при 1000 милисекундах машины
        //даже не встретятся друг с другом, успешно паркуясь на первой парковке, а при 0 одна машина не дождется
        //свободного места и уедет ни с чем.
        Competition competition = new Competition(6, 0);

        competition.createParkingLot(2);
        competition.createParkingLot(3);

        try {
            competition.start();
        } catch (NoParkingLotsForCompetitionException e) {
            e.printStackTrace();
        }

    }
}

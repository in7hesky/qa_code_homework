package com.homework.classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Engine {
    private static ArrayList<Patient> patientsList = new ArrayList<>();

    static {
        patientsList.add(new Patient("David", "Gilmour"));
        patientsList.add(new Patient("Stevie", "Ray", "Vaughan"));
        patientsList.add(new Patient("John", "Carter", "Cash",
                "Boston", 0, "Covid-19"));
        patientsList.add(new Patient("David", "Stardust",
                "Bowie", "New York", 12434354, "Liver cancer"));
        patientsList.add(new Patient("Dummy", "Dummier", "Buster",
                "LA", 1111223, "Flue"));
        patientsList.add(new Patient("Albert", "Blues", "King",
                "US", 0, "Flue"));
        patientsList.add(new Patient("King", "of",
                "Swing", "LA", 0, "Covid-19"));
    }

    public static void main(String[] args) {
        System.out.println("PATIENTS REGISTERED: " + Patient.getPatientsIdCounter());
        boolean repeat = true;
        while (repeat) {
            repeat = runMenu();
        }
    }

    private static boolean runMenu() {
        System.out.println("---CHOOSE_OPTION---\n" +
                "1. PRINT BY DIAGNOSIS\n" +
                "2. PRINT BY MED CARD RANGE\n" +
                "3. EXIT");
        Scanner menuChoice = new Scanner(System.in);

        try {
            switch (menuChoice.nextInt()) {
                case 1:
                    printByDiagnosis();
                    return true;
                case 2:
                    printByMedicalCardRange();
                    return true;
                case 3:
                    return false;
                default:
                    System.out.println("Wrong option type.");
                    return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Digits only.");
        }

        return true;

    }

    private static void printByDiagnosis() {

    }

    private static void printByMedicalCardRange() {

    }
}

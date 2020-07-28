package com.homework.classes;

import java.util.ArrayList;
import java.util.HashSet;
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
        String [] uniqueConditions = getUniqueConditionsArray();

        System.out.println("CHOOSE FROM AVAILABLE CONDITIONS:");
        for (int i = 0; i < uniqueConditions.length; i++) {
            System.out.println( i+1 + ". " + uniqueConditions[i]);
        }

        String chosenConditionName;
        try {
            int conditionChoice = new Scanner(System.in).nextInt();
            chosenConditionName = uniqueConditions[conditionChoice - 1];
        } catch (Exception e) {
            System.out.println("Wrong input.");
            return;
        }

        for (Patient p: patientsList) {
            if (p.getDiagnosis().equals(chosenConditionName))
                printPatientInfo(p);
        }

    }

    private static String[] getUniqueConditionsArray() {
        HashSet<String> conditionsFilter = new HashSet<>();
        for (Patient patient: patientsList) {
            conditionsFilter.add(patient.getDiagnosis());
        }
        String [] uniqueConditions = new String [conditionsFilter.size()];
        conditionsFilter.toArray(uniqueConditions);

        return uniqueConditions;
    }

    private static void printByMedicalCardRange() {
        System.out.println("AVAILABLE MEDCARD NUMBERS\n[FOR THE FEATURE TESTING CONVENIENCE]: ");
        for (Patient p: patientsList) {
            System.out.println(p.getMedicalCardNumber());
        }
        Scanner userInput = new Scanner(System.in);
        int lowerBound;
        int upperBound;
        try {
            System.out.println("Input lowerBound [inclusive]:");
            lowerBound = userInput.nextInt();
            System.out.println("Input upperBound [inclusive]:");
            upperBound = userInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digital bounds only.");
            return;
        }

        for (Patient p: patientsList) {
            if (p.getMedicalCardNumber() >= lowerBound &&
                    p.getMedicalCardNumber() <= upperBound ) {
                printPatientInfo(p);
            }
        }
    }

    private static void printPatientInfo(Patient p) {
        System.out.println("---PATIENTS_INFO---");
        System.out.println(String.format("Id: %d\nMedCard: %d\n" +
                "Name: %s\nSurname: %s\nLocation: %s\n" +
                "Phone Number: %s", p.getId(), p.getMedicalCardNumber(),
                p.getName(), p.getSurname(), p.getHomeAddress(), p.getPhoneNumber()));
    }
}

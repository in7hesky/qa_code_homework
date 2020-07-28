package com.homework.classes;

public class Patient {
    private static int patientsIdCounter = 0;

    private int id;
    private int medicalCardNumber;
    private String name;
    private String middleName;
    private String surname;
    private String homeAddress;
    private String phoneNumber;
    private String diagnosis;

    public Patient(String name, String surname) {
        this(name, "None", surname);
    }

    public Patient(String name, String middleName,
                   String surname) {

        this(name, middleName,
                surname, "Homeless =)");

    }

    public Patient(String name, String middleName,
                   String surname, String homeAddress) {

        this(name, middleName,
                surname, homeAddress, 0);

    }

    public Patient(String name, String middleName,
                   String surname, String homeAddress, int phoneNumber) {

        this(name, middleName,
                surname, homeAddress, phoneNumber, "UNKNOWN");

    }

    public Patient(String name, String middleName,
                   String surname, String homeAddress, int phoneNumber, String diagnosis) {

        this.id = patientsIdCounter++;
        this.medicalCardNumber = UniqueNumbersGenerator.getUniqueInt();

        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber != 0 ? String.valueOf(phoneNumber) : "Not Specified";
        this.diagnosis = diagnosis;


    }

    public static int getPatientsIdCounter() {
        return patientsIdCounter;
    }

    public int getId() {
        return id;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }


    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = String.valueOf(phoneNumber);
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return this.name + "_" + this.surname + "[" + this.id + "]";
    }
}

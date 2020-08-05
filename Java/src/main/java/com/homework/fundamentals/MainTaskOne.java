package com.homework.fundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class MainTaskOne {
    public static void main(String[] args) {
        System.out.println("Greetings! Please, enter your name (letters only): ");

        Scanner userInput = new Scanner(System.in);
        String userName = userInput.next();

        if (!userName.matches("^\\p{Alpha}+$")) {
            throw new InputMismatchException("Only letters are allowed.");
        } else {
            System.out.println("Welcome, " + userName + "!");
        }
    }
}

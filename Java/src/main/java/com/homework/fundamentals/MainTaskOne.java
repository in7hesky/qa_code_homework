package com.homework.fundamentals;

import java.util.Scanner;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class MainTaskOne {
    public static void main(String[] args) {
        System.out.println("Greetings! Please, enter your name (letters only): ");

        Scanner input = new Scanner(System.in);
        String username = input.next();

        if (!username.matches("^[a-zA-Z]+$")) {
            throw new RuntimeException("Only letters are allowed.");
        } else {
            System.out.println("Welcome, " + username + "!");
        }
    }
}

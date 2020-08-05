package com.homework.fundamentals;

import java.util.Random;
import java.util.Scanner;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class MainTaskThree {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the number of values to output: ");

        printRandomValuesVerticallyAndHorizontally(userInput.nextInt());
    }

    public static void printRandomValuesVerticallyAndHorizontally(int valuesAmount) {
        Random randomGenerator = new Random();
        System.out.println("VERTICALLY:");
        for (int i = 0; i < valuesAmount; i++) {
            System.out.println(randomGenerator.nextInt(10));
        }
        System.out.println("HORIZONTALLY:");
        for (int i = 0; i < valuesAmount; i++) {
            System.out.print(randomGenerator.nextInt(10));
        }
    }

}

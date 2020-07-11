package com.homework.fundamentals;

import java.util.Random;
import java.util.Scanner;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class MainTaskThree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of values to output: ");
        int valuesAmount = input.nextInt();

        printValues(valuesAmount);
    }

    public static void printValues(int amount) {
        Random randomGen = new Random();
        //prints vertically
        for (int i = 0; i < amount; i++) {
            System.out.println(randomGen.nextInt(10));
        }
        //prints horizontally
        for (int i = 0; i < amount; i++) {
            System.out.print(randomGen.nextInt(10));
        }
    }

}

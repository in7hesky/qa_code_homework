package com.homework.fundamentals;
//  Задание. Ввести n чисел с консоли.
//  1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//  2. Вывести числа в порядке возрастания (убывания) значений их длины.
//  3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
//  4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

import java.util.*;

public class OptionalTaskOne {
    private static String[] numbersToOperateOn;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The number of values to input: ");

        while(true) {
            numbersToOperateOn = new String[userInput.nextInt()];
            if(numbersToOperateOn.length != 0) {
                break;
            } else {
                System.out.println("The array must contain one value at least:");
            }
        }

        //init int values in string format
        System.out.println("Input integers:");
        for (int i = 0; i < numbersToOperateOn.length; i++) {
            numbersToOperateOn[i] = String.valueOf(userInput.nextInt());
        }

        Arrays.sort(numbersToOperateOn, Comparator.comparingInt(String::length));

        //TASKS RUNNERS
        printLongestAndShortestValues();

        printValuesInAscendingAndDescendingOrders();

        printValuesLongerThanAverage();

        printValueWithMinimalUniqueDigitsAmount();
    }

    static void printLongestAndShortestValues() {
        System.out.println("---FIRST_TASK---");
        System.out.println(String.format("The shortest is: %s\nIt's length: %d",
                numbersToOperateOn[0],
                numbersToOperateOn[0].length()));
        System.out.println(String.format("The longest is: %s\nIt's length: %d",
                numbersToOperateOn[numbersToOperateOn.length-1],
                numbersToOperateOn[numbersToOperateOn.length-1].length()));
    }

    static void printValuesInAscendingAndDescendingOrders() {
        System.out.println("---SECOND_TASK---");

        System.out.println("ASCENDING ORDER:");
        for (String num: numbersToOperateOn)
            System.out.println(num);

        System.out.println("DESCENDING ORDER:");
        for (int i = numbersToOperateOn.length - 1; i >= 0 ; i--)
            System.out.println(numbersToOperateOn[i]);

    }

    static void printValuesLongerThanAverage() {
        System.out.println("---THIRD_TASK---");

        int averageLength = 0;
        for (String num: numbersToOperateOn)
            averageLength += num.length();

        averageLength /= numbersToOperateOn.length;
        System.out.println("The average length: " + averageLength);

        System.out.println("Longer values:");
        for (String num: numbersToOperateOn)
            if (num.length() > averageLength)
                System.out.println(String.format("%s (%d digits)",
                        num, num.length()));
    }

    static void printValueWithMinimalUniqueDigitsAmount() {
        System.out.println("---FOURTH_TASK---");

        int minimalDigitsAmount = 0;
        String valueContainingMinimalUniqueDigits = "";

        for (String num : numbersToOperateOn) {
            Set<Character> uniqueDigits = new HashSet<>();

            for (int j = 0; j < num.length(); j++)
                uniqueDigits.add(num.charAt(j));

            if (minimalDigitsAmount == 0 || minimalDigitsAmount > uniqueDigits.size()) {
                minimalDigitsAmount = uniqueDigits.size();
                valueContainingMinimalUniqueDigits = num;
            }
        }

        System.out.println(String.format("Minimal unique digits used: %d (%s)\n",
                minimalDigitsAmount, valueContainingMinimalUniqueDigits));
    }
}

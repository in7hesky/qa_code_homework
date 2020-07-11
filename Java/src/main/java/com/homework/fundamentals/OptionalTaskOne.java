package com.homework.fundamentals;
/*Задание. Ввести n чисел с консоли.
  1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
  2. Вывести числа в порядке возрастания (убывания) значений их длины.
  3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
  4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OptionalTaskOne {
    public static String[] numbers;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The number of values to input: ");
        numbers = new String[input.nextInt()];

        //init int values in string format
        System.out.println("Input integers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(input.nextInt());
        }

        //sorting out the array
        Arrays.sort(numbers, (String a, String b) -> Integer.compare(a.length(), b.length()));

        //TASKS RUNNERS
        printLongestShortestValues();

        printValuesAscDesc();

        printValuesLongerThanAverage();

        printValueWithMinimalDigitsNumber();
    }

    static void printLongestShortestValues() {
        System.out.println("---FIRST_TASK---");
        System.out.println(String.format("The shortest is: %s\nIt's length: %d",
                numbers[0], numbers[0].length()));
        System.out.println(String.format("The longest is: %s\nIt's length: %d",
                numbers[numbers.length-1], numbers[numbers.length-1].length()));
    }

    static void printValuesAscDesc() {
        System.out.println("---SECOND_TASK---");

        System.out.println("ASCENDING ORDER:");
        for (String num: numbers) {
            System.out.println(num);
        }

        System.out.println("DESCENDING ORDER:");
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.println(numbers[i]);
        }
    }

    static void printValuesLongerThanAverage() {
        System.out.println("---THIRD_TASK---");

        int averageLength = 0;
        for (String num: numbers) {
            averageLength += num.length();
        }
        averageLength /= numbers.length;
        System.out.println("The average length: " + averageLength);

        System.out.println("Longer values:");
        for (String num: numbers) {
            if (num.length() > averageLength) {
                System.out.println(String.format("%s (%d digits)",
                        num, num.length()));
            }
        }
    }

    static void printValueWithMinimalDigitsNumber() {
        System.out.println("---FOURTH_TASK---");

        int minDigitsAmount = 0;
        String minDigitsNumber = "";

        for (int i = 0; i < numbers.length; i++) {
            String num = numbers[i];
            Set<Character> charSet = new HashSet<>();
            StringBuilder uniqDigits = new StringBuilder();

            //set can contain only unique elements
            for (int j = 0; j < num.length(); j++) {
                charSet.add(num.charAt(j));
            }

            //check how many values the set contains
            for (Character digit : charSet) {
                uniqDigits.append(digit);
            }

            if (minDigitsAmount == 0 || minDigitsAmount > uniqDigits.length()) {
                minDigitsAmount = uniqDigits.length();
                minDigitsNumber = num;
            }
        }

        System.out.println(String.format("Minimal unique digits used: %d (%s)\n",
                minDigitsAmount, minDigitsNumber));
    }
}

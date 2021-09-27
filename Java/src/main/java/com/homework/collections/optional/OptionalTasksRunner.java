package com.homework.collections.optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTasksRunner {
    public static void main(String[] args) throws IOException {
        printReversedNumberUsingStack();
        System.out.println("-----------DELIMITER------------");
        sortStringsListByLength();
        System.out.println("-----------DELIMITER------------");
        printUniqueWordsOfFile();
    }

    //2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
    private static void printReversedNumberUsingStack() {
        Scanner userInput = new Scanner(System.in);
        String userNumber;
        System.out.println("INPUT_VALUE: ");
        while(true) {
            try {
                userNumber = String.valueOf(userInput.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");
                continue;
            }
            break;
        }

        Deque<Character> digits = new ArrayDeque<>();
        for(char digit : userNumber.toCharArray()) {
            digits.push(digit);
        }

        System.out.println("REVERSED: ");
        StringBuilder reversedNumber = new StringBuilder();
        while(!digits.isEmpty())
            reversedNumber.append(digits.pop());
        System.out.println(reversedNumber);
    }

    //4. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
    private static void sortStringsListByLength() {
        List<String> stringsList = new ArrayList<>();
        stringsList.add("Caught up in a whirlwind can't catch my breath");
        stringsList.add("Knee deep in hot water broke out in a cold sweat");
        stringsList.add("Can't catch a turtle in this rat race");
        stringsList.add("Feels like I'm losin' time at a breakneck pace");

        System.out.println("INITIAL ORDER");
        for (String line : stringsList) {
            System.out.println(line);
        }

        stringsList.sort(Comparator.comparingInt(String::length));

        System.out.println("SORTED:");
        for (String line : stringsList) {
            System.out.println(line);
        }
    }

    //8. Задан файл с текстом на английском языке. Выделить все различные слова.
    // Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
    private static void printUniqueWordsOfFile() throws IOException {
        String fileContents = new String(Files.
                readAllBytes(Paths.get("src/main/java/com/homework/collections/optional/someWords.txt")));
        System.out.println("FILE_CONTENTS:\n" + fileContents);

        String [] separatedWords = fileContents.toLowerCase().split("[\\d .?!:;,\n\r]+");
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(separatedWords));

        System.out.println("UNIQUE_WORDS:");
        uniqueWords.forEach(System.out::println);
    }

    // Написать метод isPalindrome, приниммающий int number, возвращающий boolean. Число Palindrome
    // в обратном порядке равно исходному ( 1221 )
    public static boolean isPalindrome(int number) {

        String stringNumber = "" + number;
        char[] charArray = stringNumber.toCharArray();
        String reversedString = "";

        for (int i = charArray.length - 1; i >=0 ; i--) {
            reversedString += charArray[i];
        }
        if (number < 0) {
            reversedString = "-" + reversedString.substring(0, reversedString.length() - 1);
        }

        int reversedNumber = Integer.parseInt(reversedString);
        return number == reversedNumber;
    }

    // Написать метод, принимающий число и выводящий цифры числа поименно
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int reversedNumber = reverse(number);
        int digitCount = getDigitCount(number);
        int reversedLength = Integer.toString(reversedNumber).length();

        int startingZeroes = digitCount - reversedLength;


        for (int i = 0, current = 0; i < reversedLength; i++) {
            current = reversedNumber % 10;
            reversedNumber /= 10;

            String comment;
            switch (current) {
                case 1:
                    comment = "One";
                    break;
                case 2:
                    comment = "Two";
                    break;
                case 3:
                    comment = "Three";
                    break;
                case 4:
                    comment = "Four";
                    break;
                case 5:
                    comment = "Five";
                    break;
                case 6:
                    comment = "Six";
                    break;
                case 7:
                    comment = "Seven";
                    break;
                case 8:
                    comment = "Eight";
                    break;
                case 9:
                    comment = "Nine";
                    break;
                default:
                    comment = "Zero";
                    break;
            }

            System.out.println(comment);
        }
        for (int i = 0; i < startingZeroes; i++) {
            System.out.println("Zero");
        }
    }

    public static int reverse(int number) {
        String reversed = new StringBuilder(Integer.toString(number)).reverse().toString();
        if (number < 0) {
            reversed = "-" + reversed.substring(0, reversed.length() - 1);
        }
        return Integer.parseInt(reversed);
    }

    public static int getDigitCount(int number) {
        if(number < 0)
            return -1;
        return Integer.toString(number).length();
    }
}

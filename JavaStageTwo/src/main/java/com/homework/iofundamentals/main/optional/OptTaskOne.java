package com.homework.iofundamentals.main.optional;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

//1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
public class OptTaskOne {
    public static final String PATHNAME = "src/main/java/com/homework/iofundamentals/main/optional/TaskOne.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(PATHNAME);
        writeRandomNumbersToFile(file, 20);
        sortNumbersInFile(file);
    }

    public static void writeRandomNumbersToFile(File file, int bound) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        Random randomGenerator = new Random();

        System.out.println("INITIAL_ORDER:");
        for (int random, i = 0; i < 10; i++) {
            random = randomGenerator.nextInt(bound);
            printWriter.println(random);
            System.out.print(random + " ");
        }

        printWriter.close();
    }

    public static void sortNumbersInFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Integer> numbersFromFile = new ArrayList<>();

        String number;
        while ((number = bufferedReader.readLine()) != null)
            numbersFromFile.add(Integer.parseInt(number));
        bufferedReader.close();

        numbersFromFile.sort(Integer::compareTo);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        for (Integer numberSorted: numbersFromFile)
            printWriter.println(numberSorted);

        printWriter.close();
    }
}

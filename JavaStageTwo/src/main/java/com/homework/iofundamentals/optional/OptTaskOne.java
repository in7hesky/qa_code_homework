package com.homework.iofundamentals.optional;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
public class OptTaskOne {
    public static final String PATHNAME = "src/main/java/com/homework/iofundamentals/optional/TaskOne.txt";

    public static void main(String[] args) throws IOException {
        writeRandomNumbersToFile(20);
        sortNumbersInFile();
    }

    public static void writeRandomNumbersToFile(int bound) {
        try ( PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(PATHNAME)))) {
            Random randomGenerator = new Random();

            System.out.println("INITIAL_ORDER:");
            for (int random, i = 0; i < 10; i++) {
                random = randomGenerator.nextInt(bound);
                printWriter.println(random);
                System.out.print(random + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortNumbersInFile() {
        List<Integer> numbersFromFile;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(PATHNAME))) {
            numbersFromFile = bufferedReader.lines().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        numbersFromFile.sort(Integer::compareTo);

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(PATHNAME)))) {
            for (Integer numberSorted: numbersFromFile)
                printWriter.println(numberSorted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

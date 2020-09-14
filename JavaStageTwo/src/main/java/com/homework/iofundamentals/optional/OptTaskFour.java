package com.homework.iofundamentals.optional;


import java.io.*;

//10.  Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
public class OptTaskFour {
    private static final String TARGET_PATH =
            "src/main/java/com/homework/iofundamentals/optional/OptTaskFour.txt";

    public static void main(String[] args) {
        StringBuilder editedContent = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TARGET_PATH))) {
            String line;
            String[] wordsInLine;


            while((line = bufferedReader.readLine()) != null) {
                wordsInLine = line.split("[ ,\\n]+");

                String buffer = wordsInLine[0];
                wordsInLine[0] = wordsInLine[wordsInLine.length - 1];
                wordsInLine[wordsInLine.length -1] = buffer;

                for (String word: wordsInLine)
                    editedContent.append(word).append(" ");

                editedContent.replace(editedContent.length() - 1, editedContent.length(), "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(TARGET_PATH)))) {
            printWriter.print(editedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

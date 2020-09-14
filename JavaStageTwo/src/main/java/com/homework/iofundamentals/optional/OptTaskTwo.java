package com.homework.iofundamentals.optional;

import java.io.*;

//2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов
// и методов класса заменить на слово private.
public class OptTaskTwo {
    public static final String TARGET_PATH = "src/main/java/com/homework/iofundamentals/optional/OptTaskOne.java";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TARGET_PATH));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                     new FileWriter(TARGET_PATH.replace(".java", ".upd")))) ) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.contains("public") && !line.contains("class"))
                    line = line.replace("public", "private");
                printWriter.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.homework.iofundamentals.optional;


import java.io.*;

//3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
public class OptTaskThree {
    private static final String TARGET_PATH =
            "src/main/java/com/homework/iofundamentals/optional/OptTaskTwo.java";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TARGET_PATH));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(
                    TARGET_PATH.replace(".java", ".upd") )))) {
            String line;
            while( (line = bufferedReader.readLine()) != null ) {
                printWriter.println(new StringBuilder(line).reverse());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("eeh");
        }
    }
}

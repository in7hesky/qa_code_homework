package com.homework.iofundamentals.main.treetools;

import java.io.*;
import java.util.Objects;

public class TreeCreator {
    private static int tabPosition = 0;

    public static void printFoldersInnerContent(File folder, File infoFile) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(infoFile)))) {
            printFoldersChildren(folder, printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFoldersChildren(File folder, PrintWriter outputFile) {
        File[] innerFiles = folder.listFiles();

        for (File innerFile : Objects.requireNonNull(innerFiles)) {
            for (int i = 0; i < tabPosition; i++)
                outputFile.print("\t");

            if(innerFile.isFile())
                outputFile.println(innerFile.getName());

            else if(innerFile.isDirectory()) {
                outputFile.println("[" + innerFile.getName() + "]");
                tabPosition++;
                printFoldersChildren(innerFile, outputFile);
                tabPosition--;
            }

        }

    }
}

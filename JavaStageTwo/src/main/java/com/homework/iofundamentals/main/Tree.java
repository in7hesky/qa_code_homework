package com.homework.iofundamentals.main;

import java.io.*;


public class Tree {
    private static String pathname;

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("result.txt")));

        File file = new File("test");

        if(file.isDirectory()) {
            try {
                writeDirectoryStructureToFile(file.listFiles(), pw, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //showStructureInfo(file);
        }

        pw.close();
    }

    public static void writeDirectoryStructureToFile(File[] files, PrintWriter targetFile, int tabsCounter) throws IOException{
        for (File f : files) {
            for (int i = 0; i < tabsCounter; i++)
                targetFile.print("\t");

            if(f.isFile())
                targetFile.println(f.getName());

            else if(f.isDirectory()) {
                targetFile.println("[" + f.getName() + "]");
                writeDirectoryStructureToFile(f.listFiles(), targetFile, ++tabsCounter);
            }
        }

    }

    public static void showStructureInfo() {

    }

//    private static int getFoldersAmount() {
//
//        return foldersAmount;
//    }
}

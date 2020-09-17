package com.homework.iofundamentals.main.treetools;

import java.io.*;

public class TreeProcessor {
    private final File FILE;
    private int foldersAmount = 0;
    private int filesAmount = 0;
    private int averageFileNameLength;

    public TreeProcessor(File file) {
        this.FILE = file;
        setFoldersAndFilesAmount();
        setAverageFileNameLength();
    }

    public void printStructureInfo() {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(
                this.FILE.getPath().replace(".txt", "_info.txt"))))) {
            printWriter.println("FOLDERS_AMOUNT: " + this.foldersAmount);
            printWriter.println("FILES_AMOUNT: " + this.filesAmount);
            printWriter.println("AVERAGE_FILES_IN_FOLDER_AMOUNT: " + getAverageFilesInFolderAmount());
            printWriter.println("AVERAGE_FILENAME_LENGTH: " + this.averageFileNameLength);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getAverageFilesInFolderAmount() {
        return (int) Math.round ((double)filesAmount / foldersAmount);
    }

    public int getFoldersAmount() {
        return foldersAmount;
    }

    public int getFilesAmount() {
        return filesAmount;
    }

    public int getAverageFileNameLength() {
        return averageFileNameLength;
    }

    private void setFoldersAndFilesAmount() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ( (line = bufferedReader.readLine()) != null)
                if (line.contains("["))
                    this.foldersAmount++;
                else
                    this.filesAmount++;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("eeh");
        }
    }

    private void setAverageFileNameLength() {
        int filesAmount = 0;
        int totalCharactersAmount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                if (!line.contains("[")) {
                    totalCharactersAmount += line.trim().replaceAll("[\\n]+", "").length();
                    filesAmount++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("eehh");
        }

        this.averageFileNameLength = (int) Math.round((double)totalCharactersAmount / filesAmount);
    }
}

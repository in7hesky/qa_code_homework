package com.homework.iofundamentals.main;

import com.homework.iofundamentals.main.treetools.TreeCreator;
import com.homework.iofundamentals.main.treetools.TreeProcessor;

import java.io.*;
import java.util.Objects;
//Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории,
// например "D:/movies". Записать в текстовый файл структуру папок и файлов
//Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше
// - прочитать файл и вывести в консоль следующие данные:
//        Количество папок
//        Количество файлов
//        Среднее количество файлов в папке
//        Среднюю длинну названия файла

public class Runner {

    public static void main(String[] args) {
        File file = new File(args[0]);

        if(file.isDirectory()) {
            TreeCreator.printFoldersInnerContent(file, new File(file.getPath() + "_structure.txt"));
        } else {
            new TreeProcessor(file).printStructureInfo();
        }
    }








}

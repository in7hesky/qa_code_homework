package com.homework.fundamentals;

//2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
public class MainTaskTwo {
    public static void main(String[] args) {
        System.out.println("Args in reverse order:");

        for (int i = args.length - 1; i >= 0 ; i--) {
            System.out.println(args[i]);
        }
    }
}

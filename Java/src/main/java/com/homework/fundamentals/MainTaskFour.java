package com.homework.fundamentals;

// 4. Ввести целые числа как аргументы командной строки,
// подсчитать их сумму (произведение) и вывести результат на консоль.
public class MainTaskFour {
    public static void main(String [] args) {
        int argsSum = 0;
        int argsProduct = 0;

        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
        }

        for (int i = 0; i < intArgs.length; i++) {
            argsSum += intArgs[i];
            argsProduct = (i == 0) ? intArgs[0] : (argsProduct * intArgs[i]);
        }

        System.out.println(String.format(
                "The argsSum is: %d\nThe argsProduct is: %d", argsSum, argsProduct));
    }

}

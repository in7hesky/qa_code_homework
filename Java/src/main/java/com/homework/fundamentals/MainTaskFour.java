package com.homework.fundamentals;

// 4. Ввести целые числа как аргументы командной строки,
// подсчитать их сумму (произведение) и вывести результат на консоль.
public class MainTaskFour {
    public static void main(String [] args) {
        int sum = 0;
        int product = 0;

        //getting copied int args[]
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
        }

        for (int i = 0; i < intArgs.length; i++) {
            sum += intArgs[i];
            product = (i == 0) ? intArgs[0] : (product * intArgs[i]);
        }

        System.out.println(String.format(
                "The sum is: %d\nThe product is: %d", sum, product));
    }

}

package com.homework.fundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

//5.   Ввести число от 1 до 12. Вывести на консоль название месяца,
// соответствующего данному числу. Осуществить проверку корректности ввода чисел.
public class MainTaskFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input month's number: ");
        int month = 0;
        try  {
            month = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Integer required.");
            exit(2);
        }


        switch (month) {
            case 1:
                System.out.println("Jan");
                break;
            case 2:
                System.out.println("Feb");
                break;
            case 3:
                System.out.println("Mar");
                break;
            case 4:
                System.out.println("Apr");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("Jun");
                break;
            case 7:
                System.out.println("Jul");
                break;
            case 8:
                System.out.println("Aug");
                break;
            case 9:
                System.out.println("Sep");
                break;
            case 10:
                System.out.println("Oct");
                break;
            case 11:
                System.out.println("Nov");
                break;
            case 12:
                System.out.println("Dec");
                break;
            default:
                System.out.println("No such month.");
        }
    }


}

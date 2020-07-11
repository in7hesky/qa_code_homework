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
        int monthNumInput = 0;
        try  {
            monthNumInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Integer required.");
            exit(2);
        }

        String guessResult;
        switch (monthNumInput) {
            case 1:
                guessResult = "Jan";
                break;
            case 2:
                guessResult = "Feb";
                break;
            case 3:
                guessResult = "Mar";
                break;
            case 4:
                guessResult = "Apr";
                break;
            case 5:
                guessResult = "May";
                break;
            case 6:
                guessResult = "Jun";
                break;
            case 7:
                guessResult = "Jul";
                break;
            case 8:
                guessResult = "Aug";
                break;
            case 9:
                guessResult = "Sep";
                break;
            case 10:
                guessResult = "Oct";
                break;
            case 11:
                guessResult = "Nov";
                break;
            case 12:
                guessResult = "Dec";
                break;
            default:
                guessResult = "No such month.";
        }
        System.out.println(guessResult);
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author maysj
 */
public class MyString {
private Scanner in = new Scanner (System.in);
    public static String tabs(byte numberOfTabs) {
        String t = "";

        for (int i = 1; i <= numberOfTabs; i++) {
            t = t + "\t";

        }

        return t;
    }

    public static String numberToText(int number) {

        if (number == 0) {
            return "";
        }

        if (number >= 1 && number <= 19) {

            String[] arr = {
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen"
            };

            return arr[number] + " ";
        }

        if (number >= 20 && number <= 99) {

            String[] arr = {
                "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
            };

            return arr[number / 10] + " "
                    + numberToText(number % 10);
        }

        if (number >= 100 && number <= 199) {

            return "One Hundred "
                    + numberToText(number % 100);
        }

        if (number >= 200 && number <= 999) {

            return numberToText(number / 100)
                    + "Hundreds "
                    + numberToText(number % 100);
        }

        if (number >= 1000 && number <= 1999) {

            return "One Thousand "
                    + numberToText(number % 1000);
        }

        if (number >= 2000 && number <= 999999) {

            return numberToText(number / 1000)
                    + "Thousands "
                    + numberToText(number % 1000);
        }

        if (number >= 1000000 && number <= 1999999) {

            return "One Million "
                    + numberToText(number % 1000000);
        }

        if (number >= 2000000 && number <= 999999999) {

            return numberToText(number / 1000000)
                    + "Millions "
                    + numberToText(number % 1000000);
        }

        if (number >= 1000000000 && number <= 1999999999) {

            return "One Billion "
                    + numberToText(number % 1000000000);
        } else {

            return numberToText(number / 1000000000)
                    + "Billions "
                    + numberToText(number % 1000000000);
        }
    }
    public static String getSystemDateTimeString() {

    LocalDateTime now = LocalDateTime.now();

    short day = (short) now.getDayOfMonth();
    short month = (short) now.getMonthValue();
    short year = (short) now.getYear();

    short hour = (short) now.getHour();
    short minute = (short) now.getMinute();
    short second = (short) now.getSecond();

    return day + "/" + month + "/" + year
            + " - "
            + hour + ":" + minute + ":" + second;
}

    public static void printLeft(String text, int width,String leftOrRigth) {

        if(leftOrRigth.equalsIgnoreCase("left")){

            System.out.printf("%-" + width + "s", text);
            return;
        }
        System.out.printf("%" + width + "s", text);
}
    
}

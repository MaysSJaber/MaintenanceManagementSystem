package Lib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidate {

    private static final Scanner in = new Scanner(System.in);

    public static boolean isNumberBetween(short number, short from, short to) {

        return number >= from && number <= to;
    }


    public static boolean isNumberBetween(int number, int from, int to) {

        return number >= from && number <= to;
    }


    public static boolean isNumberBetween(double number, double from, double to) {

        return number >= from && number <= to;
    }




    public static int readIntNumber() {

        return readIntNumber("Invalid Number, Enter again: ");
    }


    public static int readIntNumber(String errorMessage) {

        int number;

        while (true) {

            try {

                number = in.nextInt();
                return number;

            } catch (InputMismatchException e) {

                in.next();
                System.out.print(errorMessage);
            }
        }
    }



    public static short readShortNumber() {

        return readShortNumber("Invalid Number, Enter again: ");
    }


    public static short readShortNumber(String errorMessage) {

        short number;

        while (true) {

            try {

                number = in.nextShort();
                return number;

            } catch (InputMismatchException e) {

                in.next();
                System.out.print(errorMessage);
            }
        }
    }



    public static short readShortNumberBetween(
            short from,
            short to) {

        return readShortNumberBetween(
                from,
                to,
                "Number is not within range, Enter again: ");
    }


    public static short readShortNumberBetween(
            short from,
            short to,
            String errorMessage) {

        short number = readShortNumber();

        while (!isNumberBetween(number, from, to)) {

            System.out.print(errorMessage);
            number = readShortNumber();
        }

        return number;
    }



    public static int readIntNumberBetween(
            int from,
            int to) {

        return readIntNumberBetween(
                from,
                to,
                "Number is not within range, Enter again: ");
    }


    public static int readIntNumberBetween(
            int from,
            int to,
            String errorMessage) {

        int number = readIntNumber();

        while (!isNumberBetween(number, from, to)) {

            System.out.print(errorMessage);
            number = readIntNumber();
        }

        return number;
    }




    public static float readFloatNumber() {

        return readFloatNumber(
                "Invalid Number, Enter again: ");
    }


    public static float readFloatNumber(String errorMessage) {

        float number;

        while (true) {

            try {

                number = in.nextFloat();
                return number;

            } catch (InputMismatchException e) {

                in.next();
                System.out.print(errorMessage);
            }
        }
    }




    public static float readFloatNumberBetween(
            float from,
            float to) {

        return readFloatNumberBetween(
                from,
                to,
                "Number is not within range, Enter again: ");
    }


    public static float readFloatNumberBetween(
            float from,
            float to,
            String errorMessage) {

        float number = readFloatNumber();

        while (number < from || number > to) {

            System.out.print(errorMessage);
            number = readFloatNumber();
        }

        return number;
    }



    public static double readDoubleNumber() {

        return readDoubleNumber(
                "Invalid Number, Enter again: ");
    }


    public static double readDoubleNumber(String errorMessage) {

        double number;

        while (true) {

            try {

                number = in.nextDouble();
                return number;

            } catch (InputMismatchException e) {

                in.next();
                System.out.print(errorMessage);
            }
        }
    }


    public static double readDoubleNumberBetween(
            double from,
            double to) {

        return readDoubleNumberBetween(
                from,
                to,
                "Number is not within range, Enter again: ");
    }


    public static double readDoubleNumberBetween(
            double from,
            double to,
            String errorMessage) {

        double number = readDoubleNumber();

        while (!isNumberBetween(number, from, to)) {

            System.out.print(errorMessage);
            number = readDoubleNumber();
        }

        return number;
    }
}
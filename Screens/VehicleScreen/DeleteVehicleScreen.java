package Screens.Vehicle;

import Lib.MyString;
import Screens.Screen;
import Service.Vehicle;

import java.io.IOException;
import java.util.Scanner;

public class DeleteVehicleScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void printVehicleInfo(Vehicle vehicle) {

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
        System.out.println(MyString.tabs((byte)4) + " Vehicle Information : ");

        System.out.println(MyString.tabs((byte)4) + " Vehicle ID : " + vehicle.getVehicleId());
        System.out.println(MyString.tabs((byte)4) + " Customer ID : " + vehicle.getCustomerId());
        System.out.println(MyString.tabs((byte)4) + " Plate Number : " + vehicle.getPlateNumber());
        System.out.println(MyString.tabs((byte)4) + " Brand : " + vehicle.getBrand());
        System.out.println(MyString.tabs((byte)4) + " Model : " + vehicle.getModel());
        System.out.println(MyString.tabs((byte)4) + " Year : " + vehicle.getYear());
        System.out.println(MyString.tabs((byte)4) + " Color : " + vehicle.getColor());

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
    }

    public static void showDeleteScreen() throws IOException {

        drawScreenHeader("Delete Vehicle", null);

        System.out.print("\n\n");

        System.out.print("Enter Vehicle ID : ");
        String id = in.nextLine();

        Vehicle v;

        if ((v = Vehicle.findVehicle(id)) != null) {

            printVehicleInfo(v);

            Character sure = 'n';

            System.out.println("Are you sure ? you want delete vehicle ? [y][n]");
            sure = in.next().charAt(0);

            if (Character.toLowerCase(sure) == 'y') {

                v.delete();

                System.out.println(" Deleted Successfully :) .");
                return;
            }
            else {
                return;
            }
        }

        System.out.println("Vehicle Not Found :( .");
    }
}
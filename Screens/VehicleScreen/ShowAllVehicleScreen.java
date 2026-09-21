package Screens.Vehicle;

import Lib.MyString;
import Screens.Screen;
import Service.Vehicle;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllVehicleScreen extends Screen {

    private static void printVehicleCurd(Vehicle v) {

        if (v != null) {

            System.out.print(MyString.tabs((byte) 6));

            MyString.printLeft(v.getVehicleId(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(v.getCustomerId(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(v.getPlateNumber(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(v.getBrand(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(v.getModel(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(v.getYear() + "", 8, "left");
            System.out.print("| ");

            MyString.printLeft(v.getColor(), 15, "left");

            System.out.println();
        }
    }


    public static void printHeaderTabel() {

        System.out.println(MyString.tabs((byte) 3)
                + "-------------------------------------------------------------------------------------------------------------------------");

        System.out.print(MyString.tabs((byte) 6));

        MyString.printLeft("Vehicle ID", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Customer ID", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Plate Number", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Brand", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Model", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Year", 8, "left");
        System.out.print("| ");

        MyString.printLeft("Color", 15, "left");

        System.out.println();

        System.out.println(MyString.tabs((byte) 3)
                + "-------------------------------------------------------------------------------------------------------------------------");
    }


    public static void showAllVehicleScreen() throws IOException {

        ArrayList<Vehicle> vehicleList = Vehicle.getVehicleList();

        drawScreenHeader(
                "Show All Vehicle",
                vehicleList.size() + " Vehicle(s) In System"
        );

        System.out.println("\n");

        printHeaderTabel();

        if (vehicleList.size() == 0) {

            System.out.println(
                    MyString.tabs((byte) 6)
                            + "No Vehicles available in the system."
            );

            return;
        }

        for (Vehicle v : vehicleList) {

            printVehicleCurd(v);
            System.out.print("\n");
        }
    }
}
package Screens.Vehicle;

import Core.Customer;
import Service.Vehicle;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class UpdateVehicleScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readVehicleInfo(Vehicle vehicle) throws IOException {

        System.out.println("\nEnter Vehicle Information:");

        System.out.print("Customer ID: ");
        String customerId = in.nextLine();
        vehicle.setCustomerId(customerId);

        while (!Customer.isCustomerExist(customerId)) {
            System.out.println("Customer ID does not exist.");
            System.out.print("Enter another Customer ID: ");
            customerId = in.nextLine();
        }
        vehicle.setCustomerId(customerId);


        System.out.print("Plate Number: ");
        vehicle.setPlateNumber(in.nextLine());

        System.out.print("Brand: ");
        vehicle.setBrand(in.nextLine());

        System.out.print("Model: ");
        vehicle.setModel(in.nextLine());

        System.out.print("Year: ");
        vehicle.setYear(in.nextInt());
        in.nextLine();

        System.out.print("Color: ");
        vehicle.setColor(in.nextLine());
    }


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


    public static void showUpdateVehicleScreen() throws IOException {

        drawScreenHeader("Update Vehicle", null);

        System.out.print("\n\nEnter Vehicle ID : ");

        String id = in.nextLine();

        Vehicle v;

        if ((v = Vehicle.findVehicle(id)) != null) {

            printVehicleInfo(v);

            readVehicleInfo(v);

            System.out.println(
                    "Are You Sure ? You Want Update Vehicle ? [y][n] "
            );

            Character sure = 'n';

            sure = in.next().charAt(0);

            if (Character.toLowerCase(sure) == 'y') {

                v.update();

                printVehicleInfo(v);

                System.out.println(
                        "Updated Successfully :) . "
                );

                return;
            }
            else {
                return;
            }
        }

        System.out.println("Vehicle Not Found :( . ");
    }
}
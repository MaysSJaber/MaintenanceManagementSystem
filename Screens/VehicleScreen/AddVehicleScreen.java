package Screens.Vehicle;

import Core.Customer;
import Core.SavedResult;
import Screens.Screen;
import Service.Vehicle;

import java.io.IOException;
import java.util.Scanner;

public class AddVehicleScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readVehicleInfo(Vehicle vehicle)
            throws IOException {

        System.out.println("\nEnter Vehicle Information:");

        System.out.print("Vehicle ID: ");
        vehicle.setVehicleId(in.nextLine());


        while (Vehicle.isVehicleExist(vehicle.getVehicleId())) {

            System.out.println(" Id Vehicle does exist.");

            System.out.print("Enter another ID Vehicle : ");
            vehicle.setVehicleId(in.nextLine());
        }


        System.out.print("Customer ID: ");
        String customerId = in.nextLine();

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

    public static void showAddNewVehicleScreen()
            throws IOException {

        Screen.drawScreenHeader("\t\t\tAdd Vehicle", null);

        Vehicle vehicle = new Vehicle();

        readVehicleInfo(vehicle);

        SavedResult saveR = vehicle.addVehicle();

        switch (saveR) {

            case SUCCESSFULLY_ADD:
                System.out.println(
                        "Vehicle added successfully :)"
                );
                break;

            case FAILED_ALREADY_EXISTS:
                System.out.println(
                        "Failed to add Vehicle: Vehicle already exists :( "
                );
                break;
        }
    }
}
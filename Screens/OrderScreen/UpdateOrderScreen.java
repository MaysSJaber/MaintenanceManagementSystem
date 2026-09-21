package Screens.Order;

import Core.Mechanic;
import Lib.MyString;
import Screens.Screen;
import Service.Order;
import Service.OrderStatus;

import java.io.IOException;
import java.util.Scanner;

public class UpdateOrderScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readOrderInfo(Order order) throws IOException {

        System.out.println("\nEnter Order Information:");

        System.out.print("Mechanic ID: ");
        String mechanicId = in.nextLine();

        while (!Mechanic.isMechanicExist(mechanicId)) {

            System.out.println("Mechanic ID does not exist.");

            System.out.print("Enter another Mechanic ID: ");
            mechanicId = in.nextLine();
        }

        order.setMechanicId(mechanicId);


        System.out.print("Problem Description: ");
        order.setProblemDescription(in.nextLine());


        System.out.println("\nOrder Status:");

        System.out.println("[1] PENDING");
        System.out.println("[2] IN_PROGRESS");
        System.out.println("[3] COMPLETED");

        System.out.print("Choose Status: ");

        short statusChoice = in.nextShort();
        in.nextLine();

        switch (statusChoice) {

            case 1:
                order.setStatus(OrderStatus.PENDING);
                break;

            case 2:
                order.setStatus(OrderStatus.IN_PROGRESS);
                break;

            case 3:
                order.setStatus(OrderStatus.COMPLETED);
                break;

            default:
                System.out.println("Invalid Status.");
                break;
        }


        System.out.print("Total Cost: ");
        order.setTotalCost(in.nextDouble());
        in.nextLine();
    }


    private static void printOrderInfo(Order order) {

        System.out.println(
                MyString.tabs((byte)4) +
                        "--------------------------------------------------------"
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Order Information : "
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Order ID : " + order.getOrderId()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Customer ID : " + order.getCustomerId()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Vehicle ID : " + order.getVehicleId()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Mechanic ID : " + order.getMechanicId()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Problem Description : " +
                        order.getProblemDescription()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Status : " + order.getStatus()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        " Total Cost : " + order.getTotalCost()
        );

        System.out.println(
                MyString.tabs((byte)4) +
                        "--------------------------------------------------------"
        );
    }


    public static void showUpdateOrderScreen()
            throws IOException {

        drawScreenHeader("Update Order", null);

        System.out.print("\n\nEnter Order ID : ");

        String id = in.nextLine();

        Order order;

        if ((order = Order.findOrder(id)) != null) {

            printOrderInfo(order);

            readOrderInfo(order);

            System.out.println(
                    "\nAre You Sure ? You Want Update Order ? [y][n] "
            );

            Character sure = in.next().charAt(0);

            if (Character.toLowerCase(sure) == 'y') {

                order.update();

                printOrderInfo(order);

                System.out.println(
                        "\nUpdated Successfully :) ."
                );

                return;
            }
            else {
                return;
            }
        }

        System.out.println("Order Not Found :( . ");
    }
}
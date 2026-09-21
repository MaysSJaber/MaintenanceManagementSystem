package Screens.Order;

import Lib.MyString;
import Screens.Screen;
import Service.Order;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllOrderScreen extends Screen {

    private static void printOrderCurd(Order o) {

        if (o != null) {

            System.out.print(MyString.tabs((byte) 3));

            MyString.printLeft(o.getOrderId(), 12, "left");
            System.out.print("| ");

            MyString.printLeft(o.getCustomerId(), 12, "left");
            System.out.print("| ");

            MyString.printLeft(o.getVehicleId(), 12, "left");
            System.out.print("| ");

            MyString.printLeft(o.getMechanicId(), 12, "left");
            System.out.print("| ");

            MyString.printLeft(o.getProblemDescription(), 35, "left");
            System.out.print("| ");

            MyString.printLeft(o.getStatus().toString(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(o.getTotalCost() + "", 12, "left");

            System.out.println();
        }
    }


    public static void printHeaderTabel() {

        System.out.println(
                MyString.tabs((byte) 2)
                        + "------------------------------------------------------------------------------------------------------------------------------------------"
        );

        System.out.print(MyString.tabs((byte) 3));

        MyString.printLeft("Order ID", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Customer ID", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Vehicle ID", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Mechanic ID", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Problem Description", 35, "left");
        System.out.print("| ");

        MyString.printLeft("Status", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Total Cost", 12, "left");

        System.out.println();

        System.out.println(
                MyString.tabs((byte) 2)
                        + "------------------------------------------------------------------------------------------------------------------------------------------"
        );
    }


    public static void showAllOrderScreen() throws IOException {

        ArrayList<Order> orderList = Order.getOrderList();

        drawScreenHeader(
                "Show All Orders",
                orderList.size() + " Order(s) In System"
        );

        System.out.println("\n");

        printHeaderTabel();

        if (orderList.size() == 0) {

            System.out.println(
                    MyString.tabs((byte) 3)
                            + "No Orders available in the system."
            );

            return;
        }

        for (Order o : orderList) {

            printOrderCurd(o);
            System.out.print("\n");
        }
    }
}
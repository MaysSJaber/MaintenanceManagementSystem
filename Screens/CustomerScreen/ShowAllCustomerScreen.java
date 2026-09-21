package Screens.Customer;

import Core.Customer;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllCustomerScreen extends Screen {

    private static void printCustomerCurd(Customer c) {

        if (c != null) {

            System.out.print(MyString.tabs((byte) 6));

            MyString.printLeft(c.getName(), 25, "left");
            System.out.print("| ");

            MyString.printLeft(c.getAge() + "", 5, "left");
            System.out.print("| ");

            MyString.printLeft(c.getAddress(), 20, "left");
            System.out.print("| ");

            MyString.printLeft(c.getPhone(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(c.getEmail(), 30, "left");
            System.out.print("| ");

            MyString.printLeft(c.getId(), 10, "left");

            System.out.println();
        }
    }

    private static void printHeaderTabel() {

        System.out.println(MyString.tabs((byte) 3)
                + "-----------------------------------------------------------------------------------------------------------------------");

        System.out.print(MyString.tabs((byte) 6));

        MyString.printLeft("Full Name", 25, "left");
        System.out.print("| ");

        MyString.printLeft("Age", 5, "left");
        System.out.print("| ");

        MyString.printLeft("Address", 20, "left");
        System.out.print("| ");

        MyString.printLeft("Phone", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Email", 30, "left");
        System.out.print("| ");

        MyString.printLeft("ID", 10, "left");

        System.out.println();

        System.out.println(MyString.tabs((byte) 3)
                + "-----------------------------------------------------------------------------------------------------------------------");
    }

    public static void showAllCustomerScreen() throws IOException {

        ArrayList<Customer> customerList = Customer.getCustomerList();

        drawScreenHeader(
                "Show All Customer",
                customerList.size() + " Customer(s) In System"
        );

        System.out.println("\n");

        printHeaderTabel();

        if (customerList.size() == 0) {

            System.out.println(
                    MyString.tabs((byte) 6)
                            + "No Customers available in the system."
            );

            return;
        }

        for (Customer c : customerList) {

            printCustomerCurd(c);
            System.out.print("\n");
        }
    }
}
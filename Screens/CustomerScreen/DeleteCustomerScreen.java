package Screens.Customer;

import Core.Customer;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class DeleteCustomerScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void printCustomerInfo(Customer customer) {

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
        System.out.println(MyString.tabs((byte)4) + " Customer Information : ");

        System.out.println(MyString.tabs((byte)4) + " Name : " + customer.getName());
        System.out.println(MyString.tabs((byte)4) + " Age : " + customer.getAge());
        System.out.println(MyString.tabs((byte)4) + " Address : " + customer.getAddress());
        System.out.println(MyString.tabs((byte)4) + " Phone : " + customer.getPhone());
        System.out.println(MyString.tabs((byte)4) + " Email : " + customer.getEmail());

        System.out.println(MyString.tabs((byte)4) + " ID : " + customer.getId());

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
    }

    public static void showDeleteScreen() throws IOException {

        drawScreenHeader("Delete Customer", null);

        System.out.print("\n\n");

        System.out.print("Enter ID  : ");
        String id = in.nextLine();

        Customer c;

        if ((c = Customer.findCustomer(id)) != null) {

            printCustomerInfo(c);

            Character sure = 'n';

            System.out.println("Are you sure ? you want delete customer ? [y][n]");
            sure = in.next().charAt(0);

            if (Character.toLowerCase(sure) == 'y') {

                c.delete();

                System.out.println(" Deleted Successfully :) .");
                return;
            }
            else {
                return;
            }
        }

        System.out.println("Customer Not Found :( .");
    }
}
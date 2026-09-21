package Screens.Customer;

import Core.Customer;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class UpdateCustomerScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readCustomerInfo(Customer customer) {

        System.out.println("\nEnter Customer Information:");

        System.out.print("Name: ");
        customer.setName(in.nextLine());

        System.out.print("Age: ");
        customer.setAge(in.nextInt());
        in.nextLine();

        System.out.print("Address: ");
        customer.setAddress(in.nextLine());

        System.out.print("Phone: ");
        customer.setPhone(in.nextLine());

        System.out.print("Email: ");
        customer.setEmail(in.nextLine());
    }


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


    public static void showUpdateCustomerScreen() throws IOException {

        drawScreenHeader("Update Customer", null);

        System.out.print("\n\nEnter ID : ");

        String id = in.nextLine();

        Customer c;

        if ((c = Customer.findCustomer(id)) != null) {

            printCustomerInfo(c);

            readCustomerInfo(c);

            System.out.println("Are You Sure ? You Want Update Customer ? [y][n] ");

            Character sure = 'n';

            sure = in.next().charAt(0);

            if (Character.toLowerCase(sure) == 'y') {

                c.update();

                printCustomerInfo(c);

                System.out.println("Updated Successfully :) . ");

                return;
            }
            else {
                return;
            }
        }

        System.out.println("Customer Not Found :( . ");
    }
}
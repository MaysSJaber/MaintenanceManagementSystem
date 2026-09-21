package Screens.Customer;

import Core.Customer;
import Core.SavedResult;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class AddCustomerScreen extends Screen {


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

            System.out.print("ID: ");
            customer.setId(in.nextLine());

        in.nextLine();

        }

    public static void showAddNewMechanicScreen() throws IOException {

        Screen.drawScreenHeader("\t\t\tAdd Customer", null);
        Customer customer = new Customer();
        readCustomerInfo(customer);

        SavedResult saveR = customer.addCustomer();
        switch (saveR) {
            case SUCCESSFULLY_ADD:
                System.out.println("Customer added successfully :)");
                break;
            case FAILED_ALREADY_EXISTS:
                System.out.println("Failed to add Customer: Customer already exists :( ");
                break;

        }

    }

}

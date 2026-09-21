package Screens.Customer;

import Core.Permissions;
import Lib.InputValidate;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;

public class CustomerMenegmentScreen extends Screen {

    private enum CustomerManagementMenu {

        SHOW_ALL_CUSTOMER(1),
        ADD_NEW_CUSTOMER(2),
        DELETE_CUSTOMER(3),
        UPDATE_CUSTOMER(4),
        GO_BACK(5);

        private final short enumOptionValue;

        CustomerManagementMenu(int value) {
            this.enumOptionValue = (short) value;
        }

        public short getEnumOptionValue() {
            return enumOptionValue;
        }
    }


    private static CustomerManagementMenu fromValue(short value) {

        for (CustomerManagementMenu option : CustomerManagementMenu.values()) {

            if (option.getEnumOptionValue() == value) {
                return option;
            }
        }

        return null;
    }


    private static CustomerManagementMenu readOption(String message) {

        System.out.println(MyString.tabs((byte) 6) + message);

        short option = InputValidate.readShortNumberBetween(
                (short) 1,
                (short) 5
        );

        return fromValue(option);
    }


    private static void showAddCustomerScreen() throws IOException {

        AddCustomerScreen.showAddNewMechanicScreen();
    }


    private static void showUpdateCustomerScreen() throws IOException {

        UpdateCustomerScreen.showUpdateCustomerScreen();
    }


    private static void showDeleteCustomerScreen() throws IOException {

        DeleteCustomerScreen.showDeleteScreen();
    }


    private static void showAllCustomerScreen() throws IOException {

        ShowAllCustomerScreen.showAllCustomerScreen();
    }


    private static void performCustomerMenue(
            CustomerManagementMenu option) throws IOException {

        switch (option) {

            case SHOW_ALL_CUSTOMER:
                showAllCustomerScreen();
                goBackCustomerMenue();
                break;

            case ADD_NEW_CUSTOMER:
                showAddCustomerScreen();
                goBackCustomerMenue();
                break;

            case DELETE_CUSTOMER:
                showDeleteCustomerScreen();
                goBackCustomerMenue();
                break;

            case UPDATE_CUSTOMER:
                showUpdateCustomerScreen();
                goBackCustomerMenue();
                break;

            case GO_BACK:
                return;
        }
    }


    private static void goBackCustomerMenue() throws IOException {

        System.out.println("\n\nPress Enter to go back to Customer Menu...");
        new java.util.Scanner(System.in).nextLine();

        Screen.clearScreen();
        showCustomerMenue();
    }


    public static void showCustomerMenue() throws IOException {



        if (!Screen.checkAccessRights(Permissions.CUSTOMER_SCREEN))
        {
            return;
        }

        drawScreenHeader("\t\t\tCustomer Management", null);

        System.out.print("\n\n");

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );

        System.out.println(MyString.tabs((byte) 6)
                + "[1] Show All Customer ");

        System.out.println(MyString.tabs((byte) 6)
                + "[2] Add Customer ");

        System.out.println(MyString.tabs((byte) 6)
                + "[3] Delete Customer ");

        System.out.println(MyString.tabs((byte) 6)
                + "[4] Update Customer ");

        System.out.println(MyString.tabs((byte) 6)
                + "[5] Go Back Main Menue ");

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );

        performCustomerMenue(
                readOption("Enter your choice [ 1 - 5 ] ? ")
        );
    }
}
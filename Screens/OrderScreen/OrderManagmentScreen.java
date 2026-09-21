package Screens.Order;

import Core.Permissions;
import Lib.InputValidate;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;

public class OrderManagmentScreen extends Screen {

    private enum OrderManagementMenu {

        SHOW_ALL_ORDER(1),
        ADD_NEW_ORDER(2),
        DELETE_ORDER(3),
        UPDATE_ORDER(4),
        GO_BACK(5);

        private final short enumOptionValue;

        OrderManagementMenu(int value) {
            this.enumOptionValue = (short) value;
        }

        public short getEnumOptionValue() {
            return enumOptionValue;
        }
    }


    private static OrderManagementMenu fromValue(short value) {

        for (OrderManagementMenu option : OrderManagementMenu.values()) {

            if (option.getEnumOptionValue() == value) {
                return option;
            }
        }

        return null;
    }


    private static OrderManagementMenu readOption(String message) {

        System.out.println(MyString.tabs((byte) 6) + message);

        short option = InputValidate.readShortNumberBetween(
                (short) 1,
                (short) 5
        );

        return fromValue(option);
    }


    private static void showAddOrderScreen() throws IOException {

        AddOrderScreen.showAddNewOrderScreen();

    }


    private static void showUpdateOrderScreen() throws IOException {

        UpdateOrderScreen.showUpdateOrderScreen();

    }


    private static void showDeleteOrderScreen() throws IOException {

        DeleteOrderScreen.showDeleteOrderScreen();

    }


    private static void showAllOrderScreen() throws IOException {

        ShowAllOrderScreen.showAllOrderScreen();

    }


    private static void performOrderMenue(
            OrderManagementMenu option) throws IOException {

        switch (option) {

            case SHOW_ALL_ORDER:
Screen.clearScreen();
showAllOrderScreen();
                goBackOrderMenue();
                break;

            case ADD_NEW_ORDER:
                Screen.clearScreen();
                showAddOrderScreen();
                goBackOrderMenue();
                break;

            case DELETE_ORDER:
                Screen.clearScreen();
                showDeleteOrderScreen();
                goBackOrderMenue();
                break;

            case UPDATE_ORDER:
                Screen.clearScreen();
                showUpdateOrderScreen();
                goBackOrderMenue();
                break;

            case GO_BACK:
                return;
        }
    }


    private static void goBackOrderMenue() throws IOException {

        System.out.println(
                "\n\nPress Enter to go back to Order Menu..."
        );

        new java.util.Scanner(System.in).nextLine();

        Screen.clearScreen();
        showOrderMenue();
    }


    public static void showOrderMenue() throws IOException {

        if (!Screen.checkAccessRights(Permissions.ORDER_SCREEN))
        {
            return;
        }

        drawScreenHeader(
                "\t\t\tOrder Manegment",
                null
        );

        System.out.print("\n\n");

        System.out.println(
                MyString.tabs((byte) 6)
                        + "************************************************************"
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "************************************************************"
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[1] Show All Order "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[2] Add Order "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[3] Delete Order "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[4] Update Order "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[5] Go Back Main Menue "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "************************************************************"
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "************************************************************"
        );

        performOrderMenue(
                readOption("Enter your choice [ 1 - 5 ] ? ")
        );
    }
}
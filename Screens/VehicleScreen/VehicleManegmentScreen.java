package Screens.Vehicle;

import Core.Permissions;
import Lib.InputValidate;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;

public class VehicleManegmentScreen extends Screen {

    private enum VehicleManagementMenu {

        SHOW_ALL_VEHICLE(1),
        ADD_NEW_VEHICLE(2),
        DELETE_VEHICLE(3),
        UPDATE_VEHICLE(4),
        GO_BACK(5);

        private final short enumOptionValue;

        VehicleManagementMenu(int value) {
            this.enumOptionValue = (short) value;
        }

        public short getEnumOptionValue() {
            return enumOptionValue;
        }
    }


    private static VehicleManagementMenu fromValue(short value) {

        for (VehicleManagementMenu option : VehicleManagementMenu.values()) {

            if (option.getEnumOptionValue() == value) {
                return option;
            }
        }

        return null;
    }


    private static VehicleManagementMenu readOption(String message) {

        System.out.println(MyString.tabs((byte) 6) + message);

        short option = InputValidate.readShortNumberBetween(
                (short) 1,
                (short) 5
        );

        return fromValue(option);
    }


    private static void showAddVehicleScreen() throws IOException {

        AddVehicleScreen.showAddNewVehicleScreen();

    }


    private static void showUpdateVehicleScreen() throws IOException {

        UpdateVehicleScreen.showUpdateVehicleScreen();

    }


    private static void showDeleteVehicleScreen() throws IOException {

        DeleteVehicleScreen.showDeleteScreen();

    }


    private static void showAllVehicleScreen() throws IOException {

        ShowAllVehicleScreen.showAllVehicleScreen();

    }


    private static void performVehicleMenue(
            VehicleManagementMenu option) throws IOException {

        switch (option) {

            case SHOW_ALL_VEHICLE:
                showAllVehicleScreen();
                goBackVehicleMenue();
                break;

            case ADD_NEW_VEHICLE:
                showAddVehicleScreen();
                goBackVehicleMenue();
                break;

            case DELETE_VEHICLE:
                showDeleteVehicleScreen();
                goBackVehicleMenue();
                break;

            case UPDATE_VEHICLE:
                showUpdateVehicleScreen();
                goBackVehicleMenue();
                break;

            case GO_BACK:
                return;
        }
    }


    private static void goBackVehicleMenue() throws IOException {

        System.out.println(
                "\n\nPress Enter to go back to Vehicle Menu..."
        );

        new java.util.Scanner(System.in).nextLine();

        Screen.clearScreen();
        showVehicleMenue();
    }


    public static void showVehicleMenue() throws IOException {

        if (!Screen.checkAccessRights(Permissions.VEHICLE_SCREEN))
        {
            return;
        }

        drawScreenHeader(
                "\t\t\tVehicle Manegment",
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
                        + "[1] Show All Vehicle "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[2] Add Vehicle "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[3] Delete Vehicle "
        );

        System.out.println(
                MyString.tabs((byte) 6)
                        + "[4] Update Vehicle "
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

        performVehicleMenue(
                readOption("Enter your choice [ 1 - 5 ] ? ")
        );
    }
}
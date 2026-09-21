package Screens;

import Lib.InputValidate;
import Lib.MyString;
import Screens.Customer.CustomerMenegmentScreen;
import Screens.Mechanic.MehanicMenegmentScreen;
import Screens.Order.OrderManagmentScreen;
import Screens.User.UserMenegmentMenue;
import Screens.Vehicle.VehicleManegmentScreen;

import java.io.IOException;

public class MainScreen extends Screen{



    private static void goBackMainScreen() throws IOException {

        System.out.println(
                "\n\nPress Enter to go back to Main Menu..."
        );

        new java.util.Scanner(System.in).nextLine();

        Screen.clearScreen();
        showMainScreen();

    }


    private static MainMenueOption fromValue(short value) {

        for (MainMenueOption  option : MainMenueOption.values()) {

            if (option.getEnumOptionValue() == value) {
                return option;
            }
        }

        return null;
    }


    private static MainMenueOption readOption(String message) {

        System.out.println(MyString.tabs((byte) 6) + message);

        short option = InputValidate.readShortNumberBetween(
                (short) 1,
                (short) 6
        );

        return fromValue(option);
    }


private static void showUserManagmentScreen() throws IOException {

        UserMenegmentMenue.showUserMenue();

}

    private static void showMechanivManagmentScreen() throws IOException {

        MehanicMenegmentScreen.showMechanicMenue();

    }

    private static void showCustomerManagmentScreen() throws IOException {

        CustomerMenegmentScreen.showCustomerMenue();

    }

    private static void showVehicleManagmentScreen() throws IOException {

        VehicleManegmentScreen.showVehicleMenue();
    }

    private static void showOrderManagmentScreen() throws IOException {

        OrderManagmentScreen.showOrderMenue();

    }

    private static void showLogoutScreen() throws IOException {

        System.out.println("Byeeeeeeeeee");

    }

    private static void performOrderMenue(MainMenueOption option) throws IOException{

        switch (option){

            case USER_MENUE :{

                Screen.clearScreen();
                showUserManagmentScreen();
                goBackMainScreen();
                break;
            }

            case MECHANIC_MENUE:{

                Screen.clearScreen();
showMechanivManagmentScreen();
goBackMainScreen();
                break;


            }

            case CUSTOMER_MENUE:{

                Screen.clearScreen();
showCustomerManagmentScreen();
                goBackMainScreen();
                break;


            }

            case VEHICLE_MENUE:{


                Screen.clearScreen();
                showVehicleManagmentScreen();
                goBackMainScreen();
                break;
            }

            case ORDER_MENUE:{

                Screen.clearScreen();
                showOrderManagmentScreen();
                goBackMainScreen();
                break;

            }

            case LOGOUT:{


                showLogoutScreen();
            }
        }


    }


public static  void showMainScreen() throws IOException {


        Screen.drawScreenHeader("Mechanic Managment System",null);


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
                    + "[1] User Menagment "
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "[2] Mechanic Menagment "
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "[3] Customer Menagment  "
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "[4] Vehicle Menagment "
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "[5] Order Menagment"
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "[6] Logout "
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "************************************************************"
    );

    System.out.println(
            MyString.tabs((byte) 6)
                    + "************************************************************"
    );
    performOrderMenue(readOption("Enter your choice [ 1 - 6 ] ? "));

}



}

package Screens.Mechanic;
import Core.Permissions;
import Lib.InputValidate;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;

public class MehanicMenegmentScreen extends Screen{

    private enum MechanicManagementMenu {

        SHOW_ALL_Mechanic(1),
        ADD_NEW_Mechanic(2),
        DELETE_Mechanic(3),
        UPDATE_Mechanic(4),
        GO_BACK(5);

        private final short enumOptionValue;

        MechanicManagementMenu(int value) {
            this.enumOptionValue = (short) value;
        }

        public short getEnumOptionValue() {
            return enumOptionValue;
        }
    }

    private static MechanicManagementMenu fromValue(short value) {

        for (MechanicManagementMenu option : MechanicManagementMenu.values()) {

            if (option.getEnumOptionValue() == value) {
                return option;
            }
        }

        return null;
    }

    private static MechanicManagementMenu readOption(String message) {

        System.out.println(MyString.tabs((byte) 6) + message);

        short option = InputValidate.readShortNumberBetween(
                (short) 1,
                (short) 5
        );

        return fromValue(option);
    }


    private static void showAddMechanicScreen() throws IOException {

        AddMechanicScreen.showAddNewMechanicScreen();
}

    private static void showUpdateMechanicScreen() throws IOException {

       UpdateMechanicScreen.showUpdateMechanicScreen();
    }

    private static void showDeleteMechanicScreen() throws IOException {

        DeleteMechanicScreen.showDeleteScreen();

    }

    private static void showAllMechanicScreen() throws IOException {

      ShowAllMechanicScreen.showAllMechanicScreen();

    }

private static void performMechanicMenue(MechanicManagementMenu option) throws IOException {

    switch (option) {

        case SHOW_ALL_Mechanic:
           showAllMechanicScreen();
           goBackMechanicMenue();
            break;

        case ADD_NEW_Mechanic:
            showAddMechanicScreen();
            goBackMechanicMenue();
            break;

        case DELETE_Mechanic:
            showDeleteMechanicScreen();
            goBackMechanicMenue();
            break;

        case UPDATE_Mechanic:
            showUpdateMechanicScreen();
            goBackMechanicMenue();
            break;

        case GO_BACK:
return;
    }

}


    private static void goBackMechanicMenue() throws IOException {

        System.out.println("\n\nPress Enter to go back to Mechanic Menu...");
        new java.util.Scanner(System.in).nextLine();

        Screen.clearScreen();
        showMechanicMenue();

    }

    public static void showMechanicMenue() throws IOException {

        if (!Screen.checkAccessRights(Permissions.MECHANIC_SCREEN))
        {
            return;
        }

        drawScreenHeader("\t\t\tMechnics Manegment", null);

        System.out.print("\n\n");
        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );
        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );
        System.out.println(MyString.tabs((byte) 6) + "[1] Show All Mechanic ");
        System.out.println(MyString.tabs((byte) 6) + "[2] Add Mechanic ");
        System.out.println(MyString.tabs((byte) 6) + "[3] Delete Mechanic ");
        System.out.println(MyString.tabs((byte) 6) + "[4] Update Mechanic ");
        System.out.println(MyString.tabs((byte) 6) + "[5] Go Back Main Menue ");

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );
        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );
        performMechanicMenue(readOption("Enter your choice [ 1 - 5 ] ? "));
    }


}





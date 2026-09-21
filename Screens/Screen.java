/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Screens;

import Core.Permissions;
import Lib.MyString;

import java.security.Permission;

/**
 *
 * @author maysj
 */
public abstract class Screen {

    protected static void drawScreenHeader(String mainTitle, String subTitle) {

        System.out.println();

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );

        System.out.println(MyString.tabs((byte) 6)
                + MyString.tabs((byte) 3)
                + mainTitle
                + MyString.tabs((byte) 6)
        );

        if (subTitle != null) {

            System.out.println(MyString.tabs((byte) 6)
                    + "************************************************************"
            );

            System.out.println(MyString.tabs((byte) 6)
                    + MyString.tabs((byte) 3)
                    + subTitle
                    + MyString.tabs((byte) 6)
            );
        }

        System.out.println(MyString.tabs((byte) 6)
                + "************************************************************"
        );
        System.out.println(MyString.tabs((byte) 6) + MyString.getSystemDateTimeString());
    }

    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


   protected static boolean checkAccessRights(Permissions p) {

        if (!CurrentUser.currentUser.checkAccessPermission(p)){

            System.out.println("***************************************************************************************");
            System.out.println("\n\n\t\t\t\t\t  Access Denied! Contact your Admin.");
            System.out.println("***************************************************************************************");

            return false;
        }
        return true;
    }
}

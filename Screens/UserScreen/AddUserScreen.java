/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Screens.User;

import Core.Permissions;
import Core.User;
import Core.SavedResult;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author maysj
 */
public class AddUserScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static int readPermissionsToSet()
    {

        int permissions = 0;
        char answer = 'n';


        System.out.println("\nDo you want to give full access? y/n? ");
        answer=in.next().charAt(0);
        if (answer == 'y' || answer == 'Y')
        {
            return -1;
        }

        System.out.println("\nDo you want to give access to : \n ");
        System.out.println( "\nUser Menue List? y/n? ");
        answer=in.next().charAt(0);
        if (answer == 'y' || answer == 'Y')
        {


            permissions += Permissions.USER_SCREEN.getEnumOptionValue();
        }

        System.out.println("\nMechanic Menue? y/n? ");
        answer=in.next().charAt(0);

        if (answer == 'y' || answer == 'Y')
        {
            permissions += Permissions.MECHANIC_SCREEN.getEnumOptionValue();
        }

        System.out.println("\n Customer Menue? y/n? ");
        answer=in.next().charAt(0);
        if (answer == 'y' || answer == 'Y')
        {
            permissions += Permissions.CUSTOMER_SCREEN.getEnumOptionValue();
        }

        System.out.println("\nVechile Menue? y/n? ");
        answer=in.next().charAt(0);
        if (answer == 'y' || answer == 'Y')
        {
            permissions += Permissions.VEHICLE_SCREEN.getEnumOptionValue();
        }

        System.out.println( "\nOrder Menue? y/n? ");
        answer=in.next().charAt(0);
        if (answer == 'y' || answer == 'Y')
        {
            permissions += Permissions.ORDER_SCREEN.getEnumOptionValue();
        }

        return permissions;

    }




    private static void readUserInfo(User user) {

        System.out.println("\nEnter User Information:");

        System.out.print("User Name: ");
        user.setUserName(in.nextLine());

        System.out.print("Name: ");
        user.setName(in.nextLine());

        System.out.print("Age: ");
        user.setAge(in.nextInt());
        in.nextLine();

        System.out.print("ID: ");
        user.setId(in.nextLine());

        System.out.print("Password: ");
        user.setPassword(in.nextLine());

        System.out.print("Phone: ");
        user.setPhone(in.nextLine());

        System.out.print("Address: ");
        user.setAddress(in.nextLine());

        System.out.print("Email: ");
        user.setEmail(in.nextLine());


        System.out.print("Permissions: ");
        user.setPremissions(readPermissionsToSet());



    }

    public static void showAddNewUserScreen() throws IOException {

        Screen.drawScreenHeader("Add User", null);
        User u = new User();
         readUserInfo(u);

        SavedResult saveR = u.addUser();
        switch (saveR) {
            case SUCCESSFULLY_ADD:
        System.out.println("User added successfully :)");
                break;
            case FAILED_ALREADY_EXISTS:
                 System.out.println("Failed to add user: User already exists :(");
                break;

        }

    }

}

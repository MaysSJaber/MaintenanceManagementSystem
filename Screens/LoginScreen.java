package Screens;

import Core.User;

import java.io.IOException;
import java.util.Scanner;

public class LoginScreen extends Screen {

    private static Scanner in = new Scanner(System.in);

private  static  boolean login() throws IOException {

        boolean loginFaild = false;
        int failedTries = 0;
        String username, password;
        do
        {

            if (loginFaild)
            {
                failedTries++;
                System.out.println("\nInvlaid Username/Password!\n");
                System.out.println( "You have "+ (3-failedTries ) +" trials left.\n");
            }
            if (failedTries == 3) {

                System.out.println( "\nYour are Locked after 3 faild trails \n");
                return false;
            }

            System.out.println("Enter Username? ");
            username=in.next();

            System.out.println("Enter Password? ");
            password=in.next();

            CurrentUser.currentUser = User.findUser(username, password);

            loginFaild = CurrentUser.currentUser==null?true:false;

        } while (loginFaild);

MainScreen.showMainScreen();
return true;
    }



 public static boolean ShowLoginScreen() throws IOException {
        clearScreen();
        drawScreenHeader("\t  Login Screen",null);
        return login();

    }






}

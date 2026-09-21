package Screens.User;

import Core.User;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class DeleteUserScreen extends Screen {

    static Scanner in = new Scanner(System.in);
    private static void printUSerInfo(User user){
        System.out.println(MyString.tabs((byte)4)+"--------------------------------------------------------");
        System.out.println(MyString.tabs((byte)4)+" User Information : " );
        System.out.println(MyString.tabs((byte)4)+" User Name : " + user.getUserName());
        System.out.println(MyString.tabs((byte)4)+" Name : " + user.getName());
        System.out.println(MyString.tabs((byte)4)+" Age : " + user.getAge());
        System.out.println(MyString.tabs((byte)4)+" ID : " + user.getId());
        System.out.println(MyString.tabs((byte)4)+" Password : " + user.getPassword());
        System.out.println(MyString.tabs((byte)4)+" Phone : " + user.getPhone());
        System.out.println(MyString.tabs((byte)4)+" Adraress : " + user.getAddress());
        System.out.println(MyString.tabs((byte)4)+" Email : " + user.getEmail());
        System.out.println(MyString.tabs((byte)4)+" Permission : " + user.getPremissions());

        System.out.println(MyString.tabs((byte)4)+"--------------------------------------------------------");


    }

    public static void showDeleteScreen() throws IOException {

    drawScreenHeader("Delete User",null);

    System.out.print("\n\n");

    System.out.print("Enter User Name : ");
   String userName = in.nextLine();
   User u ;
   if((u=User.findUser(userName))!=null){
       printUSerInfo(u);

       Character sure ='n';
       System.out.println("Are you sure ? you want delete user ? [y][n]");
       sure = in.next().charAt(0);
       if(Character.toLowerCase(sure)=='y'){

             u.delete();
           System.out.println(" Deleted Successfully :) .");
           return;

}


  }

        System.out.println("User Not Found :( .");


}
    }

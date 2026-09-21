package Screens.User;

import Core.User;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllUserScreen extends Screen {

    private static void printUserCurd(User u){
    if(u!=null) {

        System.out.print(MyString.tabs((byte) 6));

        MyString.printLeft(u.getUserName(), 15, "left");
        System.out.print("| ");

        MyString.printLeft(u.getName(), 20, "left");
        System.out.print("| ");

        MyString.printLeft(u.getAge() + "", 5, "left");
        System.out.print("| ");

        MyString.printLeft(u.getId(), 10, "left");
        System.out.print("| ");

        MyString.printLeft(u.getPassword(), 12, "left");
        System.out.print("| ");

        MyString.printLeft(u.getPhone(), 15, "left");
        System.out.print("| ");

        MyString.printLeft(u.getAddress(), 15, "left");
        System.out.print("| ");

        MyString.printLeft(u.getEmail(), 25, "left");
        System.out.print("| ");

        MyString.printLeft(u.getPremissions()+"", 3, "left");

        System.out.println();

    }

}


public static void printHeaderTabel() {
        System.out.println(MyString.tabs((byte)3)+"----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print(MyString.tabs((byte)6));

        MyString.printLeft("User Name", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Full Name", 20, "left");
        System.out.print("| ");

        MyString.printLeft("Age", 5, "left");
        System.out.print("| ");

        MyString.printLeft("ID", 10, "left");
        System.out.print("| ");

        MyString.printLeft("Password", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Phone", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Address", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Email", 25, "left");
    System.out.print("| ");

    MyString.printLeft("Permissions", 3, "left");


    System.out.println();
        System.out.println(MyString.tabs((byte)3)+"----------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static void showAllUserScreen() throws IOException {

        ArrayList<User>userList = User.getUserList();
        drawScreenHeader("Show All User",userList.size()+" User(s) In System");
        System.out.println("\n");
        printHeaderTabel();
        if(userList.size() == 0){

            System.out.println(MyString.tabs((byte)6)+"No users available in the system.");
return;
        }

        for(User u : userList){

            printUserCurd(u);
            System.out.print("\n");
        }

    }


}

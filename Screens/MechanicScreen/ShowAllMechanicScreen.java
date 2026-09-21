package Screens.Mechanic;
import Core.User;
import Lib.MyString;
import Core.Mechanic;
import Screens.Screen;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllMechanicScreen extends Screen {

    private static void printMechanicCurd(Mechanic m) {

        if (m != null) {

            System.out.print(MyString.tabs((byte) 6));

            MyString.printLeft(m.getName(), 25, "left");
            System.out.print("| ");

            MyString.printLeft(m.getAge() + "", 5, "left");
            System.out.print("| ");

            MyString.printLeft(m.getAddress(), 20, "left");
            System.out.print("| ");

            MyString.printLeft(m.getPhone(), 15, "left");
            System.out.print("| ");

            MyString.printLeft(m.getEmail(), 30, "left");
            System.out.print("| ");

            MyString.printLeft(m.getId(), 10, "left");
            System.out.print("| ");

            MyString.printLeft(m.getSalary() + "", 12, "left");
            System.out.print("| ");

            MyString.printLeft(m.getSpecialization(), 25, "left");
            System.out.print("| ");

            MyString.printLeft(m.getExperienceYears() + "", 18, "left");

            System.out.println();
        }
    }


    public static void printHeaderTabel() {

        System.out.println(MyString.tabs((byte)3)
                + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print(MyString.tabs((byte)6));

        MyString.printLeft("Full Name", 25, "left");
        System.out.print("| ");

        MyString.printLeft("Age", 5, "left");
        System.out.print("| ");

        MyString.printLeft("Address", 20, "left");
        System.out.print("| ");

        MyString.printLeft("Phone", 15, "left");
        System.out.print("| ");

        MyString.printLeft("Email", 30, "left");
        System.out.print("| ");

        MyString.printLeft("ID", 10, "left");
        System.out.print("| ");

        MyString.printLeft("Salary", 12, "left");
        System.out.print("| ");

        MyString.printLeft("Specialization", 25, "left");
        System.out.print("| ");

        MyString.printLeft("Experience Years", 18, "left");

        System.out.println();

        System.out.println(MyString.tabs((byte)3)
                + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void showAllMechanicScreen() throws IOException {

        ArrayList<Mechanic> mechanicList = Mechanic.getMechanicList();
        drawScreenHeader("Show All Mechanic", mechanicList.size()+" Mechanic(s) In System");
        System.out.println("\n");
        printHeaderTabel();
        if(mechanicList.size() == 0){

            System.out.println(MyString.tabs((byte)6)+"No Mechanics available in the system.");
            return;
        }

        for(Mechanic m : mechanicList){

            printMechanicCurd(m);
            System.out.print("\n");
        }

    }

}

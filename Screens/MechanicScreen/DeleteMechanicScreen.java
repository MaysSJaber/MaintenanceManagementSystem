package Screens.Mechanic;

import Core.Mechanic;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class DeleteMechanicScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void printMechanicInfo(Mechanic mechanic) {

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
        System.out.println(MyString.tabs((byte)4) + " Mechanic Information : ");

        System.out.println(MyString.tabs((byte)4) + " Name : " + mechanic.getName());
        System.out.println(MyString.tabs((byte)4) + " Age : " + mechanic.getAge());
        System.out.println(MyString.tabs((byte)4) + " Address : " + mechanic.getAddress());
        System.out.println(MyString.tabs((byte)4) + " Phone : " + mechanic.getPhone());
        System.out.println(MyString.tabs((byte)4) + " Email : " + mechanic.getEmail());

        System.out.println(MyString.tabs((byte)4) + " ID : " + mechanic.getId());
        System.out.println(MyString.tabs((byte)4) + " Salary : " + mechanic.getSalary());

        System.out.println(MyString.tabs((byte)4) + " Specialization : " + mechanic.getSpecialization());
        System.out.println(MyString.tabs((byte)4) + " Experience Years : " + mechanic.getExperienceYears());

        System.out.println(MyString.tabs((byte)4) + "--------------------------------------------------------");
    }

    public static void showDeleteScreen() throws IOException {

        drawScreenHeader("Delete Mechanic",null);

        System.out.print("\n\n");

        System.out.print("Enter ID  : ");
        String id = in.nextLine();
        Mechanic u ;
        if((u=Mechanic.findMechanic(id))!=null){
            printMechanicInfo(u);

            Character sure ='n';
            System.out.println("Are you sure ? you want delete mechanic ? [y][n]");
            sure = in.next().charAt(0);
            if(Character.toLowerCase(sure)=='y'){

                u.delete();
                System.out.println(" Deleted Successfully :) .");
                return;

            }
else return;

        }

        System.out.println("Mechanic Not Found :( .");


    }


}

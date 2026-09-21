package Screens.Mechanic;

import Core.Mechanic;
import Core.User;
import Lib.MyString;
import Screens.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateMechanicScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readMechanicInfo(Mechanic mechanic) {

        System.out.println("\nEnter Mechanic Information:");

        System.out.print("Name: ");
        mechanic.setName(in.nextLine());

        System.out.print("Age: ");
        mechanic.setAge(in.nextInt());
        in.nextLine();

        System.out.print("Address: ");
        mechanic.setAddress(in.nextLine());

        System.out.print("Phone: ");
        mechanic.setPhone(in.nextLine());

        System.out.print("Email: ");
        mechanic.setEmail(in.nextLine());


        System.out.print("Salary: ");
        mechanic.setSalary(in.nextDouble());
        in.nextLine();

        System.out.print("Specialization: ");
        mechanic.setSpecialization(in.nextLine());

        System.out.print("Experience Years: ");
        mechanic.setExperienceYears(in.nextInt());
        in.nextLine();
    }


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

    public static void showUpdateMechanicScreen() throws IOException {

        drawScreenHeader("Update Mechanic",null);
        System.out.print("\n\nEnter ID : ");
        String id = in.nextLine();
        Mechanic m ;
        if((m = Mechanic.findMechanic(id))!=null){
            printMechanicInfo(m);

            readMechanicInfo(m);
        System.out.println("Are You Sure ?You Want Update Mechanic ?[y][n] ");
            Character sure = 'n';
            sure = in.next().charAt(0);
            if(Character.toLowerCase(sure)=='y'){

                m.update();
printMechanicInfo(m);
                System.out.println("Updated Successfully :) . ");
                return;


            }
            else return ;
        }

        System.out.println("Mechanic Not Found :( . ");

    }




}

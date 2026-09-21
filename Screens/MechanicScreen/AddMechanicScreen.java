package Screens.Mechanic;
import Core.Mechanic;
import Core.SavedResult;
import Screens.Screen;

import java.io.IOException;
import java.util.Scanner;

public class AddMechanicScreen extends Screen {

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

        System.out.print("ID: ");
        mechanic.setId(in.nextLine());

        System.out.print("Salary: ");
        mechanic.setSalary(in.nextDouble());
        in.nextLine();

        System.out.print("Specialization: ");
        mechanic.setSpecialization(in.nextLine());

        System.out.print("Experience Years: ");
        mechanic.setExperienceYears(in.nextInt());
        in.nextLine();
    }

    public static void showAddNewMechanicScreen() throws IOException {

        Screen.drawScreenHeader("\t\t\tAdd Mechanic", null);
        Mechanic m = new Mechanic();
        readMechanicInfo(m);

        SavedResult saveR = m.addMechanic();
        switch (saveR) {
            case SUCCESSFULLY_ADD:
                System.out.println("Mechanic added successfully :)");
                break;
            case FAILED_ALREADY_EXISTS:
                System.out.println("Failed to add Mechanic: Mechanic already exists :(");
                break;

        }

    }



}

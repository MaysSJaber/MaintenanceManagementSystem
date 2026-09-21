package Screens.Order;

import Core.SavedResult;
import Screens.Screen;
import Service.Order;
import Service.OrderStatus;
import Service.SavedResultOrder;
import Service.Vehicle;

import java.io.IOException;
import java.util.Scanner;

public class AddOrderScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    private static void readOrderInfo(Order order) {

        System.out.println("\nEnter Order Information:");

        System.out.print("Order ID: ");
        order.setOrderId(in.nextLine());

        System.out.print("Customer ID: ");
        order.setCustomerId(in.nextLine());

        System.out.print("Vehicle ID: ");
        order.setVehicleId(in.nextLine());

        System.out.print("Mechanic ID: ");
        order.setMechanicId(in.nextLine());

        System.out.print("Problem Description: ");
        order.setProblemDescription(in.nextLine());

        order.setStatus(OrderStatus.PENDING);

        System.out.print("Total Cost: ");
        order.setTotalCost(in.nextDouble());
        in.nextLine();
    }

    public static void showAddNewOrderScreen()
            throws IOException {

        Screen.drawScreenHeader("\t\t\tAdd Order",null);

        Order order = new Order();

       readOrderInfo(order);

        SavedResultOrder saveR = order.addOrder();

        switch (saveR) {

            case SUCCESSFULLY_ADD:
                System.out.println(
                        "Order added successfully :)"
                );
                break;

            case FAILED_ID_ORDER_EXISTS:
                System.out.println(
                        "Failed to add Order: Order already exists :( "
                );
                break;
            case FAILED_ID_DOSE_NOT_EXISTS:{

                System.out.println(
                        "Failed to add Order: [Mechanic] , [Customer] or [Vehicle] dose not exists :( "
                );
                break;
            }

        }
    }



}

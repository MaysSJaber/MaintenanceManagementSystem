package Screens.Order;

import Screens.Screen;
import Service.Order;

import java.io.IOException;
import java.util.Scanner;

public class DeleteOrderScreen extends Screen {

    static Scanner in = new Scanner(System.in);

    public static void showDeleteOrderScreen()
            throws IOException {

        drawScreenHeader("Delete Order", null);

        System.out.print("\n\nEnter Order ID: ");
        String orderId = in.nextLine();

        Order order = Order.findOrder(orderId);

        // Validation: Order ID must exist

        if (order == null) {

            System.out.println(
                    "Order ID [" + orderId + "] does not exist :( "
            );

            return;
        }

        System.out.println("\nOrder Information:");
        System.out.println("----------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer ID: " + order.getCustomerId());
        System.out.println("Vehicle ID: " + order.getVehicleId());
        System.out.println("Mechanic ID: " + order.getMechanicId());
        System.out.println("Problem: " + order.getProblemDescription());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Total Cost: " + order.getTotalCost());
        System.out.println("----------------------------");

        System.out.print(
                "\nAre you sure you want to delete this order? [y][n]: "
        );

        char answer = in.next().charAt(0);
        in.nextLine();

        if (Character.toLowerCase(answer) == 'y') {

            if (order.delete()) {

                System.out.println(
                        "\nOrder deleted successfully :)"
                );

            } else {

                System.out.println(
                        "\nFailed to delete order :("
                );
            }

        } else {

            System.out.println(
                    "\nDelete operation cancelled."
            );
        }
    }
}
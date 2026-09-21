package Service;

import Core.Customer;
import Core.Mechanic;

import java.io.*;
import java.util.ArrayList;

public class Order {

    private String orderId;
    private String customerId;
    private String vehicleId;
    private String mechanicId;
    private String problemDescription;
    private OrderStatus status;
    private double totalCost;
    private static final String  filePath = "Orders.txt";
    private boolean markToDelete;

    public Order() {
    }

    public Order(String orderId, String customerId, String vehicleId,
                 String mechanicId, String problemDescription,
                 OrderStatus status, double totalCost) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.mechanicId = mechanicId;
        this.problemDescription = problemDescription;
        this.status = status;
        this.totalCost = totalCost;
    }

    public Order(String orderId, Customer c , Vehicle v, Mechanic m ,String problemDescription,
                 OrderStatus status, double totalCost){

        this.orderId = orderId;
        this.customerId = c.getId();
        this.vehicleId = v.getVehicleId();
        this.mechanicId =m.getId();
        this.problemDescription = problemDescription;
        this.status = status;
        this.totalCost = totalCost;

    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(String mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }


    private static Order convertLineRecordToObjectOrder(
            String recordLine, String separator) {

        String[] orderInfo = recordLine.split(separator);

        return new Order(
                orderInfo[0],
                orderInfo[1],
                orderInfo[2],
                orderInfo[3],
                orderInfo[4],
                OrderStatus.valueOf(orderInfo[5]),
                Double.parseDouble(orderInfo[6])
        );
    }


    protected String convertObjectToRecordLine(String separator) {

        StringBuilder line = new StringBuilder();

        line.append(this.getOrderId());
        line.append(separator);

        line.append(this.getCustomerId());
        line.append(separator);

        line.append(this.getVehicleId());
        line.append(separator);

        line.append(this.getMechanicId());
        line.append(separator);

        line.append(this.getProblemDescription());
        line.append(separator);

        line.append(this.getStatus());
        line.append(separator);

        line.append(this.getTotalCost());

        return line.toString();
    }


    private static ArrayList<Order> loadOrderFromFile()
            throws FileNotFoundException, IOException {

        ArrayList<Order> orderList = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return orderList;
        }

        FileReader reader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.trim().isEmpty()) {
                continue;
            }

            orderList.add(
                    convertLineRecordToObjectOrder(line, "#//#")
            );
        }

        return orderList;
    }

    public static boolean isOrderExist(String orderId)
            throws IOException {

        ArrayList<Order> list = loadOrderFromFile();

        for (Order order : list) {

            if (order.getOrderId().equals(orderId)) {
                return true;
            }
        }

        return false;
    }


    private void add() throws IOException {

        File myFile = new File(filePath);

        FileWriter addToFile = new FileWriter(myFile, true);

        String line = convertObjectToRecordLine("#//#");

        addToFile.write(line);
        addToFile.write("\n");

        addToFile.close();
    }

    public SavedResultOrder addOrder() throws IOException {

        if (isOrderExist(this.getOrderId())) {

                return SavedResultOrder.FAILED_ID_ORDER_EXISTS;

        }

        else if(!Vehicle.isVehicleExist(this.vehicleId)||!Mechanic.isMechanicExist(this.mechanicId)||!Customer.isCustomerExist(this.customerId)) {

                 return SavedResultOrder.FAILED_ID_DOSE_NOT_EXISTS;
        }

        else {
            add();

            return SavedResultOrder.SUCCESSFULLY_ADD;
        }
    }

    private void saveAllOrderToFile(
            ArrayList<Order> orderList) throws IOException {

        File myFile = new File(filePath);

        // Clear all data in file and insert the new data

        FileWriter addToFile = new FileWriter(myFile);

        String line;

        for (Order order : orderList) {

            if (!order.markToDelete) {

                line = order.convertObjectToRecordLine("#//#");

                addToFile.write(line);
                addToFile.write("\n");
            }
        }

        addToFile.close();
    }


    private void markedForDelete() throws IOException {

        ArrayList<Order> orderList = loadOrderFromFile();

        for (Order order : orderList) {

            if (order.getOrderId().equals(this.getOrderId())) {

                order.markToDelete = true;
            }
        }

        saveAllOrderToFile(orderList);
    }

    public boolean delete() throws IOException {

        if (this != null && isOrderExist(this.getOrderId())) {

            markedForDelete();

            return true;
        }

        return false;
    }

    public static Order findOrder(String orderId)
            throws IOException {

        ArrayList<Order> list = loadOrderFromFile();

        for (Order order : list) {

            if (order.getOrderId().equals(orderId)) {

                return order;
            }
        }

        return null;
    }


    public boolean update() throws IOException {

        ArrayList<Order> orderList =
                loadOrderFromFile();

        for (int i = 0; i < orderList.size(); i++) {

            if (this.getOrderId()
                    .equals(orderList.get(i).getOrderId())) {

                orderList.set(i, this);

                saveAllOrderToFile(orderList);

                return true;
            }
        }

        return false;
    }

    public static ArrayList<Order> getOrderList()
            throws IOException {

        return loadOrderFromFile();
    }

}

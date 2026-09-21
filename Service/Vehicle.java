package Service;
import Core.SavedResult;
import java.io.*;
import java.util.ArrayList;

public class Vehicle {

    private String vehicleId;
    private String customerId;
    private String plateNumber;
    private String brand;
    private String model;
    private int year;
    private String color;
    private static final String filePath = "Vehicles.txt";
    private boolean markToDelete;


    private static Vehicle convertLineRecordToObjectVehicle(
            String recordLine, String separator) {

        String[] vehicleInfo = recordLine.split(separator);

        return new Vehicle(
                vehicleInfo[0],
                vehicleInfo[1],
                vehicleInfo[2],
                vehicleInfo[3],
                vehicleInfo[4],
                Integer.parseInt(vehicleInfo[5]),
                vehicleInfo[6]
        );
    }


    protected String convertObjectToRecordLine(String separator) {

        StringBuilder line = new StringBuilder();

        line.append(this.getVehicleId());
        line.append(separator);

        line.append(this.getCustomerId());
        line.append(separator);

        line.append(this.getPlateNumber());
        line.append(separator);

        line.append(this.getBrand());
        line.append(separator);

        line.append(this.getModel());
        line.append(separator);

        line.append(this.getYear());
        line.append(separator);

        line.append(this.getColor());

        return line.toString();
    }


    private static ArrayList<Vehicle> loadVehicleFromFile()
            throws FileNotFoundException, IOException {

        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return vehicleList;
        }

        FileReader reader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            if (line.trim().isEmpty()) {
                continue;
            }

            vehicleList.add(
                    convertLineRecordToObjectVehicle(line, "#//#")
            );
        }

        return vehicleList;
    }


    public Vehicle(String vehicleId, String customerId,
                   String plateNumber, String brand,
                   String model, int year, String color) {

        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.markToDelete = false;
    }


    public Vehicle() {
    }


    private boolean isVehicleEqual(Vehicle v) {

        return this.getVehicleId().equals(v.getVehicleId())
                && this.getCustomerId().equals(v.getCustomerId())
                && this.getPlateNumber().equals(v.getPlateNumber())
                && this.getBrand().equals(v.getBrand())
                && this.getModel().equals(v.getModel())
                && this.getYear() == v.getYear()
                && this.getColor().equals(v.getColor());
    }


    public String getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public static boolean isVehicleExist(String vehicleId)
            throws IOException {

        ArrayList<Vehicle> list = loadVehicleFromFile();

        for (Vehicle vehicle : list) {

            if (vehicle.getVehicleId().equals(vehicleId)) {
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


    public SavedResult addVehicle() throws IOException {

        if (isVehicleExist(this.getVehicleId())) {

            return SavedResult.FAILED_ALREADY_EXISTS;

        } else {

            add();

            return SavedResult.SUCCESSFULLY_ADD;
        }
    }


    private void saveAllVehicleToFile(
            ArrayList<Vehicle> vehicleList) throws IOException {

        File myFile = new File(filePath);

        // Clear all data in file and insert the new data

        FileWriter addToFile = new FileWriter(myFile);

        String line;

        for (Vehicle vehicle : vehicleList) {

            if (!vehicle.markToDelete) {

                line = vehicle.convertObjectToRecordLine("#//#");

                addToFile.write(line);
                addToFile.write("\n");
            }
        }

        addToFile.close();
    }


    private void markedForDelete() throws IOException {

        ArrayList<Vehicle> vehicleList = loadVehicleFromFile();

        for (Vehicle vehicle : vehicleList) {

            if (vehicle.isVehicleEqual(this)) {

                vehicle.markToDelete = true;
            }
        }

        saveAllVehicleToFile(vehicleList);
    }


    public boolean delete() throws IOException {

        if (this != null && isVehicleExist(this.getVehicleId())) {

            markedForDelete();

            return true;
        }

        return false;
    }


    public static Vehicle findVehicle(String vehicleId)
            throws IOException {

        ArrayList<Vehicle> list = loadVehicleFromFile();

        for (Vehicle vehicle : list) {

            if (vehicle.getVehicleId().equals(vehicleId)) {

                return vehicle;
            }
        }

        return null;
    }


    public boolean update() throws IOException {

        ArrayList<Vehicle> vehicleList =
                loadVehicleFromFile();

        for (int i = 0; i < vehicleList.size(); i++) {

            if (this.getVehicleId()
                    .equals(vehicleList.get(i).getVehicleId())) {

                vehicleList.set(i, this);

                saveAllVehicleToFile(vehicleList);

                return true;
            }
        }

        return false;
    }


    public static ArrayList<Vehicle> getVehicleList()
            throws IOException {

        return loadVehicleFromFile();
    }
}
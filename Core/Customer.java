package Core;

import java.io.*;
import java.util.ArrayList;

public class Customer extends Person{

    private String id;
    private boolean markToDelete;
    private static final String filePath= "Customers.txt";

        private static Customer convertLineRecordToObjectCustomer(
                String recordLine, String separator) {

            String[] customerInfo = recordLine.split(separator);

            return new Customer(
                    customerInfo[0],
                    Integer.parseInt(customerInfo[1]),
                    customerInfo[2],
                    customerInfo[3],
                    customerInfo[4],
                    customerInfo[5]
            );
        }


        protected String convertObjectToRecordLine(String separator) {

            StringBuilder line = new StringBuilder();

            line.append(this.getName());
            line.append(separator);

            line.append(this.getAge());
            line.append(separator);

            line.append(this.getAddress());
            line.append(separator);

            line.append(this.getPhone());
            line.append(separator);

            line.append(this.getEmail());
            line.append(separator);

            line.append(this.getId());

            return line.toString();
        }


        private static ArrayList<Customer> loadCustomerFromFile()
                throws FileNotFoundException, IOException {

            ArrayList<Customer> customerList = new ArrayList<>();

            File file = new File(filePath);

            if (!file.exists()) {
                return customerList;
            }

            FileReader reader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                customerList.add(
                        convertLineRecordToObjectCustomer(line, "#//#")
                );
            }

            return customerList;
        }


        public Customer(String name, int age, String address,
                        String phone, String email, String id) {

            super(name, age, address, phone, email);

            this.id = id;
            this.markToDelete = false;
        }


        public Customer() {
        }


        private boolean isCustomerEqual(Customer c) {

            return this.getName().equals(c.getName())
                    && this.getAge() == c.getAge()
                    && this.getAddress().equals(c.getAddress())
                    && this.getPhone().equals(c.getPhone())
                    && this.getEmail().equals(c.getEmail())
                    && this.getId().equals(c.getId());
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public static boolean isCustomerExist(String id) throws IOException {

            ArrayList<Customer> list = loadCustomerFromFile();

            for (Customer customer : list) {

                if (customer.getId().equals(id)) {
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


        public SavedResult addCustomer() throws IOException {

            if (isCustomerExist(this.getId())) {

                return SavedResult.FAILED_ALREADY_EXISTS;

            } else {

                add();

                return SavedResult.SUCCESSFULLY_ADD;
            }
        }


        private void saveAllCustomerToFile(
                ArrayList<Customer> customerList) throws IOException {

            File myFile = new File(filePath);

            // Clear all data in file and insert the new data

            FileWriter addToFile = new FileWriter(myFile);

            String line;

            for (Customer customer : customerList) {

                if (!customer.markToDelete) {

                    line = customer.convertObjectToRecordLine("#//#");

                    addToFile.write(line);
                    addToFile.write("\n");
                }
            }

            addToFile.close();
        }


        private void markedForDelete() throws IOException {

            ArrayList<Customer> customerList = loadCustomerFromFile();

            for (Customer customer : customerList) {

                if (customer.isCustomerEqual(this)) {

                    customer.markToDelete = true;
                }
            }

            saveAllCustomerToFile(customerList);
        }


        public boolean delete() throws IOException {

            if (this != null && isCustomerExist(this.getId())) {

                markedForDelete();

                return true;
            }

            return false;
        }


        public static Customer findCustomer(String id) throws IOException {

            ArrayList<Customer> list = loadCustomerFromFile();

            for (Customer customer : list) {

                if (customer.getId().equals(id)) {

                    return customer;
                }
            }

            return null;
        }


        public boolean update() throws IOException {

            ArrayList<Customer> customerList =
                    loadCustomerFromFile();

            for (int i = 0; i < customerList.size(); i++) {

                if (this.getId().equals(customerList.get(i).getId())) {

                    customerList.set(i, this);

                    saveAllCustomerToFile(customerList);

                    return true;
                }
            }

            return false;
        }


        public static ArrayList<Customer> getCustomerList()
                throws IOException {

            return loadCustomerFromFile();
        }
    }

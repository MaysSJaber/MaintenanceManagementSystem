package Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maysj
 */
public class User extends Person {

    private int premissions;
    private String UserName;
    private String password;
    private String id;
    private boolean markToDelete;
    static final String filePath= "Users.txt";
    private String convertObjectToRecordLine(String seperator) {

        StringBuilder line = new StringBuilder();

        line.append(this.UserName);
        line.append(seperator);

        line.append(this.getName());
        line.append(seperator);

        line.append(this.getAge());
        line.append(seperator);

        line.append(this.id);
        line.append(seperator);

        line.append(this.password);
        line.append(seperator);

        line.append(this.getPhone());
        line.append(seperator);

        line.append(this.getAddress());
        line.append(seperator);

        line.append(this.getEmail());
        line.append(seperator);

        line.append(this.premissions);
        return line.toString();
    }

    private static User convertLineRecordToObjectUser(String recordLine, String seperator) {

        String[] userInfo = recordLine.split(seperator);

        return new User(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2]),
                userInfo[3], userInfo[4], userInfo[5], userInfo[6], userInfo[7],Integer.parseInt(userInfo[8]));
    }

    private static ArrayList<User> loadUserFromFile() throws FileNotFoundException, IOException {

        ArrayList<User> userList = new ArrayList<>();
        File file = new File(filePath);

        if(!file.exists()){
            return userList;
        }

        FileReader reader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(reader);


        String line = " ";

        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            userList.add(convertLineRecordToObjectUser(line, "#//#"));

        }

        return userList;
    }

    private void saveAllUserToFile(ArrayList<User> userList) throws IOException {

        File myFile = new File(filePath);

        ////clear all data in file and insert A new data

        FileWriter addToFile = new FileWriter(myFile);

        String line;

        for (User user : userList) {
            if (!user.markToDelete) {
                line = user.convertObjectToRecordLine("#//#");
                addToFile.write(line);
                addToFile.write("\n");
            }
        }

        addToFile.close();

    }

    public static boolean isUserExist(String userName) throws IOException {

        ArrayList<User> list = loadUserFromFile();

        for (User user : list) {

            if (user.UserName.equals(userName)) {
                return true;
            }

        }

        return false;
    }

    public static boolean isUserExist(String userName, String password) throws IOException {

        ArrayList<User> list = loadUserFromFile();

        for (User user : list) {

            if (user.UserName.equals(userName) && user.password.equals(password)) {
                return true;
            }

        }

        return false;
    }

    public static User findUser(String userName, String password) throws IOException {

        ArrayList<User> list = loadUserFromFile();

        for (User user : list) {

            if (user.UserName.equals(userName) && user.password.equals(password)) {
                return user;
            }

        }

        return null;
    }


    public static User findUser(String userName) throws IOException {

        ArrayList<User> list = loadUserFromFile();

        for (User user : list) {

            if (user.UserName.equals(userName)) {
                return user;
            }

        }

        return null;
    }

    private void add() throws IOException {

        File myFile = new File(filePath);

        FileWriter addToFile = new FileWriter(myFile, true);

        String line = convertObjectToRecordLine("#//#");

        addToFile.write(line);
        addToFile.write("\n");
        addToFile.close();

    }

    public User(String UserName, String name, int age, String id, String password, String phone, String address, String email,int premissions) {
        super(name, age, address, phone, email);
        this.UserName = UserName;
        this.password = password;
        this.id = id;
        this.premissions=premissions;
        this.markToDelete = false;
    }

    public User() {

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SavedResult addUser() throws IOException {

        if (isUserExist(this.UserName)) {

            return SavedResult.FAILED_ALREADY_EXISTS;

        } else {

            add();
            return SavedResult.SUCCESSFULLY_ADD;

        }
    }

    private boolean isEqualUser(User user) {

        return this.getUserName().equals(user.getUserName())
                && this.getName().equals(user.getName())
                && this.getAge() == user.getAge()
                && this.getId().equals(user.getId())
                && this.getPassword().equals(user.getPassword())
                && this.getPhone().equals(user.getPhone())
                && this.getAddress().equals(user.getAddress())
                && this.getEmail().equals(user.getEmail());
    }

    private void markedForDelete() throws IOException {

        ArrayList<User> userList = loadUserFromFile();

        for (User user : userList) {
            if (user.isEqualUser(this)) {

                user.markToDelete = true;
            }
        }
        saveAllUserToFile(userList);
    }

    public boolean delete() throws IOException {

        if ( this!=null && isUserExist(this.UserName)) {
            markedForDelete();
            return true;
        }
        return false;
    }


    public boolean update() throws IOException {

        ArrayList<User>userList = loadUserFromFile();
        for(int i=0; i<userList.size() ; i++){

            if(this.getUserName().equals(userList.get(i).UserName)){

                userList.set(i,this);
                saveAllUserToFile(userList);
                return true;

            }
        }

        return false;
    }

    public static ArrayList<User>getUserList() throws IOException {

        return loadUserFromFile();
    }

    public boolean checkAccessPermission(Permissions p)
    {
        if (this.premissions == Permissions.ALL.getEnumOptionValue())
        return true;

        if ((p.getEnumOptionValue() & this.premissions) == p.getEnumOptionValue()) {
            return true;
        } else
        return false;

    }


    public int getPremissions() {
        return premissions;
    }

    public void setPremissions(int premissions) {
        this.premissions = premissions;
    }
}
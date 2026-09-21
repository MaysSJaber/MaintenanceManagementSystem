package Core;

import java.io.*;
import java.util.ArrayList;

public class Mechanic extends Employee {

    private String specialization;
    private int experienceYears;
    private boolean markToDelete;
    private static final String filePath= "Mechanics.txt";

    private static Mechanic convertLineRecordToObjectMechanic(String recordLine, String seperator) {

        String[]  mechanicInfo = recordLine.split(seperator);

        return new Mechanic(mechanicInfo[0],Integer.parseInt( mechanicInfo[1]),
                 mechanicInfo[2],  mechanicInfo[3],  mechanicInfo[4], mechanicInfo[5],Double.parseDouble( mechanicInfo[6]), mechanicInfo[7],Integer.parseInt( mechanicInfo[8]));
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
        line.append(separator);

        line.append(this.getSalary());
        line.append(separator);


        line.append(this.specialization);
        line.append(separator);

        line.append(this.experienceYears);


        return line.toString();
    }

    private static ArrayList<Mechanic>  loadMechanicFromFile() throws FileNotFoundException, IOException {

        ArrayList<Mechanic> mechanicList = new ArrayList<>();
        File file = new File(filePath);
        if(!file.exists()){
            return mechanicList;
        }

        FileReader reader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = " ";

        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            mechanicList.add(convertLineRecordToObjectMechanic(line, "#//#"));

        }

        return mechanicList;
    }

    public Mechanic(String name, int age, String address, String phone, String email,String id ,double salary, String specialization, int experienceYears) {
        super(name, age, address, phone, email, id,salary);
        this.experienceYears = experienceYears;
        this.specialization = specialization;
        this.markToDelete=false;
    }

    public Mechanic() {

    }

    private boolean isMechanicEqual(Mechanic m) {

            return this.getName().equals(m.getName())
                    && this.getAge() == m.getAge()
                    && this.getAddress().equals(m.getAddress())
                    && this.getPhone().equals(m.getPhone())
                    && this.getEmail().equals(m.getEmail())
                    && this.getId().equals(m.getId())
                    && this.getSalary() == m.getSalary()
                    && this.getSpecialization().equals(m.getSpecialization())
                    && this.getExperienceYears() == m.getExperienceYears();

    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public static boolean  isMechanicExist(String id) throws IOException {

        ArrayList<Mechanic> list =  loadMechanicFromFile();

        for (Mechanic mechanic : list) {

            if (mechanic.getId().equals(id)) {
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


    public SavedResult addMechanic () throws IOException {

        if (isMechanicExist(this.getId())) {

            return SavedResult.FAILED_ALREADY_EXISTS;

        } else {

            add();
            return SavedResult.SUCCESSFULLY_ADD;

        }
    }

    private void saveAllMechanicToFile(ArrayList<Mechanic> mechanicList) throws IOException {

        File myFile = new File(filePath);

        ////clear all data in file and insert A new data

        FileWriter addToFile = new FileWriter(myFile);

        String line;

        for (Mechanic user : mechanicList) {
            if (!user.markToDelete) {
                line = user.convertObjectToRecordLine("#//#");
                addToFile.write(line);
                addToFile.write("\n");
            }
        }

        addToFile.close();

    }

    private void markedForDelete() throws IOException {

        ArrayList<Mechanic> mechanicList = loadMechanicFromFile();

        for (Mechanic user : mechanicList) {
            if (user.isMechanicEqual(this)) {

                user.markToDelete = true;
            }
        }
        saveAllMechanicToFile(mechanicList);
    }

    public boolean delete() throws IOException {

        if ( this!=null && isMechanicExist(this.getId())) {
            markedForDelete();
            return true;
        }
        return false;
    }

    public static Mechanic  findMechanic(String id) throws IOException {

        ArrayList<Mechanic> list = loadMechanicFromFile();

        for (Mechanic mechanic : list) {

            if (mechanic.getId().equals(id)) {

                return mechanic;
            }

        }

        return null;
    }


    public boolean update() throws IOException {

        ArrayList<Mechanic>mechanicList = loadMechanicFromFile();
        for(int i=0; i<mechanicList.size() ; i++){

            if(this.getId().equals(mechanicList.get(i).getId())){

                mechanicList.set(i,this);
                saveAllMechanicToFile(mechanicList);
                return true;

            }
        }

        return false;
    }

    public static ArrayList<Mechanic> getMechanicList() throws IOException {

        return loadMechanicFromFile();
    }




}
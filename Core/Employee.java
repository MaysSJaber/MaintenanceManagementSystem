package Core;

public abstract class Employee extends Person {

private double salary;
private String id;

    public Employee(String name, int age, String address, String phone, String email,String id ,double salary) {
        super(name, age, address, phone, email);
        this.salary = salary;
        this.id=id;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

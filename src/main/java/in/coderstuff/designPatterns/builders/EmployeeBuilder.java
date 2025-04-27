package in.coderstuff.designPatterns.builders;

public class EmployeeBuilder {

    protected String name;
    protected int age;
    protected String department;
    protected double salary;

    public EmployeeBuilder age(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder department(String department) {
        this.department = department;
        return this;
    }

    public Employee build() {
        return null;
        //return new Employee(this);
    }
}

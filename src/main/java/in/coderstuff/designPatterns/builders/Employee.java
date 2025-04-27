package in.coderstuff.designPatterns.builders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Employee {

    private final String name;
    private final int age;
    private final String department;
    private final double salary;

    public Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.department = builder.department;
        this.salary = builder.salary;
    }
}

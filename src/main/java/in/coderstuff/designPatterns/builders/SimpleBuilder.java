package in.coderstuff.designPatterns.builders;

/**
 *  Simple Builder class is created in normal way.
 *  Inner Static Builder is the first type of Builder Pattern
 *  1. Private constructor with a parameter of static inner class type
 *  2. No setters, only getters
 *  3. A static class who builds the object and also provide optional parameters.
 *
 */

public class SimpleBuilder {

    private final String name;
    private String address;
    private final int empId;
    private String age;
    private String department;

    // Private constructor to enforce object creation
    private SimpleBuilder(SimpleBuilderImpl builder) {
        this.name = builder.name;
        this.empId = builder.empId;
        this.age = builder.age;
        this.department = builder.department;
        this.address = builder.address;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public static class SimpleBuilderImpl {

        private final String name;
        private final int empId;
        private String address;
        private String age;
        private String department;

        public SimpleBuilderImpl(int empId, String name) {
            this.name = name;
            this.empId = empId;
        }

        public SimpleBuilderImpl address(String address) {
            this.address = address;
            return this;
        }

        public SimpleBuilderImpl age(String age) {
            this.age = age;
            return this;
        }

        public SimpleBuilderImpl department(String department) {
            this.department = department;
            return this;
        }

        public SimpleBuilder build() {
            return new SimpleBuilder(this);
        }
    }
}

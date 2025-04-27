package in.coderstuff.designPatterns.dto;

public record BuilderDTO(int empId, String name, String age, String department, String address) {
    public BuilderDTO(int empId, String name) {
        this(empId, name, "Not Available", "Not Assigned", "");
    }

    public BuilderDTO(int empId, String name, String age) {
        this(empId, name, age,"Not Assigned", "");
    }
}

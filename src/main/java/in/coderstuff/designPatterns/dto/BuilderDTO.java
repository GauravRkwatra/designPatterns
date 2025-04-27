package in.coderstuff.designPatterns.dto;

public record BuilderDTO(int empId, String name, String department, String address) {
    public BuilderDTO(int empId, String name) {
        this(empId, name, "Not Assigned", "");
    }
}

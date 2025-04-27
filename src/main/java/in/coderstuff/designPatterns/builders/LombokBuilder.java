package in.coderstuff.designPatterns.builders;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 *  @Builder generates a static inner class
 *
 */
@Builder
@Getter
@ToString
public class LombokBuilder {

    private int empId;
    private String name;
    private int age;
    private String department;
    private String add;



}

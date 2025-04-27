package in.coderstuff.designPatterns.services;

import in.coderstuff.designPatterns.builders.SimpleBuilder;
import org.springframework.stereotype.Service;

@Service
public class BuilderService {

    public SimpleBuilder simpleBuilderWithEmpId_Name(int empId, String name) {
        return new SimpleBuilder.SimpleBuilderImpl(empId, name)
                .build();
    }

    public SimpleBuilder simpleBuilderWithOptionalParams(
            int empId, String name, int age, String address
    ) {
        return new SimpleBuilder.SimpleBuilderImpl(empId, name)
                .age(age)
                .address(address)
                .build();
    }

}

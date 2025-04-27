package in.coderstuff.designPatterns.services;

import in.coderstuff.designPatterns.builders.SimpleBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuilderService {

    public SimpleBuilder simpleBuilderWithEmpId_Name(int empId, String name) {
        log.info("Simple Builder initiated with required params only");
        return new SimpleBuilder.SimpleBuilderImpl(empId, name)
                .build();
    }

    public SimpleBuilder simpleBuilderWithOptionalParams(
            int empId, String name, String age, String address
    ) {
        log.info("Simple builder initiated with required and optional params");
        return new SimpleBuilder.SimpleBuilderImpl(empId, name)
                .age(age)
                .address(address)
                .build();
    }

}

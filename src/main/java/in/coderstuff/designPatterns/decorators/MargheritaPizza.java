package in.coderstuff.designPatterns.decorators;

import in.coderstuff.designPatterns.services.Pizza;
import org.springframework.stereotype.Component;

@Component("margherita")
public class MargheritaPizza implements Pizza {
    @Override
    public String getDesc() {
        return "MargheritaPizza is ready ";
    }

    @Override
    public int getCost() {
        return 110;
    }
}

package in.coderstuff.designPatterns.decorators;

import in.coderstuff.designPatterns.services.Pizza;
import org.springframework.stereotype.Component;

@Component("farmHousePizza")
public class FarmHousePizza implements Pizza {
    @Override
    public String getDesc() {
        return "FarmHousePizza is ready. ";
    }

    @Override
    public int getCost() {
        return 120;
    }
}

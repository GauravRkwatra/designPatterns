package in.coderstuff.designPatterns.decorators;

import in.coderstuff.designPatterns.services.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component("paneer")
@Scope("prototype")
public class PaneerTopping extends ToppingDecorators {

    public PaneerTopping(){}

    @Override
    public int getCost() {
        return pizza.getCost() + 2;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", paneer ";
    }
}

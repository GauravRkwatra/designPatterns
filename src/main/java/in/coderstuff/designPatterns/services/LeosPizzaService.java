package in.coderstuff.designPatterns.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeosPizzaService {

    private final PizzaFactory pFactory;

    public Pizza getCustomPizza(String pType, List<String> toppings) {

        Pizza pizza = pFactory.createPizza(pType);

        pizza = toppings.stream()
                        .reduce(pizza, pFactory::addToppings, (p1, p2) -> p1);

        return pizza;
    }
}

package in.coderstuff.designPatterns.services;

import in.coderstuff.designPatterns.decorators.ToppingDecorators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PizzaFactory {

    @Autowired
    Map<String, Pizza> pizzaMap;

    @Autowired
    Map<String, ToppingDecorators> pizzaWithToppings;

    protected Pizza createPizza(String pizzaType) {
        return pizzaMap.get(pizzaType);
    }

    protected Pizza addToppings(Pizza pizza, String topping) {

        ToppingDecorators tDecorate = pizzaWithToppings.get(topping);
        tDecorate.setPizza(pizza);
        pizza = tDecorate;
        return pizza;
    }
}

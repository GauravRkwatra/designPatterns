package in.coderstuff.designPatterns.services;

import in.coderstuff.designPatterns.decorators.ToppingDecorators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class PizzaFactory {

    @Autowired
    Map<String, Pizza> pizzaMap;

    @Autowired
    Map<String, ToppingDecorators> pizzaWithToppings;

    protected Pizza createPizza(String pizzaType) {
        log.info("Main Thread {}: ", Thread.currentThread().getName());
        assignDeliveryPartner();
        return pizzaMap.get(pizzaType);
    }

    protected Pizza addToppings(Pizza pizza, String topping) {

        ToppingDecorators tDecorate = pizzaWithToppings.get(topping);

        if(tDecorate != null) {
            tDecorate.setPizza(pizza);
            pizza = tDecorate;
        }

        return pizza;
    }


    //@Async("asyncExecutor")
    //
    protected void assignDeliveryPartner() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("ThreadName: {} ", Thread.currentThread().getName());
    }
}

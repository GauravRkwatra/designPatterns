package in.coderstuff.designPatterns.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeosPizzaService {

    private final PizzaFactory pFactory;

    public Pizza getCustomPizza(String pType, List<String> toppings) {
        checkingInventory();
        Pizza pizza = pFactory.createPizza(pType);

        pizza = toppings.stream()
                        .reduce(pizza, pFactory::addToppings, (p1, p2) -> p1);

        return pizza;
    }

    @Async
    //@Async("asyncExecutor")
    public void checkingInventory() {
        log.info("Inventory: {} ",Thread.currentThread().getName());
    }
}

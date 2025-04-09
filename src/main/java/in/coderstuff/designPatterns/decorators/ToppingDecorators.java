package in.coderstuff.designPatterns.decorators;

import in.coderstuff.designPatterns.services.Pizza;

public abstract class ToppingDecorators implements Pizza {

    // Composition for decorate
    protected Pizza pizza;

    // Due to spring DI
    // Have to use setter instead of constructor
    // Below code required if we use 'new' instead of Spring DI
    /*ToppingDecorators(Pizza pizza) {
        this.pizza = pizza;
    }*/

    protected ToppingDecorators() {
    }

    // setter to initialize pizza
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDesc() {
        return pizza.getDesc();
    }
}

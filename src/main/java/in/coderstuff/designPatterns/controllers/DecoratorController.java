package in.coderstuff.designPatterns.controllers;

import in.coderstuff.designPatterns.dto.DecoratorDTO;
import in.coderstuff.designPatterns.services.BuilderService;
import in.coderstuff.designPatterns.services.LeosPizzaService;
import in.coderstuff.designPatterns.services.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decorator")
public class DecoratorController {

    private LeosPizzaService leosPizzaService;

    @Autowired
    public DecoratorController(LeosPizzaService leosPizzaService,
                               BuilderService builderService) {
        this.leosPizzaService = leosPizzaService;
    }

    @GetMapping("/pizza/{type}")
    public ResponseEntity<DecoratorDTO> pizza(@PathVariable String type,
                                              @RequestParam(required = false) List<String> toppings) {
        Pizza pizza = leosPizzaService.getCustomPizza(type, toppings);
        return ResponseEntity.ok(new DecoratorDTO(pizza.getDesc(), pizza.getCost()));
    }
}

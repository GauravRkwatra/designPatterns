package in.coderstuff.designPatterns.controllers;

import in.coderstuff.designPatterns.dto.PizzaDTO;
import in.coderstuff.designPatterns.services.LeosPizzaService;
import in.coderstuff.designPatterns.services.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class DesignPatternsExamples {

    @Autowired
    private LeosPizzaService leosPizzaService;

    @GetMapping("{type}")
    public ResponseEntity<PizzaDTO> getPizza(@PathVariable String type,
                                      @RequestParam(required = false) List<String> toppings) {
        Pizza pizza = leosPizzaService.getCustomPizza(type, toppings);
        return ResponseEntity.ok(new PizzaDTO(pizza.getDesc(), pizza.getCost()));
    }
}

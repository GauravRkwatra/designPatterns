package in.coderstuff.designPatterns.controllers;

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
    public ResponseEntity<Pizza> getPizza(@PathVariable String type,
                                      @RequestParam(required = false) List<String> toppings) {
        Pizza customPizza = leosPizzaService.getCustomPizza(type, toppings);
        return ResponseEntity.ok(customPizza);
    }
}

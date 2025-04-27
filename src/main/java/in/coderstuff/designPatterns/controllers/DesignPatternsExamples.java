package in.coderstuff.designPatterns.controllers;

import in.coderstuff.designPatterns.builders.SimpleBuilder;
import in.coderstuff.designPatterns.dto.BuilderDTO;
import in.coderstuff.designPatterns.dto.PizzaDTO;
import in.coderstuff.designPatterns.services.BuilderService;
import in.coderstuff.designPatterns.services.LeosPizzaService;
import in.coderstuff.designPatterns.services.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class DesignPatternsExamples {

    private LeosPizzaService leosPizzaService;
    private BuilderService builderService;

    @Autowired
    public DesignPatternsExamples(LeosPizzaService leosPizzaService,
                                  BuilderService builderService) {
        this.leosPizzaService = leosPizzaService;
        this.builderService = builderService;
    }

    @GetMapping("/decorator/pizza/{type}")
    public ResponseEntity<PizzaDTO> pizza(@PathVariable String type,
                                      @RequestParam(required = false) List<String> toppings) {
        Pizza pizza = leosPizzaService.getCustomPizza(type, toppings);
        return ResponseEntity.ok(new PizzaDTO(pizza.getDesc(), pizza.getCost()));
    }

    @GetMapping("/builder/{empId}/{name}")
    public ResponseEntity<BuilderDTO> createBuilderObj(@PathVariable int empId,
                                                       @PathVariable String name) {

        SimpleBuilder simpleBuilder = builderService.simpleBuilderWithEmpId_Name(empId, name);
        return ResponseEntity.ok(new BuilderDTO(simpleBuilder.getEmpId(), simpleBuilder.getName()));

    }

    @GetMapping("/builder/{empId}/{name}/optional")
    public ResponseEntity<BuilderDTO> createBuilderObjWithOptional(@PathVariable int empId,
                                                                   @PathVariable String name,
                                                                   @RequestParam String age,
                                                                   @RequestParam String address) {

        SimpleBuilder simpleBuilder = builderService.simpleBuilderWithOptionalParams(empId, name, age, address);
        return ResponseEntity.ok(new BuilderDTO(simpleBuilder.getEmpId(), simpleBuilder.getName(),
                                                simpleBuilder.getAge()));

    }
}

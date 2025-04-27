package in.coderstuff.designPatterns.controllers;

import in.coderstuff.designPatterns.builders.SimpleBuilder;
import in.coderstuff.designPatterns.dto.BuilderDTO;
import in.coderstuff.designPatterns.services.BuilderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/builder")
public class BuilderController {


    private BuilderService builderService;

    public BuilderController(BuilderService builderService) {
        this.builderService = builderService;
    }

    @GetMapping("/{empId}/{name}")
    public ResponseEntity<BuilderDTO> createBuilderObj(@PathVariable int empId,
                                                       @PathVariable String name) {

        SimpleBuilder simpleBuilder = builderService.simpleBuilderWithEmpId_Name(empId, name);
        return ResponseEntity.ok(new BuilderDTO(simpleBuilder.getEmpId(), simpleBuilder.getName()));

    }

    @GetMapping("/{empId}/{name}/optional")
    public ResponseEntity<BuilderDTO> createBuilderObjWithOptional(@PathVariable int empId,
                                                                   @PathVariable String name,
                                                                   @RequestParam String age,
                                                                   @RequestParam String address) {

        SimpleBuilder simpleBuilder = builderService.simpleBuilderWithOptionalParams(empId, name, age, address);
        return ResponseEntity.ok(new BuilderDTO(simpleBuilder.getEmpId(), simpleBuilder.getName(),
                simpleBuilder.getAge()));

    }
}

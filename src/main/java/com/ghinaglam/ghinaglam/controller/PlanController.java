package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.dto.ServicesToPlanDto;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanController {

    private final PlanService planService;
//    TODO: Include connect each plan wo its corresponding service
    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> getPlans() {
        return ResponseEntity.ok().body(planService.getPlans());
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<PlanDto> getPlan(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(planService.getPlan(id));
    }
    @PostMapping("/plan/{services}")
    public ResponseEntity<PlanDto> savePlan(@PathVariable List<Long> services, @RequestBody PlanDto planDto) {
        return ResponseEntity.ok().body(planService.savePlan(planDto, services));
    }

    @PostMapping("/plan/addService")
    public ResponseEntity<?> addServicesToPlan(@RequestBody ServicesToPlanDto servicesToPlanDto) {
        planService.addServiceToPlan(servicesToPlanDto.getServiceId(), servicesToPlanDto.getPlanId());
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/plan/{id}")
    public ResponseEntity<PlanDto> updatePlan(@PathVariable("id") Long id, @RequestBody PlanDto plan) {
        return ResponseEntity.ok().body(planService.updatePlan(id, plan));
    }

    @DeleteMapping("/plan/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(planService.deletePlan(id));
    }
}

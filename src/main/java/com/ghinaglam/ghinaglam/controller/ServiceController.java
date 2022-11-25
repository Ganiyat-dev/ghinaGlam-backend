package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.dto.ServicesToPlanDto;
import com.ghinaglam.ghinaglam.model.ServicePlan;
import com.ghinaglam.ghinaglam.repository.ServicePlanRepository;
import com.ghinaglam.ghinaglam.service.PlanService;
import com.ghinaglam.ghinaglam.service.ServicePlanService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {
    private final ServicePlanService servicePlanService;
    private final PlanService planService;

    @GetMapping("/services")
    public ResponseEntity<List<ServicePlan>> getServices() {
        return ResponseEntity.ok().body(servicePlanService.getServicePlans());
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<ServicePlan> getPlanService(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(servicePlanService.getPlanService(id));
    }

    @PostMapping("/service")
    public ResponseEntity<ServicePlan> saveService(@RequestBody ServicePlan servicePlan) {
        return ResponseEntity.ok().body(servicePlanService.saveService(servicePlan));
    }

    @PutMapping("/service/{id}")
    public ResponseEntity<ServicePlan> updatePlanService(@PathVariable("id") Long id, @RequestBody ServicePlan servicePlan) {
        return ResponseEntity.ok().body(servicePlanService.updatePlanService(id, servicePlan));
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(servicePlanService.deletePlanService(id));
    }
}

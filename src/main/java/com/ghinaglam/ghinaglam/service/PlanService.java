package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.model.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> getPlans();

//    PlanDto getPlan(String planName);

    PlanDto getPlan(Long id);

    PlanDto savePlan(PlanDto planDto);

    String deletePlan(Long id);

    PlanDto updatePlan(Long id, PlanDto planDto);
}
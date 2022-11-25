package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.model.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> getPlans();

//    PlanDto getPlan(String planName);

    PlanDto getPlan(Long id);

    void addServiceToPlan(long serviceId, long planId);

    PlanDto savePlan(PlanDto planDto, List<Long> servicesId);

    String deletePlan(Long id);

    PlanDto updatePlan(Long id, PlanDto planDto);

}

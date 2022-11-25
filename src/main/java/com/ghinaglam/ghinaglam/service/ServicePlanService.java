package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.model.ServicePlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicePlanService {

    List<ServicePlan> getServicePlans();

    ServicePlan getPlanService(Long id);

    String deletePlanService(Long id);

    ServicePlan updatePlanService(Long id, ServicePlan servicePlan);

    ServicePlan saveService(ServicePlan servicePlan);
}

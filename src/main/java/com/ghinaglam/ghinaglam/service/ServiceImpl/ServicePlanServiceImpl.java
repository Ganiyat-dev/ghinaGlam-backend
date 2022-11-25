package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.PlanDto;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.ServicePlan;
import com.ghinaglam.ghinaglam.repository.PlanRepository;
import com.ghinaglam.ghinaglam.repository.ServicePlanRepository;
import com.ghinaglam.ghinaglam.service.ServicePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ServicePlanServiceImpl implements ServicePlanService {

    private final ServicePlanRepository servicePlanRepository;
    @Override
    public List<ServicePlan> getServicePlans() {
        return servicePlanRepository.findAll();
    }

    @Override
    public ServicePlan getPlanService(Long id) {
        if (servicePlanRepository.existsById(id)) {
            return servicePlanRepository.findById(id).orElseThrow(()-> new IllegalStateException("No Service found"));
        }
        throw new IllegalStateException("Service not found");
    }
    @Override
    public ServicePlan saveService(ServicePlan servicePlan) {
        if (servicePlanRepository.existsById(servicePlan.getId())) {
            throw new IllegalStateException("Service already Exists");
        }
        return servicePlanRepository.save(servicePlan);
    }
    @Transactional
    public ServicePlan updatePlanService(Long id, ServicePlan servicePlan) {
        ServicePlan servicePlan1 = servicePlanRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Service with the" + id + " does not exist"));
        servicePlan1.setServiceName(servicePlan.getServiceName());
        servicePlan1.setServiceDetails(servicePlan.getServiceDetails());

        return servicePlanRepository.save(servicePlan);
    }
    @Override
    public String deletePlanService(Long id) {
        if (servicePlanRepository.existsById(id)) {
            servicePlanRepository.deleteById(id);
            return "Service deleted!";
        }
        throw new IllegalStateException("Plan not found!");
    }


}

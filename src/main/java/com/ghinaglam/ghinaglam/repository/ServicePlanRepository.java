package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.ServicePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePlanRepository extends JpaRepository<ServicePlan, Long> {
}

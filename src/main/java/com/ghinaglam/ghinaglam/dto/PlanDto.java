package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.ServicePlan;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class PlanDto {
    private Long id;

    @NotEmpty
    private String planName;
    private String planDescription;
    private double planPrice;
    private Long planSession;

    private Set<ServicePlan> servicePlans;
}

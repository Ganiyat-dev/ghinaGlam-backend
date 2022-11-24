package com.ghinaglam.ghinaglam.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PlanDto {
    private Long id;

    @NotEmpty
    private String planName;
    private String planDescription;
    private double planPrice;
    private Long planSession;
}

package com.ghinaglam.ghinaglam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plans")
public class Plan extends BaseEntity {
    private String planName;
    private String planDescription;
    private double planPrice;
    private Long planSession;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "plan_services", joinColumns = @JoinColumn(name = "plan_id"), inverseJoinColumns = @JoinColumn(name = "service_plan_id"))
    private Set<ServicePlan> servicePlans;

    @JsonIgnore
    @OneToMany
    private List<Appointment> appointment;


}

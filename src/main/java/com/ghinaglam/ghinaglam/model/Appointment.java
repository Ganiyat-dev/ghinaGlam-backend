package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment extends BaseEntity{
    @ManyToOne
    private Plan plan;

    @ManyToOne
    private User user;

    private LocalDate startDate;
    private Status status = Status.PENDING;
    private Boolean isAssigned = false;

}

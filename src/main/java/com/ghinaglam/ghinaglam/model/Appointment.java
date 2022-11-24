package com.ghinaglam.ghinaglam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment extends BaseEntity {
    private LocalDateTime startDate;
//    private LocalTime appointmentStartTime;
//    private Timestamp appointmentStartTime;
    private LocalDateTime endDate;
    private Boolean isAssigned = false;


    @ManyToOne
    private Plan plan;
    @ManyToOne
    private Client client;

}

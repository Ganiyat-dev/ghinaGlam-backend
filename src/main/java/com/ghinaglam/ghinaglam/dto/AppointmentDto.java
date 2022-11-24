package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.Status;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentDto {
    private Integer id;
    private LocalDateTime startDate;
//    private LocalTime appointmentStartTime;
    private LocalDateTime endDate;
    private Boolean isAssigned = false;
    private Client client;
    private Plan plan;
}

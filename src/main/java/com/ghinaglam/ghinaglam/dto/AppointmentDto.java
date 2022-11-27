package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.model.Status;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data

public class AppointmentDto {
    private Integer id;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDate;
//    private LocalTime appointmentStartTime;
    private LocalDateTime endDate;
    private Boolean isAssigned = false;
    private Client client;
    private Plan plan;
}

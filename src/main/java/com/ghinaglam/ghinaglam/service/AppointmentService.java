package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.AppointmentDto;
import com.ghinaglam.ghinaglam.model.Appointment;
import com.ghinaglam.ghinaglam.model.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    AppointmentDto createAppointment(Long clientId, Long planId, AppointmentDto appointmentDto);
//    AppointmentDto updateAppointmentStatus(Long appointmentId, Status status);
    List<AppointmentDto> getAllAppointments();
//    List<AppointmentDto> getAppointmentByStatus(Status status);
    List<Appointment> getAppointmentByStartDate(LocalDate startDate);

    void getAppointmentById(Long appointmentId);
}

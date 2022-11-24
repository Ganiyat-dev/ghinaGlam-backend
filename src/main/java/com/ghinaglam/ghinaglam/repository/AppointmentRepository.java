package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.Appointment;
import com.ghinaglam.ghinaglam.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Override
    Optional<Appointment> findById(Long aLong);

    Appointment findById(long id);
    List<Appointment> findAppointmentByStartDate(LocalDate startDate);
}

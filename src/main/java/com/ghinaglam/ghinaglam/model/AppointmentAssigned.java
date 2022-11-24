package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentAssigned extends BaseEntity {
    @OneToOne
    private Appointment appointment;

    @ManyToOne
    private MakeupArtist makeupArtist;

//TODO: How to map makeupArtists

    private Status status = Status.STARTED;

    // appointment_id, makeup_id, status, dateCompleted,
}

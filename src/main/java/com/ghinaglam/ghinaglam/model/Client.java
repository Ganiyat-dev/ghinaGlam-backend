package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @OneToOne
    private AppUser appUser;

    @Column(nullable = false)
    private String gender;
    //    @Column(unique = true)
    private String address;

    @Transient
    private String streetAddress;
    @Transient
    private String city;
    @Transient
    @Column(nullable = false)
    private String state;

//    @OneToMany(mappedBy = "client")
//    private List<AppointmentAssigned> appointmentAssigned;
}

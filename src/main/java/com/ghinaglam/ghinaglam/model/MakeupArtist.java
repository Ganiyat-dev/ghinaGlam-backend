package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "makeupArtists")
public class MakeupArtist extends BaseEntity {

    @OneToOne
    private AppUser appUser;
    private String specialization;
    private int yearsOfExperience;

    private double salary;

    private Boolean isApproved = false;
//    @ManyToMany
//    @JoinTable(name= "user_category", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
//    public Set<Role> getRole() {
//        return categories;
//    }

    @OneToMany(mappedBy = "makeupArtist")
    private List<AppointmentAssigned> appointmentAssigned;

}

package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "makeup_artists")
public class MakeupArtist extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String licensePath;

    @Lob
    private byte[] licenseData;
    private int yearsOfExperience;
    private double salary;
    private Category category = Category.MAKEUP_ARTIST;

    private Boolean isApproved = false;
//    @ManyToMany
//    @JoinTable(name= "user_category", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
//    public Set<Category> getCategory() {
//        return categories;
//    }

    @OneToMany(mappedBy = "makeupArtist")
    private List<AppointmentAssigned> appointmentAssigned;

}

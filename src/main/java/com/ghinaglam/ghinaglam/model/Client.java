package com.ghinaglam.ghinaglam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends BaseEntity{
    private int age;

    @OneToOne
    private User user;
}

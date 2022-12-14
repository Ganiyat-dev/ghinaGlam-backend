package com.ghinaglam.ghinaglam.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreationTimestamp
    protected Timestamp createdAt;

    @UpdateTimestamp
    protected Timestamp updatedAt;

    public BaseEntity(Long id) {
        this.id = id;
    }
}

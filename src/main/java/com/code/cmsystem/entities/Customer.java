package com.code.cmsystem.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CustomerDetails",uniqueConstraints = @UniqueConstraint(columnNames = {"occupation", "dob","customer_group"}))
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NaturalId(mutable = true)
    private String email;

    @DateTimeFormat
    private String dob;

    private String occupation;
    private String customer_group;

}

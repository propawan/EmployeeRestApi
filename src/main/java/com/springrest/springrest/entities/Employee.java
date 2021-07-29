package com.springrest.springrest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String fatherName;
    private boolean status;

    @ManyToOne()
    @JoinColumn(name="deptCode", referencedColumnName = "deptCode")
    private Department department;
}

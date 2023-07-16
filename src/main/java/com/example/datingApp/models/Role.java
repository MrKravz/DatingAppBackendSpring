package com.example.datingApp.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_role")
    private String name;

    @OneToOne(mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private User user;
}

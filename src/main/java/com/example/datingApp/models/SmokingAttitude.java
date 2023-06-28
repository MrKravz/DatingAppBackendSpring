package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "smoking_attitudes")
public class SmokingAttitude {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_smoking_attitude")
    private String name;

    @OneToMany(mappedBy = "smokingAttitude", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Profile> profiles;
}

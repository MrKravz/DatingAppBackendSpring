package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "pet_attitudes")
public class PetAttitude {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_pet_attitude")
    private String name;

    @OneToMany(mappedBy = "petAttitude", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Profile> profiles;
}

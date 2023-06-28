package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "zodiac_signs")
public class ZodiacSign {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_zodiac_sign")
    private String name;

    @OneToMany(mappedBy = "zodiacSign", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Profile> profiles;
}

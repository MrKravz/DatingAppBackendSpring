package com.example.datingApp.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "preferences")
public class Preference {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "id"
    )
    private Country country;

    @Column(name = "min_age_gap")
    private int minAge;

    @Column(name = "max_age_gap")
    private int maxAge;
}

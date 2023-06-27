package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "min_age_gap")
    private int minAge;

    @Column(name = "max_age_gap")
    private int maxAge;
}

package com.example.datingApp.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profiles_pics")
public class Pictures {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "picture")
    @ToString.Exclude
    private byte[] picture;

    @ManyToOne
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Profile profile;
}

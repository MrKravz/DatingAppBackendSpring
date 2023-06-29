package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

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
    @JoinTable(
            name = "profiles_pics",
            joinColumns = @JoinColumn(name = "profile_id")
    )
    @ToString.Exclude
    private Profile profiles;
}

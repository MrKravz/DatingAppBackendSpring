package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "hobbies")
public class Hobby {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_hobby")
    private String name;

    @ManyToMany(mappedBy = "hobbies", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private List<Profile> profiles;
}

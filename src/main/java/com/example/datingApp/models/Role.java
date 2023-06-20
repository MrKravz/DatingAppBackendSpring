package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

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

    @OneToOne()
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private User user;
}

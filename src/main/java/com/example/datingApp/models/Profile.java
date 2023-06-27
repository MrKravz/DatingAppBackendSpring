package com.example.datingApp.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "profiles")
public class Profile {
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

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "height")
    private int height;

    @Column(name = "about")
    private String about;



    @ManyToOne
    @JoinColumn(
            name = "location_country_id",
            referencedColumnName = "id"
    )
    private Country country;

    @ManyToOne
    @JoinColumn(
            name = "location_city_id",
            referencedColumnName = "id"
    )
    private City city;

    @ManyToOne
    @JoinColumn(
            name = "zodiac_sign_id",
            referencedColumnName = "id"
    )
    private ZodiacSign zodiacSign;

    @ManyToOne
    @JoinColumn(
            name = "goal_id",
            referencedColumnName = "id"
    )
    private Goal goal;

    @ManyToOne
    @JoinColumn(
            name = "sport_attitude_id",
            referencedColumnName = "id"
    )
    private SportAttitude sportAttitude;

    @ManyToOne
    @JoinColumn(
            name = "alcohol_attitude_id",
            referencedColumnName = "id"
    )
    private AlcoholAttitude alcoholAttitude;

    @ManyToOne
    @JoinColumn(
            name = "smoking_attitude_id",
            referencedColumnName = "id"
    )
    private SmokingAttitude smokingAttitude;

    @ManyToOne
    @JoinColumn(
            name = "pet_attitude_id",
            referencedColumnName = "id"
    )
    private PetAttitude petAttitude;

    @ManyToMany
    @JoinTable(
            name = "profiles_hobbies",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "profile")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Pictures> pictures;
}

package com.example.datingApp.models;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude
    private Role role;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Profile profile;

    @OneToOne(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ToString.Exclude
    private Preference preference;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_likes",
            joinColumns = @JoinColumn(name = "like_provider_user_id"),
            inverseJoinColumns = @JoinColumn(name = "like_receiver_user_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private List<User> likeProviders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "mutual_likes",
            joinColumns = @JoinColumn(name = "first_user_id"),
            inverseJoinColumns = @JoinColumn(name = "second_user_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private List<User> mutualLikes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

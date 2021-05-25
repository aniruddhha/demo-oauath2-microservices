package com.ani.security.auth;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usId;

    @Column(unique = true)
    private String userName;
    private String password;
    private String role;
    private Boolean isEnabled;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private String authorities;
}

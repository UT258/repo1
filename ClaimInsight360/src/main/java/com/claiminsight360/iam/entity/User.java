package com.claiminsight360.iam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    private String phone;

    public enum Role {
        ANALYST, MANAGER, FRAUD, ACTUARY, ADMIN
    }

    public User() {}

    public User(String name, Role role, String email, String phone) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

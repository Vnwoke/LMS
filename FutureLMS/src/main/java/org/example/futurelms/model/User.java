package org.example.futurelms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 20)
    private String role;

    @Column(length = 100)
    private String fullName;

    @Column(length = 250)
    private String email;

    @OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY)
    private Set<Course> courses;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Enrolment> enrolments;
}

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
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String category;

    @Column(length = 100, unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @OrderBy("id ASC")
    private Set<Topic> topics;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<Enrolment> enrolments;
}

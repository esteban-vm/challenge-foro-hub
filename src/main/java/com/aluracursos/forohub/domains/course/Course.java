package com.aluracursos.forohub.domains.course;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Course")
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Enumerated(EnumType.STRING)
    private CourseCategory category;
}

package com.aluracursos.forohub.domains.topic;

import com.aluracursos.forohub.domains.course.Course;
import com.aluracursos.forohub.domains.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1024)
    private String message;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Topic(TopicRegisterData data, User author, Course course) {
        this.title = data.title();
        this.message = data.message();
        this.author = author;
        this.course = course;
    }

    @PrePersist
    public void prePersist() {
        this.status = TopicStatus.ACTIVE;
    }

    public void update(@Valid TopicUpdateData data) {
        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.message() != null) {
            this.message = data.message();
        }
    }
    
}

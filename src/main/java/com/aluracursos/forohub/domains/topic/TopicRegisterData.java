package com.aluracursos.forohub.domains.topic;

public record TopicRegisterData(
        String title,
        String message,
        Long authorId,
        Long courseId
) {
}

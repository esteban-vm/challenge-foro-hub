package com.aluracursos.forohub.domains.topic;

import java.time.LocalDateTime;

public record TopicDetailData(

        Long id,
        String title,
        String message,
        TopicStatus status,
        String author,
        String course,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

    public TopicDetailData(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getStatus(),
                topic.getAuthor().getProfile().getName(),
                topic.getCourse().getTitle(),
                topic.getCreatedAt(),
                topic.getUpdatedAt()
        );
    }

}

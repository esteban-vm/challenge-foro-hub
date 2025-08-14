package com.aluracursos.forohub.domains.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByStatus(TopicStatus status, Pageable pageable);
}

package com.aluracursos.forohub.domains.topic;

import jakarta.validation.constraints.NotNull;

public record TopicUpdateData(

        @NotNull(message = "Se requiere el identificador del tópico")
        Long id,
        String title,
        String message

) {
}

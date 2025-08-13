package com.aluracursos.forohub.domains.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegisterData(

        @NotBlank(message = "Se requiere el título")
        String title,
        @NotBlank(message = "Se requiere el mensaje")
        String message,
        @NotNull(message = "Se requiere el identificador del autor")
        Long authorId,
        @NotNull(message = "Se requiere el identificador del curso")
        Long courseId
        
) {
}

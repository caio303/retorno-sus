package com.hackaton.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record AgendamentoDTO(
        long idMedico,
        long idPaciente,
        String status,

        @DateTimeFormat(pattern = "YYYY-MM-DD")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
        LocalDate data,

        @DateTimeFormat(pattern = "HH:mm")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        LocalDate hora
) {
}

package com.hackaton.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.entity.Agendamento;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoDTO(
        long id,
        long idMedico,
        long idPaciente,
        String status,

        @DateTimeFormat(pattern = "YYYY-MM-DD")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
        LocalDate data,

        @DateTimeFormat(pattern = "HH:mm")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        LocalTime hora
) {

        public AgendamentoDTO(Agendamento agendamento) {
                this(
                        agendamento.getId(),
                        agendamento.getMedico().getId(),
                        agendamento.getPaciente().getId(),
                        agendamento.getStatus().getName(),
                        agendamento.getData(),
                        agendamento.getHora()
                );
        }
}

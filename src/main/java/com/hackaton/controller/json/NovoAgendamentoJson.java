package com.hackaton.controller.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.dto.NovoAgendamentoDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record NovoAgendamentoJson(
        @NotNull @Positive Long idMedico,
        @NotNull @Positive Long idPaciente,
        @JsonIgnore String status,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        String data,
        @DateTimeFormat(pattern = "HH:mm")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        String hora
) {

    private static final DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public NovoAgendamentoJson(NovoAgendamentoDTO novoAgendamentoDTO) {
        this(
                novoAgendamentoDTO.idMedico(),
                novoAgendamentoDTO.idPaciente(),
                novoAgendamentoDTO.status(),
                novoAgendamentoDTO.data().format(dataFormatter),
                novoAgendamentoDTO.hora().format(horaFormatter)
        );
    }

    public NovoAgendamentoDTO toDTO() {
        return new NovoAgendamentoDTO(
                null,
                this.idMedico,
                this.idPaciente,
                this.status,
                LocalDate.parse(this.data),
                LocalTime.parse(this.hora)
        );
    }
}

package com.backend.agendacrista.demo.controller.dto;

import com.backend.agendacrista.demo.model.Evento;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class EventoDto {
    private Long id;
    private String nome;
    private String descricao;
    private String nomeCelebrante;


    public EventoDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.nomeCelebrante = evento.getNomeCelebrante();
    }


    public static Page<EventoDto> converte(Page<Evento> eventos) {
        return eventos.map(EventoDto::new);
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeCelebrante() {
        return nomeCelebrante;
    }


}

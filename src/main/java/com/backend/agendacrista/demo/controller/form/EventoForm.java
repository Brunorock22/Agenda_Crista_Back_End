package com.backend.agendacrista.demo.controller.form;

import com.backend.agendacrista.demo.model.*;
import com.backend.agendacrista.demo.service.UsuarioService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventoForm {
    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    private Long igreja_id;
    @NotNull
    @NotEmpty
    private String nomeCelebrante;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    @NotNull
    private List<@Valid HorariosForm> horarios;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCelebrante() {
        return nomeCelebrante;
    }

    public void setNomeCelebrante(String nomeCelebrante) {
        this.nomeCelebrante = nomeCelebrante;
    }

    public Long getIgreja_id() {
        return igreja_id;
    }

    public void setIgreja_id(Long igreja_id) {
        this.igreja_id = igreja_id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<HorariosForm> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorariosForm> horarios) {
        this.horarios = horarios;
    }

    public Evento converteEventoFormParaEvento() {
        List<Horarios> horariosList = this.horarios.stream().map(Horarios::new).collect(Collectors.toList());
        return new Evento(this, new Igreja(this.getIgreja_id()), new Usuario(UsuarioService.getIdUsuarioLogado()),horariosList);
    }

    public Evento converteEventoFormParaEventoESetId(Long id) {
        Evento evento = this.converteEventoFormParaEvento();
        evento.setId(id);
        return evento;
    }
}

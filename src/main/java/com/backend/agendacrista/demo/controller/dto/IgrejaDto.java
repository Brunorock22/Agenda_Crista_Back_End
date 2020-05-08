package com.backend.agendacrista.demo.controller.dto;

import com.backend.agendacrista.demo.model.Igreja;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class IgrejaDto {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem_url;
    private String nomecidade;


    public IgrejaDto(Igreja igreja) {
        this.id = igreja.getId();
        this.nome = igreja.getNome();
        this.descricao = igreja.getDescricao();
        this.imagem_url = igreja.getImagem_url();
        this.nomecidade = igreja.getCidade().getNome() + " - " + igreja.getCidade().getUf().getUf();
    }

    public static Page<IgrejaDto> converte(Page<Igreja> igrejas) {

        return igrejas.map(IgrejaDto::new);
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

    public String getImagem_url() {
        return imagem_url;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public static List<IgrejaDto> converte(List<Igreja> igreja) {
        return igreja.stream().map(IgrejaDto::new).collect(Collectors.toList());
    }
}
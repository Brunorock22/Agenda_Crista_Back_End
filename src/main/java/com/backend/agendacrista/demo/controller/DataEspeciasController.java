package com.backend.agendacrista.demo.controller;

import com.backend.agendacrista.demo.controller.dto.DataEspecialDto;
import com.backend.agendacrista.demo.controller.form.DataEspecialForm;
import com.backend.agendacrista.demo.model.DataEspecial;
import com.backend.agendacrista.demo.repository.DataEspeciaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/datas-especias")
public class DataEspeciasController {
    @Autowired
    DataEspeciaisRepository dataEspeciaisRepository;

    @PostMapping("/admin/")
    ResponseEntity<DataEspecialDto> cadastraDatas(@RequestBody @Validated DataEspecialForm dataEspecialDto, UriComponentsBuilder uriComponentsBuilder){
        DataEspecial dataEspecial = dataEspecialDto.converteDataEspecialFormParaDataEspecial();
        dataEspeciaisRepository.save(dataEspecial);
        URI uri = uriComponentsBuilder.path("/dataEspecias/{id}").buildAndExpand(dataEspecial.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataEspecialDto(dataEspecial));
    }

    @GetMapping
    List<DataEspecialDto>list(){
        List<DataEspecial> dataEspecials = dataEspeciaisRepository.findAll();

        return DataEspecialDto.converteDataEspecialListParaDataEspecialDtoList(dataEspecials);
    }

}

package com.backend.agendacrista.demo.controller;


import com.backend.agendacrista.demo.controller.dto.CidadeDto;
import com.backend.agendacrista.demo.controller.dto.EstadoDto;
import com.backend.agendacrista.demo.model.Cidade;
import com.backend.agendacrista.demo.model.Estado;
import com.backend.agendacrista.demo.repository.CidadeRepository;
import com.backend.agendacrista.demo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/localidades")
public class LocalidadesController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @GetMapping("/estados")
    @Cacheable(value = "estados")
    public ResponseEntity<List<EstadoDto>> estados() {
        List<Estado> estados = estadoRepository.findAll();
        return ResponseEntity.ok(EstadoDto.converte(estados));
    }

    @GetMapping("/estados/{uf}")
    @Cacheable(value = "estados-cidades")
    public ResponseEntity<List<CidadeDto>> estadoCidade(@PathVariable String uf) {
        //List<Cidade> cidades = cidadeRepository.findByUfId(id);
        List<Cidade> cidades = cidadeRepository.findByUfUf(uf);
        if (cidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CidadeDto.converte(cidades));
    }


}
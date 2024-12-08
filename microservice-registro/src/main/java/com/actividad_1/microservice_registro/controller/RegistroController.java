package com.actividad_1.microservice_registro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actividad_1.microservice_registro.dto.PersonaDTO;
import com.actividad_1.microservice_registro.service.PersonaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/registro(v1)")
public class RegistroController {
    @Autowired
    PersonaService personaService;

    @GetMapping()
    public String getMethodName() {
        return "Registro";
    }
    
    @GetMapping("/residentes")
    public List<PersonaDTO> getResidentes(@RequestParam String apartamento) {
        return personaService.getPersonas(apartamento);
    }
    
}

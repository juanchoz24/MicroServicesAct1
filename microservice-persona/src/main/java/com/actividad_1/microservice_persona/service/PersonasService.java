package com.actividad_1.microservice_persona.service;

import java.util.List;
import java.util.Optional;

import com.actividad_1.microservice_persona.entity.Personas;

public interface PersonasService {

    List<Personas> findAll();

    Optional<Personas> findById(int id);

    Personas findByDocumento(String documento);

    Personas save(Personas personas);

    void deleteById(int id);

    List<Personas> findByApartamento(int apartamento);

}

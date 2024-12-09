package com.actividad_1.microservice_persona.service;

import java.util.List;
import java.util.Optional;

import com.actividad_1.microservice_persona.entity.Personas;

public interface PersonasService {

    public List<Personas> findAll();

    public Optional<Personas> findById(int id);

    public Personas findByDocumento(String documento);

    public Personas save(Personas personas);

    public void deleteById(int id);

    public List<Personas> findByApartamento(int apartamento);

}

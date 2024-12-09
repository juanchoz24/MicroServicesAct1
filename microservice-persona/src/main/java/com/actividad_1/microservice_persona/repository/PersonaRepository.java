package com.actividad_1.microservice_persona.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.actividad_1.microservice_persona.entity.Personas;

@Repository
public interface PersonaRepository extends CrudRepository<Personas,Integer>{
    public Personas findByDocumento(String doc_identidad);

    public List<Personas> findByApartamento(int apartamento);
}

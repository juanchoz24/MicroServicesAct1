package com.actividad_1.microservice_persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad_1.microservice_persona.entity.Personas;
import com.actividad_1.microservice_persona.repository.PersonaRepository;

@Service
public class PersonasServiceImpl implements PersonasService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Personas> findAll() {
        return (List<Personas>) personaRepository.findAll();
    }

    @Override
    public Personas findByDocumento(String documento) {
        return personaRepository.findByDocumento(documento);
    }

    @Override
    public Personas save(Personas personas) {
        Personas per = personaRepository.save(personas);
        return per;
    }

    @Override
    public void deleteById(int id) {
        personaRepository.deleteById(((Integer)id));
    }

    @Override
    public List<Personas> findByApartamento(int apartamento) {
        return personaRepository.findByApartamento(apartamento);
    }

    @Override
    public Optional<Personas> findById(int id) {
         return personaRepository.findById(id);
    }

    
}

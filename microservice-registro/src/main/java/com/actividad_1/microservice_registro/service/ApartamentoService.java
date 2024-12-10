package com.actividad_1.microservice_registro.service;

import java.util.List;
import java.util.Optional;

import com.actividad_1.microservice_registro.entity.Apartamento;

public interface ApartamentoService {

    public List<Apartamento> findAll();

    public Optional<Apartamento> findById(String id);

    public Apartamento save(Apartamento apartamento);

    public void deleteById(String id);

}

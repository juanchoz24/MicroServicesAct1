package com.actividad_1.microservice_registro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad_1.microservice_registro.entity.Apartamento;
import com.actividad_1.microservice_registro.repository.ApartamentoRepository;

@Service
public class ApartamentoServiceImpl implements ApartamentoService{

    @Autowired
    ApartamentoRepository apartamentoRepository;

    @Override
    public List<Apartamento> findAll() {
        return (List<Apartamento>) apartamentoRepository.findAll();
    }

    @Override
    public Optional<Apartamento> findById(String id) {
        return apartamentoRepository.findById(id);
    }

    @Override
    public Apartamento save(Apartamento apartamento) {
        Apartamento apto = apartamentoRepository.save(apartamento);
        return apto;
    }

    @Override
    public void deleteById(String id) {
        apartamentoRepository.deleteById(id);
    }


}

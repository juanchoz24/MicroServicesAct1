package com.actividad_1.microservice_registro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.actividad_1.microservice_registro.entity.Apartamento;

@Repository
public interface ApartamentoRepository extends CrudRepository<Apartamento,Integer>{

    Optional<Apartamento> findById(String id);

    void deleteById(String id);

}

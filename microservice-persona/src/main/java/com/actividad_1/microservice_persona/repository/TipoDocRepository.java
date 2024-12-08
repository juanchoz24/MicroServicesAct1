package com.actividad_1.microservice_persona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.actividad_1.microservice_persona.entity.TipoDoc;

@Repository
public interface TipoDocRepository extends CrudRepository<TipoDoc,String>{

}

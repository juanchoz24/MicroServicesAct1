package com.actividad_1.microservice_persona.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_doc")
public class TipoDoc {

    @Id
    @Column(name = "tipo_doc")
    private String tipoDoc;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

}
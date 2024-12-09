package com.actividad_1.microservice_persona.entity;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipos_doc")
@NoArgsConstructor
public class TipoDoc {

     public TipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Id
    @Column(name = "tipo_doc")
    private String tipoDoc;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @JsonCreator
    public static TipoDoc fromValue(String value){
        return new TipoDoc(value);
    }

    @JsonValue
    public String toValue() {
        return tipoDoc;
    }
}
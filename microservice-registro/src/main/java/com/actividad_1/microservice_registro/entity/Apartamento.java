package com.actividad_1.microservice_registro.entity;

import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="apartamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

public Apartamento(Optional<Optional<Apartamento>> aptoExiste) {
        //TODO Auto-generated constructor stub
    }

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "torre")
    private String torre;

    @NotNull
    @Column(name = "numApartamento")
    private String numApartamento;

    @NotNull
    @Column(name = "deposito")
    private String deposito;

    @NotNull
    @Column(name = "parqueadero")
    private int parqueadero;

}

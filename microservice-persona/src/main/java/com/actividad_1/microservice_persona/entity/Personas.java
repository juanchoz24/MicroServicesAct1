package com.actividad_1.microservice_persona.entity;

import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personas {

    public Personas(Optional<Personas> personaExistente) {
        //TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT en la base de datos
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "documento")
    private String documento;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_doc_id", referencedColumnName = "tipo_doc")
    private TipoDoc tipoDocIDen;

    @NotNull
    @Column(name = "nombres")
    private String nombres;

    @NotNull
    @Column(name = "apellidos")
    private String apellidos;

    @NotNull
    @Column(name = "fecha_nacimiento")
    private int fechaNacimiento;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "apartamento")
    private int apartamento;
}
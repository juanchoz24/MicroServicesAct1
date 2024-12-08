package com.actividad_1.microservice_registro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {

    private String documento;
    private String tipoDocIDen;
    private String nombres;
    private String apellidos;
    private int fechaNacimiento;
    private String email;
    private int apartamento;
}


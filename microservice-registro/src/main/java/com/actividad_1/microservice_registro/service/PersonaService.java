package com.actividad_1.microservice_registro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.actividad_1.microservice_registro.dto.PersonaDTO;

@Service
public class PersonaService {

    @Autowired
    RestTemplate restTemplate;

    public List<PersonaDTO> getPersonas(String apartamento){
        String url = UriComponentsBuilder
                        .fromHttpUrl("http://localhost:8080/api/persona(v1)/buscarapto")
                        .queryParam("apartamento", apartamento)
                        .toUriString();

        ResponseEntity<PersonaDTO[]> response = restTemplate.getForEntity(url, PersonaDTO[].class);
        PersonaDTO[] productDTO = response.getBody();
        List<PersonaDTO> m = Arrays.asList(productDTO);
        
        return m;
    }
}

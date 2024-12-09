package com.actividad_1.microservice_persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.actividad_1.microservice_persona.entity.Personas;
import com.actividad_1.microservice_persona.service.PersonasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin("*")
@RequestMapping("api/persona(v1)")
public class PersonasController {

    @Autowired
    private PersonasService personasService;
    
    @GetMapping()
    public String getMethodName() {
        return "Personas";
    }

    @PostMapping("/save")
    public ResponseEntity<Personas> savePersonas(@RequestBody Personas personas){
        Personas per = personasService.save(personas);
        return ResponseEntity.ok(per);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Personas>> findAllPersonas(){
        List<Personas> per =personasService.findAll();
        return ResponseEntity.ok(per);
    }

    @GetMapping("/buscarid/{id}")
    public ResponseEntity<Personas> findByID(@PathVariable("id") String id) {
        Integer idInt = Integer.parseInt(id);
        Optional<Optional<Personas>>  per = Optional.ofNullable(personasService.findById(idInt));
        if (per.isPresent()) {
            return new ResponseEntity<>(per.get().get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar/{documento}")
    public ResponseEntity<Personas> findByDoc(@PathVariable("documento") String documento) {
        Optional<Personas>  per = Optional.ofNullable(personasService.findByDocumento(documento));
        if (per.isPresent()) {
            return new ResponseEntity<>(per.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarapto")
    public ResponseEntity<List<Personas>> findByApartamento(@RequestParam(name="apartamento") String apartamento) {
        Optional<List<Personas>>  per = Optional.ofNullable(personasService.findByApartamento(Integer.valueOf(apartamento)));
        System.out.println("Apartamento: "+apartamento);
        if (per.isPresent()) {
            return new ResponseEntity<>(per.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Personas> actualizarPersona(@RequestBody Personas persona) {
        Optional<Personas> per = personasService.findById((persona.getId()));
        if (per.isPresent()) {
            persona.setId(persona.getId());
            Personas personaActualizada = personasService.save(persona);            
            return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{documento}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> deleteById(@PathVariable("documento") String documento) {
        Optional<Personas> personaExistente = Optional.ofNullable(personasService.findByDocumento(documento));
        if (personaExistente.isPresent()) {
            Personas persona =  new Personas(personaExistente);
            personasService.deleteById(persona.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Status 204
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Status 404
        }

    }
    
}

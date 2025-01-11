package com.actividad_1.microservice_registro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.actividad_1.microservice_registro.entity.Apartamento;
import com.actividad_1.microservice_registro.service.ApartamentoService;

@Controller
@CrossOrigin("*")
@RequestMapping("api/registro(v1)")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

     @GetMapping()
    public String getMethodName() {
        return "Registro";
    }

    @PostMapping("/save")
    public ResponseEntity<Apartamento> savePersonas(@RequestBody Apartamento apartamento){
        Apartamento apto = apartamentoService.save(apartamento);
        return ResponseEntity.ok(apto);
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Apartamento>> findAllPersonas(){
        List<Apartamento> apto =apartamentoService.findAll();
        return ResponseEntity.ok(apto);
    }

    @GetMapping("/buscarid/{id}")
    public ResponseEntity<Apartamento> findByID(@PathVariable("id") String id) {
        Optional<Optional<Apartamento>>  apto = Optional.ofNullable(apartamentoService.findById(id));
        if (apto.isPresent()) {
            return new ResponseEntity<>(apto.get().get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Apartamento> actualizarPersona(@RequestBody Apartamento apartamento) {
        Optional<Apartamento> apto = apartamentoService.findById((apartamento.getId()));
        if (apto.isPresent()) {
            apartamento.setId(apartamento.getId());
            Apartamento aptoAct = apartamentoService.save(apartamento);            
            return new ResponseEntity<>(aptoAct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        Optional<Optional<Apartamento>> aptoExiste = Optional.ofNullable(apartamentoService.findById(id));
        if (aptoExiste.isPresent()) {
            Apartamento apartamento =  new Apartamento(aptoExiste);
            apartamentoService.deleteById(apartamento.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

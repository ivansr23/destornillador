package com.trial.controllers;

import com.trial.entities.Coche;
import com.trial.exceptions.MiExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Controlador {


    @GetMapping(value = "/get")
    public Coche get() throws MiExcepcion {
        throw new RuntimeException("Mensaje que me apetece a mi");
    }

    @GetMapping(value = "/coche")
    public Coche coche() {
        return new Coche("mercedes", 122,5);
    }

    @GetMapping(value = "/cochexml", produces = "application/xml")
    public Coche cocheXml() {
        return new Coche("mercedes benz", 320,5);
    }

    @PostMapping(value = "/post", produces = "application/xml")
    public ResponseEntity<Coche> post() {
        return new ResponseEntity<Coche>(new Coche("toyota", 200,5), HttpStatus.OK);
    }



    @PostMapping(value = "/postc")
    public static ResponseEntity<String> postCoche(@Valid @RequestBody Coche coche) {
        return ResponseEntity.ok("muy bueno");
    }

}

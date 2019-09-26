package com.trial.controllers;

import com.trial.entities.Coche;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CocheController {

    @GetMapping("/hateoas")
    public HttpEntity<Coche> hateoas(
            @RequestParam(value = "marca", required = false, defaultValue = "Mercedes") String marca) {
        Coche coche = new Coche(marca, 320,4);
        coche.add(linkTo(methodOn(Controlador.class).coche()).withSelfRel());
        return new ResponseEntity<Coche>(coche, HttpStatus.OK);
    }
}

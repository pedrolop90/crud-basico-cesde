package org.example.controller;

import org.example.entity.PersonajeEntity;
import org.example.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<PersonajeEntity> listarPersonajes(){
        return personajeService.listarPersonajes();
    }

    @PostMapping
    public Long guardarPersonaje(@RequestBody PersonajeEntity personajeEntity){

        return personajeService.guardarPersonaje(personajeEntity);
    }
}

package org.example.controller;

import org.example.entity.PersonajeEntity;
import org.example.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeEntity>> listarPersonajes(){
        return personajeService.listarPersonajes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonajeEntity> listarPersonaje(@PathVariable Long id){
        return personajeService.listarPersonaje(id);
    }
    @PostMapping
    public ResponseEntity<PersonajeEntity> guardarPersonaje(@RequestBody PersonajeEntity personajeEntity){
        return personajeService.guardarPersonaje(personajeEntity);
    }
    @PutMapping
    public ResponseEntity<PersonajeEntity> actualizarPersonaje(@RequestBody PersonajeEntity personajeEntity){
        return personajeService.actualizarPersonaje(personajeEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonajeEntity> borrarPersonaje(@PathVariable Long id){
      return personajeService.borrarPersonaje(id);
    }
    @DeleteMapping
    public ResponseEntity<PersonajeEntity> borrarPersonajes(){
       return personajeService.borrarPersonajes();
    }
}

package org.example.service;

import org.example.dao.PersonajeDao;
import org.example.entity.MochilaEntity;
import org.example.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PersonajeService {

    @Autowired
    private PersonajeDao personajeDao;

    //listar todos los personajes
    public ResponseEntity<List<PersonajeEntity>> listarPersonajes(){
        List<PersonajeEntity> personajes=personajeDao.findAll();
        return ResponseEntity.ok(personajes);
    }

    //listar un personaje
    public ResponseEntity<PersonajeEntity> listarPersonaje(Long id){
        Optional<PersonajeEntity> personaje= personajeDao.findById(id);
        if(personaje.isPresent()){
            return ResponseEntity.ok(personaje.get());
        }
        return ResponseEntity.notFound().build();
    }

    //crear un personaje

    public ResponseEntity<PersonajeEntity> guardarPersonaje(PersonajeEntity personajeEntity){
        if(personajeEntity.getPersonajeId()!=null){
            return ResponseEntity.badRequest().build();
        }
        personajeEntity= personajeDao.save(personajeEntity);
        return ResponseEntity.ok(personajeEntity);
    }
    //actualizar un personaje

    public ResponseEntity<PersonajeEntity> actualizarPersonaje(PersonajeEntity personajeEntity){
        if(personajeEntity.getPersonajeId()==null){
            return ResponseEntity.badRequest().build();
        }
        if(!personajeDao.existsById(personajeEntity.getPersonajeId())){
            return ResponseEntity.notFound().build();
        }
        PersonajeEntity personaje= personajeDao.save(personajeEntity);
        return ResponseEntity.ok(personaje);
    }

    //borrar un personaje
    public ResponseEntity<PersonajeEntity> borrarPersonaje(Long id){
        if(!personajeDao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        personajeDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //borrar todos los personajes
    public ResponseEntity<PersonajeEntity> borrarPersonajes(){
        if(personajeDao.count()>0){
            personajeDao.deleteAll();
        }
        return ResponseEntity.noContent().build();
    }
}

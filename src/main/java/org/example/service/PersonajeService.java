package org.example.service;

import org.example.dao.PersonajeDao;
import org.example.entity.MochilaEntity;
import org.example.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonajeService {

    @Autowired
    private PersonajeDao personajeDao;

    public List<PersonajeEntity> listarPersonajes(){
        return personajeDao.findAll();
    }

    public Long guardarPersonaje(PersonajeEntity personajeEntity){
        personajeEntity= personajeDao.save(personajeEntity);
        return personajeEntity.getPersonajeId();
    }
}

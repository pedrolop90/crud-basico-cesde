package org.example.dao;

import org.example.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeDao  extends JpaRepository<PersonajeEntity,Long> {
}

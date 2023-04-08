package org.example.dao;

import org.example.entity.ObjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoDao extends JpaRepository<ObjetoEntity,Long> {

}

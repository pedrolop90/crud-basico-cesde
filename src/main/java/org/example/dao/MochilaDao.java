package org.example.dao;

import org.example.entity.MochilaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MochilaDao extends JpaRepository<MochilaEntity, Long> {

}

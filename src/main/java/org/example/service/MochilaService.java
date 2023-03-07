package org.example.service;

import org.example.dao.MochilaDao;
import org.example.entity.MochilaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MochilaService {

    @Autowired
    private MochilaDao mochilaDao;

    public List<MochilaEntity> listarMochilas(){
        return mochilaDao.findAll();
    }

    public Long guardarMochila(MochilaEntity mochilaEntity){
        mochilaEntity = mochilaDao.save(mochilaEntity);
        return mochilaEntity.getMochilaId();
    }

}

package org.example.service;

import org.example.dao.ObjetoDao;
import org.example.entity.ObjetoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObjetoService {
    @Autowired
    private ObjetoDao objetoDao;

    //listar todos los objetos

    public ResponseEntity<List<ObjetoEntity>> listarObjetos(){
        List<ObjetoEntity> objetoEntities= objetoDao.findAll();
        return ResponseEntity.ok(objetoEntities);
    }

    //listar un objeto
    public ResponseEntity<ObjetoEntity> listarObjeto(Long id){
        Optional<ObjetoEntity> objetoEntity= objetoDao.findById(id);
        if (objetoEntity.isPresent()){
            return ResponseEntity.ok(objetoEntity.get());
        }
        return ResponseEntity.notFound().build();
    }

    //crear un objeto
    public ResponseEntity<ObjetoEntity> crearObjeto(ObjetoEntity objetoEntity){
        //Se valida que el id sea null
        if(objetoEntity.getObjetoId()!=null){
            return ResponseEntity.badRequest().build();
        }
        ObjetoEntity objeto=objetoDao.save(objetoEntity);
        return ResponseEntity.ok(objeto);
    }

    //actualizar un objeto
    public ResponseEntity<ObjetoEntity> actualizarObjeto(ObjetoEntity objetoEntity){
        //se valida que el id no sea null
        if(objetoEntity.getObjetoId() == null){
            return ResponseEntity.badRequest().build();
        }
        //se valida que exista
        if(!objetoDao.existsById(objetoEntity.getObjetoId())){
            return ResponseEntity.notFound().build();
        }
        ObjetoEntity objeto= objetoDao.save(objetoEntity);
        return ResponseEntity.ok(objeto);
    }

    //eliminar un objeto
    public ResponseEntity<ObjetoEntity> borrarObjeto(Long id){
        //se valida que exista
        if(!objetoDao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        objetoDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //eliminar todos los objetos
    public ResponseEntity<ObjetoEntity> borrarObjetos(){
        if(objetoDao.count()>0){
            objetoDao.deleteAll();
        }
        return ResponseEntity.noContent().build();
    }

}

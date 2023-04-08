package org.example.service;

import org.example.dao.MochilaDao;
import org.example.entity.MochilaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MochilaService {

    @Autowired
    private MochilaDao mochilaDao;

    //listar todas las mochilas
    public ResponseEntity<List<MochilaEntity>> listarMochilas(){
        List<MochilaEntity> mochilas= mochilaDao.findAll();
        return ResponseEntity.ok(mochilas);
    }

    //listar una mochila
    public ResponseEntity<MochilaEntity> listarMochila(Long id){
        Optional<MochilaEntity> mochila=mochilaDao.findById(id);
        //se valida si esta ese id en la base de datos
        if(mochila.isPresent()){
        return ResponseEntity.ok(mochila.get());
        }
        return ResponseEntity.notFound().build();
    }

    //crear una mochila
    public ResponseEntity<MochilaEntity> guardarMochila(MochilaEntity mochilaEntity){
        //valida que el usuario no haya ingresado un id al momento de crear el objeto
        if(mochilaEntity.getMochilaId()!=null){
            return ResponseEntity.badRequest().build();
        }
        MochilaEntity mochila = mochilaDao.save(mochilaEntity);
        return ResponseEntity.ok(mochila);
    }

    //actualizar una mochila
    public ResponseEntity<MochilaEntity> actualizarMochila(MochilaEntity mochilaEntity){
        //Se valida que el usuario si haya pasado un id
        if(mochilaEntity.getMochilaId()==null){
            return ResponseEntity.badRequest().build();
        }
        //Se valida que el id que el usuario ingreso exista en base de datos
        if (!mochilaDao.existsById(mochilaEntity.getMochilaId())) {
            return  ResponseEntity.notFound().build();
        }
        MochilaEntity mochila= mochilaDao.save(mochilaEntity);
        return ResponseEntity.ok(mochila);
    }

    //borrar una mochila
    public ResponseEntity<MochilaEntity> borrarMochila(Long id){
        //Se valida que el id si exista en base de datos
        if (!mochilaDao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        mochilaDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //borrar todas las mochilas
    public ResponseEntity<MochilaEntity> borrarMochilas(){
        //Se valida que almenos haya un registro en base de datos
        if(mochilaDao.count()>0){
            mochilaDao.deleteAll();
        }
        return ResponseEntity.noContent().build();
    }

}

package org.example.controller;

import org.example.entity.ObjetoEntity;
import org.example.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetos")
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @GetMapping
    public ResponseEntity<List<ObjetoEntity>> listarObjetos(){
        return objetoService.listarObjetos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ObjetoEntity> listarObjeto(@PathVariable Long id){
        return objetoService.listarObjeto(id);
    }
    @PostMapping()
    public ResponseEntity<ObjetoEntity> crearObjeto(@RequestBody ObjetoEntity objetoEntity){
        return objetoService.crearObjeto(objetoEntity);
    }
    @PostMapping()
    public ResponseEntity<ObjetoEntity> actualizarObjeto(@RequestBody ObjetoEntity objetoEntity){
        return objetoService.actualizarObjeto(objetoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjetoEntity> borrarObjeto(@PathVariable Long id){
        return objetoService.borrarObjeto(id);
    }

    @DeleteMapping()
    public ResponseEntity<ObjetoEntity> borrarObjetos(){
        return objetoService.borrarObjetos();
    }

}

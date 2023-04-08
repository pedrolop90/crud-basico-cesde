package org.example.controller;

import org.example.entity.MochilaEntity;
import org.example.service.MochilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mochilas")
public class MochilaController {

    @Autowired
    private MochilaService mochilaService;

    //listar todas las mochilas
    @GetMapping
    public ResponseEntity<List<MochilaEntity>> listarMochilas(){
        return mochilaService.listarMochilas();
    }

    //listar una mochila
    @GetMapping("/{id}")
    public ResponseEntity<MochilaEntity> listarMochila(@PathVariable Long id){
        return mochilaService.listarMochila(id);
    }
    //crear una mochila
    @PostMapping
    public ResponseEntity<MochilaEntity> guardarMochila(@RequestBody MochilaEntity mochilaEntity){
        return mochilaService.guardarMochila(mochilaEntity);
    }

    //actualizar una mochila
    @PutMapping
    public ResponseEntity<MochilaEntity> actualizarMochila(@RequestBody MochilaEntity mochilaEntity){
        return mochilaService.actualizarMochila(mochilaEntity);
    }

    //borrar una mochila
    @DeleteMapping("/{id}")
    public ResponseEntity<MochilaEntity> borrarMochila(@PathVariable Long id){
        return mochilaService.borrarMochila(id);
    }

    @DeleteMapping
    public ResponseEntity<MochilaEntity> borrarMochilas(){
        return mochilaService.borrarMochilas();
    }

}

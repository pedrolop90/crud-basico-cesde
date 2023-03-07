package org.example.controller;

import org.example.entity.MochilaEntity;
import org.example.service.MochilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mochilas")
public class MochilaController {

    @Autowired
    private MochilaService mochilaService;

    @GetMapping
    public List<MochilaEntity> listarMochilas(){
        return mochilaService.listarMochilas();
    }

    @PostMapping
    public Long guarddarMochila(@RequestBody MochilaEntity mochilaEntity){
        return mochilaService.guardarMochila(mochilaEntity);
    }

}

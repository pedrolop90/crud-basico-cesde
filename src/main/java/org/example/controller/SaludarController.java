package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/saludos")
public class SaludarController {

    @GetMapping
    public String saludar(){
        return "Hola";
    }

    @GetMapping("/v2")
    public String saludarV2(){
        return "Hola V2";
    }

}

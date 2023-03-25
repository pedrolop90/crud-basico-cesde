package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personaje")
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaje_id")
    private Long personajeId;
    private String nombre;
    private Double salud;
    private Double velocidad;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "mochila_id")
    private MochilaEntity mochila;


}

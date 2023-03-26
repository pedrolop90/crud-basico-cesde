package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mochila")
public class MochilaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mochila_id")
    private Long mochilaId;
    private String nombre;
    private Integer capacidad;
    private String color;

    @ManyToMany
    @JoinTable(name = "mochila_objeto",
        joinColumns = @JoinColumn(name = "mochila_id"),
        inverseJoinColumns = @JoinColumn(name = "objeto_id"))
    private List<ObjetoEntity> objetos= new ArrayList<>();
}

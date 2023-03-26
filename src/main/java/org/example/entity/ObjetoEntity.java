package org.example.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "objeto")
public class ObjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objeto_id")
    private Long objetoId;
    private String nombre;
    private String tipo;
    private Float costo;
    //@ManyToMany(mappedBy = "objetos")
    //@JsonBackReference
    //private List<MochilaEntity> mochilaEntities= new ArrayList<>();
    //private List<MochilaEntity> mochilaEntities= new ArrayList<>();
}

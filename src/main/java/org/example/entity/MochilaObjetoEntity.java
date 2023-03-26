package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mochila_objeto")
public class MochilaObjetoEntity {
    @EmbeddedId
    private MochilaObjetoEntityPK id;

    @ManyToOne
    @MapsId("mochilaId")
    @JoinColumn(name = "mochila_id")
    private MochilaEntity mochilaEntity;

    @ManyToOne
    @MapsId("objetoId")
    @JoinColumn(name = "objeto_id")
    private ObjetoEntity objetoEntity;
}

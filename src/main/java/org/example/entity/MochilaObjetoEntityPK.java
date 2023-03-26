package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MochilaObjetoEntityPK implements Serializable {
    @Column(name = "mochila_id")
    private Long mochilaId;
    @Column(name = "objeto_id")
    private Long objetoId;
}

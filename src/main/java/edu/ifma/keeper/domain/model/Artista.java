package edu.ifma.keeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "artista")
public class Artista {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer idArtista;

    @NotNull @NotBlank
    @Column(name = "nome")
    private String nome;
    
    @NotNull @NotBlank
    @Column(name = "nascionalidade")
    private String nascionalidade;
}

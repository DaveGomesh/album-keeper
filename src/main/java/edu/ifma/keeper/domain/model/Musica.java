package edu.ifma.keeper.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "musica")
public class Musica {
    
    @Column(name = "id_musica")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusica;

    @ManyToMany
    @JoinTable(
        name = "musica_artista_autor",
        joinColumns = @JoinColumn(name = "id_musica"),
        inverseJoinColumns = @JoinColumn(name = "id_artista")
    )
    private Set<Artista> autores;

    @ManyToMany
    @JoinTable(
        name = "musica_artista_cantor",
        joinColumns = @JoinColumn(name = "id_musica"),
        inverseJoinColumns = @JoinColumn(name = "id_artista")
    )
    private Set<Artista> cantores;

    @NotNull @NotBlank
    @Column(name = "nome")
    private String nome;
    
    @NotNull @NotBlank
    @Column(name = "duracao")
    private Integer duracao;
}

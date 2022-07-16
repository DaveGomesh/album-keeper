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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "album")
public class Album {
    
    @Column(name = "id_album")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;

    @ManyToMany
    @JoinTable(
        name = "album_artista_participante",
        joinColumns = @JoinColumn(name = "id_album"),
        inverseJoinColumns = @JoinColumn(name = "id_artista")
    )
    private Set<Artista> participantes;
    
    @ManyToMany
    @JoinTable(
        name = "album_musica_musica",
        joinColumns = @JoinColumn(name = "id_album"),
        inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    private Set<Musica> musicas;

    @NotNull @NotBlank
    @Column(name = "nome")
    private String nome;
    
    @NotNull @Min(0)
    @Column(name = "ano")
    private Integer ano;
}

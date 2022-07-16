
create table musica (
    id_musica integer not null auto_increment,
    duracao integer not null,
    nome varchar(255) not null,
    primary key (id_musica)
) engine=InnoDB;

create table musica_artista_autor (
    id_musica integer not null,
    id_artista integer not null
) engine=InnoDB;

create table musica_artista_cantor (
    id_musica integer not null,
    id_artista integer not null
) engine=InnoDB;

alter table musica_artista_autor
    add constraint FK3hsdt8da8e0n66mjtf8q5fw9h
    foreign key (id_artista)
    references artista (id_artista);

alter table musica_artista_autor
    add constraint FKn625xu02mq9y23s1s77i4q35i
    foreign key (id_musica)
    references musica (id_musica);

alter table musica_artista_cantor
    add constraint FKmgip5fnw2yq0sn0u1xna8fh0q
    foreign key (id_artista)
    references artista (id_artista);

alter table musica_artista_cantor
    add constraint FKna20892f7rjmuwvco3v07rs3a
    foreign key (id_musica)
    references musica (id_musica);
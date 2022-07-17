
create table album (
    id_album integer not null auto_increment,
    ano integer not null,
    nome varchar(255) not null,
    primary key (id_album)
) engine=InnoDB;

create table album_artista_participante (
    id_album integer not null,
    id_artista integer not null,
    primary key (id_album, id_artista)
) engine=InnoDB;

create table album_musica_musica (
    id_album integer not null,
    id_musica integer not null,
    primary key (id_album, id_musica)
) engine=InnoDB;

alter table album_artista_participante
    add constraint FK5dh7ivwwiwrclgh01dv28oj5j
    foreign key (id_artista)
    references artista (id_artista);

alter table album_artista_participante
    add constraint FKi5sk60gp9xiikmgo54fcp3g5q
    foreign key (id_album)
    references album (id_album);

alter table album_musica_musica
    add constraint FK5p9dka0qhbdbnidvydxacign5
    foreign key (id_musica)
    references musica (id_musica);

alter table album_musica_musica
    add constraint FK5d8t44ckfhau8cheslw5wj856
    foreign key (id_album)
    references album (id_album);
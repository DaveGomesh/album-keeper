create table artista (
    id_artista integer not null auto_increment,
    nascionalidade varchar(255) not null,
    nome varchar(255) not null,
    primary key (id_artista)
) engine=InnoDB;
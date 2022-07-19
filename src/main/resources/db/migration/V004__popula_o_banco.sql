
--
-- Insere dados da tabela `artista`
--

INSERT INTO `artista` (`id_artista`, `nascionalidade`, `nome`) VALUES
(1, 'Brasil', 'Lucca Martin'),
(2, 'Colômbia', 'Stefany Vanessa'),
(3, 'Espanha', 'Bernardo Ian'),
(4, 'Equador', 'Juan Cardoso Rafael'),
(5, 'Alemanha', 'Lara Drumond'),
(6, 'Brasil', 'Mariah Olivia'),
(7, 'Brasil', 'Beatriz Peixoto'),
(8, 'México', 'Isadora Carolina'),
(9, 'Espanha', 'Raul Pietro'),
(10, 'Brasil', 'Alícia Nicole');

--
-- Insere dados da tabela `musica`
--

INSERT INTO `musica` (`id_musica`, `duracao`, `nome`) VALUES
(1, 1, 'Música A'),
(2, 2, 'Música B'),
(3, 3, 'Música C'),
(4, 4, 'Música D'),
(5, 4, 'Música E'),
(6, 6, 'Música F'),
(7, 7, 'Música G'),
(8, 7, 'Música H'),
(9, 9, 'Música I'),
(10, 10, 'Música J'),
(11, 3, 'Música K'),
(12, 6, 'Música L');

--
-- Insere dados da tabela `musica_artista_autor`
--

INSERT INTO `musica_artista_autor` (`id_musica`, `id_artista`) VALUES
(1, 1),
(2, 2),
(2, 1),
(3, 3),
(4, 4),
(4, 5),
(5, 5),
(6, 6),
(7, 9),
(7, 7),
(7, 8),
(8, 8),
(8, 1),
(9, 9),
(10, 10),
(11, 10),
(11, 1),
(11, 5),
(12, 8),
(12, 2),
(12, 10),
(12, 4),
(12, 6);

--
-- Insere dados da tabela `musica_artista_cantor`
--

INSERT INTO `musica_artista_cantor` (`id_musica`, `id_artista`) VALUES
(1, 2),
(1, 1),
(2, 3),
(2, 2),
(2, 1),
(3, 3),
(4, 3),
(4, 4),
(5, 4),
(6, 3),
(6, 7),
(6, 2),
(6, 4),
(6, 6),
(6, 1),
(6, 5),
(7, 7),
(8, 8),
(8, 2),
(8, 10),
(8, 5),
(9, 9),
(9, 10),
(9, 1),
(10, 10),
(11, 9),
(11, 2),
(11, 10),
(11, 6),
(11, 1),
(11, 5),
(12, 9),
(12, 3),
(12, 7),
(12, 1),
(12, 5);

--
-- Insere dados da tabela `album`
--

INSERT INTO `album` (`id_album`, `ano`, `nome`) VALUES
(1, 2019, 'Álbum 2019'),
(2, 2020, 'Álbum 2020'),
(3, 2021, 'Álbum 2021'),
(4, 2022, 'Álbum 2022');

--
-- Insere dados da tabela `album_artista_participante`
--

INSERT INTO `album_artista_participante` (`id_album`, `id_artista`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 7),
(3, 8),
(3, 9),
(4, 9),
(4, 10);

--
-- Insere dados da tabela `album_musica_musica`
--

INSERT INTO `album_musica_musica` (`id_album`, `id_musica`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 7),
(3, 8),
(3, 9),
(4, 9),
(4, 10),
(4, 11),
(4, 12);

COMMIT;

CREATE DATABASE ahorcado;
USE ahorcado;

CREATE TABLE words(
id_word INT AUTO_INCREMENT NOT NULL,
word_name VARCHAR(50) NOT NULL,
CONSTRAINT pk_id_words PRIMARY KEY (id_word),
CONSTRAINT unq_words UNIQUE(word_name)
);

create table winners(
	id_winner bigint auto_increment,
    winner_name varchar(50) not null,
    date_game datetime not null,
    word varchar(50) not null,
    constraint pk_id_winner primary key (id_winner)
);


INSERT INTO words(word_name) VALUE
("BARCO") , ("PLANETA") , ("AMIGOS") , ("ESCUELA") , ("UNIVERSIDAD") , ("PROGRAMACION"),
("PARTIDO") , ("PESCAR") , ("FUTBOL") , ("PELOTA") , ("CASTILLO") , ("GOLF"),
("INTERNET") , ("MAVEN") , ("MUSICA") , ("TECNOLOGIA") , ("PIANO") , ("TAREA"),
("HOMBRE") , ("MUJER") , ("FLAUTA") , ("POLITICA") , ("WEB") , ("PRODUCTO"),
("CLIENTE") , ("INFORMATICA") , ("WINDOWS") , ("LINUX") , ("COMIDA") , ("NATURALEZA"),
("ANIMAL") , ("PERIODICO") , ("AJEDREZ") , ("CUMPLEAÑOS") , ("PALIGROMO") ,
("ELECTROENCEFALOGRAFISTA") , ("MEDICO") , ("OFICIO") , ("OTORRINOLARINGOLOGO")
;



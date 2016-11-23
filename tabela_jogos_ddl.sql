CREATE SCHEMA tabela_jogos DEFAULT CHARACTER SET utf8 ;

create table tabela_jogos.time(
time_id int auto_increment,
time_nome varchar(250),
CONSTRAINT pk__time__time_id PRIMARY KEY (time_id)
);

create table tabela_jogos.jogo(
jogo_id int auto_increment, 
fk_jogo_time_casa int,
fk_jogo_time_contra int,
jogo_rodada int,
CONSTRAINT pk__jogo__jogo_id PRIMARY KEY (jogo_id),
CONSTRAINT fk__jogo__fk_jogo_time_casa FOREIGN KEY (fk_jogo_time_casa) 
	REFERENCES tabela_jogos.time(time_id),
CONSTRAINT fk__jogo__fk_jogo_time_contra FOREIGN KEY (fk_jogo_time_contra) 
	REFERENCES tabela_jogos.time(time_id)
);
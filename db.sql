CREATE SEQUENCE s_pauta
INCREMENT 1
START 1;

create table t_pauta(
isn_pauta int NOT NULL primary key DEFAULT nextval('s_pauta'),
dat_cadastro timestamp without time zone not null,
dsc_pauta varchar(255) not null
);

CREATE SEQUENCE s_sessao
INCREMENT 1
START 1;

create table t_sessao(
isn_sessao int NOT NULL primary key DEFAULT nextval('s_sessao'),
isn_pauta int NOT NULL,
dat_inicio timestamp without time zone not null,
dat_fim timestamp without time zone not null,
FOREIGN KEY (isn_pauta) REFERENCES t_pauta(isn_pauta)
);

CREATE SEQUENCE s_votacao
INCREMENT 1
START 1;

create table t_votacao(
isn_votacao int NOT NULL primary key DEFAULT nextval('s_votacao'),
isn_sessao int not null,
dat_cadastro timestamp without time zone not null,
cpf varchar(11),
voto BOOLEAN not null,
FOREIGN KEY (isn_sessao) REFERENCES t_sessao(isn_sessao),
unique(isn_sessao,cpf)
);



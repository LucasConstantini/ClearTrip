﻿CREATE TABLE empresa
(
id smallint NOT NULL,
nome character varying(255) NOT NULL,
endereco character varying(255) NOT NULL,
telefone character varying(15) NOT NULL,
nomefantasia character varying(255) NOT NULL,
nomerepresentante character varying(255) NOT NULL,
cnpj bigint NOT NULL,
cpfrepresentante bigint NOT NULL,
  CONSTRAINT idempresa_primary_key PRIMARY KEY (id),
  CONSTRAINT cnpj_unique UNIQUE (cnpj),
  CONSTRAINT cpfrepresentante_unique UNIQUE (cpfrepresentante)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE categoria_despesa
(
id bigserial NOT NULL,
nome character varying(255) NOT NULL,
valorlimite numeric(10,2),
  CONSTRAINT idcategoriadespesa_primary_key PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE meio_transporte
(
id bigserial NOT NULL, 
nome character varying(255) NOT NULL, 
   CONSTRAINT idmeiotransporte_primary_key PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE usuario
(
id smallint NOT NULL,
empresa_id smallint NOT NULL,
nome character varying(255) NOT NULL,
senha character varying(50) NOT NULL,
cpf bigint NOT NULL,
rg character varying(20) NOT NULL,
tipo smallint NOT NULL,
emailpessoal character varying(255),
emailcorporativo character varying(255),
telefonepessoal character varying(15),
telefonecorporativo character varying(15),
login character varying(50) NOT NULL,
  CONSTRAINT cpf_unique UNIQUE (cpf),
  CONSTRAINT rg_unique UNIQUE (rg),
  CONSTRAINT idusuario_primary_key PRIMARY KEY (id),
  CONSTRAINT empresa_id_foreign_key FOREIGN KEY (empresa_id)
      REFERENCES empresa (id) ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
CREATE TABLE parametros
(
id integer NOT NULL, 
empresa_id smallint NOT NULL, 
manha time(6) with time zone NOT NULL, 
tarde time(6) with time zone NOT NULL, 
noite time(6) with time zone NOT NULL, 
datatermino date NOT NULL, 
datainicio date NOT NULL, 
margemdeslocamento integer NOT NULL, 
custokm numeric(10,2) NOT NULL, 
   CONSTRAINT idparametros_primary_key PRIMARY KEY (id), 
   CONSTRAINT empresa_id_foreign_key FOREIGN KEY (empresa_id) REFERENCES empresa (id) ON UPDATE CASCADE ON DELETE RESTRICT
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE viagem
(
id integer NOT NULL, 
usuario_id smallint NOT NULL, 
meio_transporte_id integer NOT NULL, 
status character varying(1) NOT NULL, 
destino character varying(255) NOT NULL, 
motivo character varying(3000), 
enderecodestino character varying(255) NOT NULL, 
telefonedestino character varying(20) NOT NULL, 
outrosmateriais character varying(3000), 
cidadepartida character varying(255) NOT NULL, 
enderecopartida character varying(255) NOT NULL, 
telefonepartida character varying(15) NOT NULL, 
datapartida date NOT NULL, 
horapartida time(6) with time zone NOT NULL, 
aeroportoida character varying(255), 
ciaaereaida character varying(255), 
numerovooida character varying(10), 
datacompromisso date, 
horacompromisso time(6) with time zone,
datavolta date NOT NULL, 
horavolta time(6) with time zone NOT NULL, 
aeroportovolta character varying(255), 
ciaaereavolta character varying(255), 
numerovoovolta character varying(10), 
valoradiantamento numeric(10,2),
valorreembolso numeric(10,2),
valorressarciamento numeric(10,2),  
nreciboadiantamento character varying(10),
nreciboressarciamento character varying(10),
relatoviagem character varying(6000),
dataaprovacao date NOT NULL,
dataencerramento date,
   CONSTRAINT idviagem_primary_key PRIMARY KEY (id), 
   CONSTRAINT usuario_id_foreign_key FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON UPDATE CASCADE ON DELETE RESTRICT, 
   CONSTRAINT meio_transporte_id_foreign_key FOREIGN KEY (meio_transporte_id) REFERENCES meio_transporte (id) ON UPDATE CASCADE ON DELETE RESTRICT
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE despesa
(
id integer NOT NULL, 
viagem_id integer NOT NULL, 
categoria_despesa_id integer NOT NULL, 
comprovante bit varying(20000000) NOT NULL, 
valor numeric(10,2) NOT NULL, 
nomeestabelecimento character varying(255), 
datacompra date NOT NULL, 
horacompra time(6) with time zone NOT NULL, 
cnpj bigint, 
descritivo character varying(255), 
valorrealautorizado numeric(10,2) NOT NULL, 
   CONSTRAINT iddespesas_primary_key PRIMARY KEY (id), 
   CONSTRAINT categoria_despesa_id_foreign_key FOREIGN KEY (categoria_despesa_id) REFERENCES categoria_despesa (id) ON UPDATE CASCADE ON DELETE RESTRICT, 
   CONSTRAINT viagem_id_foreign_key FOREIGN KEY (viagem_id) REFERENCES viagem (id) ON UPDATE CASCADE ON DELETE RESTRICT
) 
WITH (
  OIDS = FALSE
);
CREATE TABLE professor (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    funcional VARCHAR(7),
	nome VARCHAR(150) NOT NULL,
	titulo VARCHAR(15),
	cpf VARCHAR(14),
	dtnasc DATE,
    endereco VARCHAR(150),
    celular VARCHAR(15) NOT NULL,
	fixo VARCHAR(15),
	outro VARCHAR(15),
	emailprincipal VARCHAR(50) NOT NULL,
	emailsecundario VARCHAR(50),
	situacao VARCHAR(10),
	admissao DATE,
    coordenador TINYINT(1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 
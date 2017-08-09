CREATE TABLE aluno (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(13),
	nome VARCHAR(150) NOT NULL,
    emailprincipal VARCHAR(50) NOT NULL,
	celular VARCHAR(15) NOT NULL,
	fixo VARCHAR(15),
	outro VARCHAR(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


CREATE TABLE estagio (
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  aluno BIGINT(20) NOT NULL,
  periodo VARCHAR(3) NULL,
  semestreatual VARCHAR(6) NULL,
  tipoestagio VARCHAR(12) NULL,
  diaestagio VARCHAR(10) NULL,
  horario VARCHAR(12) NULL,
  observacao VARCHAR(500) NULL,
  datainscricao DATE NULL,
  dp TINYINT(1) NULL,
  cargahoraria VARCHAR(3) NULL,
  professor VARCHAR(100) NULL,
  nota DOUBLE NULL,
  situacao VARCHAR(10) NULL,
  INDEX `idx_aluno_idx` (`aluno` ASC),
  CONSTRAINT `idx_aluno`
    FOREIGN KEY (`aluno`)
    REFERENCES aluno (`codigo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE curso (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    coordenador VARCHAR(150),
    mec VARCHAR(30) NOT NULL,
    ies BIGINT(20) NOT NULL,
	KEY `fk_curso_ies_idx` (`ies`),
	CONSTRAINT `fk_curso_ies` FOREIGN KEY (`ies`) REFERENCES `ies` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 
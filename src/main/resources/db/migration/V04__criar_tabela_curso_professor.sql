CREATE TABLE curso_professor(
	curso_id BIGINT(20) NOT NULL,
	professor_id BIGINT(20) NOT NULL,	
	PRIMARY KEY (`curso_id`,`professor_id`),
	KEY `fk_cp_professor_idx` (`professor_id`),
	CONSTRAINT `fk_cp_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_cp_professor` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 
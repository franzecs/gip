package com.ikytus.gip.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import com.ikytus.gip.model.Curso;

public class CursoConverter implements Converter<String, Curso> {
	
	@Override
	public Curso convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Curso curso = new Curso();
			curso.setCodigo(Long.valueOf(codigo));
			return curso;
		}
		
		return null;
	}

}

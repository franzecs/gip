package com.ikytus.gip.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import com.ikytus.gip.model.Professor;

public class ProfessorConverter implements Converter<String, Professor> {
	
	@Override
	public Professor convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Professor professor = new Professor();
			professor.setCodigo(Long.valueOf(codigo));
			return professor;
		}
		
		return null;
	}

}

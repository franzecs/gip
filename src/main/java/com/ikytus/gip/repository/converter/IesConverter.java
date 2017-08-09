package com.ikytus.gip.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import com.ikytus.gip.model.Ies;

public class IesConverter implements Converter<String, Ies> {
	
	@Override
	public Ies convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Ies ies = new Ies();
			ies.setCodigo(Long.valueOf(codigo));
			return ies;
		}
		
		return null;
	}

}

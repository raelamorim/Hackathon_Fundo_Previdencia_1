package com.orangelittle.dominio;

import javax.persistence.AttributeConverter;

public class ConversorTipoSegmento implements AttributeConverter<TipoSegmento, Integer>{
	
	@Override
	public Integer convertToDatabaseColumn(TipoSegmento tipo) {
		return tipo.getValor();
	}

	@Override
	public TipoSegmento convertToEntityAttribute(Integer valor) {
		return TipoSegmento.getTipoSegmento(valor);
	}
}

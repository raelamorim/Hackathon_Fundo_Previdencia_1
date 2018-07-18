package com.orangelittle.dominio;

import javax.persistence.AttributeConverter;

public class ConversorTipoMovimento implements AttributeConverter<TipoMovimento, Character>{
	
	@Override
	public Character convertToDatabaseColumn(TipoMovimento tipo) {
		return tipo.getValor();
	}

	@Override
	public TipoMovimento convertToEntityAttribute(Character valor) {
		return TipoMovimento.getTipoMovimento(valor);
	}
}

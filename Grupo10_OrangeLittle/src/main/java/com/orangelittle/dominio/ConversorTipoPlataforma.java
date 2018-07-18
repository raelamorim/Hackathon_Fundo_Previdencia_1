package com.orangelittle.dominio;


import javax.persistence.AttributeConverter;

public class ConversorTipoPlataforma implements AttributeConverter<TipoPlataforma, Integer>{
	
	@Override
	public Integer convertToDatabaseColumn(TipoPlataforma tipo) {
		return tipo.getValor();
	}

	@Override
	public TipoPlataforma convertToEntityAttribute(Integer valor) {
		return TipoPlataforma.getTipoPlataforma(valor);
	}
}

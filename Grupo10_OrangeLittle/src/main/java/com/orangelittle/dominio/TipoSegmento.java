package com.orangelittle.dominio;


public enum TipoSegmento {
	SEGMENTO_1(1), SEGMENTO_2(2), SEGMENTO_3(3), SEGMENTO_4(4), SEGMENTO_5(5);
	
	private Integer valor;
	
	private TipoSegmento(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
	public static TipoSegmento getTipoSegmento(Integer valor) {
		if (valor == null) {
			return null;
		}
	        
	    for (TipoSegmento t : values()) {
	        if (t.getValor() == valor) {
	        	return t;
	        }
	    }
	    return null;
	}
}

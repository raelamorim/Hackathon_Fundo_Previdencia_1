package com.orangelittle.dominio;

public enum TipoPlataforma {
	AZ1(1), AZ2(2), AZ3(3), AZ4(4), AZ5(5);
	
	private Integer valor;
	
	private TipoPlataforma(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
	public static TipoPlataforma getTipoPlataforma(Integer valor) {
		if (valor == null) {
			return null;
		}
	        
	    for (TipoPlataforma t : values()) {
	        if (t.getValor() == valor) {
	        	return t;
	        }
	    }
	    return null;
	}
}

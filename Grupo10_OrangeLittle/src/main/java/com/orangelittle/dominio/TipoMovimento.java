package com.orangelittle.dominio;


public enum TipoMovimento {
	COMPRA('C'), VENDA('V');
	
	private Character valor;
	
	private TipoMovimento(Character valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}
	
	public static TipoMovimento getTipoMovimento(Character valor) {
		if (valor == null) {
			return null;
		}
	        
	    for (TipoMovimento t : values()) {
	        if (t.getValor() == valor) {
	        	return t;
	        }
	    }
	    return null;
	}
}

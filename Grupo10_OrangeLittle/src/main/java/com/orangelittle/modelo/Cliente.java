package com.orangelittle.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Id_Cliente")
	private int id;
	
	@Column(name = "No_Documento")
	private long numeroDocumento;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Segmn_Cli")
	private int idSegmento;
	
	@Column(name = "Segmento")
	private String segmento;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSegmento() {
		return idSegmento;
	}

	public void setIdSegmento(int idSegmento) {
		this.idSegmento = idSegmento;
	}

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getNome() {
		return nome;
	}
	
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Cliente(int id, long numeroDocumento, String nome, int idSegmento)
			throws Exception{
		setId(id);
		setNome(nome);
		setNumeroDocumento(numeroDocumento);
		setIdSegmento(idSegmento);
	}
	
	public Cliente(String nome) throws Exception{
		setNome(nome);
	}
	
	public Cliente(long numeroDocumento) throws Exception{
		setNumeroDocumento(numeroDocumento);
	}
	
	@Deprecated
	public Cliente() {}
	
	public void setNome(String nome) throws Exception{
		if ((nome.trim().isEmpty()) || (nome == null))
			throw new Exception("Nome deve ser preenchido");
		if (nome.trim().length() <= 3)
			throw new Exception("Nome deve possuir mais de três caracteres");
		this.nome = nome;
	}

	public void setNumeroDocumento(long numeroDocumento) throws Exception{
		if (numeroDocumento == 0)
			throw new Exception("Número do Documento não pode ser igual a zeros");
		this.numeroDocumento = numeroDocumento;
	}
}

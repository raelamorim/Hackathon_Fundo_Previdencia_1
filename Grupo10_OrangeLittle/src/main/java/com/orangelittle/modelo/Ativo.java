package com.orangelittle.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orangelittle.dominio.*;

@Entity 
public class Ativo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name = "Id_Ativo")
	private Long id;
	
	@Column(name = "id_Plataforma")
	private Long idPlataforma;

	@Column(name = "Plataforma")
	private String plataforma;
	
	@Column(name = "Cod_Ativo")
	private String codigo;
	
	@Column(name = "Nom_Ativo")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataVencimentoAtivo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataVencimentoAtivo() {
		return dataVencimentoAtivo;
	}

	public void setDataVencimentoAtivo(Calendar dataVencimentoAtivo) {
		this.dataVencimentoAtivo = dataVencimentoAtivo;
	}
	
	public Long getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Long idPlataforma) {
		this.idPlataforma = idPlataforma;
	}


	public Ativo(Long id, String plataforma, String nome, String codigo, Long idPlataforma)
			throws Exception{
		this.id = id;
		this.plataforma = plataforma;
		this.codigo = codigo;
		this.nome = nome;
		this.idPlataforma = idPlataforma;
	}
	
	public Ativo(){}
}

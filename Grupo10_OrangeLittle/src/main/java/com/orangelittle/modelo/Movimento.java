package com.orangelittle.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orangelittle.dominio.ConversorTipoMovimento;
import com.orangelittle.dominio.ConversorTipoPlataforma;
import com.orangelittle.dominio.TipoMovimento;

@Entity
public class Movimento {
	
	@Id
	@Column(name = "Id_Mov")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private Long cliente;
	
	@Column(name = "Tipo")
	@Convert(converter = ConversorTipoMovimento.class)
	private TipoMovimento tipo;
	
	@Column(name = "ativo")
	private Long ativo; 
	
	private Long quantidade;
	
	private BigDecimal valor;
	
	private Long idPlataforma;
	
	private String nomePlataforma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Long getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Long idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	
	public String getNomePlataforma() {
		return nomePlataforma;
	}

	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}
	
	public Movimento(Long id, Calendar data, long cliente, TipoMovimento tipo, Long ativo,
			Long quantidade, BigDecimal valor, Long idPlataforma, String nomePlataforma) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.tipo = tipo;
		this.ativo = ativo;
		this.quantidade = quantidade;
		this.valor = valor;
		this.idPlataforma = idPlataforma;
		this.nomePlataforma = nomePlataforma;
	}
	
	public Movimento() {}
}

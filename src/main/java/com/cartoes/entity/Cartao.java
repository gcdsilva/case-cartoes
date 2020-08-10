package com.cartoes.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
@Table(name="cartao") 
public class Cartao {

	@Id
	@GeneratedValue
    private Long id;
	
	@ManyToOne(optional = true)
    private Cliente clienteId;
	
	@NotNull
	private String numero;

	@JsonProperty("ativo")
	private boolean ativo;

	public Cartao(Long id, Cliente clienteId, String numero, boolean ativo) {
		this.id = id;
		this.clienteId = clienteId;
		this.numero = numero;
		this.ativo = ativo;
	}

	public Cartao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


}

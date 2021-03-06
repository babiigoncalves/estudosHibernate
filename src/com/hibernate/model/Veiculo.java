package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -5690803685277316589L;
	private Integer id;
	private String modelo;
	private Integer ano;
	private Usuario usuario;
	
	public Veiculo(){}
	
	public Veiculo(String modelo, Integer ano) {
		this.modelo = modelo;
		this.ano = ano;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy="veiculo")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}

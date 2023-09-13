package com.monitoreocontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "estados")
public class Estado {
	// PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// VARIABLES
	private int estado;

	@CreatedDate
	@Column(name = "evento", updatable = false,nullable = false)
	@Temporal(TemporalType.TIMESTAMP)

	private Date evento;

//RELACIONES 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "actuador_id")
	private Actuador actuador;

	// GETTERS Y SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getEvento() {
		return evento;
	}

	public void setEvento(Date evento) {
		this.evento = evento;
	}

	public Actuador getActuador() {
		return actuador;
	}

	public void setActuador(Actuador actuador) {
		this.actuador = actuador;
	}

}

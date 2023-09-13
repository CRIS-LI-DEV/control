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
@Table(name = "lecturas_analogicas")
public class Lectura_Analogica {

	// PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// VARIABLES
	private long id;
	private int estado;

	@CreatedDate
	@Column(name = "evento", updatable = false,nullable = false)
	@Temporal(TemporalType.TIMESTAMP)

	private Date evento;

//RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "sensor_analogico_id")
	private Sensor_Analogico sensor_analogico;

	// GETTERTS Y SETTERS

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

	public Sensor_Analogico getSensor_analogico() {
		return sensor_analogico;
	}

	public void setSensor_analogico(Sensor_Analogico sensor_analogico) {
		this.sensor_analogico = sensor_analogico;
	}

}

package com.monitoreocontrol.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "sensores_analogicos")
public class Sensor_Analogico {
//PRIMARY KEY
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//VARIABLES
	private String nombre;
	private String descripcion;
	
	//RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "tarjeta_id")
	private Tarjeta tarjeta;
	
	
	@OneToMany(mappedBy = "sensor_analogico", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Lectura_Analogica> lecturas_analogicas;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Tarjeta getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}


	public List<Lectura_Analogica> getLecturas_analogicas() {
		return lecturas_analogicas;
	}


	public void setLecturas_analogicas(List<Lectura_Analogica> lecturas_analogicas) {
		this.lecturas_analogicas = lecturas_analogicas;
	}


	
	
	
	
	
	
	
}

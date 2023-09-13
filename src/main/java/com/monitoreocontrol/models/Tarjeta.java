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
@Table(name = "tarjetas")
public class Tarjeta {
	
	//PRIMARY KEY
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//VARIABLES 
	private String nombre;
	private String descripcion;

	
	//RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "sector_id")
	private Sector sector;
		
	
	
	
	
	
	
	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Sensor_Analogico> sensores_analogicos;
	
	
	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Sensor_Logico> sensores_logicos;
	
	
	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Actuador> actuadores;

//GETTERS Y SETTERS
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


	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public List<Sensor_Analogico> getSensores_analogicos() {
		return sensores_analogicos;
	}


	public void setSensores_analogicos(List<Sensor_Analogico> sensores_analogicos) {
		this.sensores_analogicos = sensores_analogicos;
	}


	public List<Sensor_Logico> getSensores_logicos() {
		return sensores_logicos;
	}


	public void setSensores_logicos(List<Sensor_Logico> sensores_logicos) {
		this.sensores_logicos = sensores_logicos;
	}


	public List<Actuador> getActuadores() {
		return actuadores;
	}


	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}



		
	
	
	
}

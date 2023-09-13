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
@Entity
@Table(name = "sensores_logicos")
public class Sensor_Logico {
//PRIAMRY KEY
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	//VARIABLES
	private String nombre;
	private String descripcion;
	private String emai;
	
	//RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "tarjeta_id")
	private Tarjeta tarjeta;
	
	@OneToMany(mappedBy ="sensor_logico", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Lectura_Logica> lecturas_logicas;
	
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
	public String getEmai() {
		return emai;
	}
	public void setEmai(String emai) {
		this.emai = emai;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public List<Lectura_Logica> getLecturas_logicas() {
		return lecturas_logicas;
	}
	public void setLecturas_logicas(List<Lectura_Logica> lecturas_logicas) {
		this.lecturas_logicas = lecturas_logicas;
	} 


}

package com.monitoreocontrol.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "usuarios")
public class Usuario {
//PRIMARY KEY
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	// VARIABLES
	private String nombre;
	private String descripcion;
	private String email;
	
	
	
	// RELACIONES
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Sector> sectores;

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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Sector> getSectores() {
		return sectores;
	}



	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

	
	

	
	
	
	
	
	
	
}

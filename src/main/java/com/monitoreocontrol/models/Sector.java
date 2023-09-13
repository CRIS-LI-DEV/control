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
@Table(name = "sectores")
public class Sector {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//primary key
	private long id;
	
	//variables
	private String nombre;
	private String descripcion;
	private String emai;

	//RELACIONES 
		@ManyToOne(fetch = FetchType.LAZY)
		@JsonBackReference
		@JoinColumn(name = "administrador_id")
		private Administrador administrador;

		@ManyToOne(fetch = FetchType.LAZY)
		@JsonBackReference
		@JoinColumn(name = "usuarios_id")
		private Usuario usuario;
		
		@OneToMany(mappedBy = "sector", fetch = FetchType.LAZY)
		@JsonManagedReference
		private List<Tarjeta> tarjetas;

		

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

		public Administrador getAdministrador() {
			return administrador;
		}

		public void setAdministrador(Administrador administrador) {
			this.administrador = administrador;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public List<Tarjeta> getTarjeta() {
			return tarjetas;
		}

		public void setTarjeta(List<Tarjeta> tarjeta) {
			this.tarjetas = tarjeta;
		}
		
		
		


}

package com.monitoreocontrol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.monitoreocontrol.models.Administrador;
import com.monitoreocontrol.models.Usuario;

public interface AdministradorRepository extends CrudRepository<Administrador,Long>{
	// Método de convención para buscar usuarios por dirección de correo electrónico

}

package com.monitoreocontrol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.monitoreocontrol.models.*;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>  {

    List<Usuario> findByEmail(String email);
    
   
    Optional<Usuario> findByNombre(String nombre);
	 
   
    
    Optional<Usuario> findById(Long id);
	
	
}

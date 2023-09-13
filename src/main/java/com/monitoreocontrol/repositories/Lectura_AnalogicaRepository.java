package com.monitoreocontrol.repositories;

import org.springframework.data.repository.CrudRepository;

import com.monitoreocontrol.models.Lectura_Analogica;
import com.monitoreocontrol.models.Lectura_Logica;

public interface Lectura_AnalogicaRepository extends CrudRepository<Lectura_Analogica,Long>{

}

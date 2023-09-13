package com.monitoreocontrol.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monitoreocontrol.models.*;
import com.monitoreocontrol.repositories.*;

@RestController
public class ControlApi {
	// REPOSITORIOS
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SectorRepository sectorRepository;

	@Autowired
	private TarjetaRepository tarjetaRepository;
	@Autowired
	private Sensor_LogicoRepository sensor_logicoRepository;
	@Autowired
	private Sensor_AnalogicoRepository sensor_analogicoRepository;

	@Autowired
	private ActuadorRepository actuadorRepository;
	@Autowired
	private Lectura_LogicaRepository lectura_logicaRepository;

	@Autowired
	private Lectura_AnalogicaRepository lectura_analogicaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
//METODOS USUARIOS
//CREAR USUARIO
	@PostMapping(path = "/api/crear_usuario")
	public Usuario createUser(@RequestParam("nombre") String nombre, @RequestParam("email") String email) {
		System.out.println("ENTRE A CREAR USUARIOS");
		System.out.println("SE CREO EL USUARIO " + nombre + " CON EL EMAIL DE " + email);

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		return usuarioRepository.save(usuario);
	}

//BUSCAR
	@GetMapping(value = "/api/buscar_usuario")
	public Optional<Usuario> buscar_usuario() {
		Optional<Usuario> usuario = usuarioRepository.findById((long) 1);
		return usuario;

	}

//SECTOR
//CREAR SECTOR

	@PostMapping(path = "/api/crear_sector")
	public Sector crear_sector(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("id_usuario") Long id_usuario) {
		System.out.println("ENTRE A CREAR SECTOR");

		Optional<Usuario> usuarioBusqueda = usuarioRepository.findById(id_usuario);
		Usuario usuario = usuarioBusqueda.get();
		System.out.println("SE CREO EL SECTOR " + nombre + " CON LA DESCRIPCION DE " + descripcion
				+ "PERTENECIENTE AL USUARIO " + usuario.getNombre());

		Sector sector = new Sector();
		sector.setUsuario(usuario);
		sector.setNombre(nombre);
		sector.setDescripcion(descripcion);

		return sectorRepository.save(sector);

	}

//TARJETA
//CREAR TARJETA
	@PostMapping(path = "/api/crear_tarjeta")
	public Tarjeta crear_tarjeta(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("id_sector") Long id_sector) {
		System.out.println("ENTRE A CREAR TARJETA");

		Optional<Sector> sectorBusqueda = sectorRepository.findById(id_sector);
		Sector sector = sectorBusqueda.get();
		System.out.println("SE CREO TARJETA " + nombre + " CON LA DESCRIPCION DE " + descripcion
				+ "PERTENECIENTE AL SECTOR DE " + sector.getNombre());

		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setNombre(nombre);
		tarjeta.setDescripcion(descripcion);
		tarjeta.setId(id_sector);
		return tarjetaRepository.save(tarjeta);

	}

//SENSORES
	@PostMapping(path = "/api/crear_sensor_logico")
	public Sensor_Logico crear_sensor_logico(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("id_tarjeta") Long id_tarjeta) {
		System.out.println("ENTRE A CREAR SENSOR LOGICO");

		Optional<Tarjeta> tarjetaBusqueda = tarjetaRepository.findById(id_tarjeta);
		Tarjeta tarjeta = tarjetaBusqueda.get();
		System.out.println("SE CREO EL SENSOR LOGICO " + nombre + " CON LA DESCRIPCION DE " + descripcion
				+ "PERTENECIENTE A LA TARJETA " + tarjeta.getNombre());

		Sensor_Logico sensor_logico = new Sensor_Logico();
		sensor_logico.setNombre(nombre);
		sensor_logico.setDescripcion(descripcion);
		sensor_logico.setTarjeta(tarjeta);
		return sensor_logicoRepository.save(sensor_logico);

	}

	@PostMapping(path = "/api/crear_sensor_analogico")
	public Sensor_Analogico crear_sensor_analogico(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("id_tarjeta") Long id_tarjeta) {
		System.out.println("ENTRE A CREAR ANALOGICO");

		Optional<Tarjeta> tarjetaBusqueda = tarjetaRepository.findById(id_tarjeta);
		Tarjeta tarjeta = tarjetaBusqueda.get();
		System.out.println("SE CREO EL SENSOR ANALOGICO " + nombre + " CON LA DESCRIPCION DE " + descripcion
				+ "PERTENECIENTE A LA TARJETA " + tarjeta.getNombre());

		Sensor_Analogico sensor_analogico = new Sensor_Analogico();
		sensor_analogico.setNombre(nombre);
		sensor_analogico.setDescripcion(descripcion);
		sensor_analogico.setTarjeta(tarjeta);
		return sensor_analogicoRepository.save(sensor_analogico);

	}
	
	//ACTUADOR

	@PostMapping(path = "/api/crear_actuador")
	public Actuador crear_actuador(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("id_tarjeta") Long id_tarjeta) {
		System.out.println("ENTRE A CREAR ACTUADOR");

		Optional<Tarjeta> tarjetaBusqueda = tarjetaRepository.findById(id_tarjeta);
		Tarjeta tarjeta = tarjetaBusqueda.get();

		System.out.println("SE CREO EL ACTUADOR" + nombre + " CON LA DESCRIPCION DE " + descripcion
				+ "PERTENECIENTE A LA TARJETA " + tarjeta.getNombre());

		Actuador actuador = new Actuador();
		actuador.setNombre(nombre);
		actuador.setDescripcion(descripcion);
		actuador.setTarjeta(tarjeta);
		return actuadorRepository.save(actuador);
	}
	
	
	
	
	
	
	//LECTURAS
	
	@PostMapping("/api/crear_lectura_logica")
	public Lectura_Logica crear_lectura_logica(@RequestParam("valor") int valor, @RequestParam("id_sensor_logico") long id_sensor_logico){
		System.out.println("ENTRE A CREAR LECTURA LOGICA");
		
	Optional<Sensor_Logico> sensor_logicoBusqueda = sensor_logicoRepository.findById(id_sensor_logico);
	Sensor_Logico sensor_logico = sensor_logicoBusqueda.get();
	
	System.out.println("SE CREO LECTURA ANALOGICA, ASIGNADA AL SENSOR LOGICO " + sensor_logico.getNombre());
	
	Lectura_Logica lectura_logica = new Lectura_Logica();
	lectura_logica.setEstado(valor);
	lectura_logica.setSensor_logico(sensor_logico);
	return lectura_logicaRepository.save(lectura_logica);
		
	} 
	
	@PostMapping("/api/crear_lectura_analogica")
	public Lectura_Analogica crear_lectura_analogica(@RequestParam("valor") int valor, @RequestParam("id_sensor_analogico") long id_sensor_analogico){
		System.out.println("ENTRE A CREAR LECTURA LOGICA");
		
	Optional<Sensor_Analogico> sensor_analogicoBusqueda = sensor_analogicoRepository.findById(id_sensor_analogico);
	Sensor_Analogico sensor_analogico = sensor_analogicoBusqueda.get();
	
	System.out.println("SE CREO LECTURA ANALOGICA, ASIGNADA AL SENSOR LOGICO " + sensor_analogico.getNombre());
	
	Lectura_Analogica lectura_analogica = new Lectura_Analogica();
	lectura_analogica.setEstado(valor);
	lectura_analogica.setSensor_analogico(sensor_analogico);
	return lectura_analogicaRepository.save(lectura_analogica);
		
	} 
	
	
	
	
	@PostMapping("/api/crear_estado")
	public Estado crear_estado(@RequestParam("valor") int valor, @RequestParam("id_estado") long id_actuador){
		System.out.println("ENTRE A CREAR ESTADO");
		
	Optional<Actuador> actuadorBusqueda = actuadorRepository.findById(id_actuador);
	Actuador actuador = actuadorBusqueda.get();
	
	System.out.println("SE CREO ESTADO, ASIGNADA AL ACTUADOR" + actuador.getNombre());
	
	Estado estado = new Estado ();
	estado.setEstado(valor);
	estado.setActuador(actuador);
	return estadoRepository.save(estado);
		
	} 
	
    @GetMapping("/saludos")
    public String saludar(Model modelo) {
        modelo.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "hello";
    }
	
	
	

}

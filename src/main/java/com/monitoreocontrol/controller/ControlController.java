package com.monitoreocontrol.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monitoreocontrol.models.Sector;
import com.monitoreocontrol.models.Usuario;
import com.monitoreocontrol.repositories.ActuadorRepository;
import com.monitoreocontrol.repositories.EstadoRepository;
import com.monitoreocontrol.repositories.Lectura_AnalogicaRepository;
import com.monitoreocontrol.repositories.Lectura_LogicaRepository;
import com.monitoreocontrol.repositories.SectorRepository;
import com.monitoreocontrol.repositories.Sensor_AnalogicoRepository;
import com.monitoreocontrol.repositories.Sensor_LogicoRepository;
import com.monitoreocontrol.repositories.TarjetaRepository;
import com.monitoreocontrol.repositories.UsuarioRepository;

@Controller
public class ControlController {

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

	public ControlController() {
	}

	@GetMapping("/login")
	public String ingresar() {

		return "uno";
	}

	@PostMapping("/login")
	public String login_usuario(@RequestParam(name = "username") String nombre, Model model) {
		Optional<Usuario> usuarioBusqueda = usuarioRepository.findByNombre(nombre);
		Usuario usuario = usuarioBusqueda.get();

		model.addAttribute("usuario", usuario);

		System.out.println(usuario.getNombre());

		System.out.println(usuario.getEmail());
//		System.out.println(usuario.getId());
		return "dos";
	}

	@PostMapping("/sector")
	public String crear_sector( @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "descripcion") String descripcion, @RequestParam(name="id_usuario") Long id_usuario) {
Optional<Usuario>	usuario_de_busqueda = usuarioRepository.findById(id_usuario)	;
		Usuario usuario = usuario_de_busqueda.get();
		Sector sector = new Sector();
		
		
		sector.setUsuario(usuario);
		sector.setNombre(nombre);
		sector.setDescripcion(descripcion);
		
		sectorRepository.save(sector);
		
	System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(id_usuario);


	//	System.out.println(usuario.getNombre());
		//zzSystem.out.println(usuario.getEmail());

		return "tres";
	}

	
	
	
	
	
	
	
	
	
	
}

package com.example.persona.presentation.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.persona.model.model.Persona;
import com.example.persona.negocio.service.PersonaService;

/**
 * Esta clase es la encargada de representar el Web Service del Producto
 * Aqui se alojaran los metodos que seran llamados desde el cliente
 * @author Bayron Andres Perez  Muñoz
 */
@RestController		//Indica que esta clase es un controlador del  Web-Service del usuario
@RequestMapping("/apiPersonas") 	//Nombre por el cual se accedera a ete Web-Service
public class PersonaController {

	//---------------------------------------------------------------------------------
	//Atributos
	//---------------------------------------------------------------------------------

	/**
	 * Inyeccion de dependencias para instanciar a la clase ProductoService
	 */
	@Autowired
	private PersonaService personaService;


	//---------------------------------------------------------------------------------
	//Metodos
	//---------------------------------------------------------------------------------

	/**
	 * Metodo del Web Service encargado de listar todos las Personas de base de datos
	 * @param: Personas: el objeto de producto que llega como request
	 * @ResponseEntity: Para que las respuestas http code, puedan ser  modificadas
	 * @throws Exception 
	 */
	@GetMapping(value = "/todosLosPersonas" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> obtenerProductos()
	{
		List<Persona> personas = new ArrayList<>();
		personas = personaService.obtenerTodosPersonas();

		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo del Web Service encargado de guardar una Persona a la base de datos
	 * @param: Persona: el objeto de producto que llega como request
	 * @ResponseEntity: Para que las respuestas http code, puedan ser  modificadas
	 * @throws Exception 
	 */
	@PostMapping(value = "/registrarPersona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) throws Exception{

		Persona perso = new Persona();
		perso = personaService.guardarPersona(persona);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perso.getId()).toUri();
		return ResponseEntity.created(location).build(); //Estas dos renglones sirven para devolver la URL de el producto q se creo
	}


	/**
	 * Metodo del Web Service encargado de actualizar una persona a la base de datos
	 * @param: Producto: el objeto de la persona que llega como request
	 * @ResponseEntity: Para que las respuestas http code, puedan ser  modificadas
	 * @throws Exception 
	 */
	@PutMapping(value = "/actualizarPersona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) 
	{
		personaService.actualizarPersona(persona);
		return new ResponseEntity<Persona>(HttpStatus.OK);
	}
	
	
	/**
	 * Metodo del web service encargado de obtener un producto por el ID
	 * @param: codigo: el codigo o referencia del producto
	 * @return: el producto o registro de la base de datos
	 * @throws Exception 
	 */
	@GetMapping(value = "/obtenerPersonaById/{id}")
	public ResponseEntity<Persona> obtenerPersonaById(@PathVariable int id) throws Exception
	{
		
		Persona persona = personaService.obtenerPersonaById(id);

		if (persona == null) {
			throw new Exception("ID: " + persona);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK); //EL OK es el sisgnificadode 200
	}
	
	/**
	 * Metodo encargado de borrar un registro de la persona selecionada
	 * @param id: id de la persona
	 * @throws Exception
	 */
	@DeleteMapping(value = "/borrarPersonaById/{id}")
	public void borrarPersonaById(@PathVariable int id) throws Exception
	{
		Persona perso = personaService.obtenerPersonaById(id);
		personaService.borrarPersona(perso.getId());
		
		
	}

}

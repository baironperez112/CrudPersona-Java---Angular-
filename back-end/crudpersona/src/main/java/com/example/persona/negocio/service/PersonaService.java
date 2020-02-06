package com.example.persona.negocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.persona.model.DAO.PersonaDAO;
import com.example.persona.model.model.Persona;

/**
 * En esta Clase se implementan los metodos de negocio que realizaran la logica 
 * y la debida gestion con las operaciones a la base de datos y poder llevar 
 * dicha informacion a la capa de presentacion donde se exxponen los servicos
 * @author Bayron Andres Pelez Muñoz
 */
@Service
public class PersonaService {

	//-------------------------------------------------------------------------------
	//Atributos
	//-------------------------------------------------------------------------------

	/**
	 * inyeccion de dependencia para instanciar la clase DAO
	 */
	@Autowired
	private PersonaDAO personadao;


	//-------------------------------------------------------------------------------
	//Metodos
	//-------------------------------------------------------------------------------

	/**
	 * Metodo encargado de obtener la lista de todos las personas que
	 * de encuentran en la base de datos
	 * @return: Lista de tipo Usuario
	 */
	public List<Persona> obtenerTodosPersonas() 
	{
		return (List<Persona>) personadao.findAll();
	}
	
	
	/**
	 * Metodo encargado de guardar uns persona en la base de datos
	 * @param: persona: Objeto de la persona
	 * @return: La persona que fue insertado
	 */
	public Persona guardarPersona(Persona persona) throws Exception {
		// VALIDACION USUARIO NULO
		if(persona==null) 
		{
			throw new Exception("La persona no puede estar vacia");
		}
		else {
			return personadao.save(persona);
		}	
	}


	/**
	 * Metodo encargado de vender una persona de la base de datos
	 * @param: idPersona: el identificador de la persona
	 */
	public void borrarPersona(int idPersona) {

		personadao.deleteById(idPersona);
	}


	/**
	 * Metodo encargado de actualizar un producto de la base de datos
	 * @param: idPersona: el identificador de la persona
	 * @return: La persona actualizada
	 */
	public Persona actualizarPersona(Persona persona) {

		return personadao.save(persona);
	}

	
	/**
	 * Metodo encargado de buscar una persona de la base de datos por su ID
	 * @param: ID por el que se quiere buscar
	 * @return: La persona buscada
	 */
	public Persona obtenerPersonaById(int idPersona) {
		return  personadao.obtenerPersonaById(idPersona);
	}

}


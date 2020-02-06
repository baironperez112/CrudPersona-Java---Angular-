package com.example.persona.model.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.persona.model.model.Persona;

/**
 * Interfaz que hereda todos los metodos de la clase CrudRepository donde estaran
 * todos los metodos construidos y que tienen una estructura generica para recibir 
 * cualquier tipo de Objeto y realizar las operaciones DML y DLL
 * @author Bayron Andres Perez Muñoz
 */
public interface PersonaDAO extends CrudRepository<Persona, Integer>
{
	
	/**
	 * Metodo que se encarga de buscar un persona segun el ID seleccionado
	 * @author Bayron Andres Perez Muñoz
	 */
	@Query("from Persona p where p.id =:idPersona")
	Persona obtenerPersonaById(@Param("idPersona")Integer idPersona);
}

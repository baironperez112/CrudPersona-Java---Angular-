package com.example.persona.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase con el proposito de traer la tabla persona de la base de datos
 * y trabajar con ella como una clase Objeto.
 * Esta clase contara con la tecnologia de JPA para la persistencia e Hibernate 
 * @author Bayron Andres Perez Muñoz
 */
@Entity
@Table(name = "persona")
public class Persona {
	//-----------------------------------------------------------------------------
	//Atributos
	//-----------------------------------------------------------------------------
	/**
	 * Atrivuto que representa el id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/**
	 * Atrivuto que representa el nombre
	 */
	@Column
	private String nombres;

	/**
	 * Atrivuto que representa el apellido
	 */
	@Column
	private String apellidos;

	/**
	 * Atrivuto que representa la cedula
	 */
	@Column
	private int cedula;

	/**
	 * Atrivuto que representa el precio
	 */
	@Column
	private String genero;
	
	/**
	 * Atrivuto que representa la cantidad
	 */
	@Column
	private int edad;


	//-----------------------------------------------------------------------------
	//Metodos
	//-----------------------------------------------------------------------------

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Metodos Getter and Setter de la clase persona
	 * @return
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}

package com.example.hulkstore.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase con el proposito de traer la tabla producto de la base de datos
 * y trabajar con ella como una clase Objeto.
 * Esta clase contara con la tecnologia de JPA para la persistencia e Hibernate 
 * @author Bayron Andres Perez Muñoz
 */
@Entity
@Table(name = "producto")
public class Producto {
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
	 * Atrivuto que representa el codigo
	 */
	@Column
	private int codigo;

	/**
	 * Atrivuto que representa el nombre
	 */
	@Column
	private String nombre;

	/**
	 * Atrivuto que representa la descripcion
	 */
	@Column
	private String descripcion;

	/**
	 * Atrivuto que representa el precio
	 */
	@Column
	private int precio;
	
	/**
	 * Atrivuto que representa la cantidad
	 */
	@Column
	private int cantidad;

	//-----------------------------------------------------------------------------
	//Metodos
	//-----------------------------------------------------------------------------

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Metodos Getter and Setter de la clase producto
	 * @return
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

}

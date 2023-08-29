package org.generation.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO - Plain Old Java Object
@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	private	String descripcion;
	@Column(nullable=false)
	private	String imagen;
	private	Double precio;
//	private static long total=0;
	public Producto(String nombre, String descripcion, String imagen, 
														Double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
//		Producto.total++;
//		this.id=Producto.total;
	}//constructor
	public Producto() {
//		Producto.total++;
//		this.id=Producto.total;
	}//constructor
	public String getNombre() {
		return nombre;
	}//getNombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre
	public String getDescripcion() {
		return descripcion;
	}//getDescripcion
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//getDescripcion
	public String getImagen() {
		return imagen;
	}//getImagen
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen
	public Double getPrecio() {
		return precio;
	}//getPrecio
	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio
	
	public Long getId() {
		return id;
	}//getId
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + "]";
	}//toString

}//class Producto

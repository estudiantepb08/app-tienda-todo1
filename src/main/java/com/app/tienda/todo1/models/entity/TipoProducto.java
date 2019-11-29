package com.app.tienda.todo1.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_PRODUCTO")
public class TipoProducto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIPO_PRODUCTO_ID")
	private Long id;
	
	@Column(name="NOMBRE_PRODUCTO")
	private String nombreProducto;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public TipoProducto() {
		
	}
	
	public TipoProducto(Long id) {
		this.id = id;
	}	

	public TipoProducto(Long id, String nombreProducto, String descripcion) {		
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}

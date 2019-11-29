package com.app.tienda.todo1.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCTO_ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name="TIPO_PRODUCTO_ID")
	private TipoProducto tipoProductoId;
	
	@Column(name="CANTIDAD", nullable = false)
	private int cantidad;
	
	@Column(name="COLOR", nullable = false)
	private String color;
	
	@Column(name="TALLA", nullable = false)
	private String talla;
	
	@Column(name="ESTADO")
	private String estado;
	
	
	public Producto() {
		
	}

	public Producto(Long id, TipoProducto tipoProductoId, int cantidad, String color, String talla) {		
		this.id = id;
		this.tipoProductoId = tipoProductoId;
		this.cantidad = cantidad;
		this.color = color;
		this.talla = talla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoProducto getTipoProductoId() {
		return tipoProductoId;
	}

	public void setTipoProductoId(TipoProducto tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}

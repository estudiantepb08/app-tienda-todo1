package com.app.tienda.todo1.models.dto;

public class ProductoDto {
	
	private Long id;
	private String producto;
	private String descripcion;
	private Integer cantidad;
	private String color;
	private String talla;
	
	public ProductoDto() {
		
	}	

	public ProductoDto(Long id, String producto, String descripcion, Integer cantidad, String color, String talla) {		
		this.id = id;
		this.producto = producto;
		this.descripcion = descripcion;
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

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
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
	
	
	

}

package com.app.tienda.todo1.models.services;

import java.util.List;

import com.app.tienda.todo1.models.entity.TipoProducto;

public interface ITipoProductoService {
	
	public List<TipoProducto> findAll();
	
	public TipoProducto save(TipoProducto tipoProducto);
	
	public TipoProducto findById(Long id); 

}

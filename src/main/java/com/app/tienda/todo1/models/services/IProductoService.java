package com.app.tienda.todo1.models.services;

import java.util.List;

import com.app.tienda.todo1.models.dto.ProductoDto;
import com.app.tienda.todo1.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public List<ProductoDto> listProductoDto();

}

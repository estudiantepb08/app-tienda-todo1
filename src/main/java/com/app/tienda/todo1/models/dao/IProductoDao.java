package com.app.tienda.todo1.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.tienda.todo1.models.dto.ProductoDto;
import com.app.tienda.todo1.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {
	
	@Query("SELECT new com.app.tienda.todo1.models.dto.ProductoDto(p.id,tp.nombreProducto, tp.descripcion, p.cantidad, p.color, p.talla) "
			+ "from Producto p INNER JOIN p.tipoProductoId tp")
	List<ProductoDto> getListProducto();
}

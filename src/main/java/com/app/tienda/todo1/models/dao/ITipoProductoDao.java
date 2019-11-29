package com.app.tienda.todo1.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.tienda.todo1.models.entity.TipoProducto;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long>{

}

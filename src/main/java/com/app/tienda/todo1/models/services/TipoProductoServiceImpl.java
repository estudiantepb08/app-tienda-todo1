package com.app.tienda.todo1.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tienda.todo1.models.dao.ITipoProductoDao;
import com.app.tienda.todo1.models.entity.TipoProducto;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService{
	
	@Autowired
	private ITipoProductoDao iTiproductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoProducto> findAll() {
		
		return (List<TipoProducto>) iTiproductoDao.findAll() ;
	}

	@Override
	@Transactional
	public TipoProducto save(TipoProducto tipoProducto) {
		
		return iTiproductoDao.save(tipoProducto);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoProducto findById(Long id) {
		
		return iTiproductoDao.findById(id).orElse(null);
	}

}

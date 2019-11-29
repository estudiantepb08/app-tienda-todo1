package com.app.tienda.todo1.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tienda.todo1.models.dao.IProductoDao;
import com.app.tienda.todo1.models.dto.ProductoDto;
import com.app.tienda.todo1.models.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao iProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		
		return (List<Producto>) iProductoDao.findAll();
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return iProductoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		
		return iProductoDao.findById(id).orElse(null);
	}

	@Override
	public List<ProductoDto> listProductoDto() {
		
		return iProductoDao.getListProducto();
	}
	
	

}

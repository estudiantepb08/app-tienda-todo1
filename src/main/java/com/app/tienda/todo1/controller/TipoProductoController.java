package com.app.tienda.todo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tienda.todo1.models.entity.TipoProducto;
import com.app.tienda.todo1.models.services.ITipoProductoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api")
public class TipoProductoController {
	
	@Autowired
	private ITipoProductoService service;
	
	@GetMapping("/tipoProducto")
	public List<TipoProducto>getListTipoProducto(){
		return (List<TipoProducto>) this.service.findAll();
	}

}

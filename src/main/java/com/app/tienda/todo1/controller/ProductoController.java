package com.app.tienda.todo1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tienda.todo1.models.dto.ProductoDto;
import com.app.tienda.todo1.models.entity.Producto;
import com.app.tienda.todo1.models.entity.TipoProducto;
import com.app.tienda.todo1.models.services.IProductoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	final Map<String,Object> RESPONSE = new HashMap<>();
	
	@GetMapping("/producto")
	public List<ProductoDto> getProducto(){
		return service.listProductoDto();
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> getProductoId(@PathVariable Long id){
		
		Producto producto = null;
		
		try {
			producto = service.findById(id);
		}
		catch(DataAccessException ex) {
			RESPONSE.put("mensaje", "Error al realizar la consulta en la base de datos");
			RESPONSE.put("error", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(producto == null) {
			RESPONSE.put("mensaje", "El Producto ID:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String,Object>>(RESPONSE, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping("/producto")
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
		
		Producto productoNew = null;
		try {			
								
			productoNew = this.service.save(producto);
			this.service.findAll();
		}
		catch(DataAccessException ex) {
			RESPONSE.put("mensaje", "Error al realizar el insert en la base de datos");
			RESPONSE.put("error", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
		}
		
		RESPONSE.put("mensaje", "El producto se ha creado con exito");
		RESPONSE.put("producto", productoNew);
		
		return new ResponseEntity<Map<String,Object>>(RESPONSE, HttpStatus.CREATED);
	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> modificarProducto(@RequestBody Producto producto, @PathVariable Long id){
		
		Producto productoActual = this.service.findById(id), 
		productoUpdate = null; 				
		
		if(productoActual == null) {
			RESPONSE.put("mensaje", "Error: no se puede editar el producto ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(RESPONSE,HttpStatus.NOT_FOUND);
		}
		
		try {
		productoActual.setTipoProductoId(new TipoProducto(producto.getTipoProductoId().getId()));
		productoActual.setCantidad(producto.getCantidad());
		productoActual.setColor(producto.getColor());
		productoActual.setTalla(producto.getTalla());
		productoActual.setEstado(producto.getEstado());
		
		productoUpdate = this.service.save(productoActual);
		}
		catch(DataAccessException ex) {
			RESPONSE.put("mensaje", "Error al actualizar el producto en la base de datos");
			RESPONSE.put("error", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(RESPONSE,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		RESPONSE.put("mensaje", "El producto ha sido modificado con exito");
		RESPONSE.put("producto", productoUpdate);
		
		return new ResponseEntity<Map<String,Object>>(RESPONSE, HttpStatus.OK);
	}

}

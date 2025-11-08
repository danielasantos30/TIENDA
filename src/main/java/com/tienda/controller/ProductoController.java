package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DTO.ProductoDTO;
import com.tienda.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerProductoPorId(@PathVariable int id){
		ProductoDTO producto =productoService.obtenerProductoPorId(id);
	if (producto !=null) {
		return ResponseEntity.ok(producto);
	}else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No se encontró el producto con ID" + id);
	}
	
	
	}
	
	
	

}

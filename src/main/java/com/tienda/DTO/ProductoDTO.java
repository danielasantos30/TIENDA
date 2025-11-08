package com.tienda.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class ProductoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1042894595476421498L;

	private int idproducto;
	private CategoriaDTO idcategoria;
	private String nombre;
	private Double precio;
	private String marca;
	private String descripcion;
	private String imagenUrl;
	
	//constructor vacio
	
	public ProductoDTO() {
		super();
	}

	public ProductoDTO(int idproducto, CategoriaDTO idcategoria, String nombre, Double precio, String marca, String descripcion,
			String imagenUrl) {
		super();
		this.idproducto = idproducto;
		this.idcategoria = idcategoria;
		this.nombre = nombre;
		this.precio= precio;
		this.marca = marca;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
	}
	
	//constructor
	
	
	
}

package com.tienda.service;

import java.util.List;

import com.tienda.DTO.CategoriaDTO;

public interface ICategoriaService {

	
	CategoriaDTO obtenerCategoriaPorId(int id);
	
	List<CategoriaDTO> obtenerTodasLasCategorias();
	
    void eliminarCategoriaSiExiste(int idcategoria);      // Reemplaza eliminarAlumnoPorId
    
    CategoriaDTO actualizarCategoria(int id, CategoriaDTO categoriaDTO); // Reemplaza updateAlumno

	CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);

	
}

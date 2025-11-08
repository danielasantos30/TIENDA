package com.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.DTO.CategoriaDTO;
import com.tienda.DTO.ProductoDTO;
import com.tienda.entity.CategoriaEntity;
import com.tienda.entity.ProductoEntity;
import com.tienda.repository.ICategoriaRepository;
import com.tienda.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

    private final ICategoriaRepository ICategoriaRepository;
    
    @Autowired
    private CategoriaService categoriaService; // ← Inyectar el servicio para convertirCategoriaaDTO
    
	@Autowired
	//vamos a inyectar un objeto de tipo IproductoRepository
	private IProductoRepository productoRepository;

    ProductoService(ICategoriaRepository ICategoriaRepository) {
        this.ICategoriaRepository = ICategoriaRepository;
    }


 
    	@Override
	public ProductoDTO obtenerProductoPorId(int id) {
		
		return productoRepository.findById(id) //me va a regresar un Opctional<Entity> de la BD, puede ser null o Entity
				.map(entity -> new ProductoDTO( //el .map sirve para "Si hay un valor dentro del Optional, transfórmalo. Si no hay nada, no hagas nada"
						entity.getIdpproducto(), //me regresa un int
						categoriaService.convertirCategoriaADTO(entity.getIdcategoria()), //me regresa un DTO (CategoriaDTO)
						entity.getNombre(),
						entity.getPrecio(),
						entity.getMarca(),
						entity.getDescripcion(),
						entity.getImagenUrl()
							
											)).orElse(null);
				
	}

}

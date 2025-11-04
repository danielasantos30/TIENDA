package com.tienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.DTO.CategoriaDTO;
import com.tienda.DTO.UsuarioDTO;
import com.tienda.entity.CategoriaEntity;
import com.tienda.entity.UsuarioEntity;
import com.tienda.repository.ICategoriaRepository;
import com.tienda.repository.IUsuarioRepository; // ✅ NUEVO

@Service
public class CategoriaService implements ICategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepository;
    
    @Autowired
    private IUsuarioRepository usuarioRepository; //  Para buscar usuarios

    @Override
    public List<CategoriaDTO> obtenerTodasLasCategorias() {
        List<CategoriaEntity> listaCategoria = (List<CategoriaEntity>) categoriaRepository.findAll();
        List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
        
        for (CategoriaEntity entity : listaCategoria) {
            // Convertir usuarioCreacion Entity → DTO
            UsuarioDTO usuarioCreacionDTO = null;
            if (entity.getUsuarioCreacion() != null) {
                usuarioCreacionDTO = convertirUsuarioADTO(entity.getUsuarioCreacion());
            }
            
            // Convertir usuarioEliminacion Entity → DTO  
            UsuarioDTO usuarioEliminacionDTO = null;
            if (entity.getUsuarioEliminacion() != null) {
                usuarioEliminacionDTO = convertirUsuarioADTO(entity.getUsuarioEliminacion());
            }
            
            // Crear CategoriaDTO con los DTOs convertidos
            CategoriaDTO dto = new CategoriaDTO(
                entity.getIdcategoria(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getFechaCreacion(),
                entity.getFechaEliminacion(),
                usuarioCreacionDTO,        // ← UsuarioDTO, no UsuarioEntity
                usuarioEliminacionDTO      // ← UsuarioDTO, no UsuarioEntity
            );
            
            listaCategoriaDTO.add(dto);
        }
        return listaCategoriaDTO;
    }

    private UsuarioDTO convertirUsuarioADTO(UsuarioEntity usuarioEntity) {
    	if (usuarioEntity == null)
    		return null;
        return new UsuarioDTO(
            usuarioEntity.getIdUsuario(),
            usuarioEntity.getIdRol(),
            usuarioEntity.getNombre(),
            usuarioEntity.getApellido(),
            usuarioEntity.getEmail()
        );
    }

    @Override
    public void eliminarCategoriaSiExiste(int idcategoria) {
        if (!categoriaRepository.existsById(idcategoria)) {
            throw new RuntimeException("Categoria no encontrado con ID: " + idcategoria);
        }
        categoriaRepository.deleteById(idcategoria);
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(int id) {
        return categoriaRepository.findById(id)
            // Si encuentra la entidad, la convierte a DTO    
            .map(entity -> new CategoriaDTO(
                    entity.getIdcategoria(),
                    entity.getNombre(),
                    entity.getDescripcion(),
                    entity.getFechaCreacion(),
                    entity.getFechaEliminacion(),
                    convertirUsuarioADTO (entity.getUsuarioCreacion()),
                    convertirUsuarioADTO( entity.getUsuarioEliminacion())                    
                ))
                .orElse(null);
        }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) throws ServiceException {
        // Validaciones
        if(categoriaDTO.getNombre() == null || categoriaDTO.getNombre().trim().isEmpty()) {
            throw new ServiceException("El nombre es obligatorio");
        }
        
     // Crear Entity
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNombre(categoriaDTO.getNombre().trim());
        categoria.setDescripcion(categoriaDTO.getDescripcion() != null ? categoriaDTO.getDescripcion().trim() : null);
        categoria.setFechaCreacion(categoriaDTO.getFechaCreacion());
        categoria.setFechaEliminacion(categoriaDTO.getFechaEliminacion());
        
        // ASIGNAR OBJETOS UsuarioEntity (no IDs)

       Optional<UsuarioEntity> usuarioCreador= this.usuarioRepository.findById(categoriaDTO.getUsuarioCreacion().getIdUsuario());
        
		categoria.setUsuarioCreacion(usuarioCreador.get());
        categoria.setUsuarioEliminacion(null);
        
        // Guardar y obtener el entity con ID asignado
        CategoriaEntity categoriaGuardada = this.categoriaRepository.save(categoria);
        
        // Retornar DTO con ID generado
        return new CategoriaDTO(
                categoriaGuardada.getIdcategoria(),
                categoriaGuardada.getNombre(),
                categoriaGuardada.getDescripcion(),
                categoriaGuardada.getFechaCreacion(),
                categoriaGuardada.getFechaEliminacion(),
                convertirUsuarioADTO(categoriaGuardada.getUsuarioCreacion()),
                convertirUsuarioADTO(categoriaGuardada.getUsuarioEliminacion())
            ); 
        }
    

    @Override
    public CategoriaDTO actualizarCategoria(int id, CategoriaDTO categoriaDTO) {
        try {
            CategoriaEntity categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
            
            // Actualizar campos
            if(categoriaDTO.getNombre() != null) {
                categoriaExistente.setNombre(categoriaDTO.getNombre().trim());
            }
            if(categoriaDTO.getDescripcion() != null) {
                categoriaExistente.setDescripcion(categoriaDTO.getDescripcion().trim());
            }
            
                       
            // Guardar
            CategoriaEntity categoriaActualizada = categoriaRepository.save(categoriaExistente);
            
            // Convertir a DTO
            return new CategoriaDTO(
                    categoriaActualizada.getIdcategoria(),
                    categoriaActualizada.getNombre(),
                    categoriaActualizada.getDescripcion(),
                    categoriaActualizada.getFechaCreacion(),
                    categoriaActualizada.getFechaEliminacion(),
                    convertirUsuarioADTO( categoriaActualizada.getUsuarioCreacion()),
                    convertirUsuarioADTO(categoriaActualizada.getUsuarioEliminacion())
                );
                
            } catch (Exception e) {
                throw new RuntimeException("Error al actualizar la categoría: " + e.getMessage());
            }
        }
    
    
  
}
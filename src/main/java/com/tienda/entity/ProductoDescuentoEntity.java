package com.tienda.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto_descuento")
public class ProductoDescuentoEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7277212938350359268L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_descuento")
    private Long idProductoDescuento;
    
    @Column(name = "id_descuento")
    private Long idDescuento;
    
    @Column(name = "id_producto")
    private Long idProducto;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;
    
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    
    @Column(name = "usuario_eliminacion")
    private String usuarioEliminacion;

	public Long getIdProductoDescuento() {
		return idProductoDescuento;
	}

	public void setIdProductoDescuento(Long idProductoDescuento) {
		this.idProductoDescuento = idProductoDescuento;
	}

	public Long getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(Long idDescuento) {
		this.idDescuento = idDescuento;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(LocalDateTime fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}
    
    
   
    
    
}
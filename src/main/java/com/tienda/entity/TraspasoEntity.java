package com.tienda.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "traspasos")
public class TraspasoEntity implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2162015457750497941L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_traspaso")
    private Long idTraspaso;
    
    @Column(name = "id_producto")
    private Long idProducto;
    
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "sucursal_origen")
    private Long sucursalOrigen;
    
    @Column(name = "sucursal_destino")
    private Long sucursalDestino;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "fecha_traspaso")
    private LocalDateTime fechaTraspaso;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;
    
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    
    @Column(name = "usuario_eliminacion")
    private String usuarioEliminacion;
    
    @Column(name = "fecha_confirmacion")
    private LocalDateTime fechaConfirmacion;

	public Long getIdTraspaso() {
		return idTraspaso;
	}

	public void setIdTraspaso(Long idTraspaso) {
		this.idTraspaso = idTraspaso;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Long sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Long getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Long sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFechaTraspaso() {
		return fechaTraspaso;
	}

	public void setFechaTraspaso(LocalDateTime fechaTraspaso) {
		this.fechaTraspaso = fechaTraspaso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public LocalDateTime getFechaConfirmacion() {
		return fechaConfirmacion;
	}

	public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}
    
    
}
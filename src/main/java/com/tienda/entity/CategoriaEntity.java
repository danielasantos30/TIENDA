package com.tienda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="categorias") 
public class CategoriaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6702814079839071244L;
	
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	 @Column(name = "id_categoria") 
	private int idcategoria;
	
	 @Column(name = "nombre", length = 300)	
		private String nombre;
	 
	 @Column(name = "descripcion", columnDefinition = "TEXT")
	    private String descripcion;
	 
	 @CreationTimestamp
	 @Column(name = "fecha_creacion")
	    private LocalDateTime fechaCreacion;
	    
	 @Column(name = "fecha_eliminacion")
	    private LocalDateTime fechaEliminacion;
	    
	 
	 //FOREING KEYS. Relacion con UsuarioEntity
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
	    private UsuarioEntity  usuarioCreacion;
	   
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name = "usuario_eliminacion", referencedColumnName = "id_usuario")
	    private UsuarioEntity usuarioEliminacion;

	 public int getIdcategoria() {
		 return idcategoria;
	 }

	 public void setIdcategoria(int idcategoria) {
		 this.idcategoria = idcategoria;
	 }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public String getDescripcion() {
		 return descripcion;
	 }

	 public void setDescripcion(String descripcion) {
		 this.descripcion = descripcion;
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

	 public UsuarioEntity getUsuarioCreacion() {
		 return usuarioCreacion;
	 }

	 public void setUsuarioCreacion(UsuarioEntity usuarioCreacion) {
		 this.usuarioCreacion = usuarioCreacion;
	 }

	 public UsuarioEntity getUsuarioEliminacion() {
		 return usuarioEliminacion;
	 }

	 public void setUsuarioEliminacion(UsuarioEntity usuarioEliminacion) {
		 this.usuarioEliminacion = usuarioEliminacion;
	 }

	
	 
}

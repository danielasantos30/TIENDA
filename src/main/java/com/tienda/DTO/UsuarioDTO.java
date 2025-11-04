package com.tienda.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UsuarioDTO implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 5230553242264516277L;
		private Integer idUsuario;
	    private Integer idRol;
	    private String nombre;
	    private String apellido;
	    private String email;
	    private String telefono;
	    private String direccion;
	    private LocalDateTime fechaCreacion;
	    private LocalDateTime fechaEliminacion;
	   private String estatus;
	    private String curp;
	    private String tipoSangre;
	    private String imagenUrl;
		
	    //constructor vacío
	    public UsuarioDTO() {
			super();
		}

		public UsuarioDTO(Integer idUsuario, Integer idRol, String nombre, String apellido, String email
//				String telefono, String direccion, LocalDateTime fechaCreacion, LocalDateTime fechaEliminacion,
//				UsuarioDTO usuarioCreacion, UsuarioDTO usuarioEliminacion, String estatus, String curp,
//				String tipoSangre, String imagenUrl
				) {
			super();
			this.idUsuario = idUsuario;
			this.idRol = idRol;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
//			this.telefono = telefono;
//			this.direccion = direccion;
//			this.fechaCreacion = fechaCreacion;
//			this.fechaEliminacion = fechaEliminacion;
//			this.usuarioCreacion = usuarioCreacion;
//			this.usuarioEliminacion = usuarioEliminacion;
//			this.estatus = estatus;
//			this.curp = curp;
//			this.tipoSangre = tipoSangre;
//			this.imagenUrl = imagenUrl;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getCurp() {
			return curp;
		}

		public void setCurp(String curp) {
			this.curp = curp;
		}

		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}

		public Integer getIdRol() {
			return idRol;
		}

		public void setIdRol(Integer idRol) {
			this.idRol = idRol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
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

		

		public String getEstatus() {
			return estatus;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}

		public String getTipoSangre() {
			return tipoSangre;
		}

		public void setTipoSangre(String tipoSangre) {
			this.tipoSangre = tipoSangre;
		}

		public String getImagenUrl() {
			return imagenUrl;
		}

		public void setImagenUrl(String imagenUrl) {
			this.imagenUrl = imagenUrl;
		}
	    
		
		
	    
	}



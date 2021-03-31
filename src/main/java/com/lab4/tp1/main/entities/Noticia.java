package com.lab4.tp1.main.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "noticias")
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	//Atributos-------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo")
	@Size(max = 128)
	@NotEmpty
	private String titulo;
	
	@Column(name = "resumen")
	@Size(max = 1024)
	private String resumen;
	
	@Column(name = "imagen")
	@Size(max = 128)
	private String imagen;
	
	@Column(name = "contenido_html")
	@Size(max = 20480)
	@NotEmpty
	private String contenidoHTML;
	
	@Column(name = "publicada")
	private boolean publicada;
	
	@Column(name = "fecha_publicacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Empresa empresa;

	
	
	//Antes de persistir ---------------------------------
	@PrePersist
	public void prePersist() {
		this.fechaPublicacion = new Date();
	}
	
	
	
	//Getters y setters ----------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getContenidoHTML() {
		return contenidoHTML;
	}

	public void setContenidoHTML(String contenidoHTML) {
		this.contenidoHTML = contenidoHTML;
	}

	public boolean isPublicada() {
		return publicada;
	}

	public void setPublicada(boolean publicada) {
		this.publicada = publicada;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}

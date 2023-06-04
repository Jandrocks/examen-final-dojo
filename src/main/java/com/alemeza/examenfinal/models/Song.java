package com.alemeza.examenfinal.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Por favor ingresa un nombre de la cancion")
	@Size(min = 3, max = 30, message = "Nombre debe contener entre 3 y 30 caracteres")
	private String titulo;

	@NotBlank(message = "Por favor ingresa un nombre de genero")
	@Size(min = 3, max = 30, message = "Nombre debe contener entre 3 y 30 caracteres")
	private String genero;

	@NotBlank(message = "Por favor ingresa una letra de cancion")
	@Size(min = 5, message = "Por favor descripcion minima de 5 caracteres")
	@Column(length = 65535, columnDefinition = "text")
	private String letracancion;

	@Min(value = 0, message = "colaboraciones")
	private int colaborador;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// relacion uno a muchos
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User relacion;

	public User getRelacion() {
		return relacion;
	}

	public void setRelacion(User relacion) {
		this.relacion = relacion;
	}

	// Constructors
	public Song() {

	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLetracancion() {
		return letracancion;
	}

	public void setLetracancion(String letracancion) {
		this.letracancion = letracancion;
	}

	public int getColaborador() {
		return colaborador;
	}

	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

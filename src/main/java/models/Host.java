package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Host {

	// Que datos tiene un mensaje
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	Long id;
	private String titulo;
	private String pais;
	private Long precio;
	private String descripcion;
	private String estado;
	private String file;
	
	// Funciones o metodos (son sinonimos)
	
	public Host(){}
	
	public Host(Long id, String titulo, String pais, Long precio, String descripcion, String estado, String file) {
		super();
		this.id = id;
		this.titulo= titulo;
		this.pais = pais;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.file = file;
	}
	
	public Host(String titulo, String pais, Long precio, String descripcion, String estado, String file) {
		super();
		this.titulo= titulo;
		this.pais = pais;
		this.precio = precio;
		this.estado = estado;
		this.descripcion = descripcion;
		this.file = file;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}


		
}

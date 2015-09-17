package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MensajeContacto {

	// Que datos tiene un mensaje
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	Long id;
	private String nombre;
	private String email;
	private String descripcion;
	
	// Funciones o metodos (son sinonimos)
	
	public MensajeContacto(){}
	
	public MensajeContacto(Long id, String nombre, String email, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.descripcion = descripcion;
	}
	
	public MensajeContacto(String nombre, String email, String descripcion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
		
	
}

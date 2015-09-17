package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MensajeExperiencia {

	// Que datos tiene un mensaje
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	Long id;
	private String nombre;
	private String experiencia;
	
	// Funciones o metodos (son sinonimos)
	
	public MensajeExperiencia(){}
	
	public MensajeExperiencia(Long id, String nombre, String experiencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.experiencia = experiencia;

	}
	
	public MensajeExperiencia(String nombre, String experiencia) {
		super();
		this.nombre = nombre;
		this.experiencia = experiencia;

	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
		
	
}

package cl.inacap.RegistroCivilModel.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Solicitud {
	private String rut;
	private String nombre;
	private String tipo;
	private AtomicInteger id = new AtomicInteger(0);
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public AtomicInteger getId() {
		return id;
	}
	public void setId(AtomicInteger id) {
		this.id = id;
	}

}

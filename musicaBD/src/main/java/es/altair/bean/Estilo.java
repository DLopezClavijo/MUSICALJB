package es.altair.bean;

public class Estilo {
	private int id; 
	private String nombre;
	public Estilo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estilo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Estilo [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}

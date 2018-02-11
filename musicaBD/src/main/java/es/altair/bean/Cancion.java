package es.altair.bean;

public class Cancion {
	
	private int id; 
	private String nombre; 
	private float duracion; 
	private int cantanteId;
	public Cancion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cancion(int id, String nombre, float duracion, int cantanteId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.cantanteId = cantanteId;
	}
	
	
	
	public Cancion(int id, String nombre, float duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
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
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public int getCantanteId() {
		return cantanteId;
	}
	public void setCantanteId(int cantanteId) {
		this.cantanteId = cantanteId;
	}
	@Override
	public String toString() {
		return "Cancion [idCancion=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", cantanteId="
				+ cantanteId + "]";
	}
	
	
}

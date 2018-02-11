package es.altair.bean;

public class Cantante {
	private int id; 
	private String nombre; 
	private String apellidos; 
	private int edad; 
	private String pais;
	private int idEstilo; 
	
	
	public Cantante() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cantante(int id, String nombre, String apellidos, int edad, String pais, int idEstilo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
		this.idEstilo = idEstilo;
	}

	

	public Cantante(int id, String nombre, String apellidos, int edad, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
	}
	
	

	public Cantante(String pais) {
		super();
		this.pais = pais;
	}

	

	public Cantante(int id) {
		super();
		this.id = id;
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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getIdEstilo() {
		return idEstilo;
	}


	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "Artista [idArtista=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idEstilo="
				+ idEstilo + ", edad=" + edad + ", pais=" + pais + "]";
	}
	
	
}

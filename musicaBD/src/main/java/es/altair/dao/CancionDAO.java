package es.altair.dao;

import java.util.List;

import es.altair.bean.Cancion;

public interface CancionDAO {
	public boolean insertar(Cancion c);
	public List<Cancion> mostrarCancionPorCantante(int idCantante);
	public Cancion coger(String Pais);
	public boolean aumentarDuracion(Cancion c);
	public boolean borrar(int id);
	public boolean actualizarDuracion(List<Integer> idCantante); 
	
}

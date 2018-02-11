package es.altair.dao;

import java.util.List;

import es.altair.bean.Cantante;;

public interface CantanteDAO {

	public List<Cantante> listarCantante();
	public boolean insertar(Cantante a);
	public List<Cantante> listarArtistaPorEstilo(int idEstilo);
	public Cantante coger(int idCantante);
	public boolean actualizarEdad(Cantante a);
	public List<Cantante> listaPaises();
	public List<Integer> obtener(String pais);
	
}

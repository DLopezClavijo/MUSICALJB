package es.altair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Cancion;

public class CancionDAOImpJDBC implements CancionDAO {

	public boolean insertar(Cancion c) {
		int numFilas = 0; 
		
		ConnectionDAO.abrirConexion();
		
		String query = "INSERT INTO CANCIONES VALUES(null,?,?,?)";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, c.getNombre());
			sentencia.setFloat(2, c.getDuracion());
			sentencia.setInt(3, c.getCantanteId());
			
			numFilas = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDAO.cerrarConexion();
		if(numFilas == 0)
			return false;
		else
			return true; 
	}

	public List<Cancion> mostrarCancionPorCantante1(int idCantante) {
		List<Cancion> cancionPorCantante = new ArrayList<Cancion>();
		
		ConnectionDAO.abrirConexion();
		
		String query = "SELECT * FROM CANCIONES WHERE idCantante = ?";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idCantante);
			ResultSet resultado = sentencia.executeQuery();
			while(resultado.next()) {
				Cancion c = new Cancion(resultado.getInt("id"),
						resultado.getString("nombre"),
						resultado.getFloat("duracion"));
				cancionPorCantante.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionDAO.cerrarConexion();
		
		return cancionPorCantante;
	}

	public Cancion coger(String Pais) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean aumentarDuracion(Cancion c) {
		int numFilas = 0; 
		ConnectionDAO.abrirConexion();
		
		
		
		ConnectionDAO.cerrarConexion();
		if(numFilas == 0)
			return false;
		else
			return true;
	}

	public boolean borrar(int id) {
		int numFilas = 0; 
		ConnectionDAO.abrirConexion();
		
		String query = "DELETE FROM CANCIONES WHERE idCantante = ?";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, id);
			numFilas = sentencia.executeUpdate();
			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDAO.cerrarConexion();
		if(numFilas == 0)
			return false;
		else
			return true;
	}

	public boolean actualizarDuracion(List<Integer> idCantante) {
		int numFilas = 0; 
		ConnectionDAO.abrirConexion();
		
		for (int i = 0; i < idCantante.size(); i++) {
			String query = "UPDATE canciones SET duracion = duracion +1 WHERE idCantante = ?";
			
			PreparedStatement sentencia;
			try {
				sentencia = ConnectionDAO.getConexion().prepareStatement(query);
				sentencia.setInt(1, idCantante.get(i));
				numFilas = sentencia.executeUpdate(); 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		ConnectionDAO.cerrarConexion();
		if(numFilas == 0)
			return false;
		else
			return true;
	}

	public List<Cancion> mostrarCancionPorCantante(int idCantante) {
		// TODO Auto-generated method stub
		return null;
	}

}

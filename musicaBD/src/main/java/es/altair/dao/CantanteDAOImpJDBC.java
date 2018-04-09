package es.altair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Cantante;


public class CantanteDAOImpJDBC implements CantanteDAO {
	
	public List<Cantante> listarCantante(){
		List<Cantante> cantante = new ArrayList<Cantante>();
		
		ConnectionDAO.abrirConexion();
		ConnectionDAO.abrirConexion();
		
		String query ="SELECT * FROM CANTANTES";
		try {
			Statement sentencia = ConnectionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Cantante a = new Cantante(
						resultado.getInt("id"),
						resultado.getString("nombre"),
						resultado.getString("apellidos"),
						resultado.getInt("edad"),
						resultado.getString("pais"),
						resultado.getInt("idEstilo")
						);
				cantante.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionDAO.cerrarConexion();
		return cantante;
	}

	public boolean insertar(Cantante a) {
		int numFilas = 0;
		
		ConnectionDAO.abrirConexion();
		
		String query ="INSERT INTO CANTANTES VALUES(null, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, a.getNombre());
			sentencia.setString(2, a.getApellidos());
			sentencia.setInt(3, a.getEdad());
			sentencia.setString(4, a.getPais());
			sentencia.setInt(5, a.getIdEstilo());
			
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
	public List<Cantante> listarCantantePorEstilo(int idEstilo) {
		List<Cantante> cantantesPorEstilo = new ArrayList<Cantante>();
		
		ConnectionDAO.abrirConexion();
		
		String query ="SELECT * FROM CANTANTES WHERE idEstilo = ?";
		 
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idEstilo);
			ResultSet resultado = sentencia.executeQuery();
			while(resultado.next()) {
				Cantante a = new Cantante(
						resultado.getInt("id"),
						resultado.getString("nombre"),
						resultado.getString("apellidos"),
						resultado.getInt("edad"),
						resultado.getString("pais")
						);
				cantantesPorEstilo.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		ConnectionDAO.cerrarConexion();
		
		
		
		return cantantesPorEstilo;
	}
	public Cantante coger(int idCantante) {
		Cantante a = null;
		
		ConnectionDAO.abrirConexion();
		
		String query ="SELECT * FROM CANTANTES WHERE idArtista = ?";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idCantante);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				a = new Cantante(
						resultado.getInt("id"),
						resultado.getString("nombre"),
						resultado.getString("apellidos"),
						resultado.getInt("edad"),
						resultado.getString("pais"),
						resultado.getInt("idEstilo")
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionDAO.cerrarConexion();
		return a;
	}
	public boolean actualizarEdad(Cantante a) {
		int num_filas = 0; 
		
		ConnectionDAO.abrirConexion();
		
		String query ="UPDATE Cantantes SET edad = ? WHERE id= ?";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, a.getEdad());
			sentencia.setInt(2, a.getId());
			
			num_filas = sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDAO.cerrarConexion();
		
		if(num_filas == 0)
			return false;
		else
			return true;
	}

	public List<Cantante> listaPaises() {
		List<Cantante> paises = new ArrayList<Cantante>();
		ConnectionDAO.abrirConexion();
		
		String query ="SELECT distinct(pais) FROM Cantantes";
		
		try {
			Statement sentencia = ConnectionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while(resultado.next()) {
				Cantante a = new Cantante (resultado.getString("pais"));
				paises.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ConnectionDAO.cerrarConexion();
		return paises;
	}

	

	public List<Integer> obtener(String pais) {
		List<Integer> idList = new ArrayList<Integer>();
		
		ConnectionDAO.abrirConexion();
		
		String query ="SELECT id FROM Cantantes where pais = ?";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, pais);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				idList.add(resultado.getInt("id"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionDAO.cerrarConexion();
		return idList;
	}

	public List<Cantante> listarArtistaPorEstilo(int idEstilo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package es.altair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Estilo;

public class EstiloDAOImpJDBC implements EstiloDAO {

	public List<Estilo> listarEstilo() {
		
		List<Estilo> estilo = new ArrayList<Estilo>();
		
		ConnectionDAO.abrirConexion();
		
		String query = "SELECT * FROM ESTILOS"; 
		
		try {
			
			Statement sentencia = ConnectionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			
			while(resultado.next()){
				Estilo e = new Estilo(resultado.getInt("id"),
						resultado.getString("nombre"));
				estilo.add(e);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectionDAO.cerrarConexion();
		return estilo;
	}

	public boolean insertar(Estilo e) {
		int numFilas = 0; 
		
		ConnectionDAO.abrirConexion();
		
		String query= "INSERT INTO ESTILOS VALUES(null,?)";
		
		try {
			PreparedStatement sentencia = ConnectionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, e.getNombre());
			
			numFilas = sentencia.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ConnectionDAO.cerrarConexion();
		if(numFilas == 0)
			return false;
		else
			return true;
	}

}

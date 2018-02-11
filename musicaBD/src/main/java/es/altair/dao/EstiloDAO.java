package es.altair.dao;

import java.util.List;

import es.altair.bean.Estilo;

public interface EstiloDAO {
	public List<Estilo> listarEstilo();
	public boolean insertar(Estilo e);
}

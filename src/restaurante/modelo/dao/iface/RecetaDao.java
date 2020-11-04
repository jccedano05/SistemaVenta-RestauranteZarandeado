package restaurante.modelo.dao.iface;

import java.util.List;

import restaurante.modelo.dto.Receta;

public interface RecetaDao {

	
	List<Receta> crear(List<Receta> receta);
	
	Receta buscarPorId(int idReceta);
	
	List<Receta> buscarTodos();
	
	boolean Actualizar (Receta receta);
	
	boolean eliminar (int idReceta);
	
}

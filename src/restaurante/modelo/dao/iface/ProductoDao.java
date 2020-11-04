package restaurante.modelo.dao.iface;

import java.util.List;

import restaurante.modelo.dto.*;

public interface ProductoDao {

	


	Producto crear(Producto producto);
	
	Producto buscarPorId (int idProducto);

	List<Producto> listarPorSeccion(String seccion);
	
	List<Producto> buscarTodos();
	
	boolean Actualizar ( Producto producto);
	
	boolean eliminar (int idProducto);
	


}

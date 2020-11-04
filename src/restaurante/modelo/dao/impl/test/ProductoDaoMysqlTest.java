package restaurante.modelo.dao.impl.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import restaurante.modelo.dao.iface.ProductoDao;
import restaurante.modelo.dao.impl.ProductoDaoMysql;
import restaurante.modelo.dto.Producto;

public class ProductoDaoMysqlTest {

	
	
	
	
	// --------- PRUEBA DE CREACION DE PRODUCTO ---------
	/*
@Test	
public void crearClienteCorrectamente() {
	
	
	//subject
	ProductoDao dao = new ProductoDaoMysql();
	
	

	//input data
	
	Producto producto = new Producto("fresa","fruta",43,0.029,0.028,"kg");
	
	
	Producto productoCreado = dao.crear(producto);


	assertNotNull(productoCreado);
	Assert.assertTrue(productoCreado.getIdProducto()>0);
	
	
} 
   //*/
	
	
	
	
	
	
	
	
	/*
	 //--------- PRUEBA DE MODIFICACION DE PRODUCTO ---------
	@Test
	public void modificarProducto() {
		
		
		ProductoDao dao = new ProductoDaoMysql();
		
		int id = 4;
		Producto producto = new Producto(id,"fresa","frutas",43,0.029,0.028,"kg");
		boolean productoActualizado = dao.Actualizar(producto);
		
		
		Assert.assertTrue(productoActualizado);
		
	}
	//*/
	
	
	
	
	
	
	
	
	/*
	
	//--------- PRUEBA DE BUSQUEDA COMPLETA DE PRODUCTO ---------
	
	@Test
	public void listarClientes() {
		
		
		//subject
		ProductoDao dao = new ProductoDaoMysql();
		
		

		//input data
		
		List<Producto> productosListados = dao.buscarTodos();
		
		
		Assert.assertNotNull(productosListados);
		Assert.assertFalse(productosListados.isEmpty());
		
		
		for (Producto producto : productosListados) {
			
			System.out.println(producto);
		}
		
		/// NO ENCUENTRA EL ID_PRODUCTO BUSCAR EN DONDE HAGO EL QUERY
		
	}
	
	
	//*/
	
	
	
	
	
	
	
	/*
	 
	 // ------------  PRUEBA DE ELIMINACION ----------------
	   
	  
	@Test
	public void eliminarCliente() {
		
		ProductoDao dao = new ProductoDaoMysql();
		
		int id = 1;
		
		boolean fueEliminado = (dao.eliminar(id));
		
		Assert.assertTrue(fueEliminado);
		
	}
	 
	 //*/

	
	
	/*
	 
	 // ------------  PRUEBA BUSCAR POR ID ----------------
	
	@Test 
	
	public void buscarClienteById() {
		
	ProductoDao dao = new ProductoDaoMysql();
	
	int id = 2;

	Producto productoEncontradoById = dao.buscarPorId(id);
	
	Assert.assertNotNull(productoEncontradoById);
	
	System.out.println(productoEncontradoById);
	}
	
	
	//*/
	
	
	
	
	
	
	
	
	/*
	 
	 // ------------  PRUEBA BUSCAR POR SECCION ----------------
	
	@Test 
	
	public void buscarProductoBySeccion() {
		
	ProductoDao dao = new ProductoDaoMysql();
	
	String seccion = "frutas";

	List<Producto> productoEncontradoBySeccion = dao.listarPorSeccion(seccion);
	
	Assert.assertNotNull(productoEncontradoBySeccion);
	Assert.assertFalse(productoEncontradoBySeccion.isEmpty());
	
	
	for (Producto producto : productoEncontradoBySeccion) {
		System.out.println(producto);
	}
	}
	
	
	//*/
	
}

















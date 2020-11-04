package restaurante.modelo.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;


import java.sql.PreparedStatement;


import restaurante.modelo.dao.iface.ProductoDao;
import restaurante.modelo.db.ConnectionFactory;
import restaurante.modelo.dto.Producto;

public class ProductoDaoMysql implements ProductoDao {

	
	
	// ------- INSERTANDO UN NUEVO PRODUCTO ----------
	
	@Override
	public Producto crear(Producto producto) {
		
		
		
		String query = "INSERT INTO producto (nombreProducto, seccion, costoUnitario, pesoBruto, pesoNeto, factorRendimiento, unidadMedida) values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int registrosAfectados;
		int claveGenerada;
		
		
		Connection connection = ConnectionFactory.getConnection();   //abrimos la conexion a la base de datos
		
		try {
			
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, producto.getNombreProducto());
			ps.setString(2, producto.getSeccion());
			ps.setDouble(3, producto.getCostoUnitario());
			ps.setDouble(4, producto.getPesoBruto());
			ps.setDouble(5, producto.getPesoNeto());
			ps.setDouble(6, producto.getFactorRendimiento());
			ps.setString(7, producto.getUnidadMedida());
			
			registrosAfectados = ps.executeUpdate();
			
			if(registrosAfectados > 0) {
				rs= ps.getGeneratedKeys();
				if(rs.next()) {
					claveGenerada = rs.getInt(1);
					producto.setIdProducto(claveGenerada);
				}
				System.out.println("Registro Exitoso!");
			}else {
				System.out.println("Fallo el registro");
			}
						
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return producto;
	}

	
	
	
	
	// -------   BUSCAR POR ID -------
	
	
	@Override
	public Producto buscarPorId(int idProducto) {

		
		Producto productoEncontrado = null;
		
		String query = "SELECT idProducto, nombreProducto, seccion, costoUnitario, "
				+ "pesoBruto, pesoNeto, factorRendimiento, "
				+ "unidadMedida from producto where idProducto = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conexion = ConnectionFactory.getConnection();
		
		try {
			
			ps = conexion.prepareStatement(query);
			ps.setInt(1,idProducto);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				productoEncontrado = new Producto(rs.getInt("idProducto"),rs.getString("nombreProducto"),rs.getString("seccion"),rs.getDouble("costoUnitario"),rs.getDouble("pesoBruto"),rs.getDouble("pesoNeto"),rs.getString("unidadMedida"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conexion.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return productoEncontrado;
	}

	
	
	
	
	//-------------- BUSQUEDA DE PRODUCTO POR SECCION -----------
	
	
	@Override
	public List<Producto> listarPorSeccion(String seccion) {
		
		List<Producto> productos = new ArrayList<>();
		
		String query = "SELECT idProducto, nombreProducto, seccion, costoUnitario, pesoBruto, pesoNeto, factorRendimiento, "
				+ "unidadMedida FROM producto WHERE seccion = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		Connection connection = ConnectionFactory.getConnection();
		
	try {
			
			ps = connection.prepareStatement(query);
			ps.setString(1, seccion);
			
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				Producto producto;
				do {														//MANERA DE GUARDAR VARIOS CLIENTES 
					producto = new Producto(
							rs.getInt("idProducto"),
							rs.getString("nombreProducto"),
							rs.getString("seccion"),
							rs.getDouble("costoUnitario"),
							rs.getDouble("pesoBruto"),
							rs.getDouble("pesoneto"),
							rs.getString("unidadMedida"));
					
					productos.add(producto);
				
					}while(rs.next());
				
			}
			
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
		
		return productos;
	}

	
	
	
	
	
	//-------- BUSCANDO TODOS LOS PRODUCTOS DE LA TABLA PRODUCTOS
	
	@Override
	public List<Producto> buscarTodos() {

		List<Producto> productos = new ArrayList<>();
		
		String query = "SELECT idProducto, nombreProducto, seccion, costoUnitario, pesoBruto, pesoNeto, factorRendimiento,"
				+ "unidadMedida FROM producto";


		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		Connection connection = ConnectionFactory.getConnection();
		
		
		
		try {
			
			ps = connection.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Producto producto;
				
				do {														//MANERA DE GUARDAR VARIOS CLIENTES 
				producto = new Producto(
						rs.getInt("idProducto"),
						rs.getString("nombreProducto"),
						rs.getString("seccion"),
						rs.getDouble("costoUnitario"),
						rs.getDouble("pesoBruto"),
						rs.getDouble("pesoneto"),
						rs.getString("unidadMedida"));
				
				productos.add(producto);
			
				}while(rs.next());
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		return productos;
	}

	

	
	
	
	
	
	
	// ---------   ACTUALIZACION DE CLIENTES
	
	
	@Override
	public boolean Actualizar(Producto producto) {
		
		String quey = "update producto SET nombreProducto = ?, seccion = ?, costoUnitario = ?, pesoBruto = ?, pesoNeto = ?, factorRendimiento = ?, unidadMedida = ? where idProducto = ?";
int filasAfectadas = 0;
		
		
		PreparedStatement ps = null;
		
		Connection conexion = ConnectionFactory.getConnection();
		
		try {
			
			ps = conexion.prepareStatement(quey);
			
			ps.setString(1, producto.getNombreProducto());
			ps.setString(2, producto.getSeccion());
			ps.setDouble(3, producto.getCostoUnitario());
			ps.setDouble(4, producto.getPesoBruto());
			ps.setDouble(5, producto.getPesoNeto());
			ps.setDouble(6, producto.getFactorRendimiento());
			ps.setString(7, producto.getUnidadMedida());
			
			ps.setInt(8, producto.getIdProducto());


			filasAfectadas = ps.executeUpdate();
			
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return filasAfectadas>0;
		
	}
	
	
	
	
	
	

	@Override
	public boolean eliminar(int idProducto) {

		String query = "DELETE FROM producto WHERE idProducto = ?";
		
		PreparedStatement ps = null;
		
		int filasAfectadas = 0;
		
		Connection conexion = ConnectionFactory.getConnection();
		
		try {
			ps = conexion.prepareStatement(query);
			
			ps.setInt(1, idProducto);
			
			filasAfectadas = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conexion.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return filasAfectadas > 0;
	}

}

























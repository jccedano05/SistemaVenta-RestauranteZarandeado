package restaurante.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import restaurante.modelo.dao.iface.RecetaDao;
import restaurante.modelo.db.ConnectionFactory;
import restaurante.modelo.dto.Receta;

public class RecetaDaoMysql implements RecetaDao {

	@Override
	public List<Receta> crear(List<Receta> recetas) {

		String queryId = "SELECT idReceta FROM receta WHERE idReceta=(select max(idReceta) from receta)";
		String queryExecute = "INSERT INTO receta (idReceta, nombreReceta, idProducto, nombreProducto, cantidad, costo, unidadMedida) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		PreparedStatement psAux = null;
		ResultSet rs = null;
		
		int indiceMax;
		int registrosAfectados;
		int claveGenerada;
		
		Connection connection = ConnectionFactory.getConnection();   //abrimos la conexion a la base de datos
		
	try {
			psAux = connection.prepareStatement(queryId);
			rs =psAux.executeQuery();
			
			
			if(rs.next()) {
				indiceMax = rs.getInt("idReceta")+1;
			}else {
				indiceMax = 1;
			}
			psAux.close();
			
			for (Receta r : recetas) {
				ps = connection.prepareStatement(queryExecute);
				
				ps.setInt(1, indiceMax);
				ps.setString(2, r.getNombreReceta());
				ps.setInt(3, r.getIdProducto());
				ps.setString(4, r.getNombreProducto());
				ps.setDouble(5, r.getCantidad());
				ps.setDouble(6, r.getCosto());
				ps.setString(7, r.getUnidadMedida());
				
				registrosAfectados = ps.executeUpdate();
				
				if(registrosAfectados > 0) {
					System.out.println("Registro Exitoso!");
				}else {
					System.out.println("Fallo de Registro");
				}
				
				System.out.println(indiceMax);
			}		
			
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			rs.close();
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return  recetas;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Receta buscarPorId(int idReceta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receta> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Actualizar(Receta receta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int idReceta) {
		// TODO Auto-generated method stub
		return false;
	}

}

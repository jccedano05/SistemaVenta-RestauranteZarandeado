package restaurante.modelo.db;
import java.sql.*;

public class ConnectionFactory {

	//------ PATRON DE DISENO SINGLETON -----  sirve para no usar en cada instancia el mismo metodo, lo que reduce espacio en memoria
	
	
	// OBJETO SINGLETON
	private static ConnectionFactory connectionFactory; //necesitamos crear la variable statica antes de hacer el bloque statci
	
	
	
	
	
	static {   //este bloque se ejecuta una sola vez al crear el objeto a partir de esa clase, ideal para el patron singleton
					// Ya que nos evitara tener una conexionFactory por cada instancia abierta, asi solo tendremos una por todas
		connectionFactory = new ConnectionFactory();
	}
	
	
	
	
	
	private ConnectionFactory() {     
		//JDBC: Java DataBase Conector   MySQL
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
	}
	
	
	
	//------------------
	
	private Connection crearConexion() {
		Connection connection = null;
		
		try {
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_zarandeado", 
					"root",
					"cedano123321");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
	
	public static Connection getConnection() {
		return connectionFactory.crearConexion();
	}
	
	
}

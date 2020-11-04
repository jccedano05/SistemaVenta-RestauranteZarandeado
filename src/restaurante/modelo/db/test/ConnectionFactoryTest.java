package restaurante.modelo.db.test;

import java.sql.Connection;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import restaurante.modelo.db.*;

public class ConnectionFactoryTest {
	
//--------- ESTA ES LA MANERA EN LA CUAL SE HACEN TEST CON JUNIT4  -----------
	
	@Test	//PARA QUE NOS AGREGUE LA LIBRERIA MAS FACIL ES APLICAR EL @Test Y AGREGAMOS JUNIT4
	public void conexionCorrecta() throws SQLException {
		
		//Subject 
		
		Connection conexion = ConnectionFactory.getConnection();
		
		//pruebas
		Assert.assertNotNull(conexion); //NOS ASEGURAMOS QUE SI SE HAGA LA CONEXION
		Assert.assertFalse(conexion.isClosed());  //NOS ASEGURAMOS QUE LA CONEXION ESTE ABIERTA
		Assert.assertEquals("bd_zarandeado", conexion.getCatalog());  //NOS ASEGURAMOS QUE LA CONEXION QUE ESTAMOS SEA IGUAL A BANCO
	
		conexion.close();  //SIEMPRE DEBEMOS CERRAR LA CONEXION
		
		Assert.assertTrue(conexion.isClosed()); //VERIFICAMOS QUE LA CONEXION SEA CERRADA
		
		
		//---------- PARA CORRER LA PRUEBA DEBEMOS DAR CLICK DERECHO EN EL METODO Y ELEGIR LA OPCION (RUN AS -> JUNIT4)
		
	}

}

package restaurante.modelo.dao.impl.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import restaurante.modelo.dao.iface.RecetaDao;
import restaurante.modelo.dao.impl.RecetaDaoMysql;
import restaurante.modelo.dto.Receta;

public class RecetaDaoMysqlTest {

	
	
	// --------- PRUEBA DE CREACION DE PRODUCTO ---------
	//*
@Test	
public void crearClienteCorrectamente() {
	
	
	//subject
	RecetaDao dao = new RecetaDaoMysql();
	
	

	//input data
	
	List<Receta> recetas = new ArrayList<>();
	recetas.add(new Receta("prueba1",111,"prueba1",1,1,"p"));
	recetas.add(new Receta("prueba1",222,"prueba2",2,2,"p"));
	recetas.add(new Receta("prueba1",333,"prueba1",3,3,"p"));
	recetas.add(new Receta("prueba1",444,"prueba4",4,4,"p"));
	recetas.add(new Receta("prueba1",555,"prueba5",5,5,"p"));
	
	
	List<Receta> recetaCreada = dao.crear(recetas);

	assertNotNull(recetaCreada);
	

	
	
} 
   //*/
	
}

package restaurante.modelo.dto;

public class Receta {
	
	
	
	// -------- VARIABLES ----------
	
	private int idReceta;
	private String nombreReceta;
	private int idProducto;
	private String nombreProducto;
	private double cantidad;
	private double costo;
	private String unidadMedida;
	
	
	
	// -------- CONSTRUCTORES ----------
	
	public Receta() {
		
	}

	public Receta( String nombreReceta, int idProducto, String nombreProducto, double cantidad,
			double costo, String unidadMedida) {
		super();
		this.nombreReceta = nombreReceta;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.costo = costo;
		this.unidadMedida = unidadMedida;
	}

	
	public Receta(int idReceta, String nombreReceta, int idProducto, String nombreProducto, double cantidad,
			double costo, String unidadMedida) {
		this(nombreReceta, idProducto, nombreProducto, cantidad, costo, unidadMedida);
		this.idReceta = idReceta;
	}
	



	public int getIdReceta() {
		return idReceta;
	}



	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}



	public String getNombreReceta() {
		return nombreReceta;
	}



	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public double getCantidad() {
		return cantidad;
	}



	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}



	public double getCosto() {
		return costo;
	}



	public void setCosto(double costo) {
		this.costo = costo;
	}



	public String getUnidadMedida() {
		return unidadMedida;
	}



	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	

}

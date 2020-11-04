package restaurante.modelo.dto;

import java.text.DecimalFormat;

public class Producto {
	
	
	
	// -------- VARIABLES ----------
	
	private int idProducto;
	private String nombreProducto;
	private String seccion;
	private double costoUnitario;
	private double pesoBruto;
	private double pesoNeto;
	private double factorRendimiento;
	private String unidadMedida;
	
	private DecimalFormat df3 = new DecimalFormat("#.000");  //agregamos formato de solo 3 digitos
	
	
	// -------- CONSTRUCTORES ----------
	
	public Producto() {
		
	}
	
	public Producto( String nombreProducto, String seccion, double costoUnitario,String unidadMedida) {
		
		
		this.nombreProducto = nombreProducto;
		this.seccion = seccion;
		this.costoUnitario = costoUnitario;
		this.unidadMedida = unidadMedida;
		pesoBruto = 1;
		pesoNeto = 1;
		factorRendimiento = 1;
	}
	
	public Producto( int idProducto, String nombreProducto, String seccion, double costoUnitario, String unidadMedida) {
		
		
		this(nombreProducto, seccion, costoUnitario, unidadMedida);
		this.idProducto = idProducto;
	}
	
	
	public Producto( String nombreProducto, String seccion, double costoUnitario, double pesoBruto,
			double pesoNeto, String unidadMedida) {
		
		this(nombreProducto, seccion, costoUnitario, unidadMedida);
		this.pesoBruto = pesoBruto;
		this.pesoNeto = pesoNeto;
		this.factorRendimiento = Double.parseDouble(df3.format(pesoBruto / pesoNeto));  //el formato nos los da en string asi que pasamos a double
	}	
	
	//constructor para obtener todos los valores en busqueda
	public Producto( int idProducto, String nombreProducto, String seccion, double costoUnitario, double pesoBruto,
			double pesoNeto, String unidadMedida) {

		this( nombreProducto, seccion, costoUnitario, pesoBruto, pesoNeto, unidadMedida);
		this.idProducto = idProducto;
	}

	
	
	// ----------- Setters y Getters

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getPesoBruto() {
		return pesoBruto;
	}


	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}


	public double getPesoNeto() {
		return pesoNeto;
	}


	public void setPesoNeto(double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}


	public double getFactorRendimiento() {
		return factorRendimiento;
	}


	public void setFactorRendimiento(double factorRendimiento) {
		this.factorRendimiento = factorRendimiento;
	}


	public String getUnidadMedida() {
		return unidadMedida;
	}


	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", seccion=" + seccion
				+ ", costoUnitario=" + costoUnitario + ", pesoBruto=" + pesoBruto + ", pesoNeto=" + pesoNeto
				+ ", factorRendimiento=" + factorRendimiento + ", unidadMedida=" + unidadMedida + "]";
	}

	
	
	
	

	
	
}

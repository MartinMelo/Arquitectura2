package arq.domain;

import javax.persistence.Entity;

@Entity
public class Mercado extends AbstractEntity {

	private String nombre;
	
	private String provincia;
	
	private String ciudad;
	
	private String localidad;
	
	private String direccion;
	
	private double geoX;
	
	private double geoY;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getGeoX() {
		return geoX;
	}

	public void setGeoX(double geoX) {
		this.geoX = geoX;
	}

	public double getGeoY() {
		return geoY;
	}

	public void setGeoY(double geoY) {
		this.geoY = geoY;
	}
	
}

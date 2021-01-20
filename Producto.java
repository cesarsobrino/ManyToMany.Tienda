package ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	private double precio;
	
	
	//@ManyToMany
	//private List<Cliente> clientes;


	public Producto() {
		super();
	}


	public Producto(int id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		//this.clientes = clientes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/*public List<Cliente> getClientes() {
		return clientes;
	}*/


	/*public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}*/


	@Override
	public String toString() {
		return id +"." + nombre + "," + precio + "€";
	}
	
	
}

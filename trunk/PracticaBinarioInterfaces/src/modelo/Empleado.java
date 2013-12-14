package modelo;

import java.io.Serializable;

/**
 * 
 * @author Ainhoa Suárez Sánchez
 */
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private double salario;
	private int id;

	/**
	 * Constructor
	 * @param id
	 * @param nombre
	 * @param salario
	 */
	public Empleado(int id, String nombre, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
	}

	//Getters&Setters
	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return salario
	 */
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param salario
	 */
	public void setModSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * Información del empleado
	 */
	public String toString() {
		String s = "";
		s += " ID: " + getId();
		s += "\n Nombre: " + getNombre();
		s += " \n Salario: " + getSalario();
		return s;
	}
}

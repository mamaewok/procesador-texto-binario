package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * Contiene las operaciones básicas a realizar sobre documentos
 * @author Ainhoa Suárez Sánchez
 *
 */
public class Modelo {
	private final File PATH = new File(".\\empleados.bin");
	private ArrayList<Empleado> listaEmpleados;

	/**
	 * Se usa en caso de que le fichero bin ya este creado
	 * 
	 * @param rutaBin
	 */
	public Modelo() {
		listaEmpleados = new ArrayList<Empleado>();
		crearFicheroBin(PATH);
	}
	
	/**
	 * Crea el fichero de Registros con el que trabajaremos y lo pasa a un temporal antes
	 * de borrar el original (crea y guarda)
	 * 
	 * @param fichero
	 *            direccion del fichero creado //Añadir con scanner
	 */
	public void crearFicheroBin(File fichero) {
		File temporal = new File (fichero.getAbsolutePath() + ".tmp");
		
		ObjectOutputStream dataOS = null;
		try {
			FileOutputStream filein = new FileOutputStream(temporal);
			dataOS = new ObjectOutputStream(filein);

			for (Empleado e : listaEmpleados) {
				dataOS.writeObject(e);
			}
		} catch (IOException ioe) {
			System.err.println("Error en E/S en fichero BIN");
		} finally {
			try {
				dataOS.close();
			} catch (IOException e) {
				System.err.println("No se ha podido cerrar el archivo BIN");
			}
		}
		temporal.renameTo(fichero);
		fichero.delete();
	}
	
	/**
	 * Busca un empleado
	 * @param id
	 * @return
	 */
	public Empleado buscarEmpleado(int id) {
		for (Empleado empleado : listaEmpleados) {
			if (id == empleado.getId()) {
				System.out.println("ENCONTRADO: \n" + empleado.toString());
				return empleado;
			}
			else{
				System.out.println("Empleado no encontrado");
			}
		}
		return null;
	}

	/**
	 * @param id
	 * @param apellido
	 * @param nombre
	 * @param trabajo
	 * @param date
	 * @param salario
	 * @param comision
	 * @param numDep
	 */
	public String introducirEmpleado(int id, String nombre, double salario){
		Empleado empleado = new Empleado(id, nombre, salario);
		listaEmpleados.add(empleado);
		crearFicheroBin(PATH);
		
		return empleado.toString();
	}
	
	/**
	 * @return the listaEmp
	 */
	public ArrayList<Empleado> getListaEmp() {
		return listaEmpleados;
	}

	/**
	 * @param listaEmp
	 *            the listaEmp to set
	 */
	public void setListaEmp(ArrayList<Empleado> listaEmp) {
		this.listaEmpleados = listaEmp;
	}
}

package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Contiene las operaciones básicas a realizar sobre documentos
 * @author Ainhoa Suárez Sánchez
 *
 */
public class Modelo {
	
	private ArrayList<Empleado> listaEmpleados;

	/**
	 * Crea la lista de empleados y el fichero binario en caso de que no esté
	 * creado ya
	 * 
	 * @param rutaCSV
	 *            ruta del fichero con los datos para el binario
	 * @param rutaBin
	 *            ruta del fichero que se está creando
	 */
	public Modelo(String rutaCSV, String rutaBin) {
		listaEmpleados = new ArrayList<Empleado>();
		leerFicheroCSV(rutaCSV);
		crearFicheroBin(rutaBin);
	}

	/**
	 * Se usa en caso de que le fichero bin ya este creado
	 * 
	 * @param rutaBin
	 */
	public Modelo(String rutaBin) {
		listaEmpleados = new ArrayList<Empleado>();
		
	}
	
	/**
	 * Lee y devuelve los datos de un fichero csv o txt sobre empelados
	 * 
	 * @param rutaTxt
	 *            direccion del fichero a leer
	 * @return los datos de el fichero
	 */
	public void leerFicheroCSV(String rutaTxt) {

		FileReader f = null;
		BufferedReader bf = null;
		String linea;
		
		try {
			File fichero = new File(rutaTxt);
			f = new FileReader(fichero);
			bf = new BufferedReader(f);

			StringTokenizer tokens = null;
			while ((linea = bf.readLine()) != null) {
				tokens = new StringTokenizer(linea, ","); 
				
				int id = Integer.parseInt(tokens.nextToken());
				String nombre = tokens.nextToken();
				double salario = Double.parseDouble(tokens.nextToken());
				
				Empleado empleado = new Empleado(id, nombre, salario);

				listaEmpleados.add(empleado);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero no se encuentra");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el archivo");
			}
		}
	}

	/**
	 * Crea un fichero binario con objetos de tipo empleado
	 * 
	 * @param rutaBin
	 *            ruta del fichero nuevo que se crea
	 * 
	 */
	public void crearFicheroBin(String rutaBin) {

		ObjectOutputStream dataOS = null;
		try {
			File fichero = new File(rutaBin);
			FileOutputStream filein = new FileOutputStream(fichero);
			dataOS = new ObjectOutputStream(filein);

			for (Empleado emp : listaEmpleados) {
				dataOS.writeObject(emp);
			}
		} catch (IOException ioe) {
			System.out.println("Error en E/S");
		} finally {
			try {
				dataOS.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el archivo");
			}
		}
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
	public void introducirEmpleado(int id, String nombre, double salario){
		Empleado empleado = new Empleado(id, nombre, salario);
		listaEmpleados.add(empleado);
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

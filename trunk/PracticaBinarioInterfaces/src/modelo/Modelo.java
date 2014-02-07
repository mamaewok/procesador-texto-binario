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
	private File fichero;
	private File ficheroCSV;
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
		fichero = new File(rutaBin);
		ficheroCSV = new File(rutaCSV);
		listaEmpleados = new ArrayList<Empleado>();
		leerFicheroCSV();
		crearFicheroBin();
	}

	/**
	 * Se usa en caso de que le fichero bin ya este creado
	 * 
	 * @param rutaBin
	 */
	public Modelo(String rutaBin) {
		listaEmpleados = new ArrayList<Empleado>();
		fichero = new File(rutaBin);
	}

	/**
	 * Lee y devuelve los datos de un fichero csv o txt sobre empelados
	 * 
	 */
	public void leerFicheroCSV() {
		FileReader f = null;
		BufferedReader bf = null;
		String linea; 
		
		try {
			f = new FileReader(ficheroCSV);
			bf = new BufferedReader(f);

			StringTokenizer tokens = null;
			while ((linea = bf.readLine()) != null) {
				
				tokens = new StringTokenizer(linea, ";");
								
				int id = Integer.parseInt(tokens.nextToken());
				String nombre = tokens.nextToken();
				double salario = Double.parseDouble(tokens.nextToken());
				
				Empleado emp = new Empleado(id, nombre,salario);

				listaEmpleados.add(emp);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("No se encuentra el fichero CSV");
		} catch (IOException e) {
			System.err.println("Error de E/S en fichero CSV");
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.err.println("No se ha podido cerrar el archivo CSV");
			}
		}
	}

	/**
	 * Crea un fichero binario con objetos de clase Empleado usando un fichero temporal
	 */
	public void crearFicheroBin() {
		File temporal = new File (fichero.getAbsolutePath() + ".tmp");
				
		ObjectOutputStream dataOS = null;
		try {
			FileOutputStream filein = new FileOutputStream(temporal);
			dataOS = new ObjectOutputStream(filein);

			for (Empleado emp : listaEmpleados) {
				dataOS.writeObject(emp);
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
		fichero.delete();
		temporal.renameTo(fichero);
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
		crearFicheroBin();
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import modelo.Empleado;
import modelo.Modelo;

/**
 * Gestiona la acción del listener dependiendo del tipo de botón que pulsemos
 * @author Ainhoa Suárez Sánchez
 */
public class Listener implements ActionListener {

	private Vista vista;
	private Modelo modelo;
	private String rutaCSV = "empleados.csv";
	private String rutaBin = "empleados.bin";
	
	/**
	 * Constructor que pasa una vista como parámetro e inicializa el modelo, creando el fichero bin en caso de que no este creado ya
	 * @param vista
	 */
	public Listener(Vista vista) {
		this.vista = vista;
		File rutaAux = new File(rutaBin);
		if(rutaAux.exists())
			modelo = new Modelo(rutaBin);
		else
			modelo = new Modelo(rutaCSV, rutaBin);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == BotonInsertar.class) {
			insertar();
		}
		if (e.getSource().getClass() == BotonBuscar.class) {
			buscar();
		}
		if (e.getSource().getClass() == BotonIncrementar.class) {
			incrementar();
		}
	}

	/**
	 * Comprueba que el id de empleado no exista, y en este caso, lo crea
	 */
	private void insertar() {
		Object mnsj = "Id ya existe";
		if(modelo.buscarEmpleado(vista.getTextIdInser())!= null){
			JOptionPane.showMessageDialog(vista, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		else{
			modelo.introducirEmpleado(vista.getTextIdInser(),
					vista.getTextNombreInser(), vista.getTextSalarioInser());
			JOptionPane.showMessageDialog(vista, "Empleado insertado con éxito");
		}
		vista.vaciarCajastInser();
	}

	/**
	 * Busca un empleado por su id mostrando su información
	 */
	private void buscar() {
		Object mnsj;
		
		if(modelo.buscarEmpleado(vista.getTextIdBuscar())!= null){
			Empleado e = modelo.buscarEmpleado(vista.getTextIdBuscar());
			mnsj = e.toString();
			JOptionPane.showMessageDialog(vista, mnsj, "Información de empleado", JOptionPane.INFORMATION_MESSAGE);
			}
		else{
			mnsj = "Empleado no existe";
			JOptionPane.showMessageDialog(vista, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
			}
		vista.vaciarCajaBuscar();
		}

	/**
	 * Busca un empleado por su id e incrementa al salario la cantidad que introducimos
	 */
	private void incrementar() {
		Object mnsj;
		
		if(modelo.buscarEmpleado(vista.getIdIncrementar())!= null){
			Empleado e = modelo.buscarEmpleado(vista.getIdIncrementar());
			double salarioTotal = e.getSalario() + vista.getSalarioIncrementar();
			e.setSalario(salarioTotal);
			mnsj = e.toString();
			JOptionPane.showMessageDialog(vista, mnsj, "Información actualizada ", JOptionPane.INFORMATION_MESSAGE);	
		}
		vista.vaciarTextIncrem();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
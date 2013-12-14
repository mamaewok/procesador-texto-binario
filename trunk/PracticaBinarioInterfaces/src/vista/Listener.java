/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public Listener(Vista vista) {
		this.vista = vista;
		modelo = new Modelo();
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
		vista.vaciarTextInser();
	}

	/**
	 * Busca un empleado por su id mostrando su información
	 */
	private void buscar() {
		Object mnsj;
		
		if(modelo.buscarEmpleado(vista.getTextBuscarID())!= null){
			Empleado e = modelo.buscarEmpleado(vista.getTextBuscarID());
			mnsj = e.toString();
			JOptionPane.showMessageDialog(vista, mnsj, "Información de empleado", JOptionPane.INFORMATION_MESSAGE);
			}
		else{
			mnsj = "Empleado no existe";
			JOptionPane.showMessageDialog(vista, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
			}
		vista.vaciarTextBuscar();
		}

	/**
	 * Busca un empleado por su id e incrementa al salario la cantidad que introducimos
	 */
	private void incrementar() {
		Object mnsj;
		
		if(modelo.buscarEmpleado(vista.getIncrementarID())!= null){
			Empleado e = modelo.buscarEmpleado(vista.getIncrementarID());
			double salarioTotal = e.getSalario() + vista.getIncrementarSalario3();
			e.setSalario(salarioTotal);
			mnsj = e.toString();
			JOptionPane.showMessageDialog(vista, mnsj, "Información actualizada ", JOptionPane.INFORMATION_MESSAGE);	
		}
		vista.vaciarTextIncrem();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
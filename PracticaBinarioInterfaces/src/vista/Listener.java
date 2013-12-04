/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Empleado;
import modelo.Modelo;

/**
 *
 * @author Ainhoa Suárez Sánchez
 */
public class Listener implements ActionListener {
    
    private Vista vista;
    private Modelo modelo;
    private ArrayList<Empleado> listaEmpleados;
    
    public Listener() {
        listaEmpleados = new ArrayList<Empleado>();
        
    }
    
    public Listener(Vista view, Modelo model) {
        this.vista = view;
        this.modelo = model;
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
    
    //Acciones
    private void insertar() {
    	if(modelo.buscarEmpleado(Integer.parseInt(vista.getTextIdInser())) != null){
    		modelo.introducirEmpleado(Integer.parseInt(vista.getTextIdInser()), vista.getTextNombreInser(), 
					Double.parseDouble(vista.getTextSalarioInser()));
    		JOptionPane.showMessageDialog(vista, "Empleado");
    		System.out.println("Insertado empleado");
    		
    	}
    	else
    		JOptionPane.showMessageDialog(vista, "El empleado ya existe");
    	}
    
    private void buscar() {
    	modelo.buscarEmpleado(Integer.parseInt(vista.getTextBuscarID()));
    	}
    
    private void incrementar() {
    	
    }
    
   
}
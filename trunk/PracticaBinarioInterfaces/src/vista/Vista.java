package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Genera los elementos gráficos básicos y contiene métodos que devuelven información de las cajas de texto
 * @author Ainhoa Suárez Sánchez
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel p1,p2,p3;
	private JTextField sueldoInser, idInser, nombreInser, idBuscar, salarioIncrement, idIncrementar;
	private JButton boton;

	/**
	 * Crea la vista al instanciar un objeto de la clase Vista
	 */
	public Vista() {

		this.setTitle("Gestor de Archivos Binarios");
		this.setResizable(false);
		this.setSize(400, 200);
		
		Listener listener = new Listener(this);
		
		p1 = new JPanel(new GridLayout(4,1));
		
			JLabel nombre = new JLabel("Nombre: ");
			nombreInser = new JTextField("", 10);
			JLabel id = new JLabel("ID: ");
			idInser = new JTextField("", 10);
			JLabel sueldo = new JLabel("Salario: ");
			sueldoInser = new JTextField("", 10);
	
			boton = new BotonInsertar("Insertar");
			boton.addActionListener(listener);
			JPanel pAux1 = new JPanel();
			JPanel pAux2 = new JPanel();
			JPanel pAux3 = new JPanel();
			JPanel pAux4 = new JPanel();
			pAux1.add(nombre);
			pAux1.add(nombreInser);
			p1.add(pAux1);
			pAux2.add(id);
			pAux2.add(idInser);
			p1.add(pAux2);
			pAux3.add(sueldo);
			pAux3.add(sueldoInser);
			p1.add(pAux3);
			pAux4.add(boton);
			p1.add(pAux4);
		
		p2 = new JPanel();
		
			id = new JLabel("ID: ");
			idBuscar = new JTextField("", 10);
			boton = new BotonBuscar("Buscar");
			boton.addActionListener(listener);
			p2.add(id);
			p2.add(idBuscar);
			p2.add(boton);

		p3 = new JPanel(new GridLayout(3,1));
		
			id = new JLabel("ID: ");
			idIncrementar = new JTextField("", 10);
			sueldo = new JLabel("Sueldo: ");
			salarioIncrement = new JTextField("", 10);
			boton = new BotonIncrementar("Incrementar");
			boton.addActionListener(listener);
			JPanel panelAux1 = new JPanel();
			JPanel panelAux2 = new JPanel();
			JPanel panelAux3 = new JPanel();
			panelAux1.add(id);
			panelAux1.add(idIncrementar);
			panelAux2.add(sueldo);
			panelAux2.add(salarioIncrement);
			panelAux3.add(boton);
			p3.add(panelAux1);
			p3.add(panelAux2);
			p3.add(panelAux3);
		
		JTabbedPane tp = new JTabbedPane();
			tp.addTab("Insertar", p1);
			tp.addTab("Buscar", p2);
			tp.addTab("Incrementar", p3);
		
		this.getContentPane().add(tp);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	} // Acaba constructor

	
	
	//Acciones sobre los text field
	/**
	 * Hace accesible el nombre que introduzcamos en la caja de texto en el panel 1  //INSERTAR
	 * @return
	 */
	public String getTextNombreInser() {
			return nombreInser.getText();
			}
	
	/**
	 * Hace accesible en forma de integer el ID que introduzcamos en la caja de texto ID 
	 * @return hace cast de String a int
	 */
	public int getTextIdInser() {
		try{
			return Integer.parseInt(idInser.getText());
		}catch(NumberFormatException nfe){
			Object mnsj = "ID: Solo admite numeros enteros";
			JOptionPane.showMessageDialog(this, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		return -1;
	}
	
	/**
	 * Hace accesible en forma de double el salario que introduzcamos en la caja de texto 
	 * @return hace cast de String a double
	 */
	public double getTextSalarioInser() {
		try{
			return Double.parseDouble(sueldoInser.getText());
		}catch(NumberFormatException nfe){
			Object mnsj = "Salario: Solo admite números";
			JOptionPane.showMessageDialog(this, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		return -1;
	}
	
	 /**
	  * Vacia las cajas de texto de las opcion insertar
	  */
	public void vaciarCajastInser(){
		nombreInser.setText("");
		idInser.setText("");
		sueldoInser.setText("");
	}
	
	/**
	 * Hace accesible el texto que introduzcamos en la caja de texto Buscar en el panel 2 //BUSCAR
	 * @return hace cast de String a int
	 */
	public int getTextIdBuscar() {
		try{
			return Integer.parseInt(idBuscar.getText());
		}catch(NumberFormatException nfe){
			Object mnsj = "ID: Solo admite números enteros";
			JOptionPane.showMessageDialog(this, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		return -1;
	}
	
	/**
	 * Vacia las cajas de texto de las opcion buscar
	 */
	public void vaciarCajaBuscar(){
		idBuscar.setText("");
	}
	
	/**
	 * Hace accesible el ID que introduzcamos en la caja de texto ID en el panel 3  //INCREMENTAR
	 * @return hace cast de String a int
	 */
	public int getIdIncrementar() {
		try{
			return Integer.parseInt(idIncrementar.getText());
		}catch(NumberFormatException nfe){
			Object mnsj = "ID: Solo admite números enteros";
			JOptionPane.showMessageDialog(this, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		return -1;
	}

	/**
	 * Hace accesible el salario que introduzcamos en la caja de texto salario en el panel 3
	 * @return
	 */
	public double getSalarioIncrementar() {
		try{
			return Double.parseDouble(salarioIncrement.getText());
		}catch(NumberFormatException nfe){
			Object mnsj = "Incremento: Solo admite números";
			JOptionPane.showMessageDialog(this, mnsj, "Error",JOptionPane.WARNING_MESSAGE);
		}
		return -1;
	}
	
	/**
	 * Vacia las cajas de texto de las opcion incrementar
	 */
	public void vaciarTextIncrem(){
		idIncrementar.setText("");
		salarioIncrement.setText("");
	}
}

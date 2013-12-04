package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
/**
 * Genera los elementos gráficos básicos y contiene métodos que devuelven información de las cajas de texto
 * @author Ainhoa Suárez Sánchez
 *
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JTextField tfBuscar;
	private JTextField tfNombreInser
	;
	private JTextField tfIdInser;
	private JTextField tfID3;
	private JTextField tfSueldoInser;
	private JTextField tfSueldo3;
	private JButton boton;
	Listener listener = new Listener();

	/**
	 * Crea la vista al instanciar un objeto de la clase Vista
	 */
	public Vista() {

		this.setTitle("Gestor de Archivos Binarios");
		this.setResizable(false);
		this.setSize(400, 200);
		JTabbedPane tp = new JTabbedPane();
		
		p1 = new JPanel(new GridLayout(4,1));
		
			JLabel nombre = new JLabel("Nombre: ");
			tfNombreInser = new JTextField(" ", 10);
			JLabel id = new JLabel("ID: ");
			tfIdInser = new JTextField(" ", 10);
			JLabel sueldo = new JLabel("Salario: ");
			tfSueldoInser = new JTextField(" ", 10);
	
			boton = new BotonInsertar();
			boton.setText("Insertar");
			boton.addActionListener(listener);
			JPanel pAux1 = new JPanel();
			JPanel pAux2 = new JPanel();
			JPanel pAux3 = new JPanel();
			JPanel pAux4 = new JPanel();
			pAux1.add(nombre);
			pAux1.add(tfNombreInser);
			p1.add(pAux1);
			pAux2.add(id);
			pAux2.add(tfIdInser);
			p1.add(pAux2);
			pAux3.add(sueldo);
			pAux3.add(tfSueldoInser);
			p1.add(pAux3);
			pAux4.add(boton);
			p1.add(pAux4);
		
		p2 = new JPanel();
		
			id = new JLabel("ID: ");
			tfBuscar = new JTextField(" ", 10);
			boton = new BotonBuscar();
			boton.setText("Buscar");
			boton.addActionListener(listener);
			p2.add(id);
			p2.add(tfBuscar);
			p2.add(boton);

		p3 = new JPanel(new GridLayout(3,1));
		
			id = new JLabel("ID: ");
			tfID3 = new JTextField(" ", 10);
			sueldo = new JLabel("Sueldo: ");
			tfSueldo3 = new JTextField(" ", 10);
			boton = new BotonIncrementar();
			boton.setText("Incrementar");
			boton.addActionListener(listener);
			JPanel panelAux1 = new JPanel();
			JPanel panelAux2 = new JPanel();
			JPanel panelAux3 = new JPanel();
			panelAux1.add(id);
			panelAux1.add(tfID3);
			panelAux2.add(sueldo);
			panelAux2.add(tfSueldo3);
			panelAux3.add(boton);
			p3.add(panelAux1);
			p3.add(panelAux2);
			p3.add(panelAux3);
		
		tp.addTab("Insertar", p1);
		tp.addTab("Buscar", p2);
		tp.addTab("Incrementar", p3);
		
		
		this.getContentPane().add(tp);
		this.setVisible(true);
	} // Acaba constructor

	
	//Acciones sobre los text field
	/**
	 * Hace accesible el nombre que introduzcamos en la caja de texto en el panel 1  //INSERTAR
	 * @return
	 */
	public String getTextNombreInser() {
		return tfNombreInser.getText();
	}
	
	/**
	 * Hace accesible el ID que introduzcamos en la caja de texto ID en el panel 1
	 * @return
	 */
	public String getTextIdInser() {
		return tfIdInser.getText();
	}
	
	/**
	 * Hace accesible el salario que introduzcamos en la caja de texto en el panel 1
	 * @return
	 */
	public String getTextSalarioInser() {
		return tfSueldoInser.getText();
	}

	
	
	/**
	 * Hace accesible el texto que introduzcamos en la caja de texto Buscar en el panel 2 //BUSCAR
	 * @return
	 */
	public String getTextBuscarID() {
		return tfBuscar.getText();
	}
	
	
	/**
	 * Hace accesible el ID que introduzcamos en la caja de texto ID en el panel 3  //INCREMENTAR
	 * @return
	 */
	public String getIncrementarID() {
		return tfID3.getText();
	}

	/**
	 * Hace accesible el salario que introduzcamos en la caja de texto salario en el panel 3
	 * @return
	 */
	public String getIncrementarSalario3() {
		return tfSueldo3.getText();
	}

	

	
}

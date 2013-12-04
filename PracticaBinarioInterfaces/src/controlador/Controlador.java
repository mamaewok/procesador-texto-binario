package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {

	String FileCSV = ".\\empleados.csv";
	String FileBIN= ".\\empleados.bin";
	Modelo modeloOperacion;
	Vista vista;
	
	//Convierte a BIN el archivo
	//Modelo modeloConvertir = new Modelo(FileCSV, FileBIN);

	public Controlador(){
		modeloOperacion = new Modelo(FileBIN);
		vista = new Vista();
	}
}

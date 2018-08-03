package interfaz;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.HiloMatriz;
import mundo.Matematica;

@SuppressWarnings("serial")
public class InterfazMatematicas extends JFrame{
	private Matematica mat;
	private PanelInformacion panelInformacion;
	private PanelMatriz panelMatriz;
	private HiloMatriz hiloM;
	
	public InterfazMatematicas(){
		setLayout(new BorderLayout());
		setTitle("Matemáticas Didacticas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mat = new Matematica();
		panelInformacion = new PanelInformacion(this);
		panelMatriz = new PanelMatriz(this);
		
		add(panelInformacion, BorderLayout.NORTH);
		add(panelMatriz, BorderLayout.CENTER);
		pack();
	}
	
	private void redimensionarVentana(int f, int c){

		int ancho  = getWidth();
		int alto = getHeight();
		   	 
		int anchoMinimo = 50 + PanelMatriz.TAMANO_LADO_CASILLA*c;
		int altoMinimo  = 50 + panelInformacion.getHeight() + PanelMatriz.TAMANO_LADO_CASILLA*f;
		   	 
		  boolean cambio = false;
		  if(anchoMinimo>ancho){
		    ancho = anchoMinimo;
		    cambio = true;
		  }
		  if(altoMinimo>alto){
		    alto = altoMinimo;
		    cambio = true;
		  }	 
		  if(cambio) setSize(ancho,alto);

	}
	
	private void mostrarNuevaMatriz(){
		panelMatriz.cambiarMatriz(mat.darMatrizDidactica());
		redimensionarVentana(mat.darMatrizDidactica().length, mat.darMatrizDidactica()[0].length);
		panelMatriz.repaint();		
	}
	
	public void generarMatriz(){
		try{
			int f = panelInformacion.darFilas();
			int c = panelInformacion.darCols();
			
			mat = new Matematica(f,c);
			mostrarNuevaMatriz();
			
		}catch(NumberFormatException nfexc){
			JOptionPane.showMessageDialog(this, "El # de Filas y # de Columnas deben\nser valores enteros positivos.");
		}
	}
	
	public void sumar(){
			hiloM = new HiloMatriz(mat, this);
			hiloM.start();
	}
	
	public void cambiarColor() {
	}
	
	public void refrescarMatriz(){
		panelMatriz.repaint();
		panelInformacion.cambiarResultado(mat.darResultadoParcial());
	}
	
	public void cambiarCalculando(boolean calculando){
		mat.cambiarCalculando(calculando);
	}
	
	public void cargar(){
		try {
			mat.cargar();
			mostrarNuevaMatriz();
			JOptionPane.showMessageDialog(this,
					"Se cargó exitosamente la matriz del archivo:\n'" 
							+ Matematica.NOMBRE_ULTIMA_MATRIZ+ " ' ");	
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this,
					"El archivo ' " 
							+ Matematica.NOMBRE_ULTIMA_MATRIZ+" ' no existe");
			e.printStackTrace();
		}catch (IOException e) {
			JOptionPane.showMessageDialog(this,
					"Se encontraron problemas leyendo el archivo:\n'"
						+ Matematica.NOMBRE_ULTIMA_MATRIZ+ " ' ");
			e.printStackTrace();
		}
	}
	
	public void guardar(){
	}
	
	public static void main(String[] args){
		InterfazMatematicas ventana;
		ventana = new InterfazMatematicas();
		ventana.setVisible(true);
	}
}

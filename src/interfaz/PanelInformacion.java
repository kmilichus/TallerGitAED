package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel implements ActionListener{
	private JLabel labFilas;
	private JLabel labCols;
	private JLabel labResultado;
	private JTextField txtFilas;
	private JTextField txtCols;
	private JButton butGenerarMatriz;
	private JButton butColor;
	
	private JTextField txtResultado;
	
	private final static String GENERAR_MATRIZ = "GENERAR_MATRIZ";
	private final static String GUARDAR = "GUARDAR";
	private final static String CARGAR = "CARGAR";
	private final static String COLOR = "COLOR";
	
	private InterfazMatematicas principal;
	
	public PanelInformacion(InterfazMatematicas ventana){
		principal = ventana;
		
		setBorder(new TitledBorder("Información"));
		setLayout(new FlowLayout());
		
		labFilas = new JLabel("# de Filas:",SwingConstants.RIGHT);
		labCols  = new JLabel("# de Columnas:",SwingConstants.RIGHT);
		labResultado = new JLabel("Suma:",SwingConstants.RIGHT);
		txtFilas = new JTextField(2);
		txtCols  = new JTextField(2);
		butGenerarMatriz = new JButton("Generar Matriz");
		butColor = new JButton("Cambiar Color");
		butColor.addActionListener(this);
		butColor.setActionCommand(COLOR);
		add(butColor);

		
		txtResultado = new JTextField(4);
		txtResultado.setEditable(false);
		
		txtFilas.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCols.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		butGenerarMatriz.addActionListener(this);
		
		butGenerarMatriz.setActionCommand(GENERAR_MATRIZ);
		
		add(labFilas);
		add(txtFilas);
		add(labCols);
		add(txtCols);
		add(butGenerarMatriz);
		add(labResultado);
		add(txtResultado);
	}
	
	public int darFilas() throws NumberFormatException{
		return Integer.parseInt(txtFilas.getText());
	}
	
	public int darCols() throws NumberFormatException{
		return Integer.parseInt(txtCols.getText());
	}
	
	public void cambiarResultado(int res){
		txtResultado.setText(res+"");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(GENERAR_MATRIZ)){
			principal.generarMatriz();			
		}
		
		if(comando.equals(COLOR)){
			  principal.cambiarColor();
			}

	}
}
=======
package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel implements ActionListener{
	private JLabel labFilas;
	private JLabel labCols;
	private JLabel labResultado;
	private JTextField txtFilas;
	private JTextField txtCols;
	private JButton butGenerarMatriz;
	private JButton butCargar;
	private JButton butGuardar;
	
	private JTextField txtResultado;
	
	private final static String GENERAR_MATRIZ = "GENERAR_MATRIZ";
	private final static String GUARDAR = "GUARDAR";
	private final static String CARGAR = "CARGAR";
	private final static String COLOR = "COLOR";
	
	private InterfazMatematicas principal;
	
	public PanelInformacion(InterfazMatematicas ventana){
		principal = ventana;
		
		setBorder(new TitledBorder("Información"));
		setLayout(new FlowLayout());
		
		butGuardar = new JButton("Guardar");
		butGuardar.addActionListener(this);
		butGuardar.setActionCommand(GUARDAR);
		
		
		labFilas = new JLabel("# de Filas:",SwingConstants.RIGHT);
		labCols  = new JLabel("# de Columnas:",SwingConstants.RIGHT);
		labResultado = new JLabel("Suma:",SwingConstants.RIGHT);
		txtFilas = new JTextField(2);
		txtCols  = new JTextField(2);
		butGenerarMatriz = new JButton("Generar Matriz");
		butCargar = new JButton("Cargar");
		
		
		txtResultado = new JTextField(4);
		txtResultado.setEditable(false);
		
		txtFilas.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCols.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		butGenerarMatriz.addActionListener(this);
		
		butGenerarMatriz.setActionCommand(GENERAR_MATRIZ);
		
		add(labFilas);
		add(butGuardar);
		add(txtFilas);
		add(labCols);
		add(txtCols);
		add(butGenerarMatriz);
		add(butCargar);
		add(labResultado);
		add(txtResultado);
	}
	
	public int darFilas() throws NumberFormatException{
		return Integer.parseInt(txtFilas.getText());
	}
	
	public int darCols() throws NumberFormatException{
		return Integer.parseInt(txtCols.getText());
	}
	
	public void cambiarResultado(int res){
		txtResultado.setText(res+"");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(GENERAR_MATRIZ)){
			principal.generarMatriz();			
		}
		if(comando.equals(GUARDAR)) {
			principal.cargar();
		}
	}

}

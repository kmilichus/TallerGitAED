package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import mundo.Casilla;

@SuppressWarnings("serial")
public class PanelMatriz extends JPanel implements MouseListener{
	public final static int TAMANO_LADO_CASILLA = 50;
	private Casilla[][] matrizDidactica;
	private InterfazMatematicas principal;
	
	public PanelMatriz(InterfazMatematicas ventana){
		principal = ventana;
		setBackground(Color.WHITE);
		addMouseListener(this);
		matrizDidactica = new Casilla[0][0];
	}
	
	public void cambiarMatriz(Casilla[][] md){
		matrizDidactica = md;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (int i = 0; i < matrizDidactica.length; i++) {
			for (int j = 0; j < matrizDidactica[i].length; j++) {
				int x = j*TAMANO_LADO_CASILLA;
				int y = i*TAMANO_LADO_CASILLA;
				if(matrizDidactica[i][j].darEstado()==Casilla.ESTADO_NORMAL){
					g.setColor(new Color(240,240,240));
				}else{
					g.setColor(Color.PINK);
				}
				g.fillRect(x, y, TAMANO_LADO_CASILLA, TAMANO_LADO_CASILLA);
				g.setColor(Color.RED);
				g.drawRect(x, y, TAMANO_LADO_CASILLA, TAMANO_LADO_CASILLA);
				g.setColor(Color.BLACK);
				g.drawString(matrizDidactica[i][j].darValor()+"", x+TAMANO_LADO_CASILLA/4, y+3*TAMANO_LADO_CASILLA/4);
			}
		}
	}
	
	public Color generarColorAleatorio() {
		
		  int r = (int)(Math.random()*256);
		  int g = (int)(Math.random()*256);
		  int b = (int)(Math.random()*256);
		  Color colorAleatorio = new Color(r,g,b);
		  return colorAleatorio;		
	}
	
	public void cambiarFondo(Color nuevoColor) {
		setBackground(nuevoColor);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		principal.sumar();
		if(e.getButton()==MouseEvent.BUTTON1){
			  principal.sumar();
			}else if(e.getButton()==MouseEvent.BUTTON3){
			  principal.cambiarCalculando(false);
			}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Color colorA = generarColorAleatorio();
		cambiarFondo(colorA);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		  cambiarFondo(Color.WHITE);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}	
}

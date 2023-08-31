package Triange_Generate;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Panel_Triangle_Generate extends JPanel {

	private int iterate;

	public Panel_Triangle_Generate(int x, int y, int width, int height) {
		iterate=-1;
		this.setLayout(null);
		this.setBounds(x, y, width, height);
	}

	public void paintComponent(Graphics g) {
		if(iterate !=-1) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			vertexCalculator(g2, (int) (this.getWidth()*0.5), (int) (this.getWidth()*0.1), (int) (this.getWidth()*0.9), iterate);
		}
	}

	public void vertexCalculator(Graphics2D g, int x, int y, int side, int iterateCount) {
		if (iterateCount == 0) {
			drawTriangle(g,x,y,side);
		} else {
			// calcular los triangulos inferior izquierdo, inferior derecho y superior respectivamente
			vertexCalculator(g,x-side/4,y+(int)(side*Math.sqrt(3)/4),side/2,iterateCount-1); 
			vertexCalculator(g,x+side/4,y+(int)(side*Math.sqrt(3)/4),side/2,iterateCount-1); 
			vertexCalculator(g,x,y,side/2,iterateCount-1); 
		}
	}

	public void drawTriangle(Graphics2D g, int x, int y, int side) {
		int[] xCoordinates = {x - side / 2, x + side / 2, x};
		int[] yCoordinates = {y + (int) (side * Math.sqrt(3) / 2), y + (int) (side * Math.sqrt(3) / 2), y};
		g.fillPolygon(xCoordinates, yCoordinates, 3);
	}

	public void setIterate(int iterate) {
		this.iterate = iterate;
	}
}

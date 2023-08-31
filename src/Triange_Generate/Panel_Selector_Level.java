package Triange_Generate;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Selector_Level extends JPanel {

	private JComboBox<Integer> iterateField;
	private JButton drawButton;
	private JLabel instruction;

	public Panel_Selector_Level(int x, int y, int width, int height,ActionListener listener) {
		this.setBackground(new Color(255, 223, 186)); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		instruction= new JLabel("Elije el nivel del 0-8 (el tamaño del frame no permite dibujar mas del 8° nivel)");
		instruction.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.1), (int)(this.getWidth()*0.9), (int)(this.getHeight()*0.2));
		this.add(instruction);

		iterateField= new JComboBox<Integer>();
		iterateField.setBounds((int)(this.getWidth()*0.05), (int)(this.getHeight()*0.5), (int)(this.getWidth()*0.1), (int)(this.getHeight()*0.3));
		for(int i=0; i < 9; i++)
			iterateField.addItem(i);
		this.add(iterateField);

		drawButton= new JButton("Dibujar");
		drawButton.setBounds((int)(this.getWidth()*0.2), (int)(this.getHeight()*0.5), (int)(this.getWidth()*0.2), (int)(this.getHeight()*0.3));
		drawButton.setActionCommand("Draw");
		drawButton.addActionListener(listener);
		this.add(drawButton);
	}

	public JComboBox<Integer> getIterateField() {
		return iterateField;
	}
}

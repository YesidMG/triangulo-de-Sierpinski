package Triange_Generate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {

	private Panel_Selector_Level leveleSelector;
	private Panel_Triangle_Generate triangleGenerate;

	public Frame () {
		super("Triángulo de Sierpinski");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 700);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.initComponets();
		this.revalidate();
		this.repaint();
	}

	private void initComponets() {	
		leveleSelector = new Panel_Selector_Level(0, 0, this.getWidth(), (int) (this.getHeight()*0.1), this);
		triangleGenerate = new Panel_Triangle_Generate(0, (int) (this.getHeight()*0.1), this.getWidth(), (int) (this.getHeight()*0.9));
		this.add(leveleSelector);
		this.add(triangleGenerate);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case "Draw": {	
			triangleGenerate.setIterate((int) leveleSelector.getIterateField().getSelectedItem());
			this.repaint();
			this.revalidate();
			break;}
		}
	}

	public static void main(String[] args) {
		new Frame();
	}
}

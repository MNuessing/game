package Anzeige;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GebaeudeInfoAnzeige {

	public GebaeudeInfoAnzeige(JButton btnErstesGebaeude) {
		JFrame gebaeudePopUp = new JFrame (btnErstesGebaeude.getText());
		inhaltAnzeigen();
		gebaeudePopUp.pack(); //passt Ränder an das Fenster an
		gebaeudePopUp.setVisible(true);
	}

	private void inhaltAnzeigen() {
		
		
	}
	
}

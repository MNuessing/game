package Anzeige;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import laenderVerwaltung.ILand;
import laenderVerwaltung.IWeltkarte;
import laenderVerwaltung.Land;
import laenderVerwaltung.Weltkarte;

public class WeltkarteAnzeige implements IWeltkarteAnzeige {
	final JPanel panel;
	final IWeltkarte weltkarte;
	final JLabel jlb_name;
	
	public WeltkarteAnzeige(JPanel panel, int breite, int hoehe) {
		this.panel = panel;
		weltkarte = new Weltkarte(generateLaender(breite, hoehe));
		generateButtons(breite, hoehe);
		jlb_name = new JLabel();
	}

	private void generateButtons(int breite, int hoehe) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				String adsf = "Nooooooooooo";
				final int ii = i;
				final int jj = j;
				JButton btnNewButton = new JButton("New button "+i+" "+j);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jlb_name.setText(ii+" "+jj);
					}
				});
				
				
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 0);
				gbc_btnNewButton.gridx = i;
				gbc_btnNewButton.gridy = j;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
		}
	}

	private List<ILand> generateLaender(int breite, int hoehe) {
		final List<ILand> laender = new ArrayList<ILand>();
		for(int i = 0; i < breite; i++) {
			for(int j = 0; j < hoehe; j++) {
				laender.add(new Land(i+" "+j, null));
			}
		}
		return laender;
	}
	
	public void generateInfos(JPanel panelInfo) {
		int y = 0; // y-Position for grid
		{
			JLabel lblNameDesLandes = new JLabel("Name Des Aktuellen Landes:");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 0;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = jlb_name;
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 1;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude:");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 2;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude 1");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.anchor = GridBagConstraints.NORTH;
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 3;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude 2");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 4;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		} 
		{
			JLabel lblNameDesLandes = new JLabel("eigene Truppen");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 0, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = 5;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
	}
}

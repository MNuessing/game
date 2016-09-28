package Anzeige;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Spielerverwaltung.ASpieler;
import Spielerverwaltung.Bot;
import laenderVerwaltung.ILand;
import laenderVerwaltung.IWeltkarte;
import laenderVerwaltung.Land;
import laenderVerwaltung.Weltkarte;

public class WeltkarteAnzeige implements IWeltkarteAnzeige {
	final private JPanel panel;
	private JPanel panelInfo;
	final private IWeltkarte weltkarte;
	final private ASpieler spieler;
	private ILand aktuellesLand;
	
	public WeltkarteAnzeige(JPanel panel, IWeltkarte weltkarte, ASpieler spieler) {
		this.panel = panel;
		this.weltkarte = weltkarte; 
		this.spieler = spieler;
		aktuellesLand = new Land("", 0);
		generateButtons();
	}

	private void generateButtons() {
		for(int i = 0; i < weltkarte.getBreite(); i++) {
			for(int j = 0; j < weltkarte.getHoehe(); j++) {
				final ILand land = weltkarte.getLand(i, j);
				JButton btnNewButton = new JButton(land.toString());
				if(land.getSpieler() == spieler || land.nachbarlaenderHatSpieler(spieler)){
					
					if(land.getSpieler() == spieler)
						btnNewButton.setBackground(Color.RED);
					else if(land.getSpieler() instanceof Bot)
						btnNewButton.setBackground(Color.GRAY);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							aktuellesLand = land;
							generateInfos(panelInfo);
						}
					});
				}
				else {
					btnNewButton.disable();;
					btnNewButton.setBackground(Color.BLACK);
				}
				
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 0);
				gbc_btnNewButton.gridx = i;
				gbc_btnNewButton.gridy = j;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
		}
	}
	
	public void generateInfos(JPanel panelInfo) {
		int y = 0; // y-Position for grid
		this.panelInfo = panelInfo;
		{	//Landname
			JLabel lblNameDesLandes = new JLabel("Name Des Aktuellen Landes:");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel(aktuellesLand.toString());
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		

		{	//Spieler
			JLabel lblNameDesSpielers;
			if (aktuellesLand != null && aktuellesLand.getSpieler() != null){
				lblNameDesSpielers = new JLabel(aktuellesLand.getSpieler().toString());
			} else {
				lblNameDesSpielers = new JLabel("");
			}
			GridBagConstraints gbc_lblNameDesSpielers = new GridBagConstraints();
			gbc_lblNameDesSpielers.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesSpielers.gridx = 0;
			gbc_lblNameDesSpielers.gridy = y++;
			panelInfo.add(lblNameDesSpielers, gbc_lblNameDesSpielers);
		}
		
		{	//Gebaeude
			JLabel lblNameDesGebaeudes = new JLabel("Gebaeude:");
			GridBagConstraints gbc_lblNameDesGebaeudes = new GridBagConstraints();
			gbc_lblNameDesGebaeudes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesGebaeudes.gridx = 0;
			gbc_lblNameDesGebaeudes.gridy = y++;
			panelInfo.add(lblNameDesGebaeudes, gbc_lblNameDesGebaeudes);
		}
		for(int i = 0; i < aktuellesLand.getGebaeude().getGebaeudeAnzahl(); i++)
		{	// Ein Button für ein freien Gebäudeplatz
			JButton btnGebaeude = new JButton(aktuellesLand.getGebaeude().getGebaeude(i).getInfo().getName());
			GridBagConstraints gbc_btnGebaeude = new GridBagConstraints();
			gbc_btnGebaeude.anchor = GridBagConstraints.NORTH;
			gbc_btnGebaeude.insets = new Insets(0, 0, 5, 5);
			gbc_btnGebaeude.gridx = 0;
			gbc_btnGebaeude.gridy = y++;
			panelInfo.add(btnGebaeude, gbc_btnGebaeude);
			btnGebaeude.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new GebaeudeInfoAnzeige(btnGebaeude);				
				}
			});
		}
		{	//Truppe
			JLabel lblEigeneTruppen = new JLabel("eigene Truppen");
			GridBagConstraints gbc_lblEigeneTruppen = new GridBagConstraints();
			gbc_lblEigeneTruppen.insets = new Insets(0, 0, 0, 5);
			gbc_lblEigeneTruppen.gridx = 0;
			gbc_lblEigeneTruppen.gridy = y++;
			panelInfo.add(lblEigeneTruppen, gbc_lblEigeneTruppen);
		}
	}
}

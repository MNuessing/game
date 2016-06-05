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
	
	public WeltkarteAnzeige(JPanel panel, IWeltkarte weltkarte) {
		this.panel = panel;
		jlb_name = new JLabel();
		this.weltkarte = weltkarte; 
		generateButtons();
		
	}

	private void generateButtons() {
		for(int i = 0; i < weltkarte.getBreite(); i++) {
			for(int j = 0; j < weltkarte.getHoehe(); j++) {
				final ILand land = weltkarte.getLand(i, j);
				JButton btnNewButton = new JButton(land.toString());
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jlb_name.setText(land.toString());
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
	
	public void generateInfos(JPanel panelInfo) {
		int y = 0; // y-Position for grid
		{
			JLabel lblNameDesLandes = new JLabel("Name Des Aktuellen Landes:");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = jlb_name;
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude:");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude 1");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.anchor = GridBagConstraints.NORTH;
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
		{
			JLabel lblNameDesLandes = new JLabel("Gebaeude 2");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		} 
		{
			JLabel lblNameDesLandes = new JLabel("eigene Truppen");
			GridBagConstraints gbc_lblNameDesLandes = new GridBagConstraints();
			gbc_lblNameDesLandes.insets = new Insets(0, 0, 0, 5);
			gbc_lblNameDesLandes.gridx = 0;
			gbc_lblNameDesLandes.gridy = y++;
			panelInfo.add(lblNameDesLandes, gbc_lblNameDesLandes);
		}
	}
}

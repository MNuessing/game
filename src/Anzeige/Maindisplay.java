package Anzeige;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import Spielerverwaltung.ASpieler;
import laenderVerwaltung.IWeltkarte;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Maindisplay implements IMaindisplay {
	final private JFrame frame;
	final private IWeltkarte weltkarte;
	final private ASpieler spieler;
	
	public Maindisplay(IWeltkarte weltkarte, ASpieler spieler) {
		this.weltkarte = weltkarte;
		this.spieler = spieler;
		frame = new JFrame(spieler.toString());
		display();
	}

	private void display() {
		generateToolbar();
		final IWeltkarteAnzeige weltkarte = generateMain();
		generateLandinfos(weltkarte);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*private void generateSpielerinfos() {
		final JPanel panelSpielerinfos = new JPanel();
		frame.getContentPane().add(panelSpielerinfos, BorderLayout.SOUTH);
		
		GridLayout gbl_panel_spielerinfos = new Gridlayout();
	} */

	private IWeltkarteAnzeige generateMain() {
		final JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
		
		GridLayout gbl_panel_1 = new GridLayout(5,5);
		panelMain.setLayout(gbl_panel_1);
		
		
		return generateButtons(panelMain);
	}

	private IWeltkarteAnzeige generateButtons(JPanel panel_1) {
		return new WeltkarteAnzeige(panel_1, weltkarte, spieler);
	}

	private void generateLandinfos(IWeltkarteAnzeige weltkarte) {
		JPanel panelInfo = new JPanel();
		frame.getContentPane().add(panelInfo, BorderLayout.EAST);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 10};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 10};
		gbl_panel_1.columnWeights = new double[]{10.0, 10.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panelInfo.setLayout(gbl_panel_1);
		
		
		weltkarte.generateInfos(panelInfo);
	}

	private void generateToolbar() {
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
	}
	
}

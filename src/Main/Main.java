package Main;

import Anzeige.Maindisplay;
import Spielerverwaltung.ASpieler;
import Spielerverwaltung.ISpielerliste;
import Spielerverwaltung.Spieler;
import Spielerverwaltung.Spielerliste;
import laenderVerwaltung.IWeltkarte;
import laenderVerwaltung.Weltkarte;

public class Main {
	public static void main(String args[]) {
		//spieler erzeugen
		ISpielerliste spielerliste = new Spielerliste();
		spielerliste.addSpieler(new Spieler("Kewinn"));
		spielerliste.addSpieler(new Spieler("Pascal"));
		
		//karte erzeugen
		IWeltkarte weltkarte = new Weltkarte(5, 5);
		weltkarte.addSpieler(spielerliste);
		
		if (spielerliste.anzSpieler()>1){
			ASpieler spieler = spielerliste.getAktuellerSpieler();
			new Maindisplay(weltkarte, spieler);
		}	
		
		
	}
}

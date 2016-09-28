package laenderVerwaltung;

import javax.swing.Icon;

import Gebaeude.IGebaeude;
import Spielerverwaltung.ASpieler;

public interface ILand {
	
	public String toString();

	public ASpieler getSpieler();

	public void setSpieler(ASpieler aktuellerSpieler);

	public boolean istNachbarland(ILand land);
	
	public void addNachbarland(ILand land);

	public boolean nachbarlaenderHatSpieler(ASpieler spieler);

	public IGebaeude getGebaeude();

}

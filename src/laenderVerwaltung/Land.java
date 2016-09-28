package laenderVerwaltung;

import Gebaeude.IGebaeude;
import Spielerverwaltung.ASpieler;

public class Land implements ILand{
	final private ILandeigenschaften landeigenschaften;
	final private INachbarlaender nachbarlaender;
	private ASpieler besitzer;
	
	public Land(String name, int anzahlGebaeude) {
		landeigenschaften = new Landeigenschaften(name, anzahlGebaeude);
		this.besitzer = null;
		nachbarlaender = new Nachbarlaender();
	}
	public String toString() {
		return landeigenschaften.toString();
	}
	@Override
	public ASpieler getSpieler() {
		return besitzer;
	}
	@Override
	public void setSpieler(ASpieler aktuellerSpieler) {
		besitzer = aktuellerSpieler;
	}
	@Override
	public boolean istNachbarland(ILand land) {
		return nachbarlaender.istNachbarland(land);
	}
	@Override
	public void addNachbarland(ILand land) {
		nachbarlaender.addLand(land);
	}
	@Override
	public boolean nachbarlaenderHatSpieler(ASpieler spieler) {
		return nachbarlaender.hatSpieler(spieler);
		
	}
	@Override
	public IGebaeude getGebaeude() {
		return landeigenschaften.getGebaeude();
	}
	
}

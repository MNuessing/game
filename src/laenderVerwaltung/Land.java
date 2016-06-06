package laenderVerwaltung;

import Spielerverwaltung.ISpieler;

public class Land implements ILand{
	final private ILandeigenschaften landeigenschaften;
	final private INachbarlaender nachbarlaender = null;
	private ISpieler besitzer;
	
	public Land(String name) {
		landeigenschaften = new Landeigenschaften(name);
		this.besitzer = null;
	}
	public String toString() {
		return landeigenschaften.toString();
	}
	@Override
	public ISpieler getSpieler() {
		return besitzer;
	}
	@Override
	public void setSpieler(ISpieler aktuellerSpieler) {
		besitzer = aktuellerSpieler;
	}
	
}

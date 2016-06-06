package laenderVerwaltung;

import Spielerverwaltung.ISpieler;

public interface ILand {
	
	public String toString();

	public ISpieler getSpieler();

	public void setSpieler(ISpieler aktuellerSpieler);

}

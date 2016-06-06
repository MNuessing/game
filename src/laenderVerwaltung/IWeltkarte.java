package laenderVerwaltung;

import Spielerverwaltung.ISpielerliste;

public interface IWeltkarte {

	public int getHoehe();

	public int getBreite();

	public ILand getLand(int breite, int hoehe);

	public void addSpieler(ISpielerliste spielerliste);

}

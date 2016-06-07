package Spielerverwaltung;

public interface ISpielerliste {

	public boolean addSpieler(ASpieler spieler);
	public ASpieler getAktuellerSpieler();
	public int anzSpieler(); 
	
}

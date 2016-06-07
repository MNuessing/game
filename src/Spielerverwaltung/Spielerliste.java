package Spielerverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Spielerliste implements ISpielerliste{
	private int spielerindex;
	private final List<ASpieler> liste;
	
	public Spielerliste() {
		spielerindex = 0; 
		liste = new ArrayList<ASpieler>();
	}
	
	@Override
	public boolean addSpieler(ASpieler spieler) {
		return liste.add(spieler);
		
	}

	@Override
	public ASpieler getAktuellerSpieler() {
		if (spielerindex >= liste.size())
			spielerindex = 0;
		return liste.get(spielerindex++);
	}

	@Override
	public int anzSpieler() {
		return liste.size();
	}
}

package Spielerverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Spielerliste implements ISpielerliste{
	private int spielerindex;
	private final List<ISpieler> liste;
	
	public Spielerliste() {
		spielerindex = 0; 
		liste = new ArrayList<ISpieler>();
	}
	
	@Override
	public boolean addSpieler(ISpieler spieler) {
		return liste.add(spieler);
		
	}

	@Override
	public ISpieler getAktuellerSpieler() {
		if (spielerindex >= liste.size())
			spielerindex = 0;
		return liste.get(spielerindex++);
	}
}

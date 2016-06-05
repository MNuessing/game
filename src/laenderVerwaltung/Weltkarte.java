package laenderVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class Weltkarte implements IWeltkarte {
	final private List<ILand> laender;
	private final int breite;
	private final int hoehe;
	
	public Weltkarte(int breite, int hoehe){
		this.breite = breite;
		this.hoehe = hoehe;		
		laender = generateLaender();

	}
	
	private List<ILand> generateLaender() {
		final List<ILand> laenderliste = new ArrayList<ILand>();
		for(int i = 0; i < hoehe; i++)
			for(int j=0; j < breite; j++)
				laenderliste.add(new Land(i+" " +j));
		
		return laenderliste;
	}

	@Override
	public int getHoehe() {
		return hoehe;
	}

	@Override
	public int getBreite() {
		return breite;
	}

	@Override
	public ILand getLand(int breite, int hoehe) {
		return laender.get(this.hoehe*hoehe+breite);
	}
}

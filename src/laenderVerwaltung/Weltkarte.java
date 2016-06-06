package laenderVerwaltung;

import java.util.ArrayList;
import java.util.List;

import Spielerverwaltung.Bot;
import Spielerverwaltung.ISpielerliste;

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

	@Override
	public void addSpieler(ISpielerliste spielerliste) {
		for(int i = 0; i < spielerliste.anzSpieler(); i++) {
			int zufall = (int) (Math.random() * laender.size());
			int j = 0;
			while(laender.get(zufall).getSpieler() != null || j > laender.size()) { //Land hat noch kein Spieler
				zufall = (zufall + 1) % laender.size();
				j++;
			}
			
			laender.get(zufall).setSpieler(spielerliste.getAktuellerSpieler());
		}
		
		for(ILand each: laender) {
			if(each.getSpieler() == null) {
				each.setSpieler(new Bot());
			}
		}
	}
}

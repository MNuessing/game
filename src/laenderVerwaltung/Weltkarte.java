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
		setNachbarlaender();
	}
	
	private void setNachbarlaender() {
		for(int i = 0; i < hoehe; i++){
			for(int j = 0; j < breite; j++){
				ILand land = laender.get(i*hoehe+j);
				if(i-1 >= 0)
					land.addNachbarland(laender.get((i-1)*hoehe+j));							
			   	if(i+1 <= 4)
			   		land.addNachbarland(laender.get((i+1)*hoehe+j));
				if(j-1 >= 0)
					land.addNachbarland(laender.get((i)*hoehe+(j-1)));							
			   	if(j+1 <= 4)
			   		land.addNachbarland(laender.get((i)*hoehe+(j+1)));
			}   		
		}
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

package laenderVerwaltung;

import Armee.Armee;
import Armee.IArmee;
import Gebaeude.Gebaeude;
import Gebaeude.IGebaeude;

public class Landeigenschaften implements ILandeigenschaften {
	final private String name;
	final private IArmee truppen;
	final private IArmee ankommendeTruppen;
	final private IGebaeude gebaeude;
	
	public Landeigenschaften(String name) {
		this.name = name;
		truppen = new Armee();
		ankommendeTruppen = new Armee();
		gebaeude = new Gebaeude();
	}
	
	public String toString(){
		return name;
	}
}

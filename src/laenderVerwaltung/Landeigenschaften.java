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
	
	public Landeigenschaften(String name, int anzahlGebaeude) {
		this.name = name;
		truppen = new Armee();
		ankommendeTruppen = new Armee();
		gebaeude = new Gebaeude(anzahlGebaeude);
	}
	
	public String toString(){
		return name;
	}

	@Override
	public IGebaeude getGebaeude() {
		return gebaeude;
	}
}

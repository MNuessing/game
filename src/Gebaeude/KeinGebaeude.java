package Gebaeude;

import java.awt.Image;

public class KeinGebaeude extends GebaeudeArt{
	KeinGebaeude(){
		super();
		String name = "Freier Geb�udeplatz";
		String beschreibung = "Ein Platz, der zum Bebauen einl�dt.";
		Image bild = null;
		this.getInfo().initialise(name, beschreibung, bild);
	}
}

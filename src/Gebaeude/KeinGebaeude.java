package Gebaeude;

import java.awt.Image;

public class KeinGebaeude extends GebaeudeArt{
	KeinGebaeude(){
		super();
		String name = "Freier Gebäudeplatz";
		String beschreibung = "Ein Platz, der zum Bebauen einlädt.";
		Image bild = null;
		this.getInfo().initialise(name, beschreibung, bild);
	}
}

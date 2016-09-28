package Gebaeude;

import java.awt.Image;

public class GebaeudeInfo {
	String name;
	String beschreibung;
	Image bild;
	public void initialise(String name, String beschreibung, Image bild) {
		if (this.name != null || name == null){
			return;
		} else {
			this.name = name;
			this.beschreibung = beschreibung;
			this.bild = bild;
		}
		
	}
	public String getName(){
		return name;
	}
	public String getBeschreibung(){
		return beschreibung;
	}
	public Image getBild(){
		return bild;
	}
}

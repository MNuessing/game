package Spielerverwaltung;

import java.util.ArrayList;
import java.util.List;

import Gebaeude.GebaeudeArt;

public abstract class ASpieler {
	
	private final String name;
	private final IMoral moral;
	private final IRohstoff vorhandeneRohstoffe;
	private final ITruppenstaerke truppenbonus;
	private final List<GebaeudeArt> gebaeudeliste;
	
	public ASpieler(String name) {
		this.name = name;
		moral = new Moral();
		vorhandeneRohstoffe = new Rohstoff();
		truppenbonus = new Truppenstaerke();
		gebaeudeliste = new ArrayList<GebaeudeArt>();
	}
	
	public String toString(){
		return name;
	}

	public boolean addGebaeude(GebaeudeArt gebaeude) {
		return gebaeudeliste.add(gebaeude);
	}
	
}

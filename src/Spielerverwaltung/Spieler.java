package Spielerverwaltung;

public class Spieler implements ISpieler {
	private final String name;
	private final IMoral moral;
	private final IRohstoff vorhandeneRohstoffe;
	private final ITruppenstaerke truppenbonus;
	public Spieler(String name) {
		this.name = name;
		moral = new Moral();
		vorhandeneRohstoffe = new Rohstoff();
		truppenbonus = new Truppenstaerke();
	}
	
	public String toString(){
		return name;
	}
	
}

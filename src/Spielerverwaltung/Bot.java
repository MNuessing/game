package Spielerverwaltung;

public class Bot implements ISpieler {
	private final String name;
	private final IMoral moral;
	private final IRohstoff vorhandeneRohstoffe;
	private final ITruppenstaerke truppenbonus;
	
	public Bot() {
		this.name = "Bot";
		moral = new Moral();
		vorhandeneRohstoffe = new Rohstoff();
		truppenbonus = new Truppenstaerke();
	}
	
	public String toString(){
		return name;
	}
}

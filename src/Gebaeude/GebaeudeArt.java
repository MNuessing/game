package Gebaeude;

public abstract class GebaeudeArt {
	private static GebaeudeInfo info;
	public GebaeudeArt(){
		info = new GebaeudeInfo();
	}
	static public GebaeudeInfo getInfo() {
		return info;
	}
}

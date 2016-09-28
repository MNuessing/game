package Gebaeude;

import java.util.ArrayList;

public class Gebaeude implements IGebaeude{
	private GebaeudeArt[] art = null;

	public Gebaeude(int anzahl) {
		art = new GebaeudeArt[anzahl];
		for (int i = 0; i < anzahl; i++){
			art[i] = new KeinGebaeude();
		}
	}
	@Override
	public ArrayList<GebaeudeInfo> getGeneralGebaeudeInfos(){
		ArrayList<GebaeudeInfo> infos = new ArrayList<GebaeudeInfo>();
		infos.add(Festung.getInfo());
		infos.add(Kaserne.getInfo());
		infos.add(Miene.getInfo());
		infos.add(Monument.getInfo());
		infos.add(Schmiede.getInfo());	
		return infos; 
	}
	@Override
	public GebaeudeArt getGebaeude(int index){
		return art[index];
	}

	@Override
	public int getGebaeudeAnzahl() {
		return art.length;
	}
	
}

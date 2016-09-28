package Gebaeude;

import java.util.ArrayList;

public interface IGebaeude {
	
	public ArrayList<GebaeudeInfo> getGeneralGebaeudeInfos();
	public GebaeudeArt getGebaeude(int index);
	public int getGebaeudeAnzahl();
}

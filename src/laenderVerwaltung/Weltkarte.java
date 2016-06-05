package laenderVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class Weltkarte implements IWeltkarte {
	final private List<ILand> laender;
	
	public Weltkarte(List<ILand> laender) {
		this.laender = laender;
	}
	
	public void addLand(ILand land) {
		laender.add(land);
	}
}

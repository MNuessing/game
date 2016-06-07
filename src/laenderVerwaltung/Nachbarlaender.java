package laenderVerwaltung;

import java.util.ArrayList;
import java.util.List;

import Spielerverwaltung.ASpieler;

public class Nachbarlaender implements INachbarlaender{
	final private List<ILand> nachbarlaender;
	
	Nachbarlaender() {
		nachbarlaender = new ArrayList<ILand>();
	}

	@Override
	public boolean istNachbarland(ILand land) {
		return nachbarlaender.contains(land);
	}

	@Override
	public void addLand(ILand land) {
		nachbarlaender.add(land);
		
	}

	@Override
	public boolean hatSpieler(ASpieler spieler) {
		for(ILand each: nachbarlaender){
			if(each.getSpieler() == spieler)
				return true; 
		}
		return false;
	}
}
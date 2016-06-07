package laenderVerwaltung;

import Spielerverwaltung.ASpieler;

public interface INachbarlaender {

	public boolean istNachbarland(ILand land);

	public void addLand(ILand land);

	public boolean hatSpieler(ASpieler spieler);

}

package laenderVerwaltung;

public class Land implements ILand{
	final private ILandeigenschaften landeigenschaften;
	final private INachbarlaender nachbarlaender = null;
	final private ISpieler besitzer;
	
	public Land(String name, ISpieler besitzer) {
		landeigenschaften = new Landeigenschaften(name);
		this.besitzer = besitzer;
	}
	
}

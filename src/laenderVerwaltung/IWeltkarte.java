package laenderVerwaltung;

public interface IWeltkarte {

	public int getHoehe();

	public int getBreite();

	public ILand getLand(int breite, int hoehe);

}

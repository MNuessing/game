package laenderVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class Nachbarlaender implements INachbarlaender{
	final private List<Land> nachbarlaender;
	
	Nachbarlaender() {
		nachbarlaender = new ArrayList<Land>();
	}
}

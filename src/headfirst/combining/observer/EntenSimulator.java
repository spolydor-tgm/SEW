package headfirst.combining.observer;

public class EntenSimulator {

	public static void main(String[] args) {
		EntenSimulator simulator = new EntenSimulator();
		AbstrakteEntenFabrik entenFabrik = new ZaehlendeEntenFabrik();
 
		simulator.simulieren(entenFabrik);
	}

	/**
	 * simuliert den Ablauf
	 * @param entenfabrik neue EntenFabrik
	 */
	void simulieren(AbstrakteEntenFabrik entenfabrik) {

		// Erzeugt verschiedene Enten
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		Quakfaehig gansEnte = new GansAdapter(new Gans());

		// Erzeugt eine neue Schar
		Schar EntenSchar = new Schar();

		// Fuegt alle oben erstellten Enten der EntenSchar hinzu
		EntenSchar.hinzufuegen(moorEnte);
		EntenSchar.hinzufuegen(lockPfeife);
		EntenSchar.hinzufuegen(gummiEnte);
		EntenSchar.hinzufuegen(gansEnte);

		// Erzeugt eine neue Schar
		Schar stockEntenSchar = new Schar();

		// Erzeugt 4 neue StockEnten
		Quakfaehig stockEnte1 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte2 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte3 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte4 = entenfabrik.erzeugeStockEnte();

		// Fuegt alle 4 erzeugten StockEnten der Schar fuer Stockenten hinzu
		stockEntenSchar.hinzufuegen(stockEnte1);
		stockEntenSchar.hinzufuegen(stockEnte2);
		stockEntenSchar.hinzufuegen(stockEnte3);
		stockEntenSchar.hinzufuegen(stockEnte4);

		// Fuegt der EntenSchar die stockEntenSchar hinu
		EntenSchar.hinzufuegen(stockEntenSchar);

		System.out.println("\nEntensimulator: mit Observer");

		// Erzeugt einen neuen Quakologen und fuegt diesen der EntenSchar hinzu
		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		// Laesst alle enten in der Schar quaken
		simulieren(EntenSchar);

		// Gibt die Anzahl der Quaks aus
		System.out.println("\nDie Enten haben " + 
		                   QuakZaehler.getQuaks() + 
		                   "-mal gequakt.");
	}

	/**
	 * Laesst Ente quaken
	 * @param ente die quaken soll
	 */
	void simulieren(Quakfaehig ente) {
		ente.quaken();
	}
}
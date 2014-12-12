package headfirst.combining.observer;

public class EntenSimulator {
	public static void main(String[] args) {
		EntenSimulator simulator = new EntenSimulator();
		AbstrakteEntenFabrik entenFabrik = new ZaehlendeEntenFabrik();
 
		simulator.simulieren(entenFabrik);
	}

	void simulieren(AbstrakteEntenFabrik entenfabrik) {
  
		Quakfaehig moorEnte = entenfabrik.erzeugeMoorEnte();
		Quakfaehig lockPfeife = entenfabrik.erzeugeLockPfeife();
		Quakfaehig gummiEnte = entenfabrik.erzeugeGummiEnte();
		Quakfaehig gansEnte = new GansAdapter(new Gans());
 
		Schar EntenSchar = new Schar();
 
		EntenSchar.hinzufuegen(moorEnte);
		EntenSchar.hinzufuegen(lockPfeife);
		EntenSchar.hinzufuegen(gummiEnte);
		EntenSchar.hinzufuegen(gansEnte);
 
		Schar stockEntenSchar = new Schar();
 
		Quakfaehig stockEnte1 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte2 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte3 = entenfabrik.erzeugeStockEnte();
		Quakfaehig stockEnte4 = entenfabrik.erzeugeStockEnte();

		stockEntenSchar.hinzufuegen(stockEnte1);
		stockEntenSchar.hinzufuegen(stockEnte2);
		stockEntenSchar.hinzufuegen(stockEnte3);
		stockEntenSchar.hinzufuegen(stockEnte4);

		EntenSchar.hinzufuegen(stockEntenSchar);

		System.out.println("\nEntensimulator: mit Observer");

		Quakologe quakologe = new Quakologe();
		EntenSchar.registriereBeobachter(quakologe);

		simulieren(EntenSchar);

		System.out.println("\nDie Enten haben " + 
		                   QuakZaehler.getQuaks() + 
		                   "-mal gequakt.");
	}
 
	void simulieren(Quakfaehig ente) {
		ente.quaken();
	}
}

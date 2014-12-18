package headfirst.combining.observer;

public class ZaehlendeEntenFabrik extends AbstrakteEntenFabrik {

	/**
	 * Erzeugt eine neuen Quackzaehler fuer eine Stockente
	 * @return gibt eine neuen Quackzaehler fuer eine Stockente zurueck
	 */
	public Quakfaehig erzeugeStockEnte() {
		return new QuakZaehler(new StockEnte());
	}

	/**
	 * Erzeugt eine neuen Quackzaehler fuer eine Moorente
	 * @return gibt eine neuen Quackzaehler fuer eine Moorente zurueck
	 */
	public Quakfaehig erzeugeMoorEnte() {
		return new QuakZaehler(new MoorEnte());
	}

	/**
	 * Erzeugt eine neuen Quackzaehler fuer eine Lockpfeife
	 * @return gibt eine neuen Quackzaehler fuer eine Lockpfeife zurueck
	 */
	public Quakfaehig erzeugeLockPfeife() {
		return new QuakZaehler(new LockPfeife());
	}

	/**
	 * Erzeugt eine neuen Quackzaehler fuer eine Gummiente
	 * @return gibt eine neuen Quackzaehler fuer eine Gummiente zurueck
	 */
	public Quakfaehig erzeugeGummiEnte() {
		return new QuakZaehler(new GummiEnte());
	}
}

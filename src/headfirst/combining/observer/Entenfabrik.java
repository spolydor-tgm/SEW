package headfirst.combining.observer;

public class Entenfabrik extends AbstrakteEntenFabrik {

	/**
	 * Erzeugt eine neue Stockente
	 * @return gibt eine neue Stockente zurueck
	 */
	public Quakfaehig erzeugeStockEnte() {
		return new StockEnte();
	}

	/**
	 * Erzeugt eine neue Moorente
	 * @return gibt eine neue Moorente zurueck
	 */
	public Quakfaehig erzeugeMoorEnte() {
		return new MoorEnte();
	}

	/**
	 * Erzeugt eine neue Lockpfeife
	 * @return gibt eine neue Lockpfeife zurueck
	 */
	public Quakfaehig erzeugeLockPfeife() {
		return new LockPfeife();
	}

	/**
	 * Erzeugt eine neue Gummiente
	 * @return gibt eine neue Gummiente zurueck
	 */
	public Quakfaehig erzeugeGummiEnte() {
		return new GummiEnte();
	}
}

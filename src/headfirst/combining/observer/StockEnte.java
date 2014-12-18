package headfirst.combining.observer;

public class StockEnte implements Quakfaehig {

	SenderRing senderRing;

	/**
	 * Erzeugt eine neue Stockente und speichert diese in einen SenderRing
	 */
	public StockEnte() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Gibt "Quak" aus.
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void quaken() {
		System.out.println("Quak");
		benachrichtigeBeobachtende();
	}

	/**
	 * Speichert einen neuen Beobachter zu den bereits existierenden hinzu
	 * @param beobachter der gespeichert werden soll
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		senderRing.registriereBeobachter(beobachter);
	}

	/**
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void benachrichtigeBeobachtende() {
		senderRing.benachrichtigeBeobachtende();
	}

	/**
	 * @return Stockente gibt die Stockente als String zurueck ("Stockente")
	 */
	public String toString() {
		return "Stockente";
	}
}

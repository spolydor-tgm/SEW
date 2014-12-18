package headfirst.combining.observer;

public class MoorEnte implements Quakfaehig {

	SenderRing senderRing;

	/**
	 * Erzeugt eine neue Moorente und speichert diese in einen SenderRing
	 */
	public MoorEnte() {
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
	 * @return Moorente gibt die Moorente als String zurueck ("Moorente")
	 */
	public String toString() {
		return "Moorente";
	}
}

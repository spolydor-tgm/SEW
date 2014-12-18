package headfirst.combining.observer;

public class GummiEnte implements Quakfaehig {

	SenderRing senderRing;

	/**
	 * Erzeugt eine neue Gummiente und speichert diese in einen SenderRing
	 */
	public GummiEnte() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Gibt "Quietsch" aus.
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void quaken() {
		System.out.println("Quietsch");
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
	 * @return Gummiente gibt die Gummiente als String zurueck ("Gummiente")
	 */
	public String toString() {
		return "Gummiente";
	}
}

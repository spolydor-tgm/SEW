package headfirst.combining.observer;

public class LockPfeife implements Quakfaehig {

	SenderRing senderRing;

	/**
	 * Erzeugt eine neue Lockpfeife und speichert diese in einen SenderRing
	 */
	public LockPfeife() {
		senderRing = new SenderRing(this);
	}

	/**
	 * Gibt "Kwaak" aus.
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void quaken() {
		System.out.println("Kwaak");
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
	 * @return Lockpfeife gibt die Lockpfeife als String zurueck ("Lockpfeife")
	 */
	public String toString() {
		return "Lockpfeife";
	}
}

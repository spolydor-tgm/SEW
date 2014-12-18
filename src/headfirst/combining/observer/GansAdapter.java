package headfirst.combining.observer;

public class GansAdapter implements Quakfaehig {

	Gans gans;
	SenderRing senderRing;

	/**
	 * Erweitert die Funktionalitaeten der Gans. Dadurch kann sie alle Methoden, welche die anderen Enten beherschen.
	 * Speichert eine gans ab und fuegt sie einem SenderRing hinzu.
	 * @param gans die gespeichert werden soll
	 */
	public GansAdapter(Gans gans) {
		this.gans = gans;
		senderRing = new SenderRing(this);
	}

	/**
	 * Laesst die Gans schnattern und diese Methode gibt "Schnatter" aus.
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void quaken() {
		gans.schnattern();
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
	 * Gibt den GansAdapter als String zurueck
	 * @return "sich als Ente ausgebende Gans" zurueck
	 */
	public String toString() {
		return "sich als Ente ausgebende Gans";
	}
}

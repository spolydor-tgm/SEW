package headfirst.combining.observer;

public class QuakZaehler implements Quakfaehig {

	Quakfaehig ente;
	static int anzahlDerQuaks;

	/**
	 * Zaehlt die Quacks fuer eine Ente
	 * @param ente fuer die die Quackanzahl gezaehlt werden soll
	 */
	public QuakZaehler(Quakfaehig ente) {
		this.ente = ente;
	}

	/**
	 * Laesst die Ente quaken und zaehlt einen Quack dazu
	 */
	public void quaken() {
		ente.quaken();
		anzahlDerQuaks++;
	}

	/**
	 * @return anzahlDerQuaks zurueck
	 */
	public static int getQuaks() {
		return anzahlDerQuaks;
	}

	/**
	 * Speichert einen neuen Beobachter zu den bereits existierenden der Ente hinzu
	 * @param beobachter der gespeichert werden soll
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		ente.registriereBeobachter(beobachter);
	}

	/**
	 * Benachrichtigt alle registrierten Beobachter der Ente
	 */
	public void benachrichtigeBeobachtende() {
		ente.benachrichtigeBeobachtende();
	}

	/**
	 * @return den Namen der Ente. ente.toString()
	 */
	public String toString() {
		return ente.toString();
	}
}

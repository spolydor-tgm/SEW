package headfirst.combining.observer;

public class Quakologe implements Beobachter {

	/**
	 * Gibt "Quakologe: " + ente + " hat gerade gequakt." zurueck. Als Ente wird der Parameter ente genommen
	 * @param ente die beobachtet werden soll. Wenn die Ente "quaken()" aufruft
	 */
	public void aktualisieren(QuakBeobachtungsSubjekt ente) {
		System.out.println("Quakologe: " + ente + " hat gerade gequakt.");
	}

	/**
	 * @return "Quakologe" zurueck
	 */
	public String toString() {
		return "Quakologe";
	}
}

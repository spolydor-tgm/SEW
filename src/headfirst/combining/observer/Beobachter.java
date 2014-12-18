package headfirst.combining.observer;

public interface Beobachter {

	/**
	 * Stellt die Methode "aktualisieren(QuackBeobachtungsSubjekt ente" allen Klassen bereit, welche Beobachter implementieren
	 * @param ente die beobachtet werden soll. Wenn die Ente "quaken()" aufruft
	 */
	public void aktualisieren(QuakBeobachtungsSubjekt ente);
}

package headfirst.combining.observer;

public interface QuakBeobachtungsSubjekt {

	/**
	 * Stellt die Methode "registriereBeobachter(Beobachter beobachter)" allen Klassen bereit, welche QuakBeobachtungsSubjekt implementieren
	 * @param beobachter der zum Beobachten registriert wird
	 */
	public void registriereBeobachter(Beobachter beobachter);

	/**
	 * Stellt die Methode "benachrichtigeBeobachtende()" allen Klassen bereit, welche registriert sind
	 */
	public void benachrichtigeBeobachtende();
}

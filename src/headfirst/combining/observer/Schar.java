package headfirst.combining.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Schar implements Quakfaehig {

	ArrayList quakende = new ArrayList();

	/**
	 * Fuegt ein Quakfaehig Objekt in die ArrayList hinzu
	 * @param quaker der hinzugefuegt werden soll
	 */
	public void hinzufuegen(Quakfaehig quaker) {
		quakende.add(quaker);
	}

	/**
	 * Laesst alle gespeicherten Quaker quaken
	 */
	public void quaken() {
		Iterator iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.quaken();
		}
	}

	/**
	 * Fuegt der gespeicherten Ente einen neuen Beobachter hinzu
	 * @param beobachter der hinzugefuegt werden soll
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		Iterator iterator = quakende.iterator();
		while (iterator.hasNext()) {
			Quakfaehig quaker = (Quakfaehig)iterator.next();
			quaker.registriereBeobachter(beobachter);
		}
	}

	/**
	 * Benachrichtigt beobachtende
	 */
	public void benachrichtigeBeobachtende() { }

	/**
	 * @return Entenschar gibt die Entenschar als String zurueck ("Entenschar")
	 */
	public String toString() {
		return "Entenschar";
	}
}

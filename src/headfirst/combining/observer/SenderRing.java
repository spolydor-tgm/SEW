package headfirst.combining.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class SenderRing implements QuakBeobachtungsSubjekt {

	ArrayList beobachtende = new ArrayList();
	QuakBeobachtungsSubjekt ente;

	/**
	 * Speichert die Ente.
	 * @param ente wird in das Attribut ente gespeichert
	 */
	public SenderRing(QuakBeobachtungsSubjekt ente) {
		this.ente = ente;
	}

	/**
	 * Fuegt der gespeicherten Ente einen neuen Beobachter hinzu
	 * @param beobachter der hinzugefuegt werden soll
	 */
	public void registriereBeobachter(Beobachter beobachter) {
		beobachtende.add(beobachter);
	}

	/**
	 * Benachrichtigt alle registrierten Beobachter
	 */
	public void benachrichtigeBeobachtende() {
		Iterator iterator = beobachtende.iterator();
		while (iterator.hasNext()) {
			Beobachter beobachter = (Beobachter)iterator.next();
			beobachter.aktualisieren(ente);
		}
	}

	/**
	 * Gibt einen Iterator zurueck, mit dem durch die ArrayList in der alle Beobachter gespeichert werden, durchgegangen wird.
	 * @return Iterator
	 */
	public Iterator getBeobachtende() {
		return beobachtende.iterator();
	}
}

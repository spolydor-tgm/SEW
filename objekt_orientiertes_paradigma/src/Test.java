/**
 * @author Stefan Polydor on 09.10.14.
 * @version 9.10.2014
 */
public class Test {
	public static void main(String[] args) {
		Auto a = new Auto();
		Audi b = new Audi("R8");
		Spezifikationen c = new Spezifikationen(800, true, true);
		c.setModell("R8 Spyder"); // Modell setzen. Spezifikationen erbt von Audi und kann dadurch auch das Modell festlegen
		if (c.getModell().equals("R8 Spyder"))
			System.out.println(c.getModell());
		Audi d = (Audi) c; // Spezifikationen (erbt von Audi). Cast von der erweiterten Klasse (Spezifikationen) zu Audi
		if (d.getModell().equals("R8 Spyder"))
			System.out.println(d.getModell());

		System.out.println('\n' + "Typanpassung");
		long e = c.getPs(); // int in einen long speichern. Automatischer cast
		System.out.println("int in long speichern (kleinerer Datentyp in groesseren: " + e);
		byte f = (byte) e; // long e wird von der Groesse auf den Datentyp byte verringert (expliziter cast).
		// Verliert dadurch den Wert von 800 und wird auf 32 verringert. Mehr kann byte nicht speichern
		System.out.println("long zu byte cast (long wird verringert von 800 auf 32): " + f);
		c.setPs(800);
		System.out.println("setPs(long) (ueberladene Methode): " + c.getPs());

		System.out.println('\n' + "Universelle Polymorphie");
		System.out.println("Laufzeitpolymorphie");
		/*
		Die Methode soutModell() ist sozusagen vielgestaltig, polymorph.
		Diese Art der an die Vererbung (oder auch an die Implementierung einer Schnittstelle!) gebundene Polymorphie
		heisst auch Einschlusspolymorphie oder Inklusionspolymorphie.
		 */
		b.soutModell(); // Methode von Audi
		Audi g = new Spezifikationen(800, true, true); // In Objekt Audi wird ein Objekt Spezifikationen gespeichert
		g.setModell("R8 Spyder"); // setzen des Modells
		g.soutModell(); // verwendung der Methode von Spezifikationen

		System.out.println('\n' + "Generizitaet");
		/*
		Die Generizitaet wird auch parametrisierte Polymorphie genannt.
		Ein und dieselbe Methode, Klasse, soll fuer Daten verschiedener Typen verwendbar sein.
		Durch den Einsatz von formalen Typparametern wird diese Vielgestaltigkeit erreicht.
		 */
		System.out.println("Generische Klassen + Methoden");
		/**
		 * Der Typparameter wird in spitzen Klammern <E> geschrieben.
		 Bei der Erstellung von Objekten muss der Typ (z.B.: Audi<String>) bekannt gemacht werden. Mithilfe des new-Operators (new Audi<>("RS7 Sportback"))
		 wird ein Wrapper-Objekt mit dem Datentyp String erstellt.
		 */
		Audi<Integer> h = new Audi<>(7); // Speichern eines Integers durch uebergabe beim Konstruktor
		/*
		Audi<String> h = new Audi<>("RS7 Sportback"); // Speichern eines Strings durch uebergabe beim Konstruktor
		Funktioniert nicht. Warum ???
		Bitte um Erklaerung.
		 */
		System.out.printf(h.toString()); // Ausgabe der modellKurzbez
		h.setModellKurzbez(5); // Aendern der modellKurzbez
		System.out.println(h.toString()); // Ausgabe der neuen modellKurzbez
	}
}
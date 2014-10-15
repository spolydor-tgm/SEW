/**
 * @author Stefan Polydor on 09.10.14.
 * @version 9.10.2014
 */
public class Spezifikationen extends Audi {
	private int ps; // PS
	private boolean sportsitze; // Sportsitze, ja oder nein
	private boolean lederSitzbezug; // sitze mit Lederbezug

	/**
	 * Spezifikationen des Audi
	 * @param ps des Modells
	 * @param sportsitze true wenn Sportsitze vorhanden sind, andernfalls false
	 * @param lederSitzbezug true wenn die Sitze mit Leder bezogen sein sollen, andernfalls false
	 */
	public Spezifikationen(int ps, boolean sportsitze, boolean lederSitzbezug) {
		this.setPs(ps);
		this.sportsitze = sportsitze;
		this.lederSitzbezug = lederSitzbezug;
	}

	/**
	 * Ueberschreibt die Methode soutModell() der Klasse Audi
	 * Wird nur bei dem Objekt Spezifikationen verwendet
	 */
	@Override
	public void soutModell() {
		System.out.println(this.getModell() + "Methode von Spezifikationen");
	}

	/**
	 *
	 * @param ps setzt die PS des Audi
	 */
	public void setPs(int ps) {
		this.ps = ps;
	}

	/**
	 * Ueberladen der Methode setPs(int ps)
	 * @param ps setzt die PS des Audi
	 */
	public void setPs(long ps) {
		this.ps = (int) ps;
	}

	/**
	 *
	 * @return ps des Audi
	 */
	public int getPs() {
		return this.ps;
	}

	/**
	 *
	 * @return Sportsitze, ja (true) oder nein (false)
	 */
	public boolean getSportsitze() {
		return this.sportsitze;
	}

	/**
	 *
	 * @return Ledersitzbezug, ja (true) oder nein (false)
	 */
	public boolean getLederSitzbezug() {
		return this.lederSitzbezug;
	}
}

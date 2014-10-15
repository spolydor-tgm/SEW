/**
 * @author Stefan Polydor on 09.10.14.
 * @version 9.10.2014
 */
public class Audi<E> extends Auto {
	private String modell;

	private E modellKurzbez;

	public Audi() {

	}

	public Audi(String modell) {
		this.modell = modell;
	}

	/**
	 * Setzt das Modell des Audi
	 * @param modell des Audi (z.B.: R8)
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 *
	 * @return modell des Audi
	 */
	public String getModell() {
		return this.modell;
	}

	/**
	 * Wird nur bei dem Objekt Audi verwendet
	 */
	public void soutModell() {
		System.out.println(this.getModell());
	}

	/**
	 * Generisch: Typparameter E
	 * @param modellValue speichert das Modell
	 */
	public Audi(E modellKurzbez) {
		this.modellKurzbez = modellKurzbez;
	}

	/**
	 *
	 * @param modellValue setzt das Modell des Audi
	 */
	public void setModellKurzbez(E modellKurzbez) {
		this.modellKurzbez = modellKurzbez;
	}

	/**
	 *
	 * @return modellValue
	 */
	public E getModellKurzbez() {
		return this.modellKurzbez;
	}

	/**
	 *
	 * @return modellValue als String
	 */
	@Override
	public String toString() {
		return "" + this.modellKurzbez;
	}
}

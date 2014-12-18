package headfirst.combining.observer;

/**
 * Stellt die Methoden fuer die Fabriken bereit
 */
public abstract class AbstrakteEntenFabrik {

	public abstract Quakfaehig erzeugeStockEnte();

	public abstract Quakfaehig erzeugeMoorEnte();

	public abstract Quakfaehig erzeugeLockPfeife();

	public abstract Quakfaehig erzeugeGummiEnte();
}
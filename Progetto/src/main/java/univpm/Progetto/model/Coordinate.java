package univpm.Progetto.model;
/**
 * Salvare una coppia di coordinate
 * @author Antonio
 */
public class Coordinate {
	/**
	 * La longitudine delle coordinate
	 */
	private Double longitudine;
	/**
	 * La latitudine delle coordinate
	 */
	private Double latitudine;
	/**
	 * La funzione che permette di ottenere la longitudine
	 * @return la longitudine
	 */
	public Double getLongitudine() {
		return longitudine;
	}
	/**
	 * La funzione che permette di impostare la longitudine
	 * @param longitudine la longitudine da impostare
	 */
	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}
	/**
	 * La funzione che permette di ottenere la latitudine
	 * @return la latitudine
	 */
	public Double getLatitudine() {
		return latitudine;
	}
	/**
	 * La funzione che permette di impostare la latitudine
	 * @param latitudine la latitudine da impostare
	 */
	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}
	
}
package univpm.Progetto.eccezioni;

/**
 * Creazione di una classe per la gestione personalizzata delle eccezioni interne 
 * @author Antonio
 */
public class eccezioniInterne extends Exception {
	/**
	 * Variabile per la serializzazione 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Costruttore invocato per errori IOException
	 */
	public eccezioniInterne() {
		super("Errore durante la lettura");
	}
	
	/**
	 * Costruttore invocato per errori FileNotFound
	 * @param filenontrovato
	 */
	public eccezioniInterne(String filenontrovato) {
		super("Il file "+filenontrovato+" non è stato trovato");
	}
}

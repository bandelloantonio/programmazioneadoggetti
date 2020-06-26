package univpm.Progetto.eccezioni;

/**
 * Creazione di una classe per la gestione personalizzata delle eccezioni interne 
 * @author Antonio
 */
public class eccezioniInterne extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public eccezioniInterne() {
		super("Errore durante la lettura");
	}
	
	/**
	 * 
	 * @param filenontrovato
	 */
	public eccezioniInterne(String filenontrovato) {
		super("Il file "+filenontrovato+" non è stato trovato");
	}
}

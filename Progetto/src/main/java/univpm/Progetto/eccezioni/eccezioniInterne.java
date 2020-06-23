package univpm.Progetto.eccezioni;

public class eccezioniInterne extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public eccezioniInterne() {
		super("Errore durante la lettura");
	}
	public eccezioniInterne(String filenontrovato) {
		super("Il file "+filenontrovato+" non è stato trovato");
	}
}

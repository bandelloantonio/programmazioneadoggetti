package univpm.Progetto.eccezioni;

import java.util.Calendar;

/**
 * Creazione di una classe per la gestione personalizzata delle eccezzioni esterne 
 * @author Antonio
 */
public class eccezioniEsterne extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String errorepresente;
	/**
	 * 
	 */
	private Calendar istante;
	/**
	 * 
	 * @param istante
	 * @param tipoerrore
	 */
	public eccezioniEsterne(Calendar istante,String tipoerrore) {
		errorepresente="Le coordinate inserite presentano un errore in: "+tipoerrore;
		this.istante=istante;
	}
}

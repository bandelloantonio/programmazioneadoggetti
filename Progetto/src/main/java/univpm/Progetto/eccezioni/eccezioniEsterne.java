package univpm.Progetto.eccezioni;

import java.util.Calendar;

public class eccezioniEsterne extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorepresente;
	private Calendar istante;
	public eccezioniEsterne(Calendar istante,String tipoerrore) {
		errorepresente="Le coordinate inserite presentano un errore in: "+tipoerrore;
		this.istante=istante;
	}
}

package univpm.Progetto.eccezioni;

import java.util.Calendar;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Creazione di una classe per la gestione personalizzata delle eccezzioni esterne 
 * @author Antonio
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class eccezioniEsterne extends RuntimeException {
	/**
	 * Variabile per la serializzazione
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variabile che include la spiegazione dell'errore
	 */
	private String errorepresente;
	/**
	 * Variabile che memorizza l'istante in cui vi è l'errore
	 */
	private Calendar istante;
	/**
	 * Costruttore per campi non riconosciuti 
	 * @param tipoerrore il campo scritto in maniera errata
	 */
	public eccezioniEsterne(String tipoerrore) {
		errorepresente="Il campo "+tipoerrore+" non è stato scritto correttamente";
		this.istante=Calendar.getInstance();
	}
	/**
	 * Costruttore per campo numerico incorretto
	 * @param tipoerrore il campo scritto in maniera errata
	 * @param valore i valori riusciti a leggere 
	 */
	public eccezioniEsterne(String tipoerrore,String valore) {
		errorepresente="Il campo "+tipoerrore+" presenta dei valori non riconosciuti:"+valore;
		this.istante=Calendar.getInstance();
	}
	
	/**
	 * Costruttore per campo numerico oltre il range prefissato
	 * @param campo latitudine o longitudine 
	 * @param parametro il valore oltre il range
	 */
	public eccezioniEsterne(double parametro,String campo) {
		errorepresente="Il parametro inserito: "+parametro+" non rispetta il range "+campo;
		this.istante=Calendar.getInstance();
	}
	/**
	 * Getter per la descrizione dell'errore
	 * @return the errorepresente
	 */
	public String getErrorepresente() {
		return errorepresente;
	}
	/**
	 * Getter per l'istante di tempo dell'errore
	 * @return the istante
	 */
	public Calendar getIstante() {
		return istante;
	}
	
}

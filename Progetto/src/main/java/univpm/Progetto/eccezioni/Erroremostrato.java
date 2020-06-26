package univpm.Progetto.eccezioni;

import java.util.Calendar;

/**
 * Classe per la gestione degli errori esterni sulle interfaccie utenti
 * 
 * @author Antonio
 */
public class Erroremostrato {
	/**
	 * Variabile per l'istante in cui avviene l'errore
	 */
	private Calendar istante;
	/**
	 * Variabile che contiene il messaggio di errore
	 */
	private String messaggio;
	/**
	 * Variabile che contiene lo status di errore
	 */
	private String status = "400";
	/**
	 * Tipologia di errore
	 */
	private String error = "Filtro inserito non correttamente";

	/**
	 * Costruttore per assegnare le variabili istante e messaggio relative all'errore
	 * @param istante
	 * @param messaggio
	 */
	public Erroremostrato(Calendar istante, String messaggio) {
		super();
		this.istante = istante;
		this.messaggio = messaggio;
	}

	/**
	 * Getter per la variabile istante
	 * @return the istante
	 */
	public Calendar getIstante() {
		return istante;
	}

	/**
	 * Getter per la variabile messaggio
	 * @return the messaggio
	 */
	public String getMessaggio() {
		return messaggio;
	}

	/**
	 * Getter per la variabile status
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Getter per la definizione di errore
	 * @return the error
	 */
	public String getError() {
		return error;
	}

}

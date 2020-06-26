package univpm.Progetto.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univpm.Progetto.eccezioni.eccezioniEsterne;
import univpm.Progetto.eccezioni.eccezioniInterne;
import univpm.Progetto.model.Informazioni;
import univpm.Progetto.util.Definizione;
import univpm.Progetto.util.Metadata;
import univpm.Progetto.util.Stats;

/**
 * Creazione una classe ereditarietà che mi aiuta a gestire il controller
 * @author Antonio
 */
@Service
public class funzionidelController {
	/**
	 * Il database contenente tutte le informazioni scaricate e salvate
	 */
	private ArrayList<Informazioni> Database;
	/**
	 * Chiamato il costruttore per i metadati gestito mediante Autowired 
	 */
	@Autowired
	private Metadata metadati;
	/**
	 * Il costruttore: qui viene impartito il comando per il download delle informazioni assegnate poi al database
	 * @throws eccezioniInterne 
	 */
	public funzionidelController() throws eccezioniInterne {
	Definizione obj = new Definizione ();
	Database = obj.parsing();
	}

	/**
	 * Ritorna il database
	 * @return database 
	 */
	public ArrayList<Informazioni> getDatipercontroller(){
		return Database;
	}

	/**
	 * Ritorna solo le localita del database che soddisfano la specifica 
	 * @param coordinates JSON contente la coppia di coordinate del bounding box
	 * @throws eccezioniEsterne
	 * @return tutte le informazioni filtrate dalla classe Stats  
	 */
	public ArrayList<Informazioni> getStatisticapercontroller(JSONObject coordinates) throws eccezioniEsterne{
		Stats statistiche = new Stats();
		return statistiche.funzione(coordinates,Database);
	}

	/**
	 * Ritorna tutte le informazioni su come poter analizzare i dati 
	 * @return i metadati
	 */
	public  ArrayList<HashMap<String, String>> VisualizzaMetadata() {
		return metadati.getMetadati();
	}

}
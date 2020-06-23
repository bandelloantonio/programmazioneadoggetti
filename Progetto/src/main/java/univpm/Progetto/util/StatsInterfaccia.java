package univpm.Progetto.util;

import java.util.ArrayList;
import org.json.JSONObject;
import univpm.Progetto.eccezioni.eccezioniEsterne;
import univpm.Progetto.model.Informazioni;

/**
 * Creazione di una classe interfaccia 
 * @author Antonio
 */
public interface StatsInterfaccia {
	
	/**
	 * E' la definizione per creare una lista di informazioni in base alle coordinate che vengono passate 
	 * 
	 * @param data il database contenente tutte le informazioni da verificare
	 * @param coordinates
	 * @return una lista di record informazioni che soddisfano l'appartenenza al bounding box
	 * @throws eccezioniEsterne 
	 */
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data) throws eccezioniEsterne;
}

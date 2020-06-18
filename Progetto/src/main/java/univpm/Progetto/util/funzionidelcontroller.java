package univpm.Progetto.util;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;
import univpm.Progetto.model.Informazioni;

/**
 * Creazione una classe ereditarietà che mi aiuta a gestire il controller
 * @author Antonio
 */
public class funzionidelcontroller {
	/**
	 * Il database contenente tutte le informazioni scaricate e salvate
	 */
	private ArrayList<Informazioni> Database;
	
	/**
	 * Il costruttore: qui viene impartito il comando per il download delle informazioni assegnate poi al database
	 */
	public funzionidelcontroller() {
		super();

		Definizione obj = new Definizione ();
		try {
			Database = obj.parsing();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * @return tutte le informazioni filtrate dalla classe Stats 
	 */
	public ArrayList<Informazioni> getStatisticapercontroller(JSONObject coordinates){
		Stats statistiche = new Stats();
		return statistiche.funzione(coordinates,Database);
	}
}
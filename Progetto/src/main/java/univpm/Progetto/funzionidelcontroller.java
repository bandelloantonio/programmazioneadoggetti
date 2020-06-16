package univpm.Progetto;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import univpm.Progetto.model.Informazioni;


/**
 * creo una classe che mi aiuta a gestire il controller attraverso una classe eridarietà
 * @author Antonio
 */

public class funzionidelcontroller {
	private ArrayList<Informazioni> Database;
	
	
	public funzionidelcontroller() {
		super();

		Definizione obj = new Definizione ();
		try {
			Database = obj.parsing();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Informazioni> getDatipercontroller(){
		return Database;
	}

	/**
	 * @param coordinates
	 * @return tutte le informazioni passate dalla classe Stats
	 */
	public ArrayList<Informazioni> getStatisticapercontroller(JSONObject coordinates){
		Stats statistiche = new Stats();
		return statistiche.funzione(coordinates,Database);
	}
}
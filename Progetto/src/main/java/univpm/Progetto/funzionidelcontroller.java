package univpm.Progetto;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import univpm.Progetto.model.Informazioni;


public class funzionidelcontroller {
	ArrayList<Informazioni> Database;
	/**
	 * 
	 */
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

	public ArrayList<Informazioni> getStatisticapercontroller(JSONObject coordinates){
		Stats statistiche = new Stats();
		return statistiche.funzione(coordinates,Database);
	}
}